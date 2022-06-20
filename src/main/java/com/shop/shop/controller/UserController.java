package com.shop.shop.controller;


import com.shop.shop.dto.request.OrderRequest;
import com.shop.shop.dto.response.OrderMapper;
import com.shop.shop.dto.response.OrderResponse;
import com.shop.shop.entity.Order;
import com.shop.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    @Autowired
    public UserController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<OrderResponse> addOrder(OrderRequest orderRequest) {
        return new ResponseEntity<>(orderMapper.orderToOrderResponse(orderService.addOrder(orderRequest.getProductId(), orderRequest.getQuantity(), orderRequest.getCartId())),HttpStatus.OK);
    }
}
