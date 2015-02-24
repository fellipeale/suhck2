package br.ufpr.ees.suhck2.persistence;

import java.util.List;

import br.ufpr.ees.suhck2.domain.Funcionario;
import br.ufpr.ees.suhck2.domain.Permissao;

public interface PermissaoDAO extends DAOBase<Permissao> {

	Permissao findByValor(String valor);
	
	List<Permissao> listPermissoesByFuncionario(Funcionario funcionario);
	
}
