package com.dev.guarnibe.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record TableDto(
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Long id,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Integer number,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        boolean available,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Integer uses
) {
}
