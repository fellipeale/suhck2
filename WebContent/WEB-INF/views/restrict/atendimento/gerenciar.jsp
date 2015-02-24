<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Novo Atendimento</h1>
	</div>

</div>
<div class="row">
	<div class="col-lg-12">
		<sf:form role="form" modelAttribute="atendimento" method="post"
			action="gerenciar">
			<div class="col-md-12">
				<sf:errors path="*" cssClass="alert alert-danger alert-dismissable"
					element="div" />
			</div>
			<div role="tabpanel">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active">
						<a href="#paciente" aria-controls="paciente" role="tab" data-toggle="tab">Dados do Paciente</a></li>
					<li role="presentation">
						<a href="#consultas" aria-controls="consultas" role="tab" data-toggle="tab">Consultas Anteriores</a>
					</li>
					<li role="presentation">
						<a href="#diagnostico" aria-controls="diagnostico" role="tab" data-toggle="tab">Diagnóstico</a>
					</li>
					<li role="presentation">
						<a href="#receita" aria-controls="receita" role="tab" data-toggle="tab">Receita</a>
					</li>
				</ul>
				
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="paciente">
						<div class="col-lg-8">
							<div class="form-group">
								<label>Paciente</label> 
								<input class="form-control" value="${agendamento.paciente.nome}" readonly="readonly">
							</div>
						</div>
						<div class="col-lg-4">
							<div class="form-group">
								<label>Estado</label> 
								<input class="form-control" value="${agendamento.estado.descricao}" readonly="readonly">
							</div>
						</div>
						<div class="col-lg-12">
							<div class="form-group">
								<label>Anamnese</label>
								<textarea class="form-control" rows="3" readonly="readonly">${agendamento.anamnese}</textarea>
							</div>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="consultas">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Data</th>
										<th>Diagnóstico</th>
										<th>Médico</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${atendimentos}" var="atendimento">
										<tr class="gradeA">
											<td>${atendimento.dataHora}</td>
											<td>${atendimento.diagnostico}</td>
											<td>${atendimento.medico.nome}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="diagnostico">
						<div class="col-lg-12">
							<div class="form-group">
								<label>Diagnóstico</label>
								<sf:textarea path="diagnostico" class="form-control" rows="16"/>
								<sf:hidden path="medico.id"/>
								<sf:hidden path="paciente.id"/>
							</div>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="receita">
						<div class="col-lg-12">
							<div class="form-group">
								<label>Receita</label>
								<sf:textarea path="receita" class="form-control" rows="16"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-12">
				<button type="submit" class="btn btn-default">
					Concluir Atendimento
				</button>
				<a style="text-indent: 0" class="btn btn-default" href="<c:url value='cancelar'/>">
					Cancelar Atendimento
				</a>
			</div>
		</sf:form>
	</div>
</div>