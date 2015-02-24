package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.Especialidade;
import br.ufpr.ees.suhck2.persistence.EspecialidadeDAO;

@Repository
@Transactional
public class EspecialidadeHibernate implements EspecialidadeDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void create(Especialidade object) {
		this.session.getCurrentSession().save(object);
	}

	@Override
	public Especialidade read(Integer id) {
		return (Especialidade) this.session.getCurrentSession().get(Especialidade.class, id);
	}

	@Override
	public void update(Especialidade object) {
		this.session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Integer id) {
		this.session.getCurrentSession()
			.createQuery("delete from Especialidade where id=:id")
			.setInteger("id", id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidade> list() {
		return this.session.getCurrentSession().createCriteria(Especialidade.class).list();
	}

}
