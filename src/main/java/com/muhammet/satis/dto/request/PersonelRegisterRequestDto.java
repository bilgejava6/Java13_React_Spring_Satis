package com.muhammet.satis.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonelRegisterRequestDto {
    String adsoyad;
    String username;
    String password;
}
