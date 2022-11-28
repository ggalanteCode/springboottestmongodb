package com.soprasteria.springboottestmongodb.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.soprasteria.springboottestmongodb.constants.KafkaConstants;

@Configuration
public class StudenteTopicConfig {
	
	//QUESTA E' LA CLASSE CHE SI OCCUPA DI CREARE I TOPIC
	
	@Bean
	public NewTopic firstTopic() {
		return TopicBuilder.name(KafkaConstants.TOPIC_NAME).build();
	}

}
