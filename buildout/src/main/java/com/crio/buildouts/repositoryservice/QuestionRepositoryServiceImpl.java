package com.crio.buildouts.repositoryservice;

import com.crio.buildouts.dto.Question;
import com.crio.buildouts.models.QuestionEntity;
import com.crio.buildouts.repository.QuestionRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Provider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
class QuestionRepositoryServiceImpl implements QuestionRepositoryService {

  @Autowired
  private QuestionRepository questionRepository;

  @Autowired
  private Provider<ModelMapper> modelMapperProvider;

  public List<Question> getAllQuestions(String id) {

    List<QuestionEntity> questionEntities = questionRepository.findAll();
    //List<QuestionEntity> questionEntitiesFiltered = new ArrayList<>();


    // for (QuestionEntity q : questionEntities) {
    //   if (q.getQuestionId() == id) {
    //     questionEntitiesFiltered.add(q);
    //   }
    // }

    ModelMapper modelMapper = modelMapperProvider.get();
    List<Question> questions = new ArrayList<>();
    
    for (QuestionEntity q : questionEntities) {
      questions.add(modelMapper.map(q, Question.class));
    }
    return questions;
  }

  public QuestionEntity getQuestion(String id) {
    List<QuestionEntity> questionEntities = questionRepository.findAll();
    for (QuestionEntity q : questionEntities) {
      if (id != null && q.getQuestionId() != null) {
        if (q.getQuestionId().equalsIgnoreCase(id)) {
          return q;
        }
      }
    }
    return null;
  }

  @Override
  public void insertQuestion(QuestionEntity questionEntity) {
    try {
      questionRepository.insert(questionEntity);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}