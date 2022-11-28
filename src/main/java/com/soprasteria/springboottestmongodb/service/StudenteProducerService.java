package com.soprasteria.springboottestmongodb.service;

import com.soprasteria.springboottestmongodb.model.Studente;

public interface StudenteProducerService {
	
	public void publish(Studente studente);

}
