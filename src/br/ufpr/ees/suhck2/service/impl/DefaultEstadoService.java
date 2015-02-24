package br.ufpr.ees.suhck2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.ees.suhck2.domain.Estado;
import br.ufpr.ees.suhck2.persistence.EstadoDAO;
import br.ufpr.ees.suhck2.service.EstadoService;

@Service
public class DefaultEstadoService implements EstadoService {

	@Autowired
	private EstadoDAO estadoDAO;
	
	@Override
	public void save(Estado object) {
		estadoDAO.create(object);
	}

	@Override
	public Estado read(int id) {
		return estadoDAO.read(id);
	}

	@Override
	public void edit(Estado object) {
		estadoDAO.update(object);
	}

	@Override
	public void delete(Integer id) {
		estadoDAO.delete(id);
	}

	@Override
	public List<Estado> listAll() {
		return estadoDAO.list();
	}

	@Override
	public Estado findByValor(String valor) {
		return estadoDAO.findByValor(valor);
	}

}
