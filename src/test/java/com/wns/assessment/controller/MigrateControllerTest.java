package com.wns.assessment.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.wns.assessment.exception.ServiceException;
import com.wns.assessment.model.MigrateResponse;
import com.wns.assessment.service.MigrateService;

@RunWith(MockitoJUnitRunner.class)
public class MigrateControllerTest {

	@Mock
	private MigrateService migrateService;
	
	@InjectMocks
	private MigrateController migrateController;
	
	@Test
	public void createCSVTest() {
		ResponseEntity<MigrateResponse> response = migrateController.createCSV();
		assertTrue(response.getBody().isSuccess());
	}
	
	@Test(expected =  ServiceException.class)
	public void createCSVExceptionTest() {
		Mockito.doThrow(new ServiceException("")).when(migrateService).generateCSV();
		migrateController.createCSV();
	}
}
