package com.muhammet.satis.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SepetUrunEklemeRequestDto {
    /**
     * Token -> burada token alınır ve böylece kim ne eklemek istiyor,
     * yetkisi varmı? bunlar kontrol edilir.
     */
    Long userId;
    Long urunId;
    int adet;
    double fiyat;
}
