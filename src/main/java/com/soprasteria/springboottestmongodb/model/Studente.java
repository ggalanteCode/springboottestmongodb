package com.soprasteria.springboottestmongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @Document is an annotation provided by Spring data project. It is used to 
 * identify a domain object, which is persisted to MongoDB. So you can use it 
 * to map a Java class into a collection inside MongoDB.
 */

/*
 * UN DATABASE E' UN INSIEME DI COLLECTION E UNA COLLECTION E' UN INSIEME DI
 * DOCUMENT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
								//@Document E' L'EQUIVALENTE DI @Entity IN JPA
@Document(collection = "studenti")	//USEREMO UNA COLLECTION DI NOME "studenti"
public class Studente {
	
	@Id
	private String id;
	
	private String nome;
	
	private String cognome;
	
	private Integer numeroStudente;
	
	private String email;
	
	private List<String> listaCorsi;
	
	private Double mediaVoti;

}
