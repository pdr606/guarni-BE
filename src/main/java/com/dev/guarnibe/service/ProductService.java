package com.dev.guarnibe.service;

import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.dto.IngredientStatsResponseDto;
import com.dev.guarnibe.dto.ProductDto;
import com.dev.guarnibe.model.ProductEntity;

import java.util.List;

public interface ProductService{

    List<ProductDto> create(List<ProductDto> data);
    void delete(Long id);
    List<ProductDto> getAll();
    ProductDto findById(Long id);
    ProductDto update(Long id, ProductDto data);
    boolean existById(Long id);
    boolean existByName(String name);

}
