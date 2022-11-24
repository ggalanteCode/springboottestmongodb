package com.soprasteria.springboottestmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentePaginationSearchParam3 {

	// PER LA ALL STUDENTI WITH PAGINATION, LA QUALE NON RICHIEDE ALCUN FILTRO

	// NUMERO ELEMENTI PER PAGINA
	private Integer numElemPerPagina;

	// NUMERO DELLA PAGINA
	private Integer numeroPagina;

}
