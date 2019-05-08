package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;
import java.util.List;

public class HardwareModesResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<String> simple;

	public HardwareModesResponse() {
		
	}

	public List<String> getSimple() {
		return simple;
	}

	public void setSimple(List<String> simple) {
		this.simple = simple;
	}

	@Override
	public String toString() {
		return "{simple:" + simple + "}";
	}
	
	
	
}
