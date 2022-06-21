package com.shop.shop.service.impl;

import com.shop.shop.entity.Order;
import com.shop.shop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderServiceImplTest {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImplTest(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Test
    void addOrder() {
        Order order = new Order();
        orderRepository.save(order);
        assertThat(order.getId()).isGreaterThan(0);

    }

    @Test
    void findOrderById() {
        Order order = orderRepository.findById(1L).get();
        assertThat(order.getId()).isEqualTo(1L);
    }

    @Test
    void deleteOrder() {
        orderRepository.delete(orderRepository.findById(1L).get());
        assertThat(orderRepository.findById(1L)).isEmpty();
    }

    @Test
    void findAll() {
        List<Order> orderList = orderRepository.findAll();

        assertThat(orderList.size()).isGreaterThan(0);
    }
}