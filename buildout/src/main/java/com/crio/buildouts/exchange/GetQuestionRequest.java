package com.crio.buildouts.exchange;

import com.fasterxml.jackson.annotation.JsonAlias;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class GetQuestionRequest {

  @NotNull
  @JsonAlias("moduleId")
  private String moduleId;
}