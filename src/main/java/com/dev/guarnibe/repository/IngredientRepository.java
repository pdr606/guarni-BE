package com.dev.guarnibe.repository;

import com.dev.guarnibe.model.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

    boolean existsByName(String name);
}
