package com.muhammet.satis.repository;

import com.muhammet.satis.entity.SepetDetay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SepetDetayRepository extends JpaRepository<SepetDetay,Long> {
    Optional<SepetDetay> findOptionalBySepetIdAndUrunId(Long id, Long urunId);

    List<SepetDetay> findAllBySepetId(Long id);
}
