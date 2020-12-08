package com.crio.buildouts.repositoryservice;

import com.crio.buildouts.dto.Question;
import com.crio.buildouts.models.QuestionEntity;
import java.util.List;



public interface QuestionRepositoryService {
    
  List<Question> getAllQuestions(String id);

  QuestionEntity getQuestion(String questionId);

  void insertQuestion(QuestionEntity questionEntity);
}