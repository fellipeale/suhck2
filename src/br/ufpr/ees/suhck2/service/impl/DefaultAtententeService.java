package br.ufpr.ees.suhck2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.ees.suhck2.domain.Atendente;
import br.ufpr.ees.suhck2.persistence.AtendenteDAO;
import br.ufpr.ees.suhck2.persistence.CargoDAO;
import br.ufpr.ees.suhck2.persistence.PermissaoDAO;
import br.ufpr.ees.suhck2.service.AtendenteService;

@Service
public class DefaultAtententeService implements AtendenteService {

	@Autowired
	private AtendenteDAO atendenteDAO;
	
	@Autowired
	private CargoDAO cargoDao;
	
	@Autowired
	private PermissaoDAO permissaoDao;
	
	@Override
	public void save(Atendente object) {
		object.setAtivo(true);
		object.setPermissao(permissaoDao.findByValor("ROLE_ATENDENTE"));
		object.setCargo(cargoDao.findByDescricao("Atendente"));
		atendenteDAO.create(object);
	}

	@Override
	public Atendente read(int id) {
		return atendenteDAO.read(id);
	}

	@Override
	public void edit(Atendente object) {
		atendenteDAO.update(object);
	}

	@Override
	public void delete(Integer id) {
		atendenteDAO.delete(id);
	}

	@Override
	public List<Atendente> listAll() {
		return atendenteDAO.list();
	}

}
