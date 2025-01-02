package com.app.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/login")
public class LoginController {
	
	@GetMapping(path = "/doLogin")
	public ResponseEntity<Map<String, Object>> doLogin(){
		
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			Map<String, Object> responseMap = new LinkedHashMap<>();
			responseMap.put("message", "Login successfull.");
			
			responseEntity = new ResponseEntity<Map<String,Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

}
