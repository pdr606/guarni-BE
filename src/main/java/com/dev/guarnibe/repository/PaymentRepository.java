package com.dev.guarnibe.repository;

import com.dev.guarnibe.model.PaymentEntity;
import com.dev.guarnibe.model.TabletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
