package br.ufpr.ees.suhck2.persistence;

import br.ufpr.ees.suhck2.domain.Estado;

public interface EstadoDAO extends DAOBase<Estado> {

	Estado findByValor(String valor);
	
}
