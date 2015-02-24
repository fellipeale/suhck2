package br.ufpr.ees.suhck2.persistence;

import br.ufpr.ees.suhck2.domain.Funcionario;

public interface FuncionarioDAO extends DAOBase<Funcionario> {

	Funcionario getUsuario(String usuario, String senha);
	
}
