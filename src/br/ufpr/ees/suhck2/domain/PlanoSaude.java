package br.ufpr.ees.suhck2.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class PlanoSaude extends AbstractEntity {

	private static final long serialVersionUID = 6490193162279727249L;

	@NotNull(message = "O campo Nome deve ser preenchido.")
	@Size(min = 2, max = 150, message = "O campo Nome deve conter de 2 a 150 caracteres.")
	private String nome;
	@NotNull(message = "O campo CNPJ deve ser preenchido.")
	@CNPJ(message = "CNPJ inválido.")
	private String cnpj;
	@NotNull(message = "O campo Endereço deve ser preenchido.")
	private String endereco;
	@Size(min = 2, max = 150, message = "O campo Contato deve conter de 2 a 150 caracteres.")
	private String contato;
	@Pattern(regexp = "^\\(\\d{2}\\)\\d{4}-\\d{4}$", message = "Telefone inválido.")
	private String telefone;
	@Email(message = "Email inválido.")
	private String email;
	@OneToMany(mappedBy = "planoSaude")
	private List<Paciente> pacientes = new ArrayList<Paciente>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((pacientes == null) ? 0 : pacientes.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
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
		PlanoSaude other = (PlanoSaude) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pacientes == null) {
			if (other.pacientes != null)
				return false;
		} else if (!pacientes.equals(other.pacientes))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

}
