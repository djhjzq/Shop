package com.shop.shop.entity;

import com.shop.shop.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends BaseEntity {
    @ManyToOne
    private Model model;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Order> orderList;

    private String description;

}