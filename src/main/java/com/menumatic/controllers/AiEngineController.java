package com.menumatic.controllers;

import com.menumatic.dto.MenuDTO;
import com.menumatic.services.AiEngineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/engine/")
public class AiEngineController {
    private final AiEngineService aiEngineService;

    public AiEngineController(AiEngineService aiEngineService){
        this.aiEngineService = aiEngineService;
    }

    @GetMapping("/menu")
    public List<MenuDTO> getAllMenuItems(){
        return aiEngineService.getAllMenuItems();
    }

    @GetMapping("/menu/recommend")
    public List<MenuDTO> getRecommendedItems(@RequestParam String query){
        return aiEngineService.getRecommendedItems(query);
    }
}
