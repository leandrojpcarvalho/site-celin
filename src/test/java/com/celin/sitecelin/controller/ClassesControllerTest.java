package com.celin.sitecelin.controller;

import com.celin.sitecelin.entities.ClassRoom;
import com.celin.sitecelin.entities.users.User;
import com.celin.sitecelin.model.Courses;
import com.celin.sitecelin.model.Users;
import org.assertj.core.internal.Classes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ClassesControllerTest {
  @MockBean
  Classes classes;

  @Autowired
  MockMvc mockMvc;


  @Test
  public void testGetAllClasses() throws Exception {
    mockMvc.perform(get("/classes")
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content().contentType(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$").isArray())
          .andExpect(jsonPath("$[*].courseSchedule").isNotEmpty());
  }
}
