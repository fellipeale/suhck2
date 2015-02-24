package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.Atendente;
import br.ufpr.ees.suhck2.persistence.AtendenteDAO;

@Repository
@Transactional
public class AtendenteHibernate implements AtendenteDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void create(Atendente object) {
		this.session.getCurrentSession().save(object);
	}

	@Override
	public Atendente read(Integer id) {
		return (Atendente) this.session.getCurrentSession().get(Atendente.class, id);
	}

	@Override
	public void update(Atendente object) {
		this.session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Integer id) {
		this.session.getCurrentSession()
			.createQuery("delete from Atendente where id=:id")
			.setInteger("id", id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atendente> list() {
		return this.session.getCurrentSession().createCriteria(Atendente.class).list();
	}

}
