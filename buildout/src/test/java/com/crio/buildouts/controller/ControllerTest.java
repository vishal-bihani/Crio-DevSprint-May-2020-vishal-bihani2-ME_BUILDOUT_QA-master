package com.crio.buildouts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.crio.buildouts.BuildoutApplication;
import com.crio.buildouts.service.QuestionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(classes = BuildoutApplication.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ControllerTest {

  private static final String QUIZ_ENDPOINT_URI = "/quiz/xyz";

  private ObjectMapper objectMapper;

  private MockMvc mvc;

  @MockBean
  QuestionService questionService;

  @InjectMocks
  Controller controller;

  @BeforeEach
  void setup() {
    objectMapper = new ObjectMapper();
    MockitoAnnotations.initMocks(this);
    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void illegalApiRequest() throws Exception {
    URI uri = UriComponentsBuilder
        .fromPath(QUIZ_ENDPOINT_URI)
        .build().toUri(); 
    ////
      
    MockHttpServletResponse response = mvc.perform(
        get(uri.toString()).accept(APPLICATION_JSON_UTF8)
        ).andReturn().getResponse();
    assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
  }

}