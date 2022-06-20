package com.shop.shop.dto.response;

import com.shop.shop.entity.Model;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ModelMapper {
    Model modelResponseToModel(ModelResponse modelResponse);

    ModelResponse modelToModelResponse(Model model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromModelResponse(ModelResponse modelResponse, @MappingTarget Model model);

    @AfterMapping
    default void linkProductList(@MappingTarget Model model) {
        model.getProductList().forEach(productList -> productList.setModel(model));
    }
}
