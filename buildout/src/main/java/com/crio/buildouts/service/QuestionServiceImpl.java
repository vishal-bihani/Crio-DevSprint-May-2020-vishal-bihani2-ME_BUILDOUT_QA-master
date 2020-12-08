package com.crio.buildouts.service;

import com.crio.buildouts.dto.Question;
import com.crio.buildouts.dto.Questionresponse;
import com.crio.buildouts.dto.Request;
import com.crio.buildouts.dto.Requestlist;
import com.crio.buildouts.dto.Response;
import com.crio.buildouts.dto.Summary;
import com.crio.buildouts.exchange.GetQuestionRequest;
import com.crio.buildouts.exchange.GetQuestionResponse;
import com.crio.buildouts.models.QuestionEntity;
import com.crio.buildouts.repository.QuestionRepository;
import com.crio.buildouts.repositoryservice.QuestionRepositoryService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Provider;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuestionServiceImpl implements QuestionService {

  @Autowired
  QuestionRepositoryService questionRepositoryService;

  @Autowired
  Provider<ModelMapper> modelMapperProvider;


  @Override
  public GetQuestionResponse findAllQuestions(GetQuestionRequest getQuestionRequest) {

    String moduleId = getQuestionRequest.getModuleId();
    
    List<Question> questions = questionRepositoryService.getAllQuestions(moduleId);
    GetQuestionResponse getQuestionResponse = new GetQuestionResponse(questions);

    return getQuestionResponse;
  }

  @Override
  public Response checkAll(Requestlist requestList) {

    ModelMapper modelMapper = modelMapperProvider.get();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    List<Request> requests = requestList.getResponses();
    List<Questionresponse> questionResponses = new ArrayList<>();
    int total = requests.size();
    int score = 0;
    for (Request r : requests) {
      QuestionEntity questionEntity = questionRepositoryService.getQuestion(
          r.getQuestionId()
          );
      Questionresponse questionResponse = null;
      try {
        questionResponse = modelMapper.map(questionEntity, 
            Questionresponse.class);
      } catch (Exception e) {
        e.printStackTrace();
      }

      try {
        if (r.getUserResponse().equals(questionEntity.getCorrectAnswer())) {
          score++;
          questionResponse.setAnswerCorrect(true);
        } else {
          questionResponse.setAnswerCorrect(false);
        }
        questionResponse.setUserAnswer(r.getUserResponse());
        questionResponses.add(questionResponse);
      } catch (NullPointerException e1) {
        e1.printStackTrace();
      }
    }
    Summary summary = new Summary();
    summary.setScore(score);
    summary.setTotal(total);
    Response response = new Response();
    response.setQuestions(questionResponses);
    response.setSummary(summary);
    
    return response;
  }

  @Override
  public void insertQuestion(QuestionEntity questionEntity) {
    questionRepositoryService.insertQuestion(questionEntity);
  }

  
}