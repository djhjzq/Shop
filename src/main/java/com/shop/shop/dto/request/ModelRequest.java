package com.shop.shop.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ModelRequest implements Serializable {
    private final String name;
    private final Integer quantity;
    private final BigDecimal price;
}
