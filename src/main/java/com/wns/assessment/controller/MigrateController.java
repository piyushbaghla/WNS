package com.wns.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wns.assessment.model.MigrateResponse;
import com.wns.assessment.service.MigrateService;

@RestController
@RequestMapping("/api/v1/migrate")
public class MigrateController {

	@Autowired
	private MigrateService migrateService;
	
	@GetMapping("/csv")
	public ResponseEntity<MigrateResponse> createCSV() {
		migrateService.generateCSV();
		MigrateResponse migrateResponse = new MigrateResponse();
		migrateResponse.setSuccess(true);
		migrateResponse.setMessage("CSV File created successfully");
		return new ResponseEntity<MigrateResponse>(migrateResponse,HttpStatus.OK);
	}
}
