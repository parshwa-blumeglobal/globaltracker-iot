package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;
import java.util.List;

public class SensorDataResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<AssetResponse> sensorData;

	public SensorDataResponse() {
		
	}

	public List<AssetResponse> getSensorData() {
		return sensorData;
	}

	public void setSensorData(List<AssetResponse> sensorData) {
		this.sensorData = sensorData;
	}

}
