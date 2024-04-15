package com.muhammet.satis.controller;

import com.muhammet.satis.dto.request.PersonelLoginRequestDto;
import com.muhammet.satis.dto.request.PersonelRegisterRequestDto;
import com.muhammet.satis.dto.response.BasicResponse;
import com.muhammet.satis.service.PersonelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personel")
public class PersonelController {
    private final PersonelService personelService;

    @PostMapping("/register")
    @CrossOrigin("*")
    public ResponseEntity<BasicResponse<Boolean>> register(@RequestBody PersonelRegisterRequestDto dto){
        personelService.save(dto);
        return ResponseEntity.ok(BasicResponse.<Boolean>builder()
                        .status(200)
                        .message("Kayıt Başarılı")
                        .data(true)
                .build());
    }

    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<BasicResponse<String>> login(@RequestBody PersonelLoginRequestDto dto){
        String token = personelService.login(dto);
        return ResponseEntity.ok(BasicResponse.<String>builder()
                        .status(200)
                        .message("Giriş Başarılı")
                        .data(token)
                .build());
    }

}
