package com.muhammet.satis.controller;

import com.muhammet.satis.dto.request.MenuSaveRequestDto;
import com.muhammet.satis.dto.response.BasicResponse;
import com.muhammet.satis.entity.Menu;
import com.muhammet.satis.service.MenuService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/add-menu")
    @CrossOrigin("*")
    public ResponseEntity<BasicResponse<Boolean>> addMenu(@RequestBody MenuSaveRequestDto dto){
        menuService.save(dto);
        return ResponseEntity.ok(
                BasicResponse.<Boolean>builder()
                        .status(200)
                        .message("Menu Eklendi")
                        .data(true)
                        .build()
        );
    }
    @GetMapping("/get-all")
    @CrossOrigin("*")
    public ResponseEntity<BasicResponse<List<Menu>>> getAll(){
        return ResponseEntity.ok(
                BasicResponse.<List<Menu>>builder()
                        .status(200)
                        .message("Menuler Getirildi")
                        .data(menuService.getAll())
                        .build()
        );
    }
}
