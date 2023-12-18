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

        List<ProductEntity> productSaves = data.stream()
                .map(product -> {
                    List<IngredientEntity> ingredientEntityList = product.ingredient().stream()
                            .map(ingredient -> ingredientService.findByName(ingredient.name()))
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList());

                    return ProductEntity.builder()
                            .available(true)
                            .price(product.price())
                            .description(product.description())
                            .ingredient(ingredientEntityList)
                            .build();
                })
                .collect(Collectors.toList());

        productRepository.saveAll(productSaves);
        return ProductMapper.INSTANCE.toDtoList(productSaves);
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
