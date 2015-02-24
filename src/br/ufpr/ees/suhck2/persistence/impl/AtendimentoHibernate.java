package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.Atendimento;
import br.ufpr.ees.suhck2.domain.Paciente;
import br.ufpr.ees.suhck2.persistence.AtendimentoDAO;

@Repository
@Transactional
public class AtendimentoHibernate implements AtendimentoDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void create(Atendimento object) {
		this.session.getCurrentSession().save(object);
	}

	@Override
	public Atendimento read(Integer id) {
		return (Atendimento) this.session.getCurrentSession().get(Atendimento.class, id);
	}

	@Override
	public void update(Atendimento object) {
		this.session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atendimento> list() {
		return this.session.getCurrentSession().createCriteria(Atendimento.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atendimento> listByPaciente(Paciente paciente) {
		Criteria crit = this.session.getCurrentSession().createCriteria(Atendimento.class)
				.add(Restrictions.eq("paciente", paciente));
		return crit.list();
	}

}
