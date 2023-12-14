package com.dev.guarnibe.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record IngredientStatsResponseDto(
        List<String> nameWithError,
        Integer withSuccess,
        Integer withError
) {
}
