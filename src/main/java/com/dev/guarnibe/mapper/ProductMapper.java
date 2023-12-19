package com.dev.guarnibe.mapper;

import com.dev.guarnibe.dto.ProductDto;
import com.dev.guarnibe.model.ProductEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "ingredient.products", ignore = true)
    @InheritInverseConfiguration
    ProductDto toDto(ProductEntity entity);
    ProductEntity toEntity(ProductDto dto);
    List<ProductDto> toDtoList(List<ProductEntity> entity);
    List<ProductEntity> toEntityList( List<ProductDto> dtoList);
}
