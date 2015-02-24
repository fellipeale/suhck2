package br.ufpr.ees.suhck2.domain;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufpr.ees.suhck2.util.LocalDateTimePersistenceConverter;

@Entity
public class Atendimento extends AbstractEntity {

	private static final long serialVersionUID = 5677641320639989282L;

	@NotNull(message = "O campo Paciente deve ser preenchido.")
	@ManyToOne
	@JoinColumn(name = "pacienteId")
	private Paciente paciente;
	@NotNull(message = "O campo Médico deve ser preenchido.")
	@ManyToOne
	@JoinColumn(name = "medicoId")
	private Medico medico;
	@NotNull(message = "O campo Diagnóstico deve ser preenchido.")
	@Size(min = 5, max = 250, message = "O campo Diagnóstico deve conter entre 5 e 250 caracteres.")
	private String diagnostico;
	@NotNull(message = "O campo Receita deve ser preenchido.")
	@Size(min = 5, max = 250, message = "O campo Receita deve conter entre 5 e 250 caracteres.")
	private String receita;
	@Convert(converter = LocalDateTimePersistenceConverter.class)
	private LocalDateTime dataHora;

	public Paciente getPaciente() {
		return paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public String getReceita() {
		return receita;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public void setReceita(String receita) {
		this.receita = receita;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result
				+ ((diagnostico == null) ? 0 : diagnostico.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		result = prime * result
				+ ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result + ((receita == null) ? 0 : receita.hashCode());
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
		Atendimento other = (Atendimento) obj;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (diagnostico == null) {
			if (other.diagnostico != null)
				return false;
		} else if (!diagnostico.equals(other.diagnostico))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (receita == null) {
			if (other.receita != null)
				return false;
		} else if (!receita.equals(other.receita))
			return false;
		return true;
	}

}
