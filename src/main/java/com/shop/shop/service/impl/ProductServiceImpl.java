package com.shop.shop.service.impl;

import com.shop.shop.dto.request.ProductRequest;
import com.shop.shop.entity.Product;
import com.shop.shop.repository.ProductRepository;
import com.shop.shop.service.ModelService;
import com.shop.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelService modelService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelService modelService) {
        this.productRepository = productRepository;
        this.modelService = modelService;
    }

    @Override
    public Product findProductById(Long productId) {
        log.info("Try to find product with id: {}", productId);
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product with id "+productId+ " not found"));
    }

    @Override
    public Product addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setModel(modelService.findModelById(productRequest.getModelId()));
        product.setDescription(productRequest.getDescription());
        log.info("Save product with modelId: {} to repository", product.getModel().getId());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        log.info("Try to delete product with id: {}", productId);
        productRepository.delete(findProductById(productId));
    }
}
