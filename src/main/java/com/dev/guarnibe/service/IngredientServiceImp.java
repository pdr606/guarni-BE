package com.dev.guarnibe.service;

import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.dto.IngredientStatsResponseDto;
import com.dev.guarnibe.mapper.IngredientMapper;
import com.dev.guarnibe.model.IngredientEntity;
import com.dev.guarnibe.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IngredientServiceImp implements IngredientService{

    private IngredientRepository ingredientRepository;
    private IngredientMapper ingredientMapper;

    @Override
    public IngredientStatsResponseDto save(List<IngredientDto> data) {
        List<IngredientEntity> entityList = new ArrayList<>();
        List<String> duplicateNameList = new ArrayList<>();

        int error = 0;
        int success = 0;

        for(IngredientDto ingredient : data){
            if(!existByName(ingredient.name())){
                entityList.add(ingredientMapper.toEntity(ingredient));
                success++;
            }
            else{
                duplicateNameList.add(ingredient.name());
                error++;
            }
        }

        ingredientRepository.saveAll(entityList);

        return IngredientStatsResponseDto.builder().nameWithError(duplicateNameList)
                .withSuccess(success)
                .withError(error)
                .build();
    }

    @Override
    public boolean existById(Long id) {
        return ingredientRepository.existsById(id);
    }

    @Override
    public boolean existByName(String name) {
        return ingredientRepository.existsByName(name);
    }

    @Override
    public void delete(Long id) {
        try{
            ingredientRepository.deleteById(id);
        } catch (RuntimeException ex){
            throw new RuntimeException();
        }
    }

    @Override
    public List<IngredientDto> getAll() {
        List<IngredientEntity> entityList = ingredientRepository.findAll();
        return ingredientMapper.toDtoList(entityList);
    }

    @Override
    public IngredientDto findById(Long id) {
        IngredientEntity entity = ingredientRepository.findById(id).orElseThrow(RuntimeException::new);
        return ingredientMapper.toDto(entity);
    }

    @Override
    public IngredientEntity findByName(String name) {
        if(existByName(name)){
            return ingredientRepository.findByName(name);
        }
        return null;
    }

    @Override
    public IngredientDto update(Long id, String name) {
       if(!existByName(name)){
           IngredientEntity entity = ingredientRepository.getReferenceById(id);
           entity.setName(name);
           ingredientRepository.save(entity);
           return ingredientMapper.toDto(entity);
       }
       throw new RuntimeException();
    }
}
