package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;

public class ReeferResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String whenCreated;
	private String ownerId;
	private String reeferClass;
	private ReeferDataResponse data;
	private String assetId;
	private String assetSerial;
	
	
	public ReeferResponse() {
	
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getWhenCreated() {
		return whenCreated;
	}


	public void setWhenCreated(String whenCreated) {
		this.whenCreated = whenCreated;
	}


	public String getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}


	public String getReeferClass() {
		return reeferClass;
	}


	public void setReeferClass(String reeferClass) {
		this.reeferClass = reeferClass;
	}


	public ReeferDataResponse getData() {
		return data;
	}


	public void setData(ReeferDataResponse data) {
		this.data = data;
	}


	public String getAssetId() {
		return assetId;
	}


	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}


	public String getAssetSerial() {
		return assetSerial;
	}


	public void setAssetSerial(String assetSerial) {
		this.assetSerial = assetSerial;
	}


	@Override
	public String toString() {
		return "{id:" + id + ", whenCreated:" + whenCreated + ", ownerId:" + ownerId + ", reeferClass:"
				+ reeferClass + ", data:" + data + ", assetId:" + assetId + ", assetSerial:" + assetSerial + "}";
	}
	
	
	
}
