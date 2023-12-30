package com.dev.guarnibe.service;

import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.dto.IngredientStatsResponseDto;
import com.dev.guarnibe.mapper.IngredientMapper;
import com.dev.guarnibe.model.IngredientEntity;
import com.dev.guarnibe.repository.IngredientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static com.dev.guarnibe.common.IngredientConstants.*;

@ExtendWith(MockitoExtension.class)
class IngredientServiceImpTest {

    @Mock
    private IngredientRepository ingredientRepository;
    private IngredientMapper ingredientMapper;
    @InjectMocks
    private IngredientServiceImp ingredientService;

    @Test
    void createIngredient_WithValidDto_ReturnsStatsWithSuccess() {
        when(ingredientRepository.saveAll(any())).thenReturn(null);
        when(ingredientRepository.existsByName(any())).thenReturn(false);

        IngredientStatsResponseDto sut = ingredientService.save(VALID_LIST_INGREDIENT_DTO);

        assertThat(sut.withSuccess()).isEqualTo(2);
        assertThat(sut.withError()).isEqualTo(0);
        assertThat(sut.nameWithError()).isEmpty();
    }

    @Test
    void createIngredient_WithDuplicateName_ReturnsStatsWithError() {
        when(ingredientRepository.saveAll(any())).thenReturn(null);
        when(ingredientRepository.existsByName(any())).thenReturn(true);

        IngredientStatsResponseDto sut = ingredientService.save(VALID_LIST_INGREDIENT_DTO);

        assertThat(sut.withSuccess()).isEqualTo(0);
        assertThat(sut.withError()).isEqualTo(2);
        assertThat(sut.nameWithError()).hasSize(2);
    }

    @Test
    void deleteIngredient_WithValidId_WithSuccess() {
        assertThatCode(() -> ingredientService.delete(1L)).doesNotThrowAnyException();
    }

    @Test
    void getAllIngredients_WithValidData_ReturnsArray() {
        when(ingredientRepository.findAll()).thenReturn(VALID_LIST_INGREDIENT_ENTITY);

        List<IngredientDto> sut = ingredientService.getAll();

        assertThat(sut.get(0).name()).isEqualTo(VALID_LIST_INGREDIENT_DTO.get(0).name());
        assertThat(sut.get(0).dateTime().getCreated()).isNotNull();
        assertThat(sut.size()).isEqualTo(2);
    }

    @Test
    void findById_WithValidId_ReturnSuccess() {
        when(ingredientRepository.findById(1L)).thenReturn(Optional.of(VALID_INGREDIENT_ENTITY));

        IngredientDto sut = ingredientService.findById(1L);

        assertThat(sut).isNotNull();
        assertThat(sut.name()).isEqualTo(VALID_INGREDIENT_ENTITY.getName());

    }
    
    @Test
    void findById_WithInvalidId_ThrowsException(){
        doThrow(new RuntimeException()).when(ingredientRepository).findById(99L);

        assertThatThrownBy(() -> ingredientService.findById(99L)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void update_WithValidIdAndName_ReturnSuccess() {
        when(ingredientRepository.getReferenceById(1L)).thenReturn(VALID_INGREDIENT_ENTITY);

        IngredientDto sut = ingredientService.update(1L, NAME_INGREDIENT_UPDATE);

        assertThat(sut).isNotNull();
        assertThat(sut.name()).isEqualTo(NAME_INGREDIENT_UPDATE);
    }
}