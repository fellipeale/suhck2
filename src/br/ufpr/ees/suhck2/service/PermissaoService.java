package br.ufpr.ees.suhck2.service;

import br.ufpr.ees.suhck2.domain.Permissao;

public interface PermissaoService extends ServiceBase<Permissao> {

	Permissao findByValor(String valor);
	
}
