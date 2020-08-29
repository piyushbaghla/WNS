package com.wns.assessment.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.wns.assessment.model.CritExtnBO;
import com.wns.assessment.model.CritIdentity;
import com.wns.assessment.repository.MigrateRepository;
import com.wns.assessment.utils.CSVWriter;

@RunWith(MockitoJUnitRunner.class)
public class MigrateServiceTest {

	@InjectMocks
	private MigrateServiceImpl migrateServiceImpl;
	
	@Mock
	private EntityManager entity;
	
	@Mock
	private StoredProcedureQuery query;
	
	@Mock
	private MigrateRepository migrateRepo;
	
	@Mock
	private CSVWriter csvWriter;
	
	@Test
	public void generateCSVTest() {
	
		List<CritExtnBO>critList = populateCritBoList();
		Mockito.when(entity.createStoredProcedureQuery("TREFR_ACCEPT_CRIT")).thenReturn(query);
		Mockito.when(query.execute()).thenReturn(true);
		Mockito.when(migrateRepo.findAll()).thenReturn(populateCritBoList());
		migrateServiceImpl.generateCSV();
		//Mockito.verify(CSVWriter.write(critList));
	}

	private List<CritExtnBO> populateCritBoList() {
		List<CritExtnBO> critExtnBOs = new ArrayList<CritExtnBO>();
		CritExtnBO critBo = new CritExtnBO();
		critBo.setADDMOD("ADD");
		CritIdentity critIdentity = new CritIdentity();
		critIdentity.setCOMPANY("AAMI");
		critIdentity.setNVIC("01F624");
		critBo.setCritIdentity(critIdentity);
		critBo.setVEHCAT("BK");
		critBo.setEFFECTIVEDATE("20180801");
		critBo.setCHANGETIMESTAMP("20180801000000");
		critBo.setEFFECTIVEENDDATE("99991231");
		critBo.setENDDATETIMESTAMP("99991231000000");
		critBo.setACCEPTCRIT("UNCEPTABLE");
		critBo.setINTERNETJEP("Y");
		critExtnBOs.add(critBo);
		return critExtnBOs;
	}
	
}
