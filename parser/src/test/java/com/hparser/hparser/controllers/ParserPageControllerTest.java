package com.hparser.hparser.controllers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@AutoConfigureMockMvc
public class ParserPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ParserPageController parserPageController;

    @Test
    void LocationController_Smoke() {
        Assertions.assertThat(parserPageController).isNotNull();
    }

    @Test
    void ParserPageController_uploadColumnData_ReturnsLocationDto() {

    }
}
