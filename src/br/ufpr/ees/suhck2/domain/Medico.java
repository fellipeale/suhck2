package br.ufpr.ees.suhck2.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Medico extends Funcionario {

	private static final long serialVersionUID = 8940362732669878332L;

	@NotNull(message = "O campo CRM deve ser preenchido.")
	@Pattern(regexp = "[0-9]{5}", message = "O campo CRM deve conter cinco números.")
	private String crm;
	@NotNull(message = "O campo Especialidade deve ser preenchido.")
	@ManyToOne
	@JoinColumn(name = "especialidadeId")
	private Especialidade especialidade;

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((crm == null) ? 0 : crm.hashCode());
		result = prime * result
				+ ((especialidade == null) ? 0 : especialidade.hashCode());
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
		Medico other = (Medico) obj;
		if (crm == null) {
			if (other.crm != null)
				return false;
		} else if (!crm.equals(other.crm))
			return false;
		if (especialidade == null) {
			if (other.especialidade != null)
				return false;
		} else if (!especialidade.equals(other.especialidade))
			return false;
		return true;
	}

}
