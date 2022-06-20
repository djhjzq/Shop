package com.shop.shop.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductRequest implements Serializable {
    private final Long modelId;
    private final String description;
}
