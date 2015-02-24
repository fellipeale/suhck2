package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.Cargo;
import br.ufpr.ees.suhck2.persistence.CargoDAO;

@Repository
@Transactional
public class CargoHibernate implements CargoDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void create(Cargo object) {
		this.session.getCurrentSession().save(object);
	}

	@Override
	public Cargo read(Integer id) {
		return (Cargo) this.session.getCurrentSession().get(Cargo.class, id);
	}

	@Override
	public void update(Cargo object) {
		this.session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Integer id) {
		this.session.getCurrentSession()
			.createQuery("delete from Cargo where id=:id")
			.setInteger("id", id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> list() {
		return this.session.getCurrentSession().createCriteria(Cargo.class).list();
	}

	@Override
	public Cargo findByDescricao(String descricao) {
		Criteria crit = this.session.getCurrentSession().createCriteria(Cargo.class);
		crit.add(Restrictions.eq("descricao", descricao));
		return (Cargo) crit.uniqueResult();
	}

}
