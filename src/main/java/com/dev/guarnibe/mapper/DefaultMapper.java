package com.dev.guarnibe.mapper;
import java.util.List;
public interface DefaultMapper<T, C> {

    T toDto(C entity);
    C toEntity(T dto);
    List<T> toDtoList(List<C> entityList);
    List<C> toEntityList(List<T> dtoList);
}
