package com.crio.buildouts.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.HashMap;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Question {

  // @JsonAlias("moduleId")
  // @NotNull
  // private String moduleId;

  @JsonAlias("questionId")
  @NotNull
  private String questionId;

  @JsonAlias("title")
  @NotNull
  private String title;

  // @JsonAlias("description")
  // @NotNull
  // private String description;

  @JsonAlias("type")
  @NotNull
  private String type;

  @JsonAlias("options")
  private HashMap<Integer, String> options;

}