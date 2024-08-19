package com.project.avanstakas.dao;

import java.sql.Date;
import java.time.LocalDate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class AvansTakasCezaliBorcKapamaDao {
	
    private final SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public AvansTakasCezaliBorcKapamaDao(DataSource dataSource) {
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withSchemaName("OGUZ")
                .withProcedureName("PR_CEZALI_BORC_KAPAMA");
    }

    public void executeCezaliBorcKapama(LocalDate takasTarihi) {
        MapSqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("takastarihi", Date.valueOf(takasTarihi));

        simpleJdbcCall.execute(inParams);
    }

}
