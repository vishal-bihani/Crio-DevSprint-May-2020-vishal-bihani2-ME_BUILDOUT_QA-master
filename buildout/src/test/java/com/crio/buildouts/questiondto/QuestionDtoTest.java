package com.crio.buildouts.questiondto;

import static org.junit.Assert.assertEquals;

import com.crio.buildouts.models.QuestionEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuestionDtoTest {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setup() {
    objectMapper = new ObjectMapper();
  }
    
  @Test
  public void checkDto() {
    try {
      File file = resolveFileFromResources("initial_data_load.json");
      String value = objectMapper.readValue(file, String.class);
      QuestionEntity questionEntity = objectMapper.readValue(file, QuestionEntity.class);
      String response = objectMapper.writeValueAsString(questionEntity);
      assertEquals(value, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private File resolveFileFromResources(String filename) throws URISyntaxException {
    return Paths.get(Thread.currentThread().getContextClassLoader()
          .getResource(filename).toURI()).toFile();
  }
}