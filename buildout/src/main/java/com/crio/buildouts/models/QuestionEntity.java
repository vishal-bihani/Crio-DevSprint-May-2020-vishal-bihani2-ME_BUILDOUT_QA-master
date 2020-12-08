package com.crio.buildouts.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "questions")
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionEntity {

  // @JsonAlias({"moduleId", "module_Id"})
  // @JsonProperty("moduleId")
  // private String moduleId;

  @Id
  @JsonIgnore
  private ObjectId id;

  // @JsonAlias("questionId")
  @BsonProperty(value = "questionId")
  @NotNull
  private String questionId;

  @JsonAlias("title")
  @BsonProperty(value = "title")
  @NotNull
  private String title;

  // @JsonAlias("description")
  //@NotNull
  @BsonProperty(value = "description")
  private String description;

  @BsonProperty(value = "correctAnswer")
  private List<String> correctAnswer;

  @BsonProperty(value = "type")
  @JsonAlias("type")
  @NotNull
  private String type;

  // @JsonAlias("options")
  // @BsonProperty(value = "options")
  // private Options options;

  @BsonProperty("options")
  private HashMap<Integer, String> options;

  
}