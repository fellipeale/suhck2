package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.Situacao;
import br.ufpr.ees.suhck2.persistence.SituacaoDAO;

@Repository
@Transactional
public class SituacaoHibernate implements SituacaoDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void create(Situacao object) {
		this.session.getCurrentSession().save(object);
	}

	@Override
	public Situacao read(Integer id) {
		return (Situacao) this.session.getCurrentSession().get(Situacao.class, id);
	}

	@Override
	public void update(Situacao object) {
		this.session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Integer id) {
		this.session.getCurrentSession()
			.createQuery("delete from Situacao where id=:id")
			.setInteger("id", id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Situacao> list() {
		return this.session.getCurrentSession().createCriteria(Situacao.class).list();
	}
	
	@Override
	public Situacao findByValor(String valor) {
		Criteria crit = this.session.getCurrentSession().createCriteria(Situacao.class)
				.add(Restrictions.eq("descricao", valor));
		return (Situacao) crit.uniqueResult();
	}

}
