package com.soprasteria.springboottestmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentePaginationSearchParam {

	// FILTRI AND
	private String nome;
	private String cognome;
	private String corso;

	// NUMERO ELEMENTI PER PAGINA
	private Integer numElemPerPagina;

	// NUMERO DELLA PAGINA
	private Integer numeroPagina;

}
