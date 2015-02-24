package br.ufpr.ees.suhck2.persistence;

import java.util.List;

import br.ufpr.ees.suhck2.domain.Agendamento;
import br.ufpr.ees.suhck2.domain.Situacao;

public interface AgendamentoDAO extends DAOBase<Agendamento> {

	List<Agendamento> listBySituacao(Situacao situacao);
	
}
