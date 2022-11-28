package com.soprasteria.springboottestmongodb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.service.StudenteConsumerService;

@Repository
public class StudenteConsumerServiceImpl implements StudenteConsumerService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void insertStudente(Studente studente) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(studente);
	}

}
