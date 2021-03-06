package com.shop.shop.controller;


import com.shop.shop.dto.request.OrderRequest;
import com.shop.shop.dto.response.OrderMapper;
import com.shop.shop.dto.response.OrderResponse;
import com.shop.shop.service.CartService;
import com.shop.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    private final CartService cartService;

    @Autowired
    public UserController(OrderService orderService, OrderMapper orderMapper, CartService cartService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<OrderResponse> addOrder(OrderRequest orderRequest) {
        return new ResponseEntity<>(orderMapper.orderToOrderResponse(orderService.addOrder(orderRequest.getProductId(), orderRequest.getQuantity(), orderRequest.getCartId())),HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteOrder(Long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create/payment")
    public ResponseEntity<?> createPayment(Long cartId) {
        cartService.createPayment(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
