package br.ufpr.ees.suhck2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.ees.suhck2.domain.Especialidade;
import br.ufpr.ees.suhck2.persistence.EspecialidadeDAO;
import br.ufpr.ees.suhck2.service.EspecialidadeService;

@Service
public class DefaultEspecialidadeService implements EspecialidadeService {

	@Autowired
	private EspecialidadeDAO especialidadeDAO;

	@Override
	public void save(Especialidade medico) {
		especialidadeDAO.create(medico);
	}

	@Override
	public Especialidade read(int id) {
		return especialidadeDAO.read(id);
	}

	@Override
	public void edit(Especialidade medico) {
		especialidadeDAO.update(medico);
	}

	@Override
	public void delete(Integer id) {
		especialidadeDAO.delete(id);
	}

	@Override
	public List<Especialidade> listAll() {
		return especialidadeDAO.list();
	}
	

}
