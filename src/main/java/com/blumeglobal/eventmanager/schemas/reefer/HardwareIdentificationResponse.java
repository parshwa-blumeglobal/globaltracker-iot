package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;

public class HardwareIdentificationResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String reeferId;
	private String controllerSerial;
	private String controllerVersion;
	private String manufacturer;
	private String model;
	
	public HardwareIdentificationResponse() {
		
	}

	public String getReeferId() {
		return reeferId;
	}

	public void setReeferId(String reeferId) {
		this.reeferId = reeferId;
	}

	public String getControllerSerial() {
		return controllerSerial;
	}

	public void setControllerSerial(String controllerSerial) {
		this.controllerSerial = controllerSerial;
	}

	public String getControllerVersion() {
		return controllerVersion;
	}

	public void setControllerVersion(String controllerVersion) {
		this.controllerVersion = controllerVersion;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "{reeferId:" + reeferId + ", controllerSerial:" + controllerSerial
				+ ", controllerVersion:" + controllerVersion + ", manufacturer:" + manufacturer + ", model:" + model
				+ "}";
	}

	
}
