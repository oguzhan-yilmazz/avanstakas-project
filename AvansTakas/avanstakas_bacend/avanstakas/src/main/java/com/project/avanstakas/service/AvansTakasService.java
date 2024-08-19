package com.project.avanstakas.service;

import com.project.avanstakas.dao.AvansTakasAlacakDagitimDao;
import com.project.avanstakas.dao.AvansTakasBorcKapamaDao;
import com.project.avanstakas.dao.AvansTakasCezaliBorcKapamaDao;
import com.project.avanstakas.dao.AvansTakasListeleDao;
import com.project.avanstakas.model.AvansTakasListeleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AvansTakasService {
    private final AvansTakasListeleDao avansTakasListeleDao;
    private final AvansTakasBorcKapamaDao avansTakasBorcKapamaDao;
    private final AvansTakasCezaliBorcKapamaDao avansTakasCezaliBorcKapamaDao;
    private final AvansTakasAlacakDagitimDao avansTakasAlacakDagitimDao;

    @Autowired
    public AvansTakasService(AvansTakasListeleDao avansTakasListeleDao, 
    		AvansTakasBorcKapamaDao avansTakasBorcKapamaDao,
    		AvansTakasCezaliBorcKapamaDao avansTakasCezaliBorcKapamaDao,
    		AvansTakasAlacakDagitimDao avansTakasAlacakDagitimDao) {
        this.avansTakasListeleDao = avansTakasListeleDao;
        this.avansTakasBorcKapamaDao = avansTakasBorcKapamaDao;
        this.avansTakasCezaliBorcKapamaDao = avansTakasCezaliBorcKapamaDao;
        this.avansTakasAlacakDagitimDao = avansTakasAlacakDagitimDao;
    }

    public List<AvansTakasListeleResponse> getAvansTakasData() {
        return avansTakasListeleDao.fetchAvansTakasData();
    }
    
    public void borcKapama(LocalDate takasTarihi) {
    	avansTakasBorcKapamaDao.executeBorcKapama(takasTarihi);
    }
    
    public void cezaliBorcKapama(LocalDate takasTarihi) {
    	avansTakasCezaliBorcKapamaDao.executeCezaliBorcKapama(takasTarihi);
    }
    
    public void alacakDagitim(LocalDate takasTarihi) {
    	avansTakasAlacakDagitimDao.executeAlacakDagitim(takasTarihi);
    }
}