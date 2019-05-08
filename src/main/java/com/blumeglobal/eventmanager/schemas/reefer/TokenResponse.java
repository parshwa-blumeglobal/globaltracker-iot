package com.blumeglobal.eventmanager.schemas.reefer;

import java.io.Serializable;

public class TokenResponse implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private String access_token;

	public TokenResponse() {
			
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
		
}
