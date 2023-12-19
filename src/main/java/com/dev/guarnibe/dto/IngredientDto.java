package com.dev.guarnibe.dto;

import com.dev.guarnibe.model.CreateAndUpdateEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@Builder
public record IngredientDto(
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Long id,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        String name,

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<ProductDto> products,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        CreateAndUpdateEntity dateTime
) {
}
