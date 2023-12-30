package com.dev.guarnibe.service;

import com.dev.guarnibe.dto.IngredientDto;
import com.dev.guarnibe.dto.ProductDto;
import com.dev.guarnibe.mapper.ProductMapper;
import com.dev.guarnibe.mapper.ProductMapperImp;
import com.dev.guarnibe.model.IngredientEntity;
import com.dev.guarnibe.model.ProductEntity;
import com.dev.guarnibe.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final IngredientService ingredientService;
    private ProductMapper productMapper;

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

            ProductEntity product = productMapper.toEntity(productDto);
            product.setType(productDto.type());
            product.setIngredient(ingredientEntityList);
            entityList.add(product);
        }

        entityList = productRepository.saveAll(entityList);
        return productMapper.toDtoList(entityList);
    }

    @Override
    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }

    }

    @Override
    public List<ProductDto> getAll() {
        List<ProductEntity> entityList = productRepository.findAll();
        return productMapper.toDtoList(entityList);
    }

    @Override
    public ProductDto findById(Long id) {
        ProductEntity product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        return productMapper.toDto(product);
    }

    @Override
    public ProductDto update(Long id, ProductDto data) {
        try {
            ProductEntity product = productRepository.getReferenceById(id);
            if(!existByName(data.name())){
                // ProductMapper.INSTANCE.updateProductFromDto(data, product);
                productRepository.save(product);
                return productMapper.toDto(product);
            }
            return null;
        } catch (RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public boolean existById(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public boolean existByName(String name) {
        boolean res = productRepository.existsByName(name);
        if(res){
            throw new RuntimeException();
        }
        return false;
    }

    @Override
    public List<ProductDto> findAllByIngredient(List<String> ingredients) {
        if(ingredients.isEmpty()){
            return Collections.emptyList();
        }

        List<IngredientEntity> ingredientEntityList = new ArrayList<>();

        for(String ingredient : ingredients){
            IngredientEntity ingredientEntity = ingredientService.findByName(ingredient);
            if(ingredientEntity != null){
                ingredientEntityList.add(ingredientEntity);
            }
        }

        List<ProductEntity> productEntities = productRepository.findAllByIngredient(ingredientEntityList);
        return productMapper.toDtoList(productEntities);

    }

}
