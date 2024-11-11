package com.ahafeez.multids.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public class GetAccountDetailRequestDto {

	@NotBlank
	@Length(max = 4)
	private String branchCode;

	@NotBlank
	@Length(max = 6)
	private String customerNumber;

	@Nullable
	@Length(max = 4)
	private String accountType;

	@Nullable
	@Length(max = 2)
	private String runNumber;

	@Nullable
	@Length(max = 1)
	private String checkDigit;

	@NotBlank
	String response;

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getRunNumber() {
		return runNumber;
	}

	public void setRunNumber(String runNumber) {
		this.runNumber = runNumber;
	}

	public String getCheckDigit() {
		return checkDigit;
	}

	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "GetAccountDetailRequestDto [branchCode=" + branchCode + ", customerNumber=" + customerNumber
				+ ", accountType=" + accountType + ", runNumber=" + runNumber + ", checkDigit=" + checkDigit + ", response=" + response +  "]";
	}

}
