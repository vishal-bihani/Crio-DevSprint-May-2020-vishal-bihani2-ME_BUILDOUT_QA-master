package com.crio.buildouts.dto;

import java.util.HashMap;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Options {

  // @Id
  // private ObjectId id;

  // @BsonProperty(value = "1")
  // @JsonAlias("1")
  // private String optionOne;

  // @BsonProperty(value = "2")
  // @JsonAlias("2")
  // private String optionTwo;

  // @BsonProperty(value = "3")
  // @JsonAlias("3")
  // private String optionThree;

  // @BsonProperty(value = "4")
  // @JsonAlias("4")
  // private String optionFour;

  private HashMap<Integer, String> map;

}