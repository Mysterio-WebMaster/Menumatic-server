package com.menumatic.repository;

import com.menumatic.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository  extends JpaRepository<Menu, Long> {
    List<Menu> findTop10By();

    @Query("SELECT m FROM Menu m WHERE LOWER(m.item_name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Menu> findByName(String query);
}
