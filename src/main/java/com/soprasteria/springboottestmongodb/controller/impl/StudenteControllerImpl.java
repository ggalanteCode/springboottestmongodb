package com.soprasteria.springboottestmongodb.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.springboottestmongodb.controller.StudenteController;
import com.soprasteria.springboottestmongodb.exceptions.StudenteException;
import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.service.StudenteService;

@RestController
@RequestMapping("/mongodb/studenti")
public class StudenteControllerImpl implements StudenteController {
	
	@Autowired
	private StudenteService studenteService;

	@Override
	@GetMapping("/allStudenti")
	public ResponseEntity<Object> getAllStudenti() {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<Object>(studenteService.getAllStudenti(), HttpStatus.OK);
		} catch (StudenteException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	@GetMapping("/studenteById/{id}")
	public ResponseEntity<Object> getStudenteById(@PathVariable(value = "id") String id) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<Object>(studenteService.getStudenteById(id), HttpStatus.OK);
		} catch (StudenteException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	@PostMapping("/newStudente")
	public ResponseEntity<Studente> createNewStudente(@RequestBody Studente studente) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Studente>(studenteService.saveStudente(studente), HttpStatus.CREATED);
	}

	@Override
	@PutMapping("/updateStudente")
	public ResponseEntity<Object> updateExistingStudente(@RequestBody Studente studente) {
		// TODO Auto-generated method stub
		try {
			studenteService.updateStudente(studente);
			return new ResponseEntity<Object>("studente con id: " + studente.getId() + " aggiornato con successo!", HttpStatus.OK);
		} catch (StudenteException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	@DeleteMapping("/deleteStudente/{id}")
	public ResponseEntity<String> deleteStudente(@PathVariable(value = "id") String id) {
		// TODO Auto-generated method stub
		try {
			studenteService.deleteStudente(id);
			return new ResponseEntity<String>("studente con id: " + id + " cancellato con successo!", HttpStatus.OK);
		} catch (StudenteException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
