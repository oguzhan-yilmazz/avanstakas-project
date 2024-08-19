package com.project.avanstakas.dao;

import com.project.avanstakas.model.AvansTakasListeleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AvansTakasListeleDao {

    private final SimpleJdbcCall simpleJdbcCall;


    @Autowired
    public AvansTakasListeleDao(DataSource dataSource) {
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withSchemaName("OGUZ")  // Şema adını Unicode karakter kullanarak yazın
                .withProcedureName("PR_LISTELE")  // Prosedür adını da Unicode karakter kullanarak yazın
                .returningResultSet("p_cursor", new AvansTakasResultMapper());
        
    }
    
    @SuppressWarnings("unchecked")
	public List<AvansTakasListeleResponse> fetchAvansTakasData() {
        return simpleJdbcCall.executeObject(List.class);
    }

    private static class AvansTakasResultMapper implements RowMapper<AvansTakasListeleResponse> {
        @Override
        public AvansTakasListeleResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
            AvansTakasListeleResponse result = new AvansTakasListeleResponse();
            result.setAvansId(rs.getLong("avans_id"));
            result.setMusteriNo(rs.getInt("musteri_no"));
            result.setTutar(rs.getBigDecimal("tutar"));
            result.setBorcluAlacakli(rs.getString("borclu_alacakli"));
            result.setDosya(rs.getString("dosya"));
            result.setTakasTarihi(rs.getDate("takas_tarihi").toLocalDate());
            result.setOdenenTutar(rs.getBigDecimal("odenen_tutar"));
            result.setHavuzToplamBakiye(rs.getBigDecimal("havuz_toplam_bakiye"));
            result.setTeminatHavuzToplamBakiye(rs.getBigDecimal("teminathavuz_toplam_bakiye"));
            result.setSerbestHesapBakiye(rs.getBigDecimal("serbesthesap_bakiye"));
            result.setTeminatHesapBakiye(rs.getBigDecimal("teminathesap_bakiye"));
            return result;
        }
    }
}