package br.ufpr.ees.suhck2.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.ees.suhck2.domain.Agendamento;
import br.ufpr.ees.suhck2.domain.Situacao;
import br.ufpr.ees.suhck2.persistence.AgendamentoDAO;
import br.ufpr.ees.suhck2.persistence.SituacaoDAO;
import br.ufpr.ees.suhck2.service.AgendamentoService;

@Service
public class DefaultAgendamentoService implements AgendamentoService {

	@Autowired
	private AgendamentoDAO agendamentoDAO;
	
	@Autowired
	private SituacaoDAO situacaoDAO;
	
	@Override
	public void save(Agendamento object) {
		object.setDataHora(LocalDateTime.now());
		object.setSituacao(situacaoDAO.findByValor("Em Espera"));
		object.setMedico(null);
		object.setUltimaAtualizacao(LocalDateTime.now());
		agendamentoDAO.create(object);
	}

	@Override
	public Agendamento read(int id) {
		return agendamentoDAO.read(id);
	}

	@Override
	public void edit(Agendamento object) {
		if (object.getMedico().getId() == null) {
			object.setMedico(null);
		}
		object.setUltimaAtualizacao(LocalDateTime.now());
		agendamentoDAO.update(object);
	}

	@Override
	public void delete(Integer id) {
		agendamentoDAO.delete(id);
	}

	@Override
	public List<Agendamento> listAll() {
		return agendamentoDAO.list();
	}
	
	@Override
	public Agendamento getProximoAgendamento() {
		return this.listByPrioridadeAndSituacao(situacaoDAO.findByValor("Em Espera")).get(0);
	}

	@Override
	public List<Agendamento> listAllByPrioridade() {
		List<Agendamento> agendamentos = agendamentoDAO.list();
		
		return this.sortByPrioridade(agendamentos);
	}

	@Override
	public List<Agendamento> listByPrioridadeAndSituacao(Situacao situacao) {
		List<Agendamento> agendamentos = agendamentoDAO.listBySituacao(situacao);
				
		return this.sortByPrioridade(agendamentos);
	}
	
	private List<Agendamento> sortByPrioridade(List<Agendamento> agendamentos) {
		Collections.sort(agendamentos, new Comparator<Agendamento>() {
			@Override
			public int compare(Agendamento o1, Agendamento o2) {
				return o1.compareTo(o2);
			}
		});
		
		return agendamentos;
	}

	@Override
	public Agendamento getProximoAtendimento() {
		List<Agendamento> agendamentos = agendamentoDAO.listBySituacao(situacaoDAO.findByValor("Em Atendimento"));
		return agendamentos.stream()
				.max((a1, a2) -> a1.getUltimaAtualizacao().compareTo(a2.getUltimaAtualizacao()))
				.get();
	}

}
