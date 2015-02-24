<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Listagem de Agendamentos</h1>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<c:if test="${param.save_success eq 1}">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
					Agendamento salvo com sucesso.
				<a href="#" class="alert-link"></a>
			</div>
		</c:if>
		<c:if test="${param.edit_success eq 1}">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
					Agendamento editado com sucesso.
				<a href="#" class="alert-link"></a>
			</div>
		</c:if>
		<c:if test="${param.remove_success eq 1}">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
					Agendamento removido com sucesso.
				<a href="#" class="alert-link"></a>
			</div>
		</c:if>
	</div>
	<div class="col-lg-3">
		<a style="text-indent: 0" class="btn btn-default" href="<c:url value='agendamento/novo'/>">
			<i class="fa fa-plus"></i> Adicionar
		</a>
	</div>
	<div class="col-lg-3" id="sandbox-container">
		<div class="input-group date">
			<input type="text" class="form-control" />
			<span class="input-group-addon">
				<i class="fa fa-calendar"></i>
			</span>
		</div>
	</div>
	<div class="col-lg-6">
		<input type="text" class="form-control filter" placeholder="Buscar..." /> 
	</div>
</div>
<br />
<div class="row">
	<div class="col-lg-12">
		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Situação</th>
						<th>Status</th>
						<th>Horário</th>
						<th>Espera</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody class="searchable">
					<c:forEach items="${agendamentos}" var="agendamento">
						<tr class="gradeA">
							<td>${agendamento.paciente.nome}</td>
							<td>${agendamento.situacao.descricao}</td>
							<td>${agendamento.estado.descricao}</td>
							<td>${agendamento.dataHora}</td>
							<td>${agendamento.getTempoEspera()}</td>
							<td>
								<a class="btn btn-default col-lg-12"href="<c:url value='agendamento/${agendamento.id}'/>">
									<i class="fa fa-edit"></i>
								</a>
							</td>
							<td>
								<a class="btn btn-default col-lg-12 confirm"href="<c:url value='agendamento/remover/${agendamento.id}'/>">
									<i class="fa fa-trash-o"></i>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>