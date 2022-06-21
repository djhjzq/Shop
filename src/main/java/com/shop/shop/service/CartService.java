package com.shop.shop.service;

import com.shop.shop.entity.Cart;

public interface CartService {

    Cart findCartById(Long cartId);

    Cart addCart();

    void createPayment(Long cartId);
}
