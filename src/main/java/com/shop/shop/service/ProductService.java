package com.shop.shop.service;

import com.shop.shop.dto.request.ProductRequest;
import com.shop.shop.entity.Product;

public interface ProductService {

    Product addProduct(ProductRequest productRequest);

    void deleteProduct(Long productId);

    Product findProductById(Long productId);
}
