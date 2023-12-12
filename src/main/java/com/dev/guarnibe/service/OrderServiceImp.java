package com.dev.guarnibe.service;


import com.dev.guarnibe.dto.OrderDto;
import com.dev.guarnibe.mapper.OrderMapper;
import com.dev.guarnibe.model.OrderEntity;
import com.dev.guarnibe.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImp implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public void save(OrderDto data) {
        OrderEntity entity = OrderMapper.INSTANCE.toEntity(data);
        orderRepository.save(entity);

    }

    @Override
    public boolean delete(OrderDto data) {
        orderRepository.deleteById(data.id());
        return true;
    }

    @Override
    public List<OrderDto> getAll() {
        List<OrderEntity> orders = orderRepository.findAll();
        return OrderMapper.INSTANCE.toDtoList(orders);
    }

    @Override
    public OrderDto getById(Long id) {
        OrderEntity entity = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        return OrderMapper.INSTANCE.toDto(entity);
    }
}
