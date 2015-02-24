<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Gerenciar Atendentes</h1>
	</div>

</div>
<div class="row">
	<div class="col-lg-12">
		<sf:form role="form" modelAttribute="atendente" method="post" action="gerenciar">
			<div class="col-md-12">
				<sf:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div" />
			</div>
			<div class="col-lg-12">
				<div class="form-group">
					<label>Nome Completo</label>
					<sf:input path="nome" class="form-control" />
					<sf:input type="hidden" path="id" />
				</div>
			</div>
			<div class="col-lg-3">
				<div class="form-group">
					<label>CPF</label>
					<sf:input id="cpf" path="cpf" class="form-control" />
				</div>
			</div>
			<div class="col-lg-3">
				<div class="form-group">
					<label>Telefone</label>
					<sf:input id="telefone" path="telefone" class="form-control" />
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<label>Email</label>
					<sf:input type="email" path="email" class="form-control" />
				</div>
			</div>			
			<div class="col-lg-4">
				<div class="form-group">
					<label>Usuário</label>
					<sf:input path="usuario" class="form-control" />
				</div>
			</div>
			<div class="col-lg-4">
				<div class="form-group">
					<label>Senha</label>
					<sf:input type="password" path="senha" class="form-control" />
				</div>
			</div>
			<div class="col-lg-8">
				<div class="form-group">
					<label>Endereço</label>
					<sf:input path="endereco" class="form-control" />
				</div>
			</div>

			<div class="col-lg-12">
				<button class="btn btn-default">Salvar</button>
				<button class="btn btn-default">Limpar</button>
			</div>
		</sf:form>
	</div>
</div>