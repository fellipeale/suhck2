package br.ufpr.ees.suhck2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.ees.suhck2.domain.Atendimento;
import br.ufpr.ees.suhck2.domain.Paciente;
import br.ufpr.ees.suhck2.persistence.AtendimentoDAO;
import br.ufpr.ees.suhck2.service.AtendimentoService;

@Service
public class DefaultAtendimentoService implements AtendimentoService {

	@Autowired
	private AtendimentoDAO atendimentoDAO;
	
	@Override
	public void save(Atendimento object) {
		atendimentoDAO.create(object);
	}

	@Override
	public Atendimento read(int id) {
		return atendimentoDAO.read(id);
	}

	@Override
	public void edit(Atendimento object) {
		atendimentoDAO.update(object);
	}

	@Override
	public void delete(Integer id) {
		atendimentoDAO.delete(id);
	}

	@Override
	public List<Atendimento> listAll() {
		return atendimentoDAO.list();
	}

	@Override
	public List<Atendimento> listByPaciente(Paciente paciente) {
		return atendimentoDAO.listByPaciente(paciente);
	}



}
