package com.menumatic.controllers;

import com.menumatic.dto.MenuDTO;
import com.menumatic.services.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<MenuDTO> getAllMenuItems(){
        return menuService.getAllMenuItems();
    }
}
