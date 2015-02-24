package br.ufpr.ees.suhck2.service;

import br.ufpr.ees.suhck2.domain.Estado;

public interface EstadoService extends ServiceBase<Estado> {

	Estado findByValor(String valor);
	
}
