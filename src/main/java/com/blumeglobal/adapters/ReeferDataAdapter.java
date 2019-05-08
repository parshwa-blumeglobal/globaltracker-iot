package com.blumeglobal.adapters;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.blumeglobal.eventmanager.kafka.producer.NotificationSender;
import com.blumeglobal.eventmanager.schemas.reefer.AssetResponse;
import com.blumeglobal.eventmanager.schemas.reefer.ReeferResponse;
import com.blumeglobal.eventmanager.schemas.reefer.TokenResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.json.JSONObject;



@Component
public class ReeferDataAdapter {
	
	private static final Logger LOGGER = LogManager.getLogger(ReeferDataAdapter.class);
	
	@Value("${gt.asset.retrievebyIdURL}") 
	String assetURL;
	
	@Value("${gt.reefer.retrievebyIdURL}")
	String reeferURL;
	
	@Value("${gt.clientId}")
	String clientId;
	
	@Value("${gt.clientSecret}")
	String clientSecret;
	
	@Value("${gt.username}")
	String username;
	
	@Value("${gt.password}")
	String password;
	
	@Value("${gt.grant_type}")
	String grant_type;
	
	@Value("${gt.TokenName}")
	String TokenName;
	
	
	
	/**
	 * This ReeferData Adapter method is used to Deliver ReeferData to Kafka topic
	 * 
	 * @param reeferDataId - Reefer Data Id
	 * @param size - Size  of Reefer Data
	 * @param notificationSender - NotificationSender Object for Kafka producer
	 */
	public void deliverdReeferData(int reeferDataId, int size, NotificationSender notificationSender) {
		LOGGER.info("Enter into ReeferDataAdapter.deliverdReeferData");
		
		LOGGER.info("Inside ReeferDataAdapter.deliverdReeferData - Call getReeferDataBySinceId method");
		List<ReeferResponse> reeferResponselst = getReeferDataBySinceId(reeferDataId, size);
					
		LOGGER.info("Inside ReeferDataAdapter.deliverdReeferData - Call sendMessagesToKakfa method");
		sendMessagesToKakfa(reeferResponselst, notificationSender);
		
	}
	
	
	
	/**
	 * This ReeferData Adapter method is used to retrieve list of reefer data by since Id using API
	 * 
	 * @param sinceId - sinceId
	 * @param size - sinceId
	 * 
	 * @return List of ReeferResponse
	 */
	public List<ReeferResponse> getReeferDataBySinceId(int sinceId, int size) {
		LOGGER.info("Enter into ReeferDataAdapter.getReeferDataBySinceId");
		
		try {
			LOGGER.info("Inside ReeferDataAdapter.getReeferDataBySinceId - Call fetchToken method");
			String token = "Bearer " + fetchToken();
			
			String url = reeferURL.trim() + "?";
			
			LOGGER.info("Inside ReeferDataAdapter.getReeferDataBySinceId - set HttpHeaders");
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			headers.set("Authorization", token);
			HttpEntity<?> entity = new HttpEntity<>(headers);
			
			LOGGER.info("Inside ReeferDataAdapter.getReeferDataBySinceId - set url and add query parameters");
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
			        .queryParam("sinceId", sinceId)
			        .queryParam("size", size);
			
			System.setProperty("jsse.enableSNIExtension", "false");
			RestTemplate restTemplate = new RestTemplate();
		    
			
			LOGGER.info("Inside ReeferDataAdapter.getReeferDataBySinceId - make get call to GT sense API");
			ResponseEntity<List<ReeferResponse>> response = restTemplate.exchange(builder.toUriString(), 
					HttpMethod.GET, entity, new ParameterizedTypeReference<List<ReeferResponse>>(){});
			LOGGER.info("Inside ReeferDataAdapter.getReeferDataBySinceId - get response successful from GT sense API");
		    
			return response.getBody();
			
		} catch (Exception e) {
			LOGGER.info("Inside Catch Block ReeferDataAdapter.getReeferDataBySinceId - get error from GT sense API" + e);
			// e.printStackTrace();
			return null;
		}
	}
	
	
	
