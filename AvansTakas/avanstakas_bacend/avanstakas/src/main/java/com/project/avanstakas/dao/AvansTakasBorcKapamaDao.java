package com.project.avanstakas.dao;

import java.sql.Date;
import java.time.LocalDate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class AvansTakasBorcKapamaDao {


    private final SimpleJdbcCall borcKapamaCall;

    @Autowired
    public AvansTakasBorcKapamaDao(DataSource dataSource) {
        this.borcKapamaCall = new SimpleJdbcCall(dataSource)
                .withSchemaName("OGUZ")
                .withProcedureName("PR_BORC_KAPAMA");
    }

    public void executeBorcKapama(LocalDate takasTarihi) {
        MapSqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("takastarihi", Date.valueOf(takasTarihi));

        borcKapamaCall.execute(inParams);
    }
}
