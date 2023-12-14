package com.dev.guarnibe.common;

import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.dto.IngredientStatsResponseDto;
import com.dev.guarnibe.model.CreateAndUpdateEntity;
import com.dev.guarnibe.model.IngredientEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class IngredientConstants {

    public static final IngredientDto VALID_INGREDIENT_DTO =
            IngredientDto.builder()
                    .id(null)
                    .name("VALID_NAME")
                    .dateTime(CreateAndUpdateEntity.builder()
                            .created(LocalDateTime.now())
                            .updated(LocalDateTime.now())
                            .build())
                    .products(null)
                    .build();

    public static final IngredientEntity VALID_INGREDIENT_ENTITY =
            IngredientEntity.builder()
                    .id(null)
                    .name("VALID_NAME")
                    .dateTime(CreateAndUpdateEntity.builder()
                            .created(LocalDateTime.now())
                            .updated(LocalDateTime.now())
                            .build())
                    .products(null)
                    .build();

    public static final List<IngredientDto> VALID_LIST_INGREDIENT_DTO =
            new ArrayList<>(List.of(VALID_INGREDIENT_DTO, VALID_INGREDIENT_DTO));

    public static final List<IngredientEntity> VALID_LIST_INGREDIENT_ENTITY =
            new ArrayList<>(List.of(VALID_INGREDIENT_ENTITY, VALID_INGREDIENT_ENTITY));


    public static final String NAME_INGREDIENT_UPDATE = "VALID_NAME_UPDATE";
}
