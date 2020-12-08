package com.crio.buildouts.controller;

import com.crio.buildouts.dto.Question;
import com.crio.buildouts.dto.Requestlist;
import com.crio.buildouts.dto.Response;
import com.crio.buildouts.exchange.GetQuestionRequest;
import com.crio.buildouts.exchange.GetQuestionResponse;
import com.crio.buildouts.exchange.GetQuestionResponseArray;
import com.crio.buildouts.models.QuestionEntity;
import com.crio.buildouts.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(Controller.API_ENDPOINT)
public class Controller {
  public static final String API_ENDPOINT = "/quiz";
  public static final String MODULE_ENDPOINT = "/{module_id}";

  @Autowired
  QuestionService questionService;

  //GetMapping to take request
  
  @GetMapping("/{moduleID}")
  private ResponseEntity<GetQuestionResponseArray> getQuestions(@PathVariable("moduleID")
      String id) {
    GetQuestionRequest getQuestionRequest = new GetQuestionRequest(id);
    try {
      GetQuestionResponse getQuestionResponse = questionService
          .findAllQuestions(getQuestionRequest);
      GetQuestionResponseArray getQuestionResponseArray = new GetQuestionResponseArray();
      List<Question> questions = getQuestionResponse.getQuestions();
      Question[] questionsArray = new Question[questions.size()];
      for (int i = 0; i < questions.size(); i++) {
        questionsArray[i] = questions.get(i);
      }
      getQuestionResponseArray.setQuestions(questionsArray);
      return ResponseEntity.ok().body(getQuestionResponseArray);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad http request", e);
    }
  }

  //PostMapping to submit responses

  @PostMapping("/{moduleID}")
  private ResponseEntity<Response> sendResponse(@RequestBody Requestlist requestList, 
      @PathVariable("moduleID")String id) {
    try {
      Response response = questionService.checkAll(requestList);
      return ResponseEntity.ok().body(response);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad http request", e);
    }
  }

  //PutMapping to add questions

  @PutMapping("/{moduleID}")
  @ResponseStatus(HttpStatus.CREATED)
  private ResponseEntity<Void> putQuestion(@RequestBody List<QuestionEntity> questionEntity, 
      @PathVariable("moduleID")int id) {
  
    try {
      for (QuestionEntity q : questionEntity) {
        questionService.insertQuestion(q);
      }
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad http request", e);
    }
  }

}