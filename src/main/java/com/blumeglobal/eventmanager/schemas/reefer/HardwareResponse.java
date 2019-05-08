package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;

public class HardwareResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private HardwareIdentificationResponse identification;
	
	private HardwareSensorResponse sensors;
	
	private HardwareTimesResponse times;
	
	private HardwareModesResponse modes;
	
	private Integer operatingMode;
	
	private String operatingModeName;

	public HardwareResponse() {
		
	}

	public HardwareIdentificationResponse getIdentification() {
		return identification;
	}

	public void setIdentification(HardwareIdentificationResponse identification) {
		this.identification = identification;
	}

	public HardwareSensorResponse getSensors() {
		return sensors;
	}

	public void setSensors(HardwareSensorResponse sensors) {
		this.sensors = sensors;
	}

	public HardwareTimesResponse getTimes() {
		return times;
	}

	public void setTimes(HardwareTimesResponse times) {
		this.times = times;
	}

	public HardwareModesResponse getModes() {
		return modes;
	}

	public void setModes(HardwareModesResponse modes) {
		this.modes = modes;
	}

	public Integer getOperatingMode() {
		return operatingMode;
	}

	public void setOperatingMode(Integer operatingMode) {
		this.operatingMode = operatingMode;
	}

	public String getOperatingModeName() {
		return operatingModeName;
	}

	public void setOperatingModeName(String operatingModeName) {
		this.operatingModeName = operatingModeName;
	}

	@Override
	public String toString() {
		return "{identification:" + identification + ", sensors:" + sensors + ", times:" + times
				+ ", modes:" + modes + ", operatingMode:" + operatingMode + ", operatingModeName:" + operatingModeName
				+ "}";
	}
	
	
	
}
