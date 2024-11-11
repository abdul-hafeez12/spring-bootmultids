package com.ahafeez.multids.database;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component
public class LoadDataSource {
	
	    private final JdbcClient jdbcClient1;
	    private final JdbcClient jdbcClient2;

	    public LoadDataSource(@Qualifier("jdbcClient1") JdbcClient jdbcClient1,
	                                    @Qualifier("jdbcClient2") JdbcClient jdbcClient2) {
	        this.jdbcClient1 = jdbcClient1;
	        this.jdbcClient2 = jdbcClient2;
	    }

	    public JdbcClient getCurrentJdbcClient(String branchCode) {
	    	 if (branchCode.equals("1001")) {
			     return jdbcClient1;
			 } else if (branchCode.equals("1999")) {
			     return jdbcClient1;
			 } else if (branchCode.length() == 4 && branchCode.charAt(0) == '5') {
			     return jdbcClient2;
			 } else {
			     return jdbcClient1;
			 }
	    }

}
