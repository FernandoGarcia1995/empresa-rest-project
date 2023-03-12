package com.company.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.response.CommonResponse;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@PostMapping("/getEmployees")
	private ResponseEntity<CommonResponse> getEmployees () throws Exception{
		System.out.println("test");
		return new ResponseEntity<CommonResponse>(new CommonResponse(), HttpStatus.CREATED);
	}

}
