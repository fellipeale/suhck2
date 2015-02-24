package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.Funcionario;
import br.ufpr.ees.suhck2.persistence.FuncionarioDAO;

@Repository
@Transactional
public class FuncionarioHibernate implements FuncionarioDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void create(Funcionario object) {
		this.session.getCurrentSession().save(object);
	}

	@Override
	public Funcionario read(Integer id) {
		return (Funcionario) this.session.getCurrentSession().get(Funcionario.class, id);
	}

	@Override
	public void update(Funcionario object) {
		this.session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Integer id) {
		this.session.getCurrentSession()
			.createQuery("delete from Funcionario where id=:id")
			.setInteger("id", id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> list() {
		return this.session.getCurrentSession().createCriteria(Funcionario.class).list();
	}

	@Override
	public Funcionario getUsuario(String usuario, String senha) {
		Criteria crit = session.getCurrentSession().createCriteria(Funcionario.class)
				.add(Restrictions.eq("usuario", usuario))
				.add(Restrictions.eq("hashSenha", DigestUtils.sha256Hex(senha)));
		return (Funcionario) crit.uniqueResult();
	}

}
