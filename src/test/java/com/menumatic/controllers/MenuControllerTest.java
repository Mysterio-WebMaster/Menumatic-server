package com.menumatic.controllers;

import com.menumatic.dto.MenuDTO;
import com.menumatic.services.MenuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName(value = "Test Menu Controller")
@WebMvcTest(MenuController.class)
public class MenuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MenuService menuService;



    @Test
    @DisplayName("Test list of menu with DTO")
    void getAllMenuItems() throws Exception {
        List<MenuDTO> mockMenuList = Arrays.asList(
                new MenuDTO(1L, "Breakfast", "Idli", new BigDecimal("14.99")),
                new MenuDTO(2L, "Main Course", "Paratha", new BigDecimal("90"))
        );
        when(menuService.getAllMenuItems()).thenReturn(mockMenuList);

        // Assert
        mockMvc.perform(get("/v1/menu").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].itemid").value(1))
                .andExpect(jsonPath("$[0].name").value("Idli"))
                .andExpect(jsonPath("$[1].name").value("Paratha"))
        ;

        verify(menuService, times(1)).getAllMenuItems();
    }

}
