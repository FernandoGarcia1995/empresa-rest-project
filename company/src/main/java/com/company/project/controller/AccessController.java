package com.company.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.dto.RegistrationDto;
import com.company.project.interfaces.UserService;
import com.company.project.response.CommonResponse;


@RestController
@RequestMapping("/access")
public class AccessController {
	
	@Autowired
	private UserService userDetailsService;
	
	@PostMapping("/getToken")
	public ResponseEntity<CommonResponse> getToken (@RequestBody RegistrationDto registrationDto){
		return new ResponseEntity<CommonResponse>(new CommonResponse(userDetailsService.httpBasicToken(registrationDto)), HttpStatus.OK);	
	}
	
	@PostMapping("/register")
	public ResponseEntity<CommonResponse> register (@Valid @RequestBody RegistrationDto registrationDto) throws Exception{
		return new ResponseEntity<CommonResponse>(userDetailsService.registration(registrationDto), HttpStatus.CREATED);
	}

}
