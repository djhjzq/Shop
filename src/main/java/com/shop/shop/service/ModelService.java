package com.shop.shop.service;

import com.shop.shop.dto.request.ModelRequest;
import com.shop.shop.entity.Model;

public interface ModelService {

    Model findModelById(Long modelId);

    Model addModel(ModelRequest modelRequest);

    void deleteModel(Long modelId);
}
