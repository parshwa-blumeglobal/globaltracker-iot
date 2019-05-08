package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;

public class HardwareSensorResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Double batteryVoltage;
	private Double compressorTemperature;
	private Double compressorFrequency;
	private Double condenserPressure;
	private Double condenserTemperature;
	private String condenserFanLevel;
	private Double evaporatorTemperature;
	private String evaporatorFanLevel;
	private Double currentA;
	private Double currentB;
	private Double currentC;
	private Double currentTotal;
	private Double defrostTemperature;
	private Double dischargePressure;
	private Double dischargeTemperature;
	private Double engineCoolantTemperature;
	private Double engineRpm;
	private Double fuelLevel;
	private Double heater;
	private Double lineFrequency;
	private Double lineVoltage;
	private Double modernBatteryVoltage;
	private Double suctionTemperature;
	private Double hotGasValveOpening;
	private Double economizerValveOpening;
	private Double expansionValveOpening;
	
	
	public HardwareSensorResponse() {
		
	}


	public Double getBatteryVoltage() {
		return batteryVoltage;
	}


	public void setBatteryVoltage(Double batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}


	public Double getCompressorTemperature() {
		return compressorTemperature;
	}


	public void setCompressorTemperature(Double compressorTemperature) {
		this.compressorTemperature = compressorTemperature;
	}


	public Double getCompressorFrequency() {
		return compressorFrequency;
	}


	public void setCompressorFrequency(Double compressorFrequency) {
		this.compressorFrequency = compressorFrequency;
	}


	public Double getCondenserPressure() {
		return condenserPressure;
	}


	public void setCondenserPressure(Double condenserPressure) {
		this.condenserPressure = condenserPressure;
	}


	public Double getCondenserTemperature() {
		return condenserTemperature;
	}


	public void setCondenserTemperature(Double condenserTemperature) {
		this.condenserTemperature = condenserTemperature;
	}


	public String getCondenserFanLevel() {
		return condenserFanLevel;
	}


	public void setCondenserFanLevel(String condenserFanLevel) {
		this.condenserFanLevel = condenserFanLevel;
	}


	public Double getEvaporatorTemperature() {
		return evaporatorTemperature;
	}


	public void setEvaporatorTemperature(Double evaporatorTemperature) {
		this.evaporatorTemperature = evaporatorTemperature;
	}


	public String getEvaporatorFanLevel() {
		return evaporatorFanLevel;
	}


	public void setEvaporatorFanLevel(String evaporatorFanLevel) {
		this.evaporatorFanLevel = evaporatorFanLevel;
	}


	public Double getCurrentA() {
		return currentA;
	}


	public void setCurrentA(Double currentA) {
		this.currentA = currentA;
	}


	public Double getCurrentB() {
		return currentB;
	}


	public void setCurrentB(Double currentB) {
		this.currentB = currentB;
	}


	public Double getCurrentC() {
		return currentC;
	}


	public void setCurrentC(Double currentC) {
		this.currentC = currentC;
	}


	public Double getCurrentTotal() {
		return currentTotal;
	}


	public void setCurrentTotal(Double currentTotal) {
		this.currentTotal = currentTotal;
	}


	public Double getDefrostTemperature() {
		return defrostTemperature;
	}


	public void setDefrostTemperature(Double defrostTemperature) {
		this.defrostTemperature = defrostTemperature;
	}


	public Double getDischargePressure() {
		return dischargePressure;
	}


	public void setDischargePressure(Double dischargePressure) {
		this.dischargePressure = dischargePressure;
	}


	public Double getDischargeTemperature() {
		return dischargeTemperature;
	}


	public void setDischargeTemperature(Double dischargeTemperature) {
		this.dischargeTemperature = dischargeTemperature;
	}


	public Double getEngineCoolantTemperature() {
		return engineCoolantTemperature;
	}


	public void setEngineCoolantTemperature(Double engineCoolantTemperature) {
		this.engineCoolantTemperature = engineCoolantTemperature;
	}


	public Double getEngineRpm() {
		return engineRpm;
	}


	public void setEngineRpm(Double engineRpm) {
		this.engineRpm = engineRpm;
	}


	public Double getFuelLevel() {
		return fuelLevel;
	}


	public void setFuelLevel(Double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}


	public Double getHeater() {
		return heater;
	}


	public void setHeater(Double heater) {
		this.heater = heater;
	}


	public Double getLineFrequency() {
		return lineFrequency;
	}


	public void setLineFrequency(Double lineFrequency) {
		this.lineFrequency = lineFrequency;
	}


	public Double getLineVoltage() {
		return lineVoltage;
	}


	public void setLineVoltage(Double lineVoltage) {
		this.lineVoltage = lineVoltage;
	}


	public Double getModernBatteryVoltage() {
		return modernBatteryVoltage;
	}


	public void setModernBatteryVoltage(Double modernBatteryVoltage) {
		this.modernBatteryVoltage = modernBatteryVoltage;
	}


	public Double getSuctionTemperature() {
		return suctionTemperature;
	}


	public void setSuctionTemperature(Double suctionTemperature) {
		this.suctionTemperature = suctionTemperature;
	}


	public Double getHotGasValveOpening() {
		return hotGasValveOpening;
	}


	public void setHotGasValveOpening(Double hotGasValveOpening) {
		this.hotGasValveOpening = hotGasValveOpening;
	}


	public Double getEconomizerValveOpening() {
		return economizerValveOpening;
	}


	public void setEconomizerValveOpening(Double economizerValveOpening) {
		this.economizerValveOpening = economizerValveOpening;
	}


	public Double getExpansionValveOpening() {
		return expansionValveOpening;
	}


	public void setExpansionValveOpening(Double expansionValveOpening) {
		this.expansionValveOpening = expansionValveOpening;
	}


	@Override
	public String toString() {
		return "{batteryVoltage:" + batteryVoltage + ", compressorTemperature:"
				+ compressorTemperature + ", compressorFrequency:" + compressorFrequency + ", condenserPressure:"
				+ condenserPressure + ", condenserTemperature:" + condenserTemperature + ", condenserFanLevel:"
				+ condenserFanLevel + ", evaporatorTemperature:" + evaporatorTemperature + ", evaporatorFanLevel:"
				+ evaporatorFanLevel + ", currentA:" + currentA + ", currentB:" + currentB + ", currentC:" + currentC
				+ ", currentTotal:" + currentTotal + ", defrostTemperature:" + defrostTemperature
				+ ", dischargePressure=" + dischargePressure + ", dischargeTemperature=" + dischargeTemperature
				+ ", engineCoolantTemperature:" + engineCoolantTemperature + ", engineRpm:" + engineRpm + ", fuelLevel:"
				+ fuelLevel + ", heater:" + heater + ", lineFrequency:" + lineFrequency + ", lineVoltage:" + lineVoltage
				+ ", modernBatteryVoltage:" + modernBatteryVoltage + ", suctionTemperature:" + suctionTemperature
				+ ", hotGasValveOpening:" + hotGasValveOpening + ", economizerValveOpening:" + economizerValveOpening
				+ ", expansionValveOpening:" + expansionValveOpening + "}";
	}
	
	
	
}
