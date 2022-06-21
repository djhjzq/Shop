package com.shop.shop.service.impl;

import com.shop.shop.entity.Product;
import com.shop.shop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductServiceImplTest {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImplTest(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    void findProductById() {
        Product product = productRepository.findById(1L).get();
        assertThat(product.getId()).isEqualTo(1L);
    }

    @Test
    void addProduct() {
        Product product = new Product();
        productRepository.save(product);
        assertThat(product.getId()).isGreaterThan(0);
    }

    @Test
    void deleteProduct() {
        productRepository.delete(productRepository.findById(1L).get());
        assertThat(productRepository.findById(1L)).isEmpty();
    }

    @Test
    void getProducts() {
        List<Product> productList = productRepository.findAll();

        assertThat(productList.size()).isGreaterThan(0);
    }
}