package com.ahafeez.multids.querystore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.context.annotation.RequestScope;

import com.ahafeez.multids.dto.GetAccountDetailRequestDto;
import com.ahafeez.multids.dto.GetAccountDetailResponseDto;

@RequestScope
public class AccountTlQueries {
	
	 static String queryString="queryString";
     static String errorMessage="errorMessage";
     static String selectQueryKeyString = " Select ";
     static String accountType = " and ac_type=";
     static String customerNumber = " and cust_no=";
     static String runNumber = " and run_no =";
     static String checkDigit = " and chk_digt=";
     static String fromAccountTl = " from account_tl ";
     static String branchCode = " brn_cd= ";
     static String foundAgainstTheGivenBranchCode = " found against the given brn_cd=";
     static String where = " where ";
     static String errorBranchCode = " branch code = ";
     static String errorAccountType = " and account type = ";
     static String errorCustomerNumber = " and customer number = ";
     static String errorRunNumber = " and run number = ";
     static String errorCheckDigit = " and check digit = ";
     
     private AccountTlQueries()
     {
             //constructor
     }
     
     /**
      * Map is created and key value is store in this Map.
      * Map consists of Query of account_tl table and the Error message.
      * 
      * @param getAccountDetailRequestDtoObj
      * @return Map of Query and its error.
      */
      /**DA Query for getting account Detail by branch code and customer number using account_tl*/
      public static Map<String,String> fnGetAccountDetailByBranchCodeAndCustomerNumberTlQuery(GetAccountDetailRequestDto getAccountDetailRequestDtoObj){
              GetAccountDetailResponseDto accountDetailResponseDtoObj = new GetAccountDetailResponseDto();
              String projections = accountDetailResponseDtoObj.getDBColumnNamesForResponseFields(Arrays.asList(getAccountDetailRequestDtoObj.getResponse().split(",")));
              Map<String,String> queryMapObj=new HashMap<>();
                      queryMapObj.put(queryString,selectQueryKeyString+projections+" from account_tl where cust_no = "+getAccountDetailRequestDtoObj.getCustomerNumber()+" and brn_Cd="+getAccountDetailRequestDtoObj.getBranchCode()+"");
                      queryMapObj.put(errorMessage,"ACC01-027 : No account detail found against the given"+errorBranchCode
                      +getAccountDetailRequestDtoObj.getBranchCode()+errorCustomerNumber+getAccountDetailRequestDtoObj.getCustomerNumber());
              return queryMapObj;
      }


}
