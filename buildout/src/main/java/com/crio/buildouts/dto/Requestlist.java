package com.crio.buildouts.dto;

import com.crio.buildouts.dto.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class Requestlist {

  @JsonProperty("responses")
  private List<Request> responses;
  
}