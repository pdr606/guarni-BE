package com.dev.guarnibe.controller;

import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.dto.IngredientStatsResponseDto;
import com.dev.guarnibe.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/ingredient")
public class IngredientController {

    private IngredientService ingredientService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public IngredientStatsResponseDto create(@RequestBody List<IngredientDto> dtoList){
        return ingredientService.save(dtoList);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/{id}")
    @DeleteMapping
    public void delete(@PathVariable Long id){
        ingredientService.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IngredientDto> findAll(){
        return ingredientService.getAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/{id}")
    public IngredientDto update(@PathVariable Long id, @RequestBody IngredientDto dto){
        return ingredientService.update(id, dto.name());
    }
}
