package com.wns.assessment.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CritIdentity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6891670323251365137L;

	private String NVIC;
	
	private String COMPANY;
	
	public CritIdentity() {
		
	}
	
	public CritIdentity(String NVIC, String COMPANY){
		this.NVIC = NVIC;
		this.COMPANY = COMPANY;
	}

	public String getNVIC() {
		return NVIC;
	}

	public void setNVIC(String nVIC) {
		NVIC = nVIC;
	}

	public String getCOMPANY() {
		return COMPANY;
	}

	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CritIdentity other = (CritIdentity) obj;
		if (COMPANY == null) {
			if (other.COMPANY != null)
				return false;
		} else if (!COMPANY.equals(other.COMPANY))
			return false;
		if (NVIC == null) {
			if (other.NVIC != null)
				return false;
		} else if (!NVIC.equals(other.NVIC))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((COMPANY == null) ? 0 : COMPANY.hashCode());
		result = prime * result + ((NVIC == null) ? 0 : NVIC.hashCode());
		return result;
	}
}
