package com.soprasteria.springboottestmongodb.controller;

import org.springframework.http.ResponseEntity;

import com.soprasteria.springboottestmongodb.model.Studente;

public interface StudenteProducerController {
	
	public ResponseEntity<Object> produceNewStudente(Studente studente);

}
