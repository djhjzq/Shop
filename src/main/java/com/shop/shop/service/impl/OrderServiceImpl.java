package com.shop.shop.service.impl;

import com.shop.shop.entity.Order;
import com.shop.shop.entity.OrderStatus;
import com.shop.shop.entity.Product;
import com.shop.shop.repository.OrderRepository;
import com.shop.shop.service.CartService;
import com.shop.shop.service.OrderService;
import com.shop.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class OrderServiceImpl implements OrderService {

    @Value("600000")
    private Integer expirationMs;

    private final CartService cartService;

    private final ProductService productService;

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(CartService cartService, ProductService productService, OrderRepository orderRepository) {
        this.cartService = cartService;
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order addOrder(Long productId, Integer quantity, Long cartId) {
        Order order = new Order();
        order.setCart(cartService.findCartById(cartId));
        order.setOrderStatus(OrderStatus.ACTIVE);
        LocalDateTime localDateTime = LocalDateTime.now();
        Date nowDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        order.setDate(new Date(nowDate.getTime()+expirationMs));
        Product product = productService.findProductById(productId);
        product.getModel().setQuantity(product.getModel().getQuantity() - quantity);
        order.setQuantity(quantity);
        order.setProduct(product);
        return orderRepository.save(order);
    }
}
