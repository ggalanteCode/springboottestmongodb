package com.soprasteria.springboottestmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudenteSearchParam {
	
	//TRE FILTRI
	private String nome;
	private String cognome;
	private String corso;

}
