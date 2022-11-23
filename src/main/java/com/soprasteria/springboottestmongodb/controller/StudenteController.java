package com.soprasteria.springboottestmongodb.controller;

import org.springframework.http.ResponseEntity;

import com.soprasteria.springboottestmongodb.model.Studente;

public interface StudenteController {
	
	public ResponseEntity<Object> getAllStudenti();
	
	public ResponseEntity<Object> getStudenteById(String id);
	
	public ResponseEntity<Studente> createNewStudente(Studente studente);
	
	public ResponseEntity<Object> updateExistingStudente(Studente studente);
	
	public ResponseEntity<String> deleteStudente(String id);

}
