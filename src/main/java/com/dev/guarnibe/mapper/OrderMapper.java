package com.dev.guarnibe.mapper;

import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.dto.OrderDto;
import com.dev.guarnibe.model.IngredientEntity;
import com.dev.guarnibe.model.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto toDto(OrderEntity entity);
    OrderEntity toEntity(OrderDto dto);
    List<OrderDto> toDtoList(List<OrderEntity> entity);
}
