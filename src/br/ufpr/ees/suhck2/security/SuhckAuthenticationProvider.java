package br.ufpr.ees.suhck2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import br.ufpr.ees.suhck2.domain.Funcionario;
import br.ufpr.ees.suhck2.persistence.FuncionarioDAO;
import br.ufpr.ees.suhck2.persistence.PermissaoDAO;

public class SuhckAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private FuncionarioDAO funcionarioDAO;
	
	@Autowired
	private PermissaoDAO permissaoDAO;
	
	@Override
	public Authentication authenticate(Authentication autenticacao)
			throws AuthenticationException {
		
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) autenticacao;
		String usuario = token.getName();
		String senha = token.getCredentials() != null ? token.getCredentials().toString() : null;
		Funcionario funcionario = funcionarioDAO.getUsuario(usuario, senha);
		if (funcionario == null) {
			return null;
		}
		SuhckAuthentication resultado = new SuhckAuthentication(funcionario, funcionario.getPermissao());
		resultado.setAuthenticated(funcionario != null);
		
		return resultado;
	}

	@Override
	public boolean supports(Class<?> autenticacao) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(autenticacao));
	}

}
