package br.ufac.sgcmapi.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufac.sgcmapi.model.Atendimento;
import br.ufac.sgcmapi.service.AtendimentoService;

@WebMvcTest(AtendimentoController.class)
public class AtendimentoControllerTest {

    @MockBean
    private AtendimentoService servico;

    @Autowired
    private MockMvc mockMvc;

    Atendimento a1, a2;
    List<Atendimento> atendimentos;
    String jsonContent;

    @BeforeEach
    public void setUp() throws JsonProcessingException {
        a1 = new Atendimento();
        a2 = new Atendimento();
        a1.setId(1L);
        a2.setId(2L);
        jsonContent = new ObjectMapper().writeValueAsString(a1);
        atendimentos = new ArrayList<Atendimento>();
        atendimentos.add(a1);
        atendimentos.add(a2);
    }

    @Test
    void testAtendimentoControllerDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/atendimento/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testAtendimentoControllerGetAll() throws Exception {
        Mockito.when(servico.get()).thenReturn(atendimentos);
        mockMvc.perform(MockMvcRequestBuilders.get("/atendimento/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(2)));
    }

    @Test
    void testAtendimentoControllerGetById() throws Exception {
        Mockito.when(servico.get(1L)).thenReturn(a1);
        mockMvc.perform(MockMvcRequestBuilders.get("/atendimento/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)));
    }

    @Test
    void testAtendimentoControllerGetTermo() throws Exception {
        Mockito.when(servico.get("termo")).thenReturn(atendimentos);
        mockMvc.perform(MockMvcRequestBuilders.get("/atendimento/busca/termo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)));
    }

    @Test
    void testAtendimentoControllerGetHorarios() throws Exception {
        List<String> horarios = new ArrayList<>();
        horarios.add("14:00:00");
        horarios.add("15:00:00");
        Mockito.when(servico.getHorarios(1L, LocalDate.now())).thenReturn(horarios);
        mockMvc.perform(MockMvcRequestBuilders.get("/atendimento/horarios/1/" + LocalDate.now()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]", Matchers.is("14:00:00")));
    }

    @Test
    void testAtendimentoControllerInsert() throws Exception {
        Mockito.when(servico.save(Mockito.any(Atendimento.class))).thenReturn(a1);
        mockMvc.perform(MockMvcRequestBuilders.post("/atendimento/")
                .contentType(MediaType.APPLICATION_JSON).content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)));
    }

    @Test
    void testUpdate() throws Exception {
        Mockito.when(servico.save(Mockito.any(Atendimento.class))).thenReturn(a1);
        mockMvc.perform(MockMvcRequestBuilders.put("/atendimento/")
                .contentType(MediaType.APPLICATION_JSON).content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)));
    }

    @Test
    void testUpdateStatus() throws Exception {
        Mockito.when(servico.updateStatus(1L)).thenReturn(a1);
        mockMvc.perform(MockMvcRequestBuilders.put("/atendimento/status/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is("AGENDADO")));
    }
}
