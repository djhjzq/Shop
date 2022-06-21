package com.shop.shop.service.impl;

import com.shop.shop.entity.Cart;
import com.shop.shop.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CartServiceImplTest {

    private final CartRepository cartRepository;


    @Autowired
    public CartServiceImplTest(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Test
    void findCartById() {
        Cart cart = cartRepository.findById(1L).get();
        assertThat(cart.getId()).isEqualTo(1L);
    }

    @Test
    void addCart() {
        Cart cart = new Cart();
        cartRepository.save(cart);
        assertThat(cart.getId()).isGreaterThan(0);
    }

}