package com.muhammet.satis.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VwSepetDetay {
    Long urunId;
    String ad;
    String resim;
    String aciklama;
    double fiyat;
    int adet;
    double toplamFiyat;
}
