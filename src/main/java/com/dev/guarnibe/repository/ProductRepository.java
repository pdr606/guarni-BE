package com.dev.guarnibe.repository;

import com.dev.guarnibe.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    boolean existsById(Long id);
}