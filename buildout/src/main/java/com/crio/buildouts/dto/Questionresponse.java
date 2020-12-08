package com.crio.buildouts.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Questionresponse {

  @JsonProperty(value = "questionId")
  @NotNull
  private String questionId;
  
  @JsonAlias("title")
  @JsonProperty(value = "title")
  @NotNull
  private String title;
  
  // @JsonAlias("description")
  //@NotNull
  @JsonProperty(value = "description")
  private String description;
  
  @JsonAlias("correctAnswer")
  @JsonProperty(value = "correct")
  private List<String> correctAnswer;
  
  @JsonProperty(value = "type")
  @JsonAlias("type")
  @NotNull
  private String type;
  
  // @JsonAlias("options")
  // @BsonProperty(value = "options")
  // private Options options;
  
  @JsonProperty("options")
  private HashMap<Integer, String> options;

  @JsonProperty("userAnswer")
  private List<String> userAnswer;

  @JsonProperty("explanation")
  private String explanation;

  @JsonProperty("answerCorrect")
  private Boolean answerCorrect;
  
}