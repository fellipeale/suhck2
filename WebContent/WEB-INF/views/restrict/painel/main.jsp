<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">

	$(document).ready(function() {
		
		window.setTimeout("location.reload();",30000);
		
		$(".estado").each(function() {
			var estado = $(this).val();
			var classe = "";
	
			switch(estado) {
	
			case 'Estável':
				classe = 'success';
				break;
			case 'Crítico':
				classe = 'warning';
				break;
			case 'Risco de Vida':
				classe = 'danger';
				break;
			}
	
			$(this).parent().parent().attr("class", classe);
		})
	});

</script>
<div id="page-full">
	<div class="row">
		<div class="col-lg-12 jumbotron">
			<div class="container">
				<h1 class="text-center">
					<small>Próximo Atendimento:</small> <br /> 
					<strong>${proximoAtendimento.id} - ${proximoAtendimento.paciente.nome}</strong>
				</h1>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>Número</th>
							<th>Nome</th>
							<th>Horário de Agendamento</th>
							<th>Tempo de Espera</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${agendamentos}" var="agendamento">
							<tr>
								<td>
									${agendamento.id}
									<input type="hidden" class="estado" value="${agendamento.estado.descricao}" />	
								</td>
								<td>${agendamento.paciente.nome}</td>
								<td>${agendamento.dataHora}</td>
								<td>${agendamento.getTempoEspera()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>