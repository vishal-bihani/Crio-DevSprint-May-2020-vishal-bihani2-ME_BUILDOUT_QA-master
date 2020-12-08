package com.crio.buildouts.exchange;

import com.crio.buildouts.dto.Question;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class GetQuestionResponseArray {

  private Question[] questions;
}