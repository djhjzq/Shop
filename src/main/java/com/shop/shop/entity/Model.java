package com.shop.shop.entity;

import com.shop.shop.entity.base.NamedEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "model")
public class Model extends NamedEntity {

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Product> productList;
}