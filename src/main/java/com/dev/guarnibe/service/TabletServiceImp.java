package com.dev.guarnibe.service;


import com.dev.guarnibe.dto.TabletDto;
import com.dev.guarnibe.mapper.TabletMapper;
import com.dev.guarnibe.model.TabletEntity;
import com.dev.guarnibe.repository.TabletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TabletServiceImp implements TabletService {

    private TabletRepository tabletRepository;

    @Override
    public void save(TabletDto data) {
        TabletEntity entity = TabletMapper.INSTANCE.toEntity(data);
        tabletRepository.save(entity);
    }

    @Override
    public boolean delete(TabletDto data) {
        tabletRepository.deleteById(data.id());
        return true;
    }

    @Override
    public List<TabletDto> getAll() {
        List<TabletEntity> entityList = tabletRepository.findAll();
        return TabletMapper.INSTANCE.toDtoList(entityList);
    }

    @Override
    public TabletDto getById(Long id) {
        TabletEntity entity = tabletRepository.findById(id).orElseThrow(RuntimeException::new);
        return TabletMapper.INSTANCE.toDto(entity);
    }
}
