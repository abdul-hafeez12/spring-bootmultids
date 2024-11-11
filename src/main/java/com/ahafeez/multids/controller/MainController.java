package com.ahafeez.multids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.BindParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahafeez.multids.dto.GetAccountDetailRequestDto;
import com.ahafeez.multids.dto.GetAccountDetailResponseDto;
import com.ahafeez.multids.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accountDetails")
public class MainController {

	@Autowired
	private AccountService accountDetailServiceObj;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	 List<GetAccountDetailResponseDto> fnGetAccountDetail(@BindParam @Valid GetAccountDetailRequestDto getAccountDetailRequestDtoObj){
		return accountDetailServiceObj.fnGetAccountDetail(getAccountDetailRequestDtoObj);
	}
}
