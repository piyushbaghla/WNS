package com.wns.assessment.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="final_crit_ext")
public class CritExtnBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6816800751537990620L;

	@EmbeddedId
	private CritIdentity critIdentity;
	
	private String ADDMOD;
	
	//private String NVIC;
	
	private String VEHCAT;
	
	//private String COMPANY;
	
	private String EFFECTIVEDATE;
	
	private String CHANGETIMESTAMP;
	
	private String EFFECTIVEENDDATE;
	
	private String ENDDATETIMESTAMP;
	
	private String ACCEPTCRIT;
	
	private String INTERNETJEP;

	public String getADDMOD() {
		return ADDMOD;
	}

	public void setADDMOD(String aDDMOD) {
		ADDMOD = aDDMOD;
	}

	public void setCritIdentity(CritIdentity critIdentity) {
		this.critIdentity = critIdentity;
	}
	public CritIdentity getCritIdentity() {
		return critIdentity;
	}
	/*
	 * public String getNVIC() { return NVIC; }
	 * 
	 * public void setNVIC(String nVIC) { NVIC = nVIC; }
	 */

	public String getVEHCAT() {
		return VEHCAT;
	}

	public void setVEHCAT(String vEHCAT) {
		VEHCAT = vEHCAT;
	}

	/*
	 * public String getCOMPANY() { return COMPANY; }
	 * 
	 * public void setCOMPANY(String cOMPANY) { COMPANY = cOMPANY; }
	 */

	public String getEFFECTIVEDATE() {
		return EFFECTIVEDATE;
	}

	public void setEFFECTIVEDATE(String eFFECTIVEDATE) {
		EFFECTIVEDATE = eFFECTIVEDATE;
	}

	public String getCHANGETIMESTAMP() {
		return CHANGETIMESTAMP;
	}

	public void setCHANGETIMESTAMP(String cHANGETIMESTAMP) {
		CHANGETIMESTAMP = cHANGETIMESTAMP;
	}

	public String getEFFECTIVEENDDATE() {
		return EFFECTIVEENDDATE;
	}

	public void setEFFECTIVEENDDATE(String eFFECTIVEENDDATE) {
		EFFECTIVEENDDATE = eFFECTIVEENDDATE;
	}

	public String getENDDATETIMESTAMP() {
		return ENDDATETIMESTAMP;
	}

	public void setENDDATETIMESTAMP(String eNDDATETIMESTAMP) {
		ENDDATETIMESTAMP = eNDDATETIMESTAMP;
	}

	public String getACCEPTCRIT() {
		return ACCEPTCRIT;
	}

	public void setACCEPTCRIT(String aCCEPTCRIT) {
		ACCEPTCRIT = aCCEPTCRIT;
	}

	public String getINTERNETJEP() {
		return INTERNETJEP;
	}

	public void setINTERNETJEP(String iNTERNETJEP) {
		INTERNETJEP = iNTERNETJEP;
	}
}
