package com.soprasteria.springboottestmongodb.controller;

import org.springframework.http.ResponseEntity;

import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam2;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam3;
import com.soprasteria.springboottestmongodb.model.StudenteSearchParam;

public interface StudenteController {
	
	public ResponseEntity<Object> getAllStudenti();
	
	public ResponseEntity<Object> getAllStudentiPag(StudentePaginationSearchParam3 pagParam);
	
	public ResponseEntity<Object> getStudenteById(String id);
	
	public ResponseEntity<Object> getStudentiWith(StudenteSearchParam param);
	
	public ResponseEntity<Object> getStudentiWithPag(StudentePaginationSearchParam pagParam);
	
	public ResponseEntity<Object> getStudentiWith(String sottoStringa);
	
	public ResponseEntity<Object> getStudentiWithPag(StudentePaginationSearchParam2 pagParam);
	
	public ResponseEntity<Studente> createNewStudente(Studente studente);
	
	public ResponseEntity<Object> updateExistingStudente(Studente studente);
	
	public ResponseEntity<String> deleteStudente(String id);

}
