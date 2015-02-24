<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Gerenciar Agendamentos</h1>
	</div>

</div>
<div class="row">
	<div class="col-lg-12">
		<sf:form role="form" modelAttribute="agendamento" method="post"
			action="gerenciar">
			<div class="col-md-12">
				<sf:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div" />
			</div>
			<div class="col-lg-12">
				<div class="form-group">
					<label>Paciente</label>
					<sf:select path="paciente" class="form-control">
						<sf:option label="-- Selecione --" value=""></sf:option>
						<sf:options items="${pacientes}" itemLabel="nome" itemValue="id" />
					</sf:select>
					<sf:input type="hidden" path="id" />
				</div>
			</div>
			<div class="col-lg-12">
				<div class="form-group">
					<label>Anamnese</label>
					<sf:textarea path="anamnese" class="form-control" rows="3"/>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="form-group">
					<label>Estado</label>
					<sf:select path="estado" class="form-control">
						<sf:option label="-- Selecione --" value=""></sf:option>
						<sf:options items="${estados}" itemLabel="descricao" itemValue="id" />
					</sf:select>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="form-group">
					<label>Situação</label>
					<sf:input path="situacao.descricao" class="form-control" readOnly="true" />
					<sf:hidden path="situacao.id" />
				</div>
			</div>
			<div class="col-lg-4">
				<div class="form-group">
					<label>Médico Responsável</label> 
					<sf:input path="medico.nome" class="form-control" readOnly="true" />
					<sf:hidden path="medico.id" />
				</div>
			</div>
			<div class="col-lg-2">
				<div class="form-group">
					<label>Horário</label>
					<sf:input path="dataHora" class="form-control" readOnly="true" />
				</div>
			</div>
			<div class="col-lg-4">
				<div class="form-group">
					<label>Atendente</label>
					<sf:input path="atendente.nome" class="form-control" readOnly="true" />
					<sf:hidden path="atendente.id" />
				</div>
			</div>

			<div class="col-lg-12">
				<button type="submit" class="btn btn-default">Salvar</button>
				<button type="reset" class="btn btn-default">Limpar</button>
			</div>
		</sf:form>
	</div>
</div>