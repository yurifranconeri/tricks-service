package com.mysk8life.tricks.tricksrestservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TricksRestController.class)
class TricksRestControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TricksService tricksService;


  @Test
  void getTricksShouldReturn200() throws Exception {
    mockMvc.perform(get("/api/v1/tricks")
    .contentType("application/json"))
    .andExpect(status().isOk());
  }

  @Test
  void getStancesShouldReturn200() throws Exception {
    mockMvc.perform(get("/api/v1/tricks/stances")
    .contentType("application/json"))
    .andExpect(status().isOk());
  }

  @Test
  void getCategoriesShouldReturn200() throws Exception {
    mockMvc.perform(get("/api/v1/tricks/categories")
    .contentType("application/json"))
    .andExpect(status().isOk());
  }

  @Test
  void getDifficultiesShouldReturn200() throws Exception {
    mockMvc.perform(get("/api/v1/tricks/difficulties")
    .contentType("application/json"))
    .andExpect(status().isOk());
  }

  @Test
  void getAllByStanceShouldReturn200() throws Exception {
    mockMvc.perform(get("/api/v1/tricks/stance/{stance}", "regular")
    .contentType("application/json"))
    .andExpect(status().isOk());
  }

  @Test
  void getAllByCategoryShouldReturn200() throws Exception {
    mockMvc.perform(get("/api/v1/tricks/category/{category}", "basic")
    .contentType("application/json"))
    .andExpect(status().isOk());
  }

  @Test
  void getAllByDifficultyShouldReturn200() throws Exception {
    mockMvc.perform(get("/api/v1/tricks/difficulty/{difficulty}", "one")
    .contentType("application/json"))
    .andExpect(status().isOk());
  }

  @Test
  void getAllGroupedShouldReturn200() throws Exception {
    mockMvc.perform(get("/api/v1/tricks/group/{group}","category")
    .contentType("application/json"))
    .andExpect(status().isOk());
  }


  @Test
  void getAllByStanceEmptyShouldReturn200() throws Exception {
    mockMvc.perform(get("/api/v1/tricks/stance/{stance}", "")
    .contentType("application/json"))
    .andExpect(status().isNotFound());
  }

  @Test
  void getAllByCategoryEmptyShouldReturn200() throws Exception {
    mockMvc.perform(get("/api/v1/tricks/category/{category}", "")
    .contentType("application/json"))
    .andExpect(status().isNotFound());
  }

  @Test
  void getAllByDifficultyEmptyShouldReturn200() throws Exception {
    mockMvc.perform(get("/api/v1/tricks/difficulty/{difficulty}", "")
    .contentType("application/json"))
    .andExpect(status().isNotFound());
  }

  @Test
  void getAllGroupedEmptyShouldReturn200() throws Exception {
    mockMvc.perform(get("/api/v1/tricks/group/{group}","")
    .contentType("application/json"))
    .andExpect(status().isNotFound());
  }
}
