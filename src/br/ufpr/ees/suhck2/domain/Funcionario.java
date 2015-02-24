package br.ufpr.ees.suhck2.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public abstract class Funcionario extends Pessoa {

	private static final long serialVersionUID = 8509994108336730800L;

	@ManyToOne
	@JoinColumn(name = "cargoId")
	private Cargo cargo;
	@NotNull(message="O campo Usuário deve ser preenchido.")
	@Pattern(regexp="\\w{5,20}", message="O campo Usuário deve conter de 5 a 20 caracteres.")
	private String usuario;
	@NotNull(message="O campo Senha deve ser preenchido.")
	@Pattern(regexp="(?=.*\\d).{5,20}", message="O campo Senha deve conter de 5 a 20 caracteres.")
	private transient String senha;
	@NotNull(message="O campo Hash deve ser preenchido.")
	private String hashSenha;
//	@NotNull(message="O campo Permissão deve ser preenchido.")
	@ManyToOne
	@JoinColumn(name = "permissaoId")
	private Permissao permissao;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		setHashSenha(org.apache.commons.codec.digest.DigestUtils.sha256Hex(senha));
		this.senha = senha;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getHashSenha() {
		return hashSenha;
	}

	public void setHashSenha(String hashSenha) {
		this.hashSenha = hashSenha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result
				+ ((hashSenha == null) ? 0 : hashSenha.hashCode());
		result = prime * result
				+ ((permissao == null) ? 0 : permissao.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (hashSenha == null) {
			if (other.hashSenha != null)
				return false;
		} else if (!hashSenha.equals(other.hashSenha))
			return false;
		if (permissao == null) {
			if (other.permissao != null)
				return false;
		} else if (!permissao.equals(other.permissao))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
