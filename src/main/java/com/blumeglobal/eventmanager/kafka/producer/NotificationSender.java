package com.blumeglobal.eventmanager.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class NotificationSender {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationSender.class);
	
	static final String ORBCOMM_TOPIC = "Raw_Event_OrbComm";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String payload) {
		LOGGER.info("sending payload='{}'", payload);
//		kafkaTemplate.send(ORBCOMM_TOPIC, payload);
		kafkaTemplate.send("test", payload);
	}
}