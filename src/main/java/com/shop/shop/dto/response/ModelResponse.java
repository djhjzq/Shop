package com.shop.shop.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ModelResponse implements Serializable {
    private final Long id;
    private final String name;
    private final Integer quantity;
    private final List<ProductDto> productList;
    private final BigDecimal price;

    @Data
    public static class ProductDto implements Serializable {
        private final Long id;
        private final String description;
    }
}
