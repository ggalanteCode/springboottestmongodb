package com.soprasteria.springboottestmongodb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.soprasteria.springboottestmongodb.constants.KafkaConstants;
import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.service.StudenteProducerService;

@Service
public class StudenteProducerServiceImpl implements StudenteProducerService {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Override
	public void publish(Studente studente) {
		// TODO Auto-generated method stub
		kafkaTemplate.send(KafkaConstants.TOPIC_NAME, studente);
	}

}
