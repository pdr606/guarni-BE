package com.dev.guarnibe.service;


import com.dev.guarnibe.dto.TableDto;
import com.dev.guarnibe.mapper.TableMapper;
import com.dev.guarnibe.model.TableEntity;
import com.dev.guarnibe.repository.TableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TableServiceImp implements TableService {

    private TableRepository tableRepository;

    @Override
    public void save(TableDto data) {
        TableEntity entity = TableMapper.INSTANCE.toEntity(data);
        tableRepository.save(entity);
    }

    @Override
    public boolean delete(TableDto data) {
        tableRepository.deleteById(data.id());
        return true;
    }

    @Override
    public List<TableDto> getAll() {
        List<TableEntity> entityList = tableRepository.findAll();
        return TableMapper.INSTANCE.toDtoList(entityList);
    }

    @Override
    public TableDto getById(Long id) {
        TableEntity entity = tableRepository.findById(id).orElseThrow(RuntimeException::new);
        return TableMapper.INSTANCE.toDto(entity);
    }
}
