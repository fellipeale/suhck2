package br.ufpr.ees.suhck2.domain;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.ufpr.ees.suhck2.util.LocalDateTimePersistenceConverter;

@Entity
public class Agendamento extends AbstractEntity implements Comparable<Agendamento>{

	private static final long serialVersionUID = -2635804782010869376L;

	@NotNull(message = "O campo Anamnese deve ser preenchido.")
	@NotEmpty(message = "O campo Anamnese deve ser preenchido.")
	@Size(min = 5, max = 250, message = "O campo Anamnese deve conter entre 5 e 250 caracteres.")
	private String anamnese;
	@NotNull(message = "O campo Hora deve ser preenchido.")
//	@Past(message = "O campo Hora deve conter uma data passada.")
//	@Temporal(TemporalType.TIMESTAMP)
	@Convert(converter = LocalDateTimePersistenceConverter.class)
	private LocalDateTime dataHora;
	@NotNull(message = "O campo Estado deve ser preenchido.")
	@ManyToOne
	@JoinColumn(name = "estadoId")
	private Estado estado;
	@NotNull(message = "O campo situação deve ser preenchido.")
	@ManyToOne
	@JoinColumn(name = "situacaoId")
	private Situacao situacao;
	@NotNull(message = "O campo Paciente deve ser preenchido.")
	@ManyToOne
	@JoinColumn(name = "pacienteId")
	private Paciente paciente;
	@NotNull(message = "O campo Atendente deve ser preenchido.")
	@ManyToOne
	@JoinColumn(name = "atendenteId")
	private Atendente atendente;
	@ManyToOne
	@JoinColumn(name = "medicoId", nullable = true)
	private Medico medico;
	@Convert(converter = LocalDateTimePersistenceConverter.class)
	private LocalDateTime ultimaAtualizacao;
	
	public String getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(String anamnese) {
		this.anamnese = anamnese;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public LocalDateTime getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	public Duration getTempoEspera() {
		return Duration.between(this.getDataHora(), LocalDateTime.now());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((anamnese == null) ? 0 : anamnese.hashCode());
		result = prime * result
				+ ((atendente == null) ? 0 : atendente.hashCode());
		result = prime * result
				+ ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		result = prime * result
				+ ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result
				+ ((situacao == null) ? 0 : situacao.hashCode());
		result = prime
				* result
				+ ((ultimaAtualizacao == null) ? 0 : ultimaAtualizacao
						.hashCode());
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
		Agendamento other = (Agendamento) obj;
		if (anamnese == null) {
			if (other.anamnese != null)
				return false;
		} else if (!anamnese.equals(other.anamnese))
			return false;
		if (atendente == null) {
			if (other.atendente != null)
				return false;
		} else if (!atendente.equals(other.atendente))
			return false;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
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
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		if (ultimaAtualizacao == null) {
			if (other.ultimaAtualizacao != null)
				return false;
		} else if (!ultimaAtualizacao.equals(other.ultimaAtualizacao))
			return false;
		return true;
	}

	@Override
	public int compareTo(Agendamento o) {
		if (this.getEstado().getId() > o.getEstado().getId()) {
			return -1;
		} else if (this.getEstado().getId() < o.getEstado().getId()) {
			return 1;
		} else if (this.getEstado().getId() == o.getEstado().getId()) {
			return this.getDataHora().compareTo(o.getDataHora());
		} else {
			return 0;
		}
	}

}
