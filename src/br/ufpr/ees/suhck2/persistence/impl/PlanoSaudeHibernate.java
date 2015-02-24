package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.PlanoSaude;
import br.ufpr.ees.suhck2.persistence.PlanoSaudeDAO;

@Repository
@Transactional
public class PlanoSaudeHibernate implements PlanoSaudeDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void create(PlanoSaude object) {
		this.session.getCurrentSession().save(object);
	}

	@Override
	public PlanoSaude read(Integer id) {
		return (PlanoSaude) this.session.getCurrentSession().get(PlanoSaude.class, id);
	}

	@Override
	public void update(PlanoSaude object) {
		this.session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Integer id) {
		this.session.getCurrentSession()
			.createQuery("delete from PlanoSaude where id=:id")
			.setInteger("id", id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanoSaude> list() {
		return this.session.getCurrentSession().createCriteria(PlanoSaude.class).list();
	}

}
