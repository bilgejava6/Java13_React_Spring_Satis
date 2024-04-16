package com.muhammet.satis.service;

import com.muhammet.satis.dto.request.UrunEklemeRequetDto;
import com.muhammet.satis.entity.Urun;
import com.muhammet.satis.repository.UrunRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UrunService {
    private final UrunRepository repository;

    public Boolean save(UrunEklemeRequetDto dto) {
        repository.save(Urun.builder()
                        .aciklama(dto.getAciklama())
                        .ad(dto.getAd())
                        .fiyat(dto.getFiyat())
                        .resim(dto.getResim())
                .build());

        return true;
    }

    public List<Urun> getAll(){
        return repository.findAll();
    }
}
