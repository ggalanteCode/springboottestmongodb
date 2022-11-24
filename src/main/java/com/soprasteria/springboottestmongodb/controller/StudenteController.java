package com.soprasteria.springboottestmongodb.controller;

import org.springframework.http.ResponseEntity;

import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.model.StudenteSearchParam;

public interface StudenteController {
	
	public ResponseEntity<Object> getAllStudenti();
	
	public ResponseEntity<Object> getAllStudentiPag();
	
	public ResponseEntity<Object> getStudenteById(String id);
	
	public ResponseEntity<Object> getStudentiWith(StudenteSearchParam param);
	
	public ResponseEntity<Object> getStudentiWithPag(StudenteSearchParam param);
	
	public ResponseEntity<Object> getStudentiWith(String sottoStringa);
	
	public ResponseEntity<Object> getStudentiWithPag(String sottoStringa);
	
	public ResponseEntity<Studente> createNewStudente(Studente studente);
	
	public ResponseEntity<Object> updateExistingStudente(Studente studente);
	
	public ResponseEntity<String> deleteStudente(String id);

}
