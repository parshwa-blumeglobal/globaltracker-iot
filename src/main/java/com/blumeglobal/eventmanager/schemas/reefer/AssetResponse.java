package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;

public class AssetResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Boolean disabled;
	private String note;
	private String whenCreated;
	private String whenUpdated;
	private String tags;
	private String ownerId;
	private String id;
	private String name;
	
	
	public AssetResponse() {
		
	}


	public Boolean getDisabled() {
		return disabled;
	}


	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getWhenCreated() {
		return whenCreated;
	}


	public void setWhenCreated(String whenCreated) {
		this.whenCreated = whenCreated;
	}


	public String getWhenUpdated() {
		return whenUpdated;
	}


	public void setWhenUpdated(String whenUpdated) {
		this.whenUpdated = whenUpdated;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}


	public String getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
}
