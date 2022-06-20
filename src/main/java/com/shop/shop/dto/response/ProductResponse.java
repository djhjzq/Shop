package com.shop.shop.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProductResponse implements Serializable {
    private final Long id;
    private final Long modelId;
    private final String modelName;
    private final Integer modelQuantity;
    private final BigDecimal modelPrice;
    private final String description;
}
