package com.shop.shop.entity;

import com.shop.shop.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart extends BaseEntity {

    private BigDecimal amount;

    @OneToMany(mappedBy = "cart")
    private List<Order> orderList;

    private CartStatus cartStatus;

}