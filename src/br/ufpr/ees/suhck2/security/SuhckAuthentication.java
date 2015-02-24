package br.ufpr.ees.suhck2.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import br.ufpr.ees.suhck2.domain.Funcionario;
import br.ufpr.ees.suhck2.domain.Permissao;

public class SuhckAuthentication implements Authentication {

	private static final long serialVersionUID = 2782561396717631399L;
	
	private Funcionario funcionario;
	private Permissao permissao;
	private boolean autenticado;
	
	public SuhckAuthentication(Funcionario funcionario, Permissao permissao) {
		this.funcionario = funcionario;
		this.permissao = permissao; 
	}

	@Override
	public String getName() {
		return funcionario != null ? funcionario.getUsuario() : null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Permissao> permissoes = new ArrayList<Permissao>();
		permissoes.add(permissao);
		return permissoes;
	}

	@Override
	public Object getCredentials() {
		return funcionario != null ? funcionario.getHashSenha() : null;
	}

	@Override
	public Object getDetails() {
		return funcionario;
	}

	@Override
	public Object getPrincipal() {
		return funcionario != null ? funcionario.getUsuario() : null;
	}

	@Override
	public boolean isAuthenticated() {
		return autenticado;
	}

	@Override
	public void setAuthenticated(boolean arg0) throws IllegalArgumentException {
		this.autenticado = arg0;
	}
		
}
