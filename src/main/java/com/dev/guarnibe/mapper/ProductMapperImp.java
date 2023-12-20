package com.dev.guarnibe.mapper;

import com.dev.guarnibe.dto.ProductDto;
import com.dev.guarnibe.model.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductMapperImp implements ProductMapper {


    private IngredientMapper ingredientMapper;

    @Override
    public ProductDto toDto(ProductEntity entity) {
        return ProductDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .requests(entity.getRequests())
                .available(entity.isAvailable())
                .dateTime(entity.getDateTime())
                .type(entity.getType())
                .ingredient(ingredientMapper.toDtoList(entity.getIngredient()))
                .build();
    }

    @Override
    public ProductEntity toEntity(ProductDto dto) {
        return ProductEntity.builder()
                .id(dto.id())
                .name(dto.name())
                .price(dto.price())
                .description(dto.description())
                .requests(dto.requests())
                .available(dto.available())
                .dateTime(dto.dateTime())
                .type(dto.type())
                .ingredient(ingredientMapper.toEntityList(dto.ingredient()))
                .build();
    }

    @Override
    public List<ProductDto> toDtoList(List<ProductEntity> entityList) {
        return entityList.stream().map(this::toDto).toList();
    }

    @Override
    public List<ProductEntity> toEntityList(List<ProductDto> dtoList) {
        return dtoList.stream().map((this::toEntity)).toList();
    }
}
