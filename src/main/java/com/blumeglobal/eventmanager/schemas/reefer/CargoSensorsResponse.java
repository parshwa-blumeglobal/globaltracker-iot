package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;

public class CargoSensorsResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Double airExchange;
	private Double ambientTemperature;
	private Double co;
	private Double co2;
	private Double ethylene;
	private Double humidity;
	private Double nitrogen;
	private Double o2;
	private Double returnAirTemperature;
	private Double returnAir2Temperature;
	private Double supplyAirTemperature;
	private Double supplyAir2Temperature;
	private Double usda1Temperature;
	private Double usda2Temperature;
	private Double usda3Temperature;
	private Double usda4Temperature;
	
	
	public CargoSensorsResponse() {
		
	}


	public Double getAirExchange() {
		return airExchange;
	}


	public void setAirExchange(Double airExchange) {
		this.airExchange = airExchange;
	}


	public Double getAmbientTemperature() {
		return ambientTemperature;
	}


	public void setAmbientTemperature(Double ambientTemperature) {
		this.ambientTemperature = ambientTemperature;
	}


	public Double getCo() {
		return co;
	}


	public void setCo(Double co) {
		this.co = co;
	}


	public Double getCo2() {
		return co2;
	}


	public void setCo2(Double co2) {
		this.co2 = co2;
	}


	public Double getEthylene() {
		return ethylene;
	}


	public void setEthylene(Double ethylene) {
		this.ethylene = ethylene;
	}


	public Double getHumidity() {
		return humidity;
	}


	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}


	public Double getNitrogen() {
		return nitrogen;
	}


	public void setNitrogen(Double nitrogen) {
		this.nitrogen = nitrogen;
	}


	public Double getO2() {
		return o2;
	}


	public void setO2(Double o2) {
		this.o2 = o2;
	}


	public Double getReturnAirTemperature() {
		return returnAirTemperature;
	}


	public void setReturnAirTemperature(Double returnAirTemperature) {
		this.returnAirTemperature = returnAirTemperature;
	}


	public Double getReturnAir2Temperature() {
		return returnAir2Temperature;
	}


	public void setReturnAir2Temperature(Double returnAir2Temperature) {
		this.returnAir2Temperature = returnAir2Temperature;
	}


	public Double getSupplyAirTemperature() {
		return supplyAirTemperature;
	}


	public void setSupplyAirTemperature(Double supplyAirTemperature) {
		this.supplyAirTemperature = supplyAirTemperature;
	}


	public Double getSupplyAir2Temperature() {
		return supplyAir2Temperature;
	}


	public void setSupplyAir2Temperature(Double supplyAir2Temperature) {
		this.supplyAir2Temperature = supplyAir2Temperature;
	}


	public Double getUsda1Temperature() {
		return usda1Temperature;
	}


	public void setUsda1Temperature(Double usda1Temperature) {
		this.usda1Temperature = usda1Temperature;
	}


	public Double getUsda2Temperature() {
		return usda2Temperature;
	}


	public void setUsda2Temperature(Double usda2Temperature) {
		this.usda2Temperature = usda2Temperature;
	}


	public Double getUsda3Temperature() {
		return usda3Temperature;
	}


	public void setUsda3Temperature(Double usda3Temperature) {
		this.usda3Temperature = usda3Temperature;
	}


	public Double getUsda4Temperature() {
		return usda4Temperature;
	}


	public void setUsda4Temperature(Double usda4Temperature) {
		this.usda4Temperature = usda4Temperature;
	}


	@Override
	public String toString() {
		return "{airExchange:" + airExchange + ", ambientTemperature:" + ambientTemperature
				+ ", co:" + co + ", co2:" + co2 + ", ethylene:" + ethylene + ", humidity:" + humidity + ", nitrogen:"
				+ nitrogen + ", o2:" + o2 + ", returnAirTemperature:" + returnAirTemperature
				+ ", returnAir2Temperature:" + returnAir2Temperature + ", supplyAirTemperature:" + supplyAirTemperature
				+ ", supplyAir2Temperature:" + supplyAir2Temperature + ", usda1Temperature:" + usda1Temperature
				+ ", usda2Temperature:" + usda2Temperature + ", usda3Temperature:" + usda3Temperature
				+ ", usda4Temperature:" + usda4Temperature + "}";
	}
	
	
}
