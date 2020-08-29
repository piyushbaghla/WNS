package com.wns.assessment.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wns.assessment.exception.ServiceException;
import com.wns.assessment.model.CritExtnBO;
import com.wns.assessment.model.Headers;

public class CSVWriter {

	private static Logger LOGGER = LoggerFactory.getLogger(CSVWriter.class);
	
	/**
	 * This method writes data to CSV file.
	 * 
	 * @param critList
	 * @throws IOException
	 */
	public static void write(List<CritExtnBO> critList) throws IOException {
		LOGGER.info("Inside CSVWriter -> write()");
		//create filewrite object with CSV file name.
		FileWriter fileWriter = new FileWriter("FINAL_CRIT_EXT.CSV");
		//set CSV format with column names.
		
		try(CSVPrinter printer = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader(Headers.class))) {
			critList.forEach(crit -> {
				try {
					printer.printRecord(crit.getADDMOD(),
								crit.getCritIdentity().getNVIC(),
								crit.getVEHCAT(),
								crit.getCritIdentity().getCOMPANY(),
								crit.getEFFECTIVEDATE(),
								crit.getCHANGETIMESTAMP(),
								crit.getEFFECTIVEENDDATE(),
								crit.getENDDATETIMESTAMP(),
								crit.getACCEPTCRIT(), 
								crit.getINTERNETJEP());
				} catch (IOException e) {
					LOGGER.info("Exception occurred: "+e.getMessage());
					throw new ServiceException("some error occurred while writing CSV");
				} 
			});
		}
		
	}
}
