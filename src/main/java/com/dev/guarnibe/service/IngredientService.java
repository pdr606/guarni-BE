package com.dev.guarnibe.service;

import com.dev.guarnibe.dto.IngredientDto;

public interface IngredientService extends CrudService<IngredientDto> {

    boolean existByName(String name);
}
