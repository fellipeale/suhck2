package br.ufpr.ees.suhck2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.ees.suhck2.domain.Permissao;
import br.ufpr.ees.suhck2.persistence.PermissaoDAO;
import br.ufpr.ees.suhck2.service.PermissaoService;

@Service
public class DefaultPermissaoService implements PermissaoService {

	@Autowired
	private PermissaoDAO permissaoDAO;
	
	@Override
	public void save(Permissao medico) {
		permissaoDAO.create(medico);
	}

	@Override
	public Permissao read(int id) {
		return permissaoDAO.read(id);
	}

	@Override
	public void edit(Permissao medico) {
		permissaoDAO.update(medico);
	}

	@Override
	public void delete(Integer id) {
		permissaoDAO.delete(id);;
	}

	@Override
	public List<Permissao> listAll() {
		return permissaoDAO.list();
	}

	@Override
	public Permissao findByValor(String valor) {
		return permissaoDAO.findByValor(valor);
	}

}
