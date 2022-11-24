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
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam2;
import com.soprasteria.springboottestmongodb.model.StudentePaginationSearchParam3;
import com.soprasteria.springboottestmongodb.model.StudenteSearchParam;
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
			return new ResponseEntity<Object>("studente con id: " + studente.getId() + " aggiornato con successo!",
					HttpStatus.OK);
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

	// SEARCH PARAMETRIZZATE

	@Override
	@GetMapping("/studentiWithMultipleParams")
	public ResponseEntity<Object> getStudentiWith(@RequestBody StudenteSearchParam param) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<Object>(studenteService.getStudentiWith(param), HttpStatus.OK);
		} catch (StudenteException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	@GetMapping("/studentiWith/{sottoStringa}")
	public ResponseEntity<Object> getStudentiWith(@PathVariable(value = "sottoStringa") String sottoStringa) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<Object>(studenteService.getStudentiWith(sottoStringa), HttpStatus.OK);
		} catch (StudenteException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// SEARCH CON PAGINAZIONE

	@Override
	@PostMapping("/allStudentiPag")
	public ResponseEntity<Object> getAllStudentiPag(@RequestBody StudentePaginationSearchParam3 pagParam) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<Object>(studenteService.getAllStudentiPagination(pagParam), HttpStatus.OK);
		} catch (StudenteException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	@PostMapping("/studentiWithMultipleParamsPag")
	public ResponseEntity<Object> getStudentiWithPag(@RequestBody StudentePaginationSearchParam pagParam) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<Object>(studenteService.getStudentiWithPagination(pagParam), HttpStatus.OK);
		} catch (StudenteException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	@PostMapping("/studentiWithPag/{sottoStringa}")
	public ResponseEntity<Object> getStudentiWithPag(@RequestBody StudentePaginationSearchParam2 pagParam) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<Object>(studenteService.getStudentiWithPagination(pagParam), HttpStatus.OK);
		} catch (StudenteException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
