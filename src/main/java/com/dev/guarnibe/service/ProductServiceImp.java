package com.dev.guarnibe.service;

import com.dev.guarnibe.dto.ProductDto;
import com.dev.guarnibe.mapper.ProductMapper;
import com.dev.guarnibe.model.ProductEntity;
import com.dev.guarnibe.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public void save(ProductDto data) {
        existsById(data.id());
        ProductEntity entity = ProductMapper.INSTANCE.toEntity(data);
        productRepository.save(entity);
    }

    @Override
    public boolean delete(ProductDto data) {
        existsById(data.id());
        productRepository.deleteById(data.id());
        return true;
    }

    @Override
    public List<ProductDto> getAll() {
        List<ProductEntity> entityList = productRepository.findAll();
        return ProductMapper.INSTANCE.toDtoList(entityList);
    }

    @Override
    public ProductDto getById(Long id) {
        ProductEntity entity = productRepository.findById(id).orElseThrow(RuntimeException::new);
        return ProductMapper.INSTANCE.toDto(entity);
    }

    @Override
    public boolean existsById(Long id) {
        if(productRepository.existsById(id)){
            return true;
        }
        throw new RuntimeException();
    }
}
