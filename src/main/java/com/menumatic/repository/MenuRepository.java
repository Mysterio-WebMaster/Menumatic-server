package com.menumatic.repository;

import com.menumatic.entities.Menu;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository  extends JpaRepository<Menu, Long> { }
