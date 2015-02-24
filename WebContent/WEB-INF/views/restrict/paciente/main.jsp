<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Listagem de Pacientes</h1>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<c:if test="${param.save_success eq 1}">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
					Paciente salvo com sucesso.
				<a href="#" class="alert-link"></a>
			</div>
		</c:if>
		<c:if test="${param.edit_success eq 1}">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
					Paciente editado com sucesso.
				<a href="#" class="alert-link"></a>
			</div>
		</c:if>
		<c:if test="${param.remove_success eq 1}">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
					Paciente removido com sucesso.
				<a href="#" class="alert-link"></a>
			</div>
		</c:if>
	</div>
	<div class="col-lg-6">
		<a style="text-indent: 0" class="btn btn-default" href="<c:url value='paciente/novo'/>">
			<i class="fa fa-plus"></i> Adicionar
		</a>
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
						<th class="col-md-4">Nome</th>
						<th class="col-md-3">CPF</th>
						<th class="col-md-3">Plano de Saúde</th>
						<th class="col-md-1" />
						<th class="col-md-1" />
					</tr>
				</thead>
				<tbody class="searchable">
					<c:forEach items="${pacientes}" var="paciente">
						<tr class="gradeA">
							<td>${paciente.nome}</td>
							<td>${paciente.cpf}</td>
							<td>${paciente.planoSaude.nome}</td>
							<td>
								<a class="btn btn-default col-lg-12"href="<c:url value='paciente/${paciente.id}'/>">
									<i class="fa fa-edit"></i>
								</a>
							</td>
							<td>
								<a class="btn btn-default col-lg-12 confirm"href="<c:url value='paciente/remover/${paciente.id}'/>">
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