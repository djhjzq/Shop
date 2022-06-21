package com.shop.shop.service.impl;

import com.shop.shop.entity.Order;
import com.shop.shop.entity.OrderStatus;
import com.shop.shop.service.OrderService;
import com.shop.shop.service.ScheduledTasks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ScheduledTasksImpl implements ScheduledTasks {

    private final OrderService orderService;

    @Autowired
    public ScheduledTasksImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Scheduled(fixedRate = 5000)
    @Override
    public void deleteExpired() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date nowDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        List<Order> orderList = orderService.findAll();
        log.info("Scheduled tasks worked");
        for(Order order: orderList) {
            if(order.getDate().getTime() < nowDate.getTime() && order.getOrderStatus().equals(OrderStatus.ACTIVE)) {
                order.getProduct().getModel().setQuantity(order.getProduct().getModel().getQuantity() + order.getQuantity());
                orderService.deleteOrder(order.getId());
            }
        }
    }
}
