package com.dev.guarnibe.service;

import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.dto.IngredientStatsResponseDto;

import java.util.List;

public interface IngredientService {

     void delete(Long id);
     List<IngredientDto> getAll();
     IngredientDto findById(Long id);
     IngredientDto update(Long id, String name);
    IngredientStatsResponseDto save(List<IngredientDto> dtosList);
    boolean existById(Long id);
    boolean existByName(String name);
}
