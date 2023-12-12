package com.dev.guarnibe.repository;

import com.dev.guarnibe.model.TabletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabletRepository extends JpaRepository<TabletEntity, Long> {
}
