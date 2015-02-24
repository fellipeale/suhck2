package br.ufpr.ees.suhck2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.ees.suhck2.domain.Medico;
import br.ufpr.ees.suhck2.persistence.CargoDAO;
import br.ufpr.ees.suhck2.persistence.MedicoDAO;
import br.ufpr.ees.suhck2.persistence.PermissaoDAO;
import br.ufpr.ees.suhck2.service.MedicoService;

@Service
public class DefaultMedicoService implements MedicoService {

	@Autowired
	private MedicoDAO medicoDao;
	
	@Autowired
	private CargoDAO cargoDao;
	
	@Autowired
	private PermissaoDAO permissaoDao;
		
	@Override
	public void save(Medico medico) {
		medico.setAtivo(true);
		medico.setPermissao(permissaoDao.findByValor("ROLE_MEDICO"));
		medico.setCargo(cargoDao.findByDescricao("Medico"));
		medicoDao.create(medico);
	}

	@Override
	public Medico read(int id) {
		return medicoDao.read(id);
	}
	
	@Override
	public void edit(Medico medico) {
		medicoDao.update(medico);
	}

	@Override
	public void delete(Integer id) {
		medicoDao.delete(id);
	}

	@Override
	public List<Medico> listAll() {
		return medicoDao.list();
	}
	
}
