package com.soprasteria.springboottestmongodb.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.soprasteria.springboottestmongodb.dao.StudenteDAO;
import com.soprasteria.springboottestmongodb.exceptions.StudenteException;
import com.soprasteria.springboottestmongodb.exceptions.StudenteNotFoundException;
import com.soprasteria.springboottestmongodb.model.Studente;

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

}
