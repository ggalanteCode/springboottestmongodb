package com.soprasteria.springboottestmongodb.dao;

import java.util.List;

import com.soprasteria.springboottestmongodb.exceptions.StudenteException;
import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.model.StudenteSearchParam;

public interface StudenteDAO {
	
	public Studente insertStudente(Studente studente);
	
	public List<Studente> findAllStudenti();
	
	public Studente findStudenteById(String sId);
	
	public List<Studente> findStudentiWith(String sottoStringa) throws StudenteException;
	
	public List<Studente> findStudentiWith(StudenteSearchParam param) throws StudenteException;
	
	public Studente updateStudente(Studente studente);
	
	public void deleteStudente(String sId) throws StudenteException;

}
