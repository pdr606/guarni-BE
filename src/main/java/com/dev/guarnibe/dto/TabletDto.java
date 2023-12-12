package com.dev.guarnibe.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record TabletDto(

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Long id,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        int battery,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        boolean available

) {
}
