package com.muhammet.satis.controller;

import com.muhammet.satis.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/urun")
public class UrunController {
    private final UrunService urunService;
}
