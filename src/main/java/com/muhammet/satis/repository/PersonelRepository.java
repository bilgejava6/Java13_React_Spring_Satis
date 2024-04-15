package com.muhammet.satis.repository;

import com.muhammet.satis.entity.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonelRepository extends JpaRepository<Personel,Long> {
    Optional<Personel> findOptionalByUsernameAndPassword(String username, String password);
}
