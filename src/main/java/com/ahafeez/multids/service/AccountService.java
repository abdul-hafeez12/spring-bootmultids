package com.ahafeez.multids.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahafeez.multids.database.LoadDataSource;
import com.ahafeez.multids.dto.GetAccountDetailRequestDto;
import com.ahafeez.multids.dto.GetAccountDetailResponseDto;
import com.ahafeez.multids.querystore.AccountTlQueries;
import com.ahafeez.multids.util.Utility;
//import com.ahafeez.multids.util.CustumRowMaper;

@Service
@Transactional
public class AccountService {


	@Autowired
	LoadDataSource datasource;

	
	

	public List<GetAccountDetailResponseDto> fnGetAccountDetail(GetAccountDetailRequestDto getAccountDetailRequestDtoObj) {
			
//		return jdbcClient.sql("SELECT * FROM account_tl WHERE BRN_CD = :brn_cd AND cust_no= :cust_no")
//	        .param("brn_cd", getAccountDetailRequestDtoObj.getBranchCode())
//	        .param("cust_no", getAccountDetailRequestDtoObj.getCustomerNumber())
//	        .query(new CustumRowMaper()).list();
		
		 Map<String,String> queryMapObj = new HashMap<>();
		 
		 queryMapObj=AccountTlQueries.fnGetAccountDetailByBranchCodeAndCustomerNumberTlQuery(getAccountDetailRequestDtoObj);
         System.out.println(queryMapObj.get("queryString"));
         System.out.println(queryMapObj.get("errorMessage"));
         
		 List<GetAccountDetailResponseDto>  getAccountDetailListResponseDtoObj=new ArrayList<>();
	     GetAccountDetailResponseDto getAccountDetailResponseDtoObj=new GetAccountDetailResponseDto();

		 getAccountDetailListResponseDtoObj = fnExecuteQuery(
                 getAccountDetailRequestDtoObj,
                 queryMapObj,
                 GetAccountDetailResponseDto.class,
                 Arrays.asList(getAccountDetailRequestDtoObj.getResponse().split(","))
                 );
		 
		  if (getAccountDetailListResponseDtoObj.isEmpty()) {
	            getAccountDetailResponseDtoObj.setmBoolean(true);
	            getAccountDetailResponseDtoObj.setErrorMessage(queryMapObj.get("errorMessage"));
	            getAccountDetailListResponseDtoObj.add(getAccountDetailResponseDtoObj);
	       }
		  
	       return getAccountDetailListResponseDtoObj;
		 
	}
	
	public <T> List<T> fnExecuteQuery(GetAccountDetailRequestDto getAccountDetailRequestDtoObj,Map<String, String>  queryMapObj,Class<T> type, List<String> projections) {
        List<T> list = new ArrayList<>();
        JdbcClient dbconnction=datasource.getCurrentJdbcClient(getAccountDetailRequestDtoObj.getBranchCode());
        dbconnction.sql(queryMapObj.get("queryString"))
        .query((ResultSet rs) -> {
            try {
                	 T t = type.getDeclaredConstructor().newInstance();
                     Utility.fnLoadResultSetIntoObject(rs, t,projections);
                     list.add(t);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                    | NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
            }
            catch (SQLException sqlExceptionObj) {
                sqlExceptionObj.printStackTrace();
            }
        });
        
        return list;
    }

}