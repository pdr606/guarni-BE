package com.dev.guarnibe.dto;

import com.dev.guarnibe.model.CreateAndUpdateEntity;
import com.dev.guarnibe.model.OrderEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record PaymentDto(

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Long id,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Double value,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        OrderEntity order,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        CreateAndUpdateEntity dateTime

) {
}
