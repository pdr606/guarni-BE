package com.dev.guarnibe.service;

import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.mapper.IngredientMapper;
import com.dev.guarnibe.model.IngredientEntity;
import com.dev.guarnibe.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientServiceImp implements IngredientService{

    private IngredientRepository ingredientRepository;
    @Override
    public void save(IngredientDto data) {
        existByName(data.name());

        IngredientEntity entity = IngredientMapper.INSTANCE.toEntity(data);
        ingredientRepository.save(entity);
    }

    @Override
    public boolean delete(IngredientDto data) {
        existByName(data.name());
        ingredientRepository.deleteById(data.id());
        return true;
    }

    @Override
    public List<IngredientDto> getAll() {
        List<IngredientEntity> entityList = ingredientRepository.findAll();
        return IngredientMapper.INSTANCE.toDtoList(entityList);
    }

    @Override
    public IngredientDto getById(Long id) {
        IngredientEntity entity = ingredientRepository.findById(id).orElseThrow(RuntimeException::new);
        return IngredientMapper.INSTANCE.toDto(entity);
    }

    @Override
    public boolean existByName(String name) {
        boolean exist = ingredientRepository.existsByName(name);
        if(exist){
            throw new RuntimeException();
        }
        return false;
    }
}
