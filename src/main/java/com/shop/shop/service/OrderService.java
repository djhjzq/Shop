package com.shop.shop.service;

import com.shop.shop.entity.Order;

public interface OrderService {

    Order addOrder(Long productId, Integer quantity, Long cartId);

    Order findOrderById(Long orderId);

    void deleteOrder(Long orderId);
}
