package com.menumatic.dto;

import java.math.BigDecimal;

public record MenuDTO (Long itemid, String category, String name, BigDecimal price){}
