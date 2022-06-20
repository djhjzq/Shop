package com.shop.shop.dto.response;

import com.shop.shop.entity.Product;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "modelId", target = "model.id")
    @Mapping(source = "modelName", target = "model.name")
    @Mapping(source = "modelQuantity", target = "model.quantity")
    @Mapping(source = "modelPrice", target = "model.price")
    Product productResponseToProduct(ProductResponse productResponse);

    @InheritInverseConfiguration(name = "productResponseToProduct")
    ProductResponse productToProductResponse(Product product);

    @InheritConfiguration(name = "productResponseToProduct")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductFromProductResponse(ProductResponse productResponse, @MappingTarget Product product);
}
