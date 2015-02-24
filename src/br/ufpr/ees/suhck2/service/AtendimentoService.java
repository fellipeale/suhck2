package br.ufpr.ees.suhck2.service;

import java.util.List;

import br.ufpr.ees.suhck2.domain.Atendimento;
import br.ufpr.ees.suhck2.domain.Paciente;

public interface AtendimentoService extends ServiceBase<Atendimento> {
	
	List<Atendimento> listByPaciente(Paciente paciente);
	
}
