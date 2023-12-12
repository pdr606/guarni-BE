package com.dev.guarnibe.mapper;


import com.dev.guarnibe.dto.TableDto;
import com.dev.guarnibe.dto.TabletDto;
import com.dev.guarnibe.model.TableEntity;
import com.dev.guarnibe.model.TabletEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TabletMapper {

    TabletMapper INSTANCE = Mappers.getMapper(TabletMapper.class);

    TabletDto toDto(TabletEntity entity);
    TabletEntity toEntity(TabletDto dto);
    List<TabletDto> toDtoList(List<TabletEntity> entity);
}
