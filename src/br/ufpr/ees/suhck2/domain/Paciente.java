package br.ufpr.ees.suhck2.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Paciente extends Pessoa {

	private static final long serialVersionUID = 8367689103326923843L;

	@NotNull(message = "O campo Plano de Saúde deve ser preenchido.")
	@ManyToOne
	@JoinColumn(name = "planoSaudeId")
	private PlanoSaude planoSaude;
	@NotNull(message = "O campo Tipo Plano de Saúde deve ser preenchido.")
	@ManyToOne
	@JoinColumn(name = "tipoPlanoSaudeId")
	private TipoPlanoSaude tipoPlanoSaude;
	@NotNull(message = "O Número do Plano de Saúde deve ser preenchido.")
	private Integer numeroPlano;

	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}

	public TipoPlanoSaude getTipoPlanoSaude() {
		return tipoPlanoSaude;
	}

	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}

	public void setTipoPlanoSaude(TipoPlanoSaude tipoPlanoSaude) {
		this.tipoPlanoSaude = tipoPlanoSaude;
	}

	public Integer getNumeroPlano() {
		return numeroPlano;
	}

	public void setNumeroPlano(Integer numeroPlano) {
		this.numeroPlano = numeroPlano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((numeroPlano == null) ? 0 : numeroPlano.hashCode());
		result = prime * result
				+ ((planoSaude == null) ? 0 : planoSaude.hashCode());
		result = prime * result
				+ ((tipoPlanoSaude == null) ? 0 : tipoPlanoSaude.hashCode());
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
		Paciente other = (Paciente) obj;
		if (numeroPlano == null) {
			if (other.numeroPlano != null)
				return false;
		} else if (!numeroPlano.equals(other.numeroPlano))
			return false;
		if (planoSaude == null) {
			if (other.planoSaude != null)
				return false;
		} else if (!planoSaude.equals(other.planoSaude))
			return false;
		if (tipoPlanoSaude == null) {
			if (other.tipoPlanoSaude != null)
				return false;
		} else if (!tipoPlanoSaude.equals(other.tipoPlanoSaude))
			return false;
		return true;
	}

}
