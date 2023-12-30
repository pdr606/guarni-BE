package com.dev.guarnibe.repository;

import com.dev.guarnibe.model.IngredientEntity;
import com.dev.guarnibe.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
    public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    boolean existsById(Long id);
    boolean existsByName(String name);

    List<ProductEntity> findAllByIngredient(List<IngredientEntity> ingredient);

}
