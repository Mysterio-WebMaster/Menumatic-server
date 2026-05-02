package com.menumatic.services;

import com.menumatic.dto.MenuDTO;
import com.menumatic.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AiEngineService {
    private final MenuRepository menuRepo;

    public AiEngineService(MenuRepository menuRepo){
        this.menuRepo = menuRepo;
    }

    @Value("${aiengineurl}")
    private String aiEngineUrl;

    public List<MenuDTO> getAllMenuItems(){
        return menuRepo.findAll().stream()
                .map(item-> new MenuDTO(
                        item.getItem_id(),
                        item.getItem_category(),
                        item.getItem_name(),
                        item.getItem_price(),
                        item.getItem_description(),
                        item.getVeg_non_veg()
                )).collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public List<MenuDTO> getRecommendedItems(String query){

        // Make rest call to AI Engine and pass the searched string
        String URL = aiEngineUrl + "/recommend/search?q=" + query;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Map> response = restTemplate.getForEntity(URL, Map.class);

        try {
            List<Map<String, Object>> data = (List<Map<String, Object>>) response.getBody().get("data");
            return data.stream()
                    .map(item-> new MenuDTO(
                            ((Number) item.get("itemid")).longValue(),
                            (String) item.get("category"),
                            (String) item.get("name"),
                            new java.math.BigDecimal(item.get("price").toString()),
                            null,
                            (String) item.get("veg_non_veg")
                    )).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
