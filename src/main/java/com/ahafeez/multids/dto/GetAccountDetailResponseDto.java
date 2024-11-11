package com.ahafeez.multids.dto;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ahafeez.multids.util.ResponseParam;
import com.ahafeez.multids.util.Table;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAccountDetailResponseDto {

	@Table(column = "brn_cd")
	@ResponseParam(name = "branchCode")
	private BigDecimal branchCode;

	@Table(column = "cust_no")
	@ResponseParam(name = "customerNumber")
	private BigDecimal customerNumber;

	@Table(column = "ac_type")
	@ResponseParam(name = "accountType")
	private BigDecimal accountType;

	@Table(column = "run_no")
	@ResponseParam(name = "runNumber")
	private BigDecimal runNumber;

	@Table(column = "chk_digt")
	@ResponseParam(name = "checkDigit")
	private BigDecimal checkDigit;

	@ResponseParam(name = "mBoolean")
	public boolean mBoolean;

	@ResponseParam(name = "errorMessage")
	private String errorMessage;

	public GetAccountDetailResponseDto(BigDecimal branchCode, BigDecimal customerNumber, BigDecimal accountType,
			BigDecimal runNumber, BigDecimal checkDigit) {
		super();
		this.branchCode = branchCode;
		this.customerNumber = customerNumber;
		this.accountType = accountType;
		this.runNumber = runNumber;
		this.checkDigit = checkDigit;
	}

	public GetAccountDetailResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(BigDecimal branchCode) {
		this.branchCode = branchCode;
	}

	public BigDecimal getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(BigDecimal customerNumber) {
		this.customerNumber = customerNumber;
	}

	public BigDecimal getAccountType() {
		return accountType;
	}

	public void setAccountType(BigDecimal accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getRunNumber() {
		return runNumber;
	}

	public void setRunNumber(BigDecimal runNumber) {
		this.runNumber = runNumber;
	}

	public BigDecimal getCheckDigit() {
		return checkDigit;
	}

	public void setCheckDigit(BigDecimal checkDigit) {
		this.checkDigit = checkDigit;
	}
	
	public boolean ismBoolean() {
        return mBoolean;
    }

    public void setmBoolean(boolean mBoolean) {
        this.mBoolean = mBoolean;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

	

	@Override
	public String toString() {
		return "GetAccountDetailResponseDto [branchCode=" + branchCode + ", customerNumber=" + customerNumber
				+ ", accountType=" + accountType + ", runNumber=" + runNumber + ", checkDigit=" + checkDigit
				+ ", mBoolean=" + mBoolean + ", errorMessage=" + errorMessage + "]";
	}

	public String getDBColumnNamesForResponseFields(List<String> responseParams) {
		List<String> dbColumns = new ArrayList<>();

		for (Field field : this.getClass().getDeclaredFields()) {
			Table column = field.getAnnotation(Table.class);
			ResponseParam responseParam = field.getAnnotation(ResponseParam.class);

			if (responseParam != null && responseParams.contains(responseParam.name())) {
				dbColumns.add(column.column());
			}
		}

		return String.join(",", dbColumns);
	}
}
