package com.muhammet.satis.repository;

import com.muhammet.satis.entity.Sepet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SepetRepository extends JpaRepository<Sepet,Long> {
    Optional<Sepet> findOptionalByUserId(Long userId);

    Sepet findByUserId(Long userId);
}
