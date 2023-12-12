package com.dev.guarnibe.mapper;

import com.dev.guarnibe.dto.PaymentDto;
import com.dev.guarnibe.dto.ProductDto;
import com.dev.guarnibe.model.PaymentEntity;
import com.dev.guarnibe.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
    PaymentDto toDto(PaymentEntity entity);
    PaymentEntity toEntity(PaymentDto dto);
    List<PaymentDto> toDtoList(List<PaymentEntity> entity);
}
