package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;

public class CargoSettingsResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Double co2Setpoint;
	private Double humiditySetpoint;
	private Double o2Setpoint;
	private Double temperatureSetpoint;
	
	public CargoSettingsResponse() {
		
	}

	public Double getCo2Setpoint() {
		return co2Setpoint;
	}

	public void setCo2Setpoint(Double co2Setpoint) {
		this.co2Setpoint = co2Setpoint;
	}

	public Double getHumiditySetpoint() {
		return humiditySetpoint;
	}

	public void setHumiditySetpoint(Double humiditySetpoint) {
		this.humiditySetpoint = humiditySetpoint;
	}

	public Double getO2Setpoint() {
		return o2Setpoint;
	}

	public void setO2Setpoint(Double o2Setpoint) {
		this.o2Setpoint = o2Setpoint;
	}

	public Double getTemperatureSetpoint() {
		return temperatureSetpoint;
	}

	public void setTemperatureSetpoint(Double temperatureSetpoint) {
		this.temperatureSetpoint = temperatureSetpoint;
	}

	@Override
	public String toString() {
		return "{co2Setpoint:" + co2Setpoint + ", humiditySetpoint:" + humiditySetpoint
				+ ", o2Setpoint:" + o2Setpoint + ", temperatureSetpoint:" + temperatureSetpoint + "}";
	}
	
	
}
