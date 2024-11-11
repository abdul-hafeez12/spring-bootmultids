package com.ahafeez.multids.util;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.ahafeez.multids.dto.GetAccountDetailResponseDto;

public class CustumRowMaper implements RowMapper<GetAccountDetailResponseDto>{

    public GetAccountDetailResponseDto mapRow(ResultSet rs, int arg1) throws SQLException {
     return  new GetAccountDetailResponseDto(
			 rs.getBigDecimal("brn_cd"),
	         rs.getBigDecimal("cust_no"),
	         rs.getBigDecimal("ac_type"),
	         rs.getBigDecimal("run_no"),
	         rs.getBigDecimal("chk_digt")
			 );
    }
}