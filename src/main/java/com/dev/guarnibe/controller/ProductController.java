package com.dev.guarnibe.controller;

import com.dev.guarnibe.dto.ProductDto;
import com.dev.guarnibe.model.ProductEntity;
import com.dev.guarnibe.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public List<ProductDto> save(@RequestBody List<ProductDto> data){
        return productService.create(data);
    }

    @GetMapping
    public List<ProductDto> findAll(){
        return productService.getAll();
    }

}
