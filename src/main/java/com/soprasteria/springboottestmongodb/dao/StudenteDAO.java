package com.soprasteria.springboottestmongodb.dao;

import java.util.List;

import com.soprasteria.springboottestmongodb.dto.StudentePageInformation;
import com.soprasteria.springboottestmongodb.exceptions.StudenteException;
import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam2;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam3;
import com.soprasteria.springboottestmongodb.model.StudenteSearchParam;

public interface StudenteDAO {
	
	public Studente insertStudente(Studente studente);
	
	//NO FILTRI
	public List<Studente> findAllStudenti();
	public StudentePageInformation findAllStudentiPagination(StudentePaginationSearchParam3 pagParam);
	
	public Studente findStudenteById(String sId);
	
	//1 FILTRO
	public List<Studente> findStudentiWith(String sottoStringa);
	public StudentePageInformation findStudentiWithPagination(StudentePaginationSearchParam2 pagParam);
	
	//3 FILTRI
	public List<Studente> findStudentiWith(StudenteSearchParam param);
	public StudentePageInformation findStudentiWithPagination(StudentePaginationSearchParam pagParam);
	
	public Studente updateStudente(Studente studente);
	
	public void deleteStudente(String sId) throws StudenteException;

}
