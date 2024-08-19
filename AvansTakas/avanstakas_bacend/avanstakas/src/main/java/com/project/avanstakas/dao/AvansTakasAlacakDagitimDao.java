package com.project.avanstakas.dao;

import java.sql.Date;
import java.time.LocalDate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class AvansTakasAlacakDagitimDao {
	
    private final SimpleJdbcCall alacakDagitimCall;

    @Autowired
    public AvansTakasAlacakDagitimDao(DataSource dataSource) {
        this.alacakDagitimCall = new SimpleJdbcCall(dataSource)
                .withSchemaName("OGUZ")
                .withProcedureName("PR_ALACAK_DAGITIM");
    }

    public void executeAlacakDagitim(LocalDate takasTarihi) {
        MapSqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("takastarihi", Date.valueOf(takasTarihi));

        alacakDagitimCall.execute(inParams);
    }

}
