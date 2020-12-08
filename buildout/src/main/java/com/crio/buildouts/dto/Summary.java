package com.crio.buildouts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Summary {

  @JsonProperty("score")
  private int score;

  @JsonProperty("total")
  private int total;
}