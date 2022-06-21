package com.shop.shop.service.impl;

import com.shop.shop.entity.Cart;
import com.shop.shop.entity.OrderStatus;
import com.shop.shop.repository.CartRepository;
import com.shop.shop.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    public final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }



    @Override
    public Cart findCartById(Long cartId) {
        log.info("Try to find cart with id: {}", cartId);
        return cartRepository.findById(cartId)
                .orElseThrow(()-> new RuntimeException("Cart with id " + cartId + " not found"));
    }

    @Override
    public Cart addCart() {
        Cart cart = new Cart();
        cart.setAmount(BigDecimal.ZERO);
        log.info("Save cart to repository");
        return cartRepository.save(cart);
    }

    @Override
    public void createPayment(Long cartId) {
        Cart cart = findCartById(cartId);
        log.info("Set all orders status to success");
        cart.getOrderList().forEach(order -> order.setOrderStatus(OrderStatus.SUCCESS));
        log.info("Clear orderList");
        cart.getOrderList().clear();
        cart.setAmount(BigDecimal.ZERO);
        cartRepository.save(cart);
    }
}
