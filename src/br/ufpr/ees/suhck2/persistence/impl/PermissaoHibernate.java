package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.Funcionario;
import br.ufpr.ees.suhck2.domain.Permissao;
import br.ufpr.ees.suhck2.persistence.PermissaoDAO;

@Repository
@Transactional
public class PermissaoHibernate implements PermissaoDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void create(Permissao object) {
		this.session.getCurrentSession().save(object);
	}

	@Override
	public Permissao read(Integer id) {
		return (Permissao) this.session.getCurrentSession().get(Permissao.class, id);
	}

	@Override
	public void update(Permissao object) {
		this.session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Integer id) {
		this.session.getCurrentSession()
			.createQuery("delete from Permissao where id=:id")
			.setInteger("id", id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permissao> list() {
		return this.session.getCurrentSession().createCriteria(Permissao.class).list();
	}

	@Override
	public Permissao findByValor(String valor) {
		Criteria crit = this.session.getCurrentSession().createCriteria(Permissao.class)
				.add(Restrictions.eq("valor", valor));
		return (Permissao) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permissao> listPermissoesByFuncionario(Funcionario funcionario) {
		Criteria crit = this.session.getCurrentSession().createCriteria(Permissao.class)
				.add(Restrictions.eq("funcionario", funcionario));
		return crit.list();
	}

}
