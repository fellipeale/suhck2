package br.ufpr.ees.suhck2.persistence;

import br.ufpr.ees.suhck2.domain.Situacao;

public interface SituacaoDAO extends DAOBase<Situacao> {

	Situacao findByValor(String valor);
	
}
