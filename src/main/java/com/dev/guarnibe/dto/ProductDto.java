package com.dev.guarnibe.dto;

import com.dev.guarnibe.model.CreateAndUpdateEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record ProductDto(
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Long id,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Double price,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        String description,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Integer requests,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        boolean available,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        CreateAndUpdateEntity dateTime
) {
}
