package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.Agendamento;
import br.ufpr.ees.suhck2.domain.Situacao;
import br.ufpr.ees.suhck2.persistence.AgendamentoDAO;

@Repository
@Transactional
public class AgendamentoHibernate implements AgendamentoDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void create(Agendamento object) {
		this.session.getCurrentSession().save(object);
	}

	@Override
	public Agendamento read(Integer id) {
		return (Agendamento) this.session.getCurrentSession().get(Agendamento.class, id);
	}

	@Override
	public void update(Agendamento object) {
		this.session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Integer id) {
		this.session.getCurrentSession()
			.createQuery("delete from Agendamento where id=:id")
			.setInteger("id", id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agendamento> list() {
		return this.session.getCurrentSession().createCriteria(Agendamento.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agendamento> listBySituacao(Situacao situacao) {
		Criteria crit =  this.session.getCurrentSession().createCriteria(Agendamento.class)
				.add(Restrictions.eq("situacao", situacao));
				
		return crit.list();
	}

}
