package com.muhammet.satis.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UrunEklemeRequetDto {
    String ad;
    String aciklama;
    double fiyat;
    String resim;
}
