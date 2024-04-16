package com.muhammet.satis.service;

import com.muhammet.satis.dto.request.MenuSaveRequestDto;
import com.muhammet.satis.entity.Menu;
import com.muhammet.satis.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService{
    private final MenuRepository repository;

    public void save(MenuSaveRequestDto dto){
        repository.save(Menu.builder()
                        .ad(dto.getAd())
                        .url(dto.getUrl())
                .build());
    }

    public List<Menu> getAll(){
        return repository.findAll();
    }
}
