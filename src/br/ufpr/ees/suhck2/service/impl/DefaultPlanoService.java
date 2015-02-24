package br.ufpr.ees.suhck2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.ees.suhck2.domain.PlanoSaude;
import br.ufpr.ees.suhck2.persistence.PlanoSaudeDAO;
import br.ufpr.ees.suhck2.service.PlanoService;

@Service
public class DefaultPlanoService implements PlanoService {

	@Autowired
	private PlanoSaudeDAO planoDAO;
	
	@Override
	public void save(PlanoSaude medico) {
		planoDAO.create(medico);
	}

	@Override
	public PlanoSaude read(int id) {
		return planoDAO.read(id);
	}

	@Override
	public void edit(PlanoSaude medico) {
		planoDAO.update(medico);
	}

	@Override
	public void delete(Integer id) {
		planoDAO.delete(id);
	}

	@Override
	public List<PlanoSaude> listAll() {
		return planoDAO.list();
	}

}
