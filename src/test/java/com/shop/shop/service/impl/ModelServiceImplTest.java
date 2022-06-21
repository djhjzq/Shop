package com.shop.shop.service.impl;


import com.shop.shop.entity.Model;
import com.shop.shop.repository.ModelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ModelServiceImplTest {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImplTest(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Test
    void findModelById() {
        Model model = modelRepository.findById(1L).get();
        assertThat(model.getId()).isEqualTo(1L);
    }

    @Test
    void addModel() {
        Model model = new Model();
        modelRepository.save(model);
        assertThat(model.getId()).isGreaterThan(0);
    }

    @Test
    void deleteModel() {
        modelRepository.delete(modelRepository.findById(1L).get());
        assertThat(modelRepository.findById(1L)).isEmpty();
    }
}