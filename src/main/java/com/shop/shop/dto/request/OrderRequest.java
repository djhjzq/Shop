package com.shop.shop.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderRequest implements Serializable {
    private final Long productId;
    private final Long cartId;
    private final Integer quantity;
}
