package com.dev.guarnibe.mapper;


import com.dev.guarnibe.dto.ProductDto;
import com.dev.guarnibe.dto.TableDto;
import com.dev.guarnibe.model.ProductEntity;
import com.dev.guarnibe.model.TableEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TableMapper {

    TableMapper INSTANCE = Mappers.getMapper(TableMapper.class);

    TableDto toDto(TableEntity entity);
    TableEntity toEntity(TableDto dto);
    List<TableDto> toDtoList(List<TableEntity> entity);
}
