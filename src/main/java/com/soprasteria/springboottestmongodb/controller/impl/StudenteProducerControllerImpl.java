package com.soprasteria.springboottestmongodb.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.springboottestmongodb.controller.StudenteProducerController;
import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.service.StudenteProducerService;

@RestController
@RequestMapping("/kafka/studenti")
public class StudenteProducerControllerImpl implements StudenteProducerController {

	@Autowired
	private StudenteProducerService studenteProducerService;
	
	@Override
	@PostMapping("/newStudente")
	public ResponseEntity<Object> produceNewStudente(@RequestBody Studente studente) {
		// TODO Auto-generated method stub
		studenteProducerService.publish(studente);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
