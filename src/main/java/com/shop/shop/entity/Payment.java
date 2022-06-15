package com.shop.shop.entity;

import com.shop.shop.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {
}