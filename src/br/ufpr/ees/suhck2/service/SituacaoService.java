package br.ufpr.ees.suhck2.service;

import br.ufpr.ees.suhck2.domain.Situacao;

public interface SituacaoService extends ServiceBase<Situacao> {

	Situacao findByValor(String valor);
	
}
