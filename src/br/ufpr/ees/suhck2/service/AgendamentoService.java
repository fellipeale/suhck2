package br.ufpr.ees.suhck2.service;

import java.util.List;

import br.ufpr.ees.suhck2.domain.Agendamento;
import br.ufpr.ees.suhck2.domain.Situacao;

public interface AgendamentoService extends ServiceBase<Agendamento> {

	Agendamento getProximoAgendamento();
	
	Agendamento getProximoAtendimento();
	
	List<Agendamento> listAllByPrioridade();
	
	List<Agendamento> listByPrioridadeAndSituacao(Situacao situacao);
	
}
