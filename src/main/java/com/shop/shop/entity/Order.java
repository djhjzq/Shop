package com.shop.shop.entity;

import com.shop.shop.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @ManyToOne
    private Product product;

    @ManyToOne
    private Cart cart;

    private Integer quantity;

}