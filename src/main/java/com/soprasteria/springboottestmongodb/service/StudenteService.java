package com.soprasteria.springboottestmongodb.service;

import java.util.List;

import com.soprasteria.springboottestmongodb.exceptions.StudenteException;
import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.model.StudenteSearchParam;

public interface StudenteService {
	
	public Studente saveStudente(Studente studente);
	
	public Studente updateStudente(Studente studente) throws StudenteException;
	
	public List<Studente> getAllStudenti() throws StudenteException;
	
	public List<Studente> getAllStudentiPagination();
	
 	public Studente getStudenteById(String sId) throws StudenteException;
 	
 	public List<Studente> getStudentiWith(StudenteSearchParam param) throws StudenteException;
 	
 	public List<Studente> getStudentiWith(String sottoStringa) throws StudenteException;
 	
 	public void deleteStudente(String id) throws StudenteException;

}
