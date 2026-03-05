package com.menumatic.services;

import com.menumatic.dto.MenuDTO;
import com.menumatic.entities.Menu;
import com.menumatic.repository.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName(value = "Test Menu Service")
public class MenuServiceTest {

    @Mock
    private MenuRepository menuRepo;

    @InjectMocks
    private MenuService menuService;

    private Menu menuItem1;
    private Menu menuItem2;

    @BeforeEach
    void setUp(){
        menuItem1 = new Menu();
        menuItem1.setItem_id(1L);
        menuItem1.setItem_category("Breakfast");
        menuItem1.setItem_name("Vada pav");
        menuItem1.setItem_price(new BigDecimal("15.00"));

        menuItem2 = new Menu();
        menuItem2.setItem_id(2L);
        menuItem2.setItem_category("Main Course");
        menuItem2.setItem_name("Panner Tikka Masala");
        menuItem2.setItem_price(new BigDecimal("214.99"));
    }

    @Test
    @DisplayName(value = "Test Get all Menu Items")
    void getAllMenuItems(){
        when(menuRepo.findAll()).thenReturn(Arrays.asList(menuItem1, menuItem2));

        List<MenuDTO> results = menuService.getAllMenuItems();

        assertThat(results).hasSize(2);

        // Assert MenuItem1
        assertThat(results.get(0).itemid()).isEqualTo(1L);
        assertThat(results.get(0).category()).isEqualTo("Breakfast");
        assertThat(results.get(0).name()).isEqualTo("Vada pav");
        assertThat(results.get(0).price()).isEqualTo("15.00");

        // Assert MenuItem2
        assertThat(results.get(1).itemid()).isEqualTo(2L);
        assertThat(results.get(1).category()).isEqualTo("Main Course");
        assertThat(results.get(1).name()).isEqualTo("Panner Tikka Masala");
        assertThat(results.get(1).price()).isEqualTo("214.99");
    }
}
