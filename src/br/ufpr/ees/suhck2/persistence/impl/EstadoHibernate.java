package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.Estado;
import br.ufpr.ees.suhck2.persistence.EstadoDAO;

@Repository
@Transactional
public class EstadoHibernate implements EstadoDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void create(Estado object) {
		this.session.getCurrentSession().save(object);
	}

	@Override
	public Estado read(Integer id) {
		return (Estado) this.session.getCurrentSession().get(Estado.class, id);
	}

	@Override
	public void update(Estado object) {
		this.session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Integer id) {
		this.session.getCurrentSession()
			.createQuery("delete from Estado where id=:id")
			.setInteger("id", id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> list() {
		return this.session.getCurrentSession().createCriteria(Estado.class).list();
	}
	
	@Override
	public Estado findByValor(String valor) {
		Criteria crit = this.session.getCurrentSession().createCriteria(Estado.class)
				.add(Restrictions.eq("descricao", valor));
		return (Estado) crit.uniqueResult();
	}

}
