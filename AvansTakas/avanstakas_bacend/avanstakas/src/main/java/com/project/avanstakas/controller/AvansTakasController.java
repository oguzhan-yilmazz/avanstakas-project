package com.project.avanstakas.controller;

import com.project.avanstakas.service.AvansTakasService;
import com.project.avanstakas.model.AvansTakasListeleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/avans-takas")
public class AvansTakasController {

    private final AvansTakasService avansTakasService;

    @Autowired
    public AvansTakasController(AvansTakasService avansTakasService) {
        this.avansTakasService = avansTakasService;
    }

    @PostMapping("/listele")
    public ResponseEntity<List<AvansTakasListeleResponse>> listeleAvansTakas() {
        List<AvansTakasListeleResponse> result = avansTakasService.getAvansTakasData();
        System.out.println(result);
        return ResponseEntity.ok(result);
    }
    
    @PostMapping("/borc-kapama")
    public ResponseEntity<String> borcKapama(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate takasTarihi) {
        avansTakasService.borcKapama(takasTarihi);
        return ResponseEntity.ok("Borç kapama işlemi başarıyla tamamlandı.");
    }
    
    @PostMapping("/cezali-borc-kapama")
    public ResponseEntity<String> cezaliBorcKapama(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate takasTarihi) {
        avansTakasService.cezaliBorcKapama(takasTarihi);
        return ResponseEntity.ok("Cezalı borç kapama işlemi başarıyla tamamlandı.");
    }
    
    @PostMapping("/alacak-dagitim")
    public ResponseEntity<String> alacakDagitim(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate takasTarihi) {
        avansTakasService.alacakDagitim(takasTarihi);
        return ResponseEntity.ok("Alacak dağıtım işlemi başarıyla tamamlandı.");
    }
    
}