package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.Medico;
import br.ufpr.ees.suhck2.persistence.MedicoDAO;

@Repository
@Transactional
public class MedicoHibernate implements MedicoDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void create(Medico object) {
		this.session.getCurrentSession().save(object);
	}

	@Override
	public Medico read(Integer id) {
		return (Medico) this.session.getCurrentSession().get(Medico.class, id);
	}

	@Override
	public void update(Medico object) {
		this.session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Integer id) {
		this.session.getCurrentSession()
			.createQuery("update Medico set ativo=0 where id=:id")
			.setInteger("id", id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> list() {
		return this.session.getCurrentSession().createCriteria(Medico.class).list();
	}

}
