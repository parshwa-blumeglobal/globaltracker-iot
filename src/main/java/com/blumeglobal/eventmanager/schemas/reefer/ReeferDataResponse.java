package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;
import java.util.List;

public class ReeferDataResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private HardwareResponse hardware;
	private List<Integer> alarms;
	private CargoResponse cargo;
	
	public ReeferDataResponse() {
		
	}

	public HardwareResponse getHardware() {
		return hardware;
	}

	public void setHardware(HardwareResponse hardware) {
		this.hardware = hardware;
	}

	public List<Integer> getAlarms() {
		return alarms;
	}

	public void setAlarms(List<Integer> alarms) {
		this.alarms = alarms;
	}

	public CargoResponse getCargo() {
		return cargo;
	}

	public void setCargo(CargoResponse cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "{hardware:" + hardware + ", alarms:" + alarms + ", cargo:" + cargo + "}";
	}
	
}
