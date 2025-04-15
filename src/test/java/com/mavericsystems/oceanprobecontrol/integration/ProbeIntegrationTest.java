package com.mavericsystems.oceanprobecontrol.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mavericsystems.oceanprobecontrol.dto.ProbeCommandRequest;
import com.mavericsystems.oceanprobecontrol.model.Direction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProbeIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testProbeControlApi() throws Exception {
        ProbeCommandRequest request = new ProbeCommandRequest();
        request.startX = 0;
        request.startY = 0;
        request.startDirection = Direction.NORTH;
        request.commands = List.of('F', 'R', 'F');

        mockMvc.perform(post("/api/probe/command")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.finalPosition.x").value(1))
                .andExpect(jsonPath("$.finalPosition.y").value(1));
    }
}
