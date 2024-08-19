package com.project.avanstakas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvansTakasListeleResponse {
	
    private Long avansId;           // NUMBER
    private Integer musteriNo;      // NUMBER(4)
    private BigDecimal tutar;       // NUMBER(10,2)
    private String borcluAlacakli;  // VARCHAR2(10)
    private String dosya;           // VARCHAR2(50)
    private LocalDate takasTarihi;  // DATE not null
    private BigDecimal odenenTutar; // NUMBER(10,2)
    private BigDecimal havuzToplamBakiye;         // NUMBER(15,2)
    private BigDecimal teminatHavuzToplamBakiye;  // NUMBER(15,2)
    private BigDecimal serbestHesapBakiye;        // NUMBER(15,2)
    private BigDecimal teminatHesapBakiye;        // NUMBER(15,2)
    
    @Override
    public String toString() {
        return "AvansTakasResponse{" +
                "avansId=" + avansId +
                ", musteriNo=" + musteriNo +
                ", tutar=" + tutar +
                ", borcluAlacakli='" + borcluAlacakli + '\'' +
                ", dosya='" + dosya + '\'' +
                ", takasTarihi=" + takasTarihi +
                ", odenenTutar=" + odenenTutar +
                ", havuzToplamBakiye=" + havuzToplamBakiye +
                ", teminatHavuzToplamBakiye=" + teminatHavuzToplamBakiye +
                ", serbestHesapBakiye=" + serbestHesapBakiye +
                ", teminatHesapBakiye=" + teminatHesapBakiye +
                '}';
    }
}