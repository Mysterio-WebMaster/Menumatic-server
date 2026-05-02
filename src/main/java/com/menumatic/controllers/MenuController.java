package com.menumatic.controllers;

import com.menumatic.dto.MenuDTO;
import com.menumatic.services.AiEngineService;
import com.menumatic.services.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public List<MenuDTO> getAllMenuItems(@RequestParam(required = false) String query){

        if (query != null && !query.trim().isEmpty()) {
            return menuService.getFilteredMenuItems(query);
        }

        return menuService.getAllMenuItems();
    }
}
