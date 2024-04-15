package com.muhammet.satis.service;

import com.muhammet.satis.dto.request.PersonelLoginRequestDto;
import com.muhammet.satis.dto.request.PersonelRegisterRequestDto;
import com.muhammet.satis.entity.Personel;
import com.muhammet.satis.exception.ErrorType;
import com.muhammet.satis.exception.SatisServiceException;
import com.muhammet.satis.repository.PersonelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonelService {
    private final PersonelRepository repository;

    public void save(PersonelRegisterRequestDto dto) {
        repository.save(
                Personel.builder()
                        .adsoyad(dto.getAdsoyad())
                        .username(dto.getUsername())
                        .password(dto.getPassword())
                        .build()
        );
    }

    public String login(PersonelLoginRequestDto dto){
        Optional<Personel> personelOptional = repository.findOptionalByUsernameAndPassword(dto.getUsername(),dto.getPassword());
        if (personelOptional.isEmpty())
            throw new SatisServiceException(ErrorType.ERROR_INVALID_LOGIN_PARAMETER);
        return "Token: "+personelOptional.get().getId();
    }

}