	/**
	 * This ReeferData Adapter method is used to Fetch Token using API
	 * 
	 * @return token as String
	 */
	public String fetchToken() {
		LOGGER.info("Enter into ReeferDataAdapter.fetchToken");
		
		try {
			// Parshwa put url in property file
			String url = "https://auth.globetracker.com/auth/realms/gtsense/protocol/openid-connect/token";
			
			LOGGER.info("Inside ReeferDataAdapter.fetchToken - set HttpHeaders");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			
			LOGGER.info("Inside ReeferDataAdapter.fetchToken - set HttpEntity Body part");
			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("grant_type", grant_type);
			map.add("username", username);
			map.add("password", password);
			map.add("client_id", clientId);
			map.add("client_secret", clientSecret);
			map.add("Token Name", TokenName);
			
			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);

			System.setProperty("jsse.enableSNIExtension", "false");
			// Parshwa Autowire resttemplate
			RestTemplate restTemplate = new RestTemplate();
			
			LOGGER.info("Inside ReeferDataAdapter.fetchToken - Post Call to GT sense fetch token security API");
			ResponseEntity<TokenResponse> response = restTemplate.postForEntity(url, entity, TokenResponse.class);

			return response.getBody().getAccess_token();
			
		} catch(Exception e) {
			LOGGER.info("Inside Catch Block ReeferDataAdapter.fetchToken - error in Post Call to GT sense fetch token security API" + e);
			// e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	/**
	 * This ReeferData Adapter method is used to get Asset data by asset Id using API
	 * 
	 * @param reeferResponselst - List of ReeferResponse
	 * @param notificationSender - NotificationSender
	 * 
	 */
	private void sendMessagesToKakfa(List<ReeferResponse> reeferResponselst, NotificationSender notificationSender) {
		LOGGER.info("Enter into ReeferDataAdapter.sendMessagesToKakfa");
		// Parshwa possible NPE reeferResponselst
		if(reeferResponselst.size() != 0) {
			for(ReeferResponse reeferResponse : reeferResponselst) {
				LOGGER.info("Inside ReeferDataAdapter.sendMessagesToKakfa - call parseMessage method");
				JSONObject parsedReeferResponse = parseMessage(reeferResponse);
				
				try {
					LOGGER.info("Inside ReeferDataAdapter.sendMessagesToKakfa - send message to kafka topic");
					notificationSender.send(parsedReeferResponse.toString());
				} catch (Exception e) {
					LOGGER.info("Inside Catch Block of ReeferDataAdapter.sendMessagesToKakfa - error in send message to kafka topic" + e);
				}
				
				LOGGER.info("Inside ReeferDataAdapter.sendMessagesToKakfa - send message to kafka topic successfully");
			}
		} else {
			LOGGER.info("Inside ReeferDataAdapter.sendMessagesToKakfa - Data not available from Reefer API");
		}
		
	}
	
	
	
	/**
	 * This ReeferData Adapter method is used to parse message and map it with kafka response
	 * 
	 * @param reeferResponse - ReeferResponse
	 * 
	 * @return JSONObject
	 */
	private JSONObject parseMessage(ReeferResponse reeferResponse) {
		LOGGER.info("Enter into ReeferDataAdapter.parseMessage");
		JSONObject parsedReeferResponse = new JSONObject();
		// Parshwa no need of OBjectMapper use objectmapper
		ObjectWriter ow = new ObjectMapper().writer();
		
		JSONObject reeferMessage = null;
		try {
			reeferMessage = new JSONObject(ow.writeValueAsString(reeferResponse));
		} catch (JsonProcessingException jpe) {
			LOGGER.error("Inside ReeferDataAdapter.parseMessage Catch Block" + jpe);
			// jpe.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Inside ReeferDataAdapter.parseMessage Catch Block" + e);
			// e.printStackTrace();		
		}
		
		if (reeferMessage != null && reeferResponse != null) {
			parsedReeferResponse.put("Content", reeferMessage);
			parsedReeferResponse.put("SourceDesc", "GT Sense");
			
			parsedReeferResponse.put("SystemId", "");
			
			//check
			parsedReeferResponse.put("OrganizationId", "");
			
			parsedReeferResponse.put("LocationId", "");
			parsedReeferResponse.put("SourceCategory", "IoT Vendor");
			parsedReeferResponse.put("DestinationRefNumber", "");
			parsedReeferResponse.put("DestinationId", "");
			parsedReeferResponse.put("DestinationCategory", "");
			parsedReeferResponse.put("DestinationDesc", "");
			parsedReeferResponse.put("StatusPrimary", "received");
			parsedReeferResponse.put("StatusSecondary", "");
			parsedReeferResponse.put("AuthId", "0");
			parsedReeferResponse.put("AuthType", "system");
			parsedReeferResponse.put("TimeZone", "UTC");
			parsedReeferResponse.put("NotificationNeeded", false);
			parsedReeferResponse.put("NotificationGenerated", false);
			parsedReeferResponse.put("RetryCount", 0);
			parsedReeferResponse.put("Priority", "normal");
			parsedReeferResponse.put("NextStep", "");
			parsedReeferResponse.put("LastSuccessStep", "");
			
			parsedReeferResponse.put("Ref1_type", "ASSETID");
			parsedReeferResponse.put("Reference1", reeferResponse.getAssetId());
			
			parsedReeferResponse.put("Ref2_type", "ASSETNAME");
			 
			LOGGER.info("Inside ReeferDataAdapter.parseMessage - fetch Asset Name value Call Retrieve asset data by asset id API of GT Sense");
			AssetResponse assetResponse = getAssetDataByAssetId(reeferResponse.getAssetId());
			if(assetResponse == null ) {
				parsedReeferResponse.put("Reference2", "");
			} else {
				parsedReeferResponse.put("Reference2", assetResponse.getName());
			}
			
			
			parsedReeferResponse.put("SystemId", UUID.randomUUID());
			parsedReeferResponse.put("TmpSystemId", "");
			parsedReeferResponse.put("SourceId", "GT");
			parsedReeferResponse.put("Category", "GT Reefer Data");
		
			parsedReeferResponse.put("SourceRefNumber", reeferResponse.getId());
			
			parsedReeferResponse.put("SourceRefNumber", "");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String dateTime = dateFormat.format(cal.getTime());
			parsedReeferResponse.put("Timestamp", dateTime);
			parsedReeferResponse.put("EventTimestamp", dateTime);
			
			return parsedReeferResponse;
		} else {
			LOGGER.info("Inside ReeferDataAdapter.parseMessage - Reefer Data is not available from GT Sense");
		}
		
		return null;
	}
	
	
	
	/**
	 * This ReeferData Adapter method is used to retrieve asset data by asset Id using API
	 * 
	 * @param assetId - asset Id
	 * 
	 * @return AssetResponse
	 */
	public AssetResponse getAssetDataByAssetId(String assetId) {
		LOGGER.info("Enter into ReeferDataAdapter.getAssetDataByAssetId");
		
		if(assetId == null) {
			LOGGER.warn("Inside ReeferDataAdapter.getAssetDataByAssetId - assetId is null");
			return  null;
		}
		
		try {
			String token = "Bearer " + fetchToken();
			String url = assetURL + "/" + assetId;
			
			LOGGER.info("Inside ReeferDataAdapter.getAssetDataByAssetId - set header");
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			headers.set("Authorization", token);
			HttpEntity<?> entity = new HttpEntity<>(headers);
			
			
			
			System.setProperty("jsse.enableSNIExtension", "false");
			// parshwa autowire resttemplate
			RestTemplate restTemplate = new RestTemplate();
		    
			LOGGER.info("Inside ReeferDataAdapter.getAssetDataByAssetId - Get call to asset id API");
			ResponseEntity<AssetResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, AssetResponse.class);
		    
			return response.getBody();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	
	
}















///**
// * This Asset Adapter method is used to retrieve asset data by since Id using API
// * 
// * @param assetId - sinceId
// * @param size - sinceId
// * 
// * @return List of AssetResponse
// */
//public List<AssetResponse> getAssetBySinceId(String assetId, int size) {
//	try {
//		String token = "Bearer " + fetchToken().trim();
//		
//		String url = assetURL.trim() + "?";
//		
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//		headers.set("Authorization", token);
//		HttpEntity<?> entity = new HttpEntity<>(headers);
//		
//		
//		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
//		        .queryParam("sinceId", assetId)
//		        .queryParam("size", size);
//		System.out.println("Builder Query: " + builder.toUriString());
//
//		
//		System.setProperty("jsse.enableSNIExtension", "false");
//		RestTemplate restTemplate = new RestTemplate();
//	    
//		
//		//Get Call
//		ResponseEntity<List<AssetResponse>> response = restTemplate.exchange(builder.toUriString(), 
//				HttpMethod.GET, entity, new ParameterizedTypeReference<List<AssetResponse>>(){});
//	    
//		System.out.println("Response:" + response.getBody());
//		return response.getBody();
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		return null;
//	}
//}
//
//
//
///**
// * This Asset Adapter method is used to get Asset data by asset Id using API
// * 
// * @param assetId - asset Id
// * @param pageNumber - Page Number
// * @param recordSize - Record Size
// * 
// * @return List of AssetResponse
// */
//public List<AssetResponse> getAssetSensorDataByAssetId(String assetId, String pageNumber, String recordSize) {
//	try {
//		String token = "Bearer " + fetchToken();
//		String url = assetURL.trim() + "/" + assetId + assetSensorURL;
//		
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//		headers.set("Authorization", token);
//		HttpEntity<?> entity = new HttpEntity<>(headers);
//		
//		
//		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
//		        .queryParam("page", pageNumber)
//		        .queryParam("size", recordSize);
//		System.out.println("Builder Query: " + builder.toUriString());
//
//		
//		System.setProperty("jsse.enableSNIExtension", "false");
//		RestTemplate restTemplate = new RestTemplate();
//	    
//		
//		//Get Call
//		ResponseEntity<List<AssetResponse>> response = restTemplate.exchange(builder.toUriString(), 
//				HttpMethod.GET, entity, new ParameterizedTypeReference<List<AssetResponse>>(){});
//	    
//		System.out.println("Response:" + response.getBody());
//		return response.getBody();
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		return null;
//	}
//}
//
//
//

//
//
//
///**
// * This Asset Adapter method is used to get Reefer data by reeferId using API
// * 
// * @param reeferDataId - Reefer Data Id
// * 
// * @return ReeferResponse
// */
//public ReeferResponse getReeferDataById(String reeferDataId) {
//	try {
//		
//		String url = reeferURL + "/" + reeferDataId;
//		String token = "Bearer " + fetchToken();
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//		headers.set("Authorization", token);
//		HttpEntity<?> entity = new HttpEntity<>(headers);
//		
//		System.setProperty("jsse.enableSNIExtension", "false");
//		
//		RestTemplate restTemplate = new RestTemplate();
//	    
//		ResponseEntity<ReeferResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, ReeferResponse.class);
//	    
//		System.out.println("Response:" + response.getBody());
//		return response.getBody();
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		return null;
//	}
//}



