<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<c:if test="${param.logout_success eq 1}">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
					Logout efetuado com sucesso.
				<a href="#" class="alert-link">Sucesso</a>.
			</div>
		</c:if>
		<c:if test="${param.login_error eq 1}">
			<div class="alert alert-danger alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
					Erro ao efetuar login. 
				<a href="#" class="alert-link">Erro</a>.
			</div>
		</c:if>
	</div>
</div>
<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-panel panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Faça seu login</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post"
				action="<c:url value="/j_spring_security_check"/>">
					<fieldset>
						<div class="form-group">
							<input class="form-control" placeholder="Usuário"
								name="j_username" type="text" autofocus="autofocus" />
						</div>
						<div class="form-group">
							<input class="form-control" placeholder="Senha"
								name="j_password" type="password" value="" />
						</div>
						<div class="checkbox">
							<label> <input name="remember" type="checkbox"
								value="Remember Me" />Lembre-me
							</label>
						</div>
						<input type="submit" class="btn btn-lg btn-success btn-block" value="Login" />
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>