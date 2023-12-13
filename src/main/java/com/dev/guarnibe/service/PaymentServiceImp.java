package com.dev.guarnibe.service;

import com.dev.guarnibe.dto.PaymentDto;
import com.dev.guarnibe.mapper.PaymentMapper;
import com.dev.guarnibe.model.PaymentEntity;
import com.dev.guarnibe.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceImp implements PaymentService {

    private PaymentRepository paymentRepository;

    @Override
    public void save(PaymentDto data) {
        PaymentEntity entity = PaymentMapper.INSTANCE.toEntity(data);
        paymentRepository.save(entity);
    }

    @Override
    public boolean delete(PaymentDto data) {
        paymentRepository.deleteById(data.id());
        return true;
    }

    @Override
    public List<PaymentDto> getAll() {
        List<PaymentEntity> paymentList = paymentRepository.findAll();
        return PaymentMapper.INSTANCE.toDtoList(paymentList);
    }

    @Override
    public PaymentDto getById(Long id) {
        PaymentEntity entity = paymentRepository.findById(id).orElseThrow(RuntimeException::new);
        return PaymentMapper.INSTANCE.toDto(entity);
    }
}
