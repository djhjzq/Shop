package com.shop.shop.controller;

import com.shop.shop.dto.request.ModelRequest;
import com.shop.shop.dto.response.ModelMapper;
import com.shop.shop.dto.response.ModelResponse;
import com.shop.shop.entity.Model;
import com.shop.shop.entity.Product;
import com.shop.shop.service.ModelService;
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

    @Autowired
    public ManagerController(ModelService modelService, ModelMapper modelMapper) {
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return null;
    }


    @PostMapping("/add/model")
    public ResponseEntity<ModelResponse> addModel(ModelRequest modelRequest) {
        return new ResponseEntity<>(modelMapper.modelToModelResponse(modelService.addModel(modelRequest)), HttpStatus.OK);
    }
}
