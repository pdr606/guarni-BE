package com.dev.guarnibe.mapper;


import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.model.IngredientEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IngredientMapperImp implements IngredientMapper {

    @Override
    public IngredientDto toDto(IngredientEntity entity) {
        return IngredientDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .dateTime(entity.getDateTime())
                .build();
    }

    @Override
    public IngredientEntity toEntity(IngredientDto dto) {
        return IngredientEntity.builder()
                .id(dto.id())
                .name(dto.name())
                .dateTime(dto.dateTime())
                .build();
    }

    @Override
    public List<IngredientDto> toDtoList(List<IngredientEntity> entityList) {
        return entityList.stream().map(this::toDto).toList();
    }

    @Override
    public List<IngredientEntity> toEntityList(List<IngredientDto> dtoList) {
        return dtoList.stream().map(this::toEntity).toList();
    }
}
