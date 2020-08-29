package com.wns.assessment.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wns.assessment.exception.ServiceException;
import com.wns.assessment.model.CritExtnBO;
import com.wns.assessment.repository.MigrateRepository;
import com.wns.assessment.utils.CSVWriter;

@Service
public class MigrateServiceImpl implements MigrateService{

	private static Logger LOGGER = LoggerFactory.getLogger(MigrateServiceImpl.class);
	
	@Autowired
	private EntityManager entity;
	
	@Autowired
	private MigrateRepository migrateRepo;
	
	/* (non-Javadoc)
	 * @see com.wns.assessment.service.MigrateService#fetchData()
	 */
	@Override
	public void generateCSV() {
		try {
			LOGGER.info("Inside MigrateServiceImpl -> generateCSV()");
			// create stored procedure object to execute proc.
			StoredProcedureQuery procedureQuery = entity.createStoredProcedureQuery("TREFR_ACCEPT_CRIT");
			LOGGER.info("Executing procedure");
			procedureQuery.execute();
			//call final_crit_ext table to fetch details.
			List<CritExtnBO> critList = migrateRepo.findAll();
			//write csv file with fetched details.
			CSVWriter.write(critList);
		} catch (IOException e) {
			LOGGER.info("Exception occurred: "+e.getMessage());
			throw new ServiceException("some error occurred while writing CSV");
		}
		LOGGER.info("Exiting MigrateServiceImpl -> generateCSV()");
	}
}
