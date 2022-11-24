package com.soprasteria.springboottestmongodb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import com.soprasteria.springboottestmongodb.dao.StudenteDAO;
import com.soprasteria.springboottestmongodb.dto.StudentePageInformation;
import com.soprasteria.springboottestmongodb.exceptions.StudenteException;
import com.soprasteria.springboottestmongodb.exceptions.StudenteNotFoundException;
import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam2;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam3;
import com.soprasteria.springboottestmongodb.model.StudenteSearchParam;

@Repository
public class StudenteDAOImpl implements StudenteDAO {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Studente insertStudente(Studente studente) {
		// TODO Auto-generated method stub
		return mongoTemplate.insert(studente);
	}

	@Override
	public List<Studente> findAllStudenti() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Studente.class);
	}

	@Override
	public Studente findStudenteById(String sId) {
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(sId)), Studente.class);
	}

	@Override
	public Studente updateStudente(Studente studente) {
		// TODO Auto-generated method stub
		return mongoTemplate.findAndReplace(new Query(Criteria.where("id").is(studente.getId())), studente);
	}

	@Override
	public void deleteStudente(String sId) throws StudenteException {
		// TODO Auto-generated method stub
		String studenteNotFoundMessage = "errore: lo studente con id: " + sId + " non è stato cancellato perchè non è presente nel database!";
		//The $in operator selects the documents where the value of a field equals any value in the specified array.
		Criteria criteria = Criteria.where("id").in(sId);
		if(criteria != null) {
			Query query = new Query(criteria);
			if(query != null && mongoTemplate.findOne(query, Studente.class) != null) {
				mongoTemplate.remove(mongoTemplate.findOne(query, Studente.class));
			} else {
				throw new StudenteNotFoundException(studenteNotFoundMessage);
			}
		} else {
			throw new StudenteNotFoundException(studenteNotFoundMessage);
		}
	}

	//OR
	@Override
	public List<Studente> findStudentiWith(String sottoStringa) {
		// TODO Auto-generated method stub
		
		//I PARAMETRI LI USO TUTTI
		Criteria searchCriteria = new Criteria();
		Criteria nomeCriteria = Criteria.where("nome").regex(".*" + sottoStringa + ".*", "i");
		Criteria cognomeCriteria = Criteria.where("cognome").regex(".*" + sottoStringa + ".*", "i");
		Criteria corsoCriteria = Criteria.where("listaCorsi").regex(".*" + sottoStringa + ".*", "i");
		searchCriteria.orOperator(nomeCriteria, cognomeCriteria, corsoCriteria);
		
		//FACCIO LA RICERCA
		List<Studente> studenti = null;
		if(searchCriteria != null) {
			Query query = new Query(searchCriteria);
			studenti = mongoTemplate.find(query, Studente.class);
		}
		return studenti;
	}
	
	//AND
	@Override
	public List<Studente> findStudentiWith(StudenteSearchParam param) {
		// TODO Auto-generated method stub
		
		//QUALI PARAMETRI SCELGO DI USARE?
		String nome = param.getNome();
		String cognome = param.getCognome();
		String corso = param.getCorso();
		Criteria nomeCriteria = null;
		Criteria cognomeCriteria = null;
		Criteria corsoCriteria = null;
		Criteria searchCriteria = new Criteria();
		List<Criteria> criterias = new ArrayList<Criteria>();
		if(nome != null) {
			nomeCriteria = Criteria.where("nome").regex(".*" + nome + ".*", "i");
			criterias.add(nomeCriteria);
		}
		if(cognome != null) {
			cognomeCriteria = Criteria.where("cognome").regex(".*" + cognome + ".*", "i");
			criterias.add(cognomeCriteria);
		}
		if(corso != null) {
			corsoCriteria = Criteria.where("listaCorsi").regex(".*" + corso + ".*", "i");
			criterias.add(corsoCriteria);
		}
		searchCriteria.andOperator(criterias);
		
		//FACCIO LA RICERCA
		List<Studente> studenti = null;
		if(searchCriteria != null) {
			Query query = new Query(searchCriteria);
			studenti = mongoTemplate.find(query, Studente.class);
		}
		return studenti;
	}

	@Override
	public StudentePageInformation findAllStudentiPagination(StudentePaginationSearchParam3 pagParam) {
		// TODO Auto-generated method stub
		Pageable paginabile = PageRequest.of(pagParam.getNumeroPagina(), pagParam.getNumElemPerPagina());
		Query query = new Query().with(paginabile);
		List<Studente> studenti = mongoTemplate.find(query, Studente.class);
		Page<Studente> paginaStudente = PageableExecutionUtils.getPage(studenti, paginabile, () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), Studente.class));
		StudentePageInformation spi = new StudentePageInformation(studenti, paginaStudente.getNumber(), paginaStudente.getTotalPages(), paginaStudente.getTotalElements());
		return spi;
	}

	@Override
	public StudentePageInformation findStudentiWithPagination(StudentePaginationSearchParam2 pagParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentePageInformation findStudentiWithPagination(StudentePaginationSearchParam pagParam) {
		// TODO Auto-generated method stub
		return null;
	}

}
