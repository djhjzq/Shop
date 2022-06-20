package com.shop.shop.dto.response;

import com.shop.shop.entity.Order;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "productModelId", target = "product.model.id")
    @Mapping(source = "productModelName", target = "product.model.name")
    @Mapping(source = "productModelPrice", target = "product.model.price")
    @Mapping(source = "productDescription", target = "product.description")
    Order orderResponseToOrder(OrderResponse orderResponse);

    @InheritInverseConfiguration(name = "orderResponseToOrder")
    OrderResponse orderToOrderResponse(Order order);

    @InheritConfiguration(name = "orderResponseToOrder")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrderFromOrderResponse(OrderResponse orderResponse, @MappingTarget Order order);
}
