package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;

public class CargoResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private CargoSensorsResponse sensors;
	
	private CargoSettingsResponse settings;

	public CargoResponse() {
		
	}

	public CargoSensorsResponse getSensors() {
		return sensors;
	}

	public void setSensors(CargoSensorsResponse sensors) {
		this.sensors = sensors;
	}

	public CargoSettingsResponse getSettings() {
		return settings;
	}

	public void setSettings(CargoSettingsResponse settings) {
		this.settings = settings;
	}

	@Override
	public String toString() {
		return "{sensors:" + sensors + ", settings:" + settings + "}";
	}
	
	
	
}
