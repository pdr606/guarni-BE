package com.dev.guarnibe.dto;

import com.dev.guarnibe.model.CreateAndUpdateEntity;
import com.dev.guarnibe.model.enums.CategoryTypes;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@Builder
public record ProductDto(
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Long id,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        String name,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Double price,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        String description,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Integer requests,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        boolean available,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<IngredientDto> ingredient,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        CategoryTypes type,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        CreateAndUpdateEntity dateTime
) {
}
