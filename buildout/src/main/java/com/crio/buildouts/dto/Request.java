package com.crio.buildouts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Request {

  @JsonProperty("questionId")
  @NotNull
  private String questionId;

  @JsonProperty("userResponse")
  private List<String> userResponse;
}