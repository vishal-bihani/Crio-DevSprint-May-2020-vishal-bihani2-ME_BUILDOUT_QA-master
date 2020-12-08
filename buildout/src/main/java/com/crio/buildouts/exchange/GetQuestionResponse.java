package com.crio.buildouts.exchange;

import com.crio.buildouts.dto.Question;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class GetQuestionResponse {
  
  private List<Question> questions;
}