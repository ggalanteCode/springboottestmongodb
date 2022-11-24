package com.soprasteria.springboottestmongodb.dto;

import java.util.List;

import com.soprasteria.springboottestmongodb.model.Studente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentePageInformation {
	
	//QUESTO E' L'OGGETTO CHE RESTITUIAMO COME RISULTATO DI UNA SEARCH
	//CON PAGINAZIONE
	
	private List<Studente> studentiInThePage;
	private Integer numeroPagina;
	private Integer numeroPagine;
	private Long numTotElem;

}
