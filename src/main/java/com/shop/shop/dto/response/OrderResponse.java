package com.shop.shop.dto.response;

import com.shop.shop.entity.OrderStatus;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderResponse implements Serializable {
    private final Long id;
    private final Long productId;
    private final Long productModelId;
    private final String productModelName;
    private final BigDecimal productModelPrice;
    private final String productDescription;
    private final Integer quantity;
    private final OrderStatus orderStatus;
}
