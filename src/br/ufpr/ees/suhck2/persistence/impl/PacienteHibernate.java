package br.ufpr.ees.suhck2.persistence.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.ees.suhck2.domain.Paciente;
import br.ufpr.ees.suhck2.persistence.PacienteDAO;

@Repository
@Transactional
public class PacienteHibernate implements PacienteDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void create(Paciente object) {
		this.session.getCurrentSession().save(object);
	}

	@Override
	public Paciente read(Integer id) {
		return (Paciente) this.session.getCurrentSession().get(Paciente.class, id);
	}

	@Override
	public void update(Paciente object) {
		this.session.getCurrentSession().update(object);
	}

	@Override
	public void delete(Integer id) {
		this.session.getCurrentSession()
			.createQuery("update Paciente set ativo=0 where id=:id")
			.setInteger("id", id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> list() {
		return this.session.getCurrentSession().createCriteria(Paciente.class).list();
	}

}
