package com.soprasteria.springboottestmongodb.service;

import java.util.List;

import com.soprasteria.springboottestmongodb.dto.StudentePageInformation;
import com.soprasteria.springboottestmongodb.exceptions.StudenteException;
import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam2;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam3;
import com.soprasteria.springboottestmongodb.model.StudenteSearchParam;

public interface StudenteService {
	
	public Studente saveStudente(Studente studente);
	
	public Studente updateStudente(Studente studente) throws StudenteException;
	
	//NO FILTRI
	public List<Studente> getAllStudenti() throws StudenteException;
	public StudentePageInformation getAllStudentiPagination(StudentePaginationSearchParam3 pagParam) throws StudenteException;
	
 	public Studente getStudenteById(String sId) throws StudenteException;
 	
 	//3 FILTRI
 	public List<Studente> getStudentiWith(StudenteSearchParam param) throws StudenteException;
 	public StudentePageInformation getStudentiWithPagination(StudentePaginationSearchParam pagParam) throws StudenteException;
 	
 	//1 FILTRO
 	public List<Studente> getStudentiWith(String sottoStringa) throws StudenteException;
 	public StudentePageInformation getStudentiWithPagination(StudentePaginationSearchParam2 pagParam) throws StudenteException;
 	
 	public void deleteStudente(String id) throws StudenteException;

}
