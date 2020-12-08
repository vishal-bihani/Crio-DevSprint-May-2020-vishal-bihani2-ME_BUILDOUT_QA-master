package com.crio.buildouts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response {

  @JsonProperty("questions")
  private List<Questionresponse> questions;

  @JsonProperty("summary")
  private Summary summary;
}