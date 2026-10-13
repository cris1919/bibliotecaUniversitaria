package com.biblioteca.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

class HomeControllerTest {

    @Test
    void rootShouldRedirectToLibros() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();

        mockMvc.perform(get("/"))
                .andExpect(redirectedUrl("/libros"));
    }
}
