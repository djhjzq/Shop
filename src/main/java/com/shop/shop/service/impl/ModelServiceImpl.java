package com.shop.shop.service.impl;

import com.shop.shop.dto.request.ModelRequest;
import com.shop.shop.entity.Model;
import com.shop.shop.repository.ModelRepository;
import com.shop.shop.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model findModelById(Long modelId) {
        log.info("Try to find model with id: {}", modelId);
        return modelRepository.findById(modelId).orElseThrow
                (()-> new RuntimeException("Model with id "+modelId+" not found"));
    }

    @Override
    public Model addModel(ModelRequest modelRequest) {
        Model model = new Model();
        model.setQuantity(modelRequest.getQuantity());
        model.setPrice(modelRequest.getPrice());
        model.setName(modelRequest.getName());
        log.info("Save model with name: {} to repository", model.getName());
        return modelRepository.save(model);
    }

    @Override
    public void deleteModel(Long modelId) {
        log.info("Try to delete model with id: {}", modelId);
        modelRepository.delete(findModelById(modelId));
    }
}
