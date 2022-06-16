package com.shop.shop.controller;

import com.shop.shop.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return null;
    }
}
