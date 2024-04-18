package com.muhammet.satis.controller;

import com.muhammet.satis.dto.request.SepetUrunEklemeRequestDto;
import com.muhammet.satis.dto.request.UrunEklemeRequetDto;
import com.muhammet.satis.dto.response.BasicResponse;
import com.muhammet.satis.service.SepetService;
import com.muhammet.satis.view.VwSepetDetay;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sepet")
public class SepetController {
    private final SepetService sepetService;

    @PostMapping("/add-sepet-urun")
    @CrossOrigin("*")
    public ResponseEntity<BasicResponse<Boolean>> addSepetUrun(@RequestBody SepetUrunEklemeRequestDto dto){
        sepetService.sepeteEkle(dto);
        return ResponseEntity.ok(
                BasicResponse.<Boolean>builder()
                        .data(true)
                        .message("Sepete Eklendi")
                        .status(200)
                        .build()
        );
    }

    @GetMapping("/get-all")
    @CrossOrigin("*")
    public ResponseEntity<BasicResponse<List<VwSepetDetay>>> getAll(Long userId){
        return ResponseEntity.ok(
                BasicResponse.<List<VwSepetDetay>>builder()
                        .status(200)
                        .message("Sepetler Getirildi")
                        .data(sepetService.getAll(userId))
                        .build()
        );
    }
}
