package com.dev.guarnibe.service;

import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.dto.ProductDto;
import com.dev.guarnibe.mapper.ProductMapper;
import com.dev.guarnibe.model.IngredientEntity;
import com.dev.guarnibe.model.ProductEntity;
import com.dev.guarnibe.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final IngredientService ingredientService;

    @Override
    public List<ProductDto> create(List<ProductDto> data) {

        List<ProductEntity> entityList = new ArrayList<>();

        for(ProductDto productDto : data){
            List<IngredientEntity> ingredientEntityList = new ArrayList<>();
            for(IngredientDto ingredientDto : productDto.ingredient()){
                IngredientEntity ingredient = ingredientService.findByName(ingredientDto.name());
                if(ingredient != null){
                    ingredientEntityList.add(ingredient);
                }
            }

            ProductEntity product = ProductMapper.INSTANCE.toEntity(productDto);
            product.setIngredient(ingredientEntityList);
            entityList.add(product);
        }

        return productRepository.saveAll(entityList).stream().map(ProductMapper.INSTANCE::toDto).toList();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProductDto> getAll() {
        return ProductMapper.INSTANCE.toDtoList(productRepository.findAll());
    }

    @Override
    public ProductDto findById(Long id) {
        return null;
    }

    @Override
    public ProductDto update(Long id, String name) {
        return null;
    }

    @Override
    public boolean existById(Long id) {
        return false;
    }

    @Override
    public boolean existByName(String name) {
        return false;
    }
}
