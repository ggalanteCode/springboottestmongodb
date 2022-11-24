package com.soprasteria.springboottestmongodb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soprasteria.springboottestmongodb.dao.StudenteDAO;
import com.soprasteria.springboottestmongodb.exceptions.StudenteEmptyListException;
import com.soprasteria.springboottestmongodb.exceptions.StudenteException;
import com.soprasteria.springboottestmongodb.exceptions.StudenteNotFoundException;
import com.soprasteria.springboottestmongodb.model.Studente;
import com.soprasteria.springboottestmongodb.model.StudenteSearchParam;
import com.soprasteria.springboottestmongodb.service.StudenteService;

@Service
public class StudenteServiceImpl implements StudenteService {
	
	@Autowired
	private StudenteDAO studenteDAO;

	@Override
	public Studente saveStudente(Studente studente) {
		// TODO Auto-generated method stub
		return studenteDAO.insertStudente(studente);
	}

	@Override
	public Studente updateStudente(Studente studente) throws StudenteException {
		// TODO Auto-generated method stub
		Studente vecchioStudente = studenteDAO.updateStudente(studente);
		if(vecchioStudente != null) {
			return vecchioStudente;
		} else {
			throw new StudenteNotFoundException("errore: lo studente con id: " + studente.getId() + " non è stato aggiornato perchè non è presente nel database!");
		}
	}

	@Override
	public List<Studente> getAllStudenti() throws StudenteException {
		// TODO Auto-generated method stub
		List<Studente> studenti = studenteDAO.findAllStudenti();
		if(studenti.size() != 0) {
			return studenti;
		} else {
			throw new StudenteEmptyListException("errore: non ci sono studenti nel database!");
		}
	}

	@Override
	public Studente getStudenteById(String sId) throws StudenteException {
		// TODO Auto-generated method stub
		Studente findById = studenteDAO.findStudenteById(sId);
		if(findById != null) {
			return findById;
		} else {
			throw new StudenteNotFoundException("errore: lo studente con id: " + sId + " non è presente nel database!");
		}
	}

	@Override
	public void deleteStudente(String id) throws StudenteException {
		// TODO Auto-generated method stub
		studenteDAO.deleteStudente(id);
	}
	
	//AND
	@Override
	public List<Studente> getStudentiWith(StudenteSearchParam param) throws StudenteException {
		// TODO Auto-generated method stub
		return studenteDAO.findStudentiWith(param);
	}

	//OR
	@Override
	public List<Studente> getStudentiWith(String sottoStringa) throws StudenteException {
		// TODO Auto-generated method stub
		return studenteDAO.findStudentiWith(sottoStringa);
	}

	@Override
	public List<Studente> getAllStudentiPagination() {
		// TODO Auto-generated method stub
		return null;
	}

}
