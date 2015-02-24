package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.TipoPlanoSaude;
import br.ufpr.ees.suhck2.persistence.TipoPlanoSaudeDAO;

@Repository
@Transactional
public class TipoPlanoSaudeHibernate implements TipoPlanoSaudeDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void create(TipoPlanoSaude object) {
		// TODO Auto-generated method stub

	}

	@Override
	public TipoPlanoSaude read(Integer id) {
		return (TipoPlanoSaude) this.session.getCurrentSession().get(TipoPlanoSaude.class, id);
	}

	@Override
	public void update(TipoPlanoSaude object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPlanoSaude> list() {
		return this.session.getCurrentSession().createCriteria(TipoPlanoSaude.class).list();
	}

}
