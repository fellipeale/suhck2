package br.ufpr.ees.suhck2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.ees.suhck2.domain.TipoPlanoSaude;
import br.ufpr.ees.suhck2.persistence.TipoPlanoSaudeDAO;
import br.ufpr.ees.suhck2.service.TipoPlanoSaudeService;

@Service
public class DefaultTipoPlanoSaude implements TipoPlanoSaudeService {

	@Autowired
	private TipoPlanoSaudeDAO tipoPlanoDAO;
	
	@Override
	public void save(TipoPlanoSaude object) {
		// TODO Auto-generated method stub

	}

	@Override
	public TipoPlanoSaude read(int id) {
		return tipoPlanoDAO.read(id);
	}

	@Override
	public void edit(TipoPlanoSaude object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TipoPlanoSaude> listAll() {
		return tipoPlanoDAO.list();
	}

}
