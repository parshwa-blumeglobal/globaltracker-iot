package com.blumeglobal.eventmanager.service.rest;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blumeglobal.adapters.ReeferDataAdapter;
import com.blumeglobal.eventmanager.kafka.producer.NotificationSender;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/v1")
public class ReeferDataService {
	
	private static final Logger LOGGER = LogManager.getLogger(ReeferDataService.class);
	
	@Autowired
	ReeferDataAdapter assetAdapter;
	
	@Value("${spring.adapter.cron-time}")
	private int cronTime;
	
	@Value("${spring.reeferData.reeferSinceId}")
	int reeferSinceId;
	
	@Value("${spring.reeferData.size}")
	int size;
	
	@Autowired
	private NotificationSender notificationSender;
	
	
	/**
	 * This ReeferData Adapter Service method is used to start Adapter
	 * 
	 * @return List of ReeferResponse
	 */
	@RequestMapping("/startReeferDataAdapter")
	public String startAdapter() {
		LOGGER.info("Enter into AdapterService.startAdapter");
		
		LOGGER.info("Inside AdapterService.startAdapter - set ScheduledExecutorService");
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		Runnable task = () -> {
			try {
				//System.out.println("*******************************---Started---******************************   =>  " + reeferSinceId);
				LOGGER.info("Inside AdapterService.startAdapter - delivering messages to Kafka");
				assetAdapter.deliverdReeferData(reeferSinceId, size, notificationSender);
				reeferSinceId++;
			} catch (Exception e) {
				LOGGER.info("Inside Catch Block AdapterService.startAdapter - error occur in delivering messages to Kafka" + e.getMessage());
			}
		};
		
		executor.scheduleAtFixedRate(task, 0, cronTime, TimeUnit.SECONDS);
		return "Started Reefer Data tasks";
	}
	
}


















	/*
	@RequestMapping(value = "/gt/rs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAssetsgetReeferDataSince() {
		List<ReeferResponse> assetResponse = assetAdapter.getReeferDataBySinceId("1", "10");
		return new ResponseEntity<>(assetResponse, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/gt/token", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getToken() {
		String token = assetAdapter.fetchToken();
		return new ResponseEntity<>(token, HttpStatus.OK);
	}
	
	*/

