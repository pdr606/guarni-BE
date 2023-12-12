package com.dev.guarnibe.dto;

import com.dev.guarnibe.model.CreateAndUpdateEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record OrderDto(
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Long id,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Double taxService,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        boolean finished,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        CreateAndUpdateEntity dateTime
) {
}
