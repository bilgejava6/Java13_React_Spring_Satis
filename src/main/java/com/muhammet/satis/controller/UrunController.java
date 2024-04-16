package com.muhammet.satis.controller;

import com.muhammet.satis.dto.request.UrunEklemeRequetDto;
import com.muhammet.satis.dto.response.BasicResponse;
import com.muhammet.satis.entity.Urun;
import com.muhammet.satis.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/urun")
public class UrunController {
    private final UrunService urunService;

    @PostMapping("/ekle")
    @CrossOrigin("*")
    public ResponseEntity<BasicResponse<Boolean>> urunEkle(@RequestBody UrunEklemeRequetDto dto){
        return ResponseEntity.ok(
                BasicResponse.<Boolean>builder()
                        .message("Urun Eklendi")
                        .status(200)
                        .data(urunService.save(dto))
                        .build()
        );
    }

    @GetMapping("/get-all")
    @CrossOrigin("*")
    public ResponseEntity<BasicResponse<List<Urun>>> getAll(){
        return ResponseEntity.ok(
                BasicResponse.<List<Urun>>builder()
                        .status(200)
                        .message("Urunler Getirildi")
                        .data(urunService.getAll())
                        .build()
        );
    }
}
