package com.shop.shop.service.impl;

import com.shop.shop.entity.Cart;
import com.shop.shop.repository.CartRepository;
import com.shop.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    public final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart findCartById(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(()-> new RuntimeException("Cart with id " + cartId + " not found"));
    }
}
