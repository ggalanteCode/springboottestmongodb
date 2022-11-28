package com.soprasteria.springboottestmongodb.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.soprasteria.springboottestmongodb.constants.KafkaConstants;
import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.service.StudenteConsumerService;

@Component
public class StudenteListeners {

	// IL CONSUMER RIMANE IN ASCOLTO E RICEVE GLI STREAM DI EVENTI
	// DI UN TOPIC...
	// ...QUINDI CON IL CONTROLLER (PER MEZZO DI UN KAFKA TEMPLATE)
	// PUBBLICHIAMO UN MESSAGGIO, E IL CONSUMER LO LEGGE
	
	@Autowired
	private StudenteConsumerService studenteConsumerService;

	@KafkaListener(topics = KafkaConstants.TOPIC_NAME, groupId = KafkaConstants.GROUP_ID_JSON, containerFactory = KafkaConstants.KAFKA_LISTENER_CONTAINER_FACTORY)
	public void listener(Studente studente) {
		studenteConsumerService.insertStudente(studente);
	}

}
