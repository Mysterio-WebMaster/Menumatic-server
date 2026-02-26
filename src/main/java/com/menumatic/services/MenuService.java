package com.menumatic.services;

import com.menumatic.dto.MenuDTO;
import com.menumatic.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {
    private final MenuRepository menuRepo;

    public MenuService(MenuRepository menuRepo){
        this.menuRepo = menuRepo;
    }

    public List<MenuDTO> getAllMenuItems(){
        return menuRepo.findAll().stream()
                .map(item-> new MenuDTO(
                item.getItem_id(),
                item.getItem_category(),
                item.getItem_name(),
                item.getItem_price()
        )).collect(Collectors.toList());
    }
}
