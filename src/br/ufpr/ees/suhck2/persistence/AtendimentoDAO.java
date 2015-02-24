package br.ufpr.ees.suhck2.persistence;

import java.util.List;

import br.ufpr.ees.suhck2.domain.Atendimento;
import br.ufpr.ees.suhck2.domain.Paciente;

public interface AtendimentoDAO extends DAOBase<Atendimento> {

	List<Atendimento> listByPaciente(Paciente paciente);
	
}
