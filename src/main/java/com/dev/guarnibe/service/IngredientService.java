package com.dev.guarnibe.service;

import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.dto.IngredientStatsResponseDto;
import com.dev.guarnibe.model.IngredientEntity;

import java.util.List;

public interface IngredientService {

     void delete(Long id);
     List<IngredientDto> getAll();
     IngredientDto findById(Long id);
     IngredientEntity findByName(String name);
     IngredientDto update(Long id, String name);
    IngredientStatsResponseDto save(List<IngredientDto> dtosList);
    boolean existById(Long id);
    boolean existByName(String name);
}
