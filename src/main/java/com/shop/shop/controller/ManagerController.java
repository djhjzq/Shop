package com.shop.shop.controller;

import com.shop.shop.dto.request.ModelRequest;
import com.shop.shop.dto.request.ProductRequest;
import com.shop.shop.dto.response.ModelMapper;
import com.shop.shop.dto.response.ModelResponse;
import com.shop.shop.dto.response.ProductMapper;
import com.shop.shop.dto.response.ProductResponse;
import com.shop.shop.entity.Product;
import com.shop.shop.service.ModelService;
import com.shop.shop.service.OrderService;
import com.shop.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final ModelService modelService;

    private final ModelMapper modelMapper;

    private final ProductService productService;

    private final ProductMapper productMapper;

    private final OrderService orderService;

    @Autowired
    public ManagerController(ModelService modelService, ModelMapper modelMapper, ProductService productService, ProductMapper productMapper, OrderService orderService) {
        this.modelService = modelService;
        this.modelMapper = modelMapper;
        this.productService = productService;
        this.productMapper = productMapper;
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return null;
    }


    @PostMapping("/add/model")
    public ResponseEntity<ModelResponse> addModel(ModelRequest modelRequest) {
        return new ResponseEntity<>(modelMapper.modelToModelResponse(modelService.addModel(modelRequest)), HttpStatus.OK);
    }

    @PostMapping("/delete/model")
    public ResponseEntity<?> deleteModel(Long modelId) {
        modelService.deleteModel(modelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add/product")
    public ResponseEntity<ProductResponse> addProduct(ProductRequest productRequest) {
        return new ResponseEntity<>(productMapper.productToProductResponse(productService.addProduct(productRequest)), HttpStatus.OK);
    }

    @PostMapping("/delete/product")
    public ResponseEntity<?> deleteProduct(Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
