package com.crio.buildouts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Module {

  @JsonProperty("moduleId")
  @NotNull
  private String moduleId;

  @JsonProperty("moduleId")
  @NotNull
  private ArrayList<Question> questions;
}