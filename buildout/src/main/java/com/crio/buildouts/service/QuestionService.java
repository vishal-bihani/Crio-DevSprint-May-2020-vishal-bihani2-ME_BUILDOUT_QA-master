package com.crio.buildouts.service;

import com.crio.buildouts.dto.Requestlist;
import com.crio.buildouts.dto.Response;
import com.crio.buildouts.exchange.GetQuestionRequest;
import com.crio.buildouts.exchange.GetQuestionResponse;
import com.crio.buildouts.models.QuestionEntity;

public interface QuestionService {

  GetQuestionResponse findAllQuestions(GetQuestionRequest getQuestionRequest);

  Response checkAll(Requestlist requestlist);

  void insertQuestion(QuestionEntity questionEntity);
} 