package br.ufpr.ees.suhck2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.ees.suhck2.domain.Paciente;
import br.ufpr.ees.suhck2.persistence.PacienteDAO;
import br.ufpr.ees.suhck2.service.PacienteService;

@Service
public class DefaultPacienteService implements PacienteService {

	@Autowired
	private PacienteDAO pacienteDAO;
	
	@Override
	public void save(Paciente object) {
		object.setAtivo(true);
		pacienteDAO.create(object);
	}

	@Override
	public Paciente read(int id) {
		return pacienteDAO.read(id);
	}

	@Override
	public void edit(Paciente object) {
		pacienteDAO.update(object);
	}

	@Override
	public void delete(Integer id) {
		pacienteDAO.delete(id);
	}

	@Override
	public List<Paciente> listAll() {
		return pacienteDAO.list();
	}

}
