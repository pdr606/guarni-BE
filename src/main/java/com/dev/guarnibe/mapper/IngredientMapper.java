package com.dev.guarnibe.mapper;

import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.dto.ProductDto;
import com.dev.guarnibe.model.IngredientEntity;
import com.dev.guarnibe.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IngredientMapper {

    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    @Mapping(target = "products", ignore = true)
    IngredientDto toDto(IngredientEntity entity);
    @Mapping(target = "products", ignore = true)
    IngredientEntity toEntity(IngredientDto dto);
    @Mapping(target = "products", ignore = true)
    List<IngredientDto> toDtoList(List<IngredientEntity> entity);
}
