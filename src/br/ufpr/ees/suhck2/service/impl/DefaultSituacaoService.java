package br.ufpr.ees.suhck2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.ees.suhck2.domain.Situacao;
import br.ufpr.ees.suhck2.persistence.SituacaoDAO;
import br.ufpr.ees.suhck2.service.SituacaoService;

@Service
public class DefaultSituacaoService implements SituacaoService {

	@Autowired
	private SituacaoDAO situacaoDAO;
	
	@Override
	public void save(Situacao object) {
		situacaoDAO.create(object);
	}

	@Override
	public Situacao read(int id) {
		return situacaoDAO.read(id);
	}

	@Override
	public void edit(Situacao object) {
		situacaoDAO.update(object);;
	}

	@Override
	public void delete(Integer id) {
		situacaoDAO.delete(id);
	}

	@Override
	public List<Situacao> listAll() {
		return situacaoDAO.list();
	}

	@Override
	public Situacao findByValor(String valor) {
		return situacaoDAO.findByValor(valor);
	}

}
