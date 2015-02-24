<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar-default sidebar" role="navigation">
   	<div class="sidebar-nav navbar-collapse">
 		<ul class="nav" id="side-menu">
 			<sec:authorize ifAllGranted="ROLE_ATENDENTE">
	       		<li>
	            	<a href="<c:url value='paciente'/>"><i class="fa fa-fw"></i> Pacientes</a>
	          	</li>
	          	<li>
	            	<a href="<c:url value='agendamento'/>"><i class="fa fa-fw"></i> Agenda</a>
	          	</li>
           	</sec:authorize>
           	<sec:authorize ifAllGranted="ROLE_GERENTE">
				<li>
               		<a href="<c:url value='medico'/>"><i class="fa fa-fw"></i> Médicos</a>
             	</li>
				<li>
                	<a href="<c:url value='plano'/>"><i class="fa fa-fw"></i> Planos de Saúde</a>
            	</li>
				<li>
                	<a href="<c:url value='atendente'/>"><i class="fa fa-fw"></i> Atendentes</a>
            	</li>
				<li>
                	<a href="#"><i class="fa fa-fw"></i> Relatórios<span class="fa arrow"></span></a>
              		<ul class="nav nav-second-level">
                   		<li>
                       		<a href="#">Agendamento por Data</a>
                    	</li>
                    	<li>
                        	<a href="#">Atendimento por Data</a>
                    	</li>
						<li>
                        	<a href="#">Atendimento por Cliente</a>
                     	</li>
                 	</ul>
             	</li>
            </sec:authorize>
            <sec:authorize ifAllGranted="ROLE_MEDICO">
				<li>
                 	<a href="<c:url value='atendimento'/>"><i class="fa fa-fw"></i> Atendimento</a>
             	</li>
            </sec:authorize>
            <sec:authorize ifAllGranted="ROLE_PAINEL">
				<li>
                 	<a href="<c:url value='painel'/>"><i class="fa fa-fw"></i> Painel</a>
             	</li>
           	</sec:authorize>
      	</ul>
   	</div>
</div>