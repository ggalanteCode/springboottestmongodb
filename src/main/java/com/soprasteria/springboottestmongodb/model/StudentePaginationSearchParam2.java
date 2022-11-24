package com.soprasteria.springboottestmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentePaginationSearchParam2 {

	// FILTRO OR
	private String sottoStringa;

	// NUMERO ELEMENTI PER PAGINA
	private Integer numElemPerPagina;

	// NUMERO DELLA PAGINA
	private Integer numeroPagina;

}
