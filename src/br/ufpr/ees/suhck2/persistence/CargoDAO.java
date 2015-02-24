package br.ufpr.ees.suhck2.persistence;

import br.ufpr.ees.suhck2.domain.Cargo;

public interface CargoDAO extends DAOBase<Cargo> {

	Cargo findByDescricao(String descricao);
	
}
