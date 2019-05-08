package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;

public class HardwareTimesResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Double ageOfReadingTime;
	private Double compressorTime;
	private Double currentTime;
	private Double electricTime;
	private Double engineTime;
	private Double lastPollTime;
	private Double onTime;
	private Double standbyTime;
	private Double vehicleTime;
	
	public HardwareTimesResponse() {
		
	}

	public Double getAgeOfReadingTime() {
		return ageOfReadingTime;
	}

	public void setAgeOfReadingTime(Double ageOfReadingTime) {
		this.ageOfReadingTime = ageOfReadingTime;
	}

	public Double getCompressorTime() {
		return compressorTime;
	}

	public void setCompressorTime(Double compressorTime) {
		this.compressorTime = compressorTime;
	}

	public Double getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Double currentTime) {
		this.currentTime = currentTime;
	}

	public Double getElectricTime() {
		return electricTime;
	}

	public void setElectricTime(Double electricTime) {
		this.electricTime = electricTime;
	}

	public Double getEngineTime() {
		return engineTime;
	}

	public void setEngineTime(Double engineTime) {
		this.engineTime = engineTime;
	}

	public Double getLastPollTime() {
		return lastPollTime;
	}

	public void setLastPollTime(Double lastPollTime) {
		this.lastPollTime = lastPollTime;
	}

	public Double getOnTime() {
		return onTime;
	}

	public void setOnTime(Double onTime) {
		this.onTime = onTime;
	}

	public Double getStandbyTime() {
		return standbyTime;
	}

	public void setStandbyTime(Double standbyTime) {
		this.standbyTime = standbyTime;
	}

	public Double getVehicleTime() {
		return vehicleTime;
	}

	public void setVehicleTime(Double vehicleTime) {
		this.vehicleTime = vehicleTime;
	}

	@Override
	public String toString() {
		return "{ageOfReadingTime:" + ageOfReadingTime + ", compressorTime:" + compressorTime
				+ ", currentTime:" + currentTime + ", electricTime:" + electricTime + ", engineTime:" + engineTime
				+ ", lastPollTime:" + lastPollTime + ", onTime:" + onTime + ", standbyTime:" + standbyTime
				+ ", vehicleTime:" + vehicleTime + "}";
	}

	
}
