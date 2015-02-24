<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse"
		data-target=".navbar-collapse">
		<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	<a class="navbar-brand" href="#">SUHCK - Sistema Unificado Hospitalar de Controle Kabuloso</a>
</div>

<ul class="nav navbar-top-links navbar-right">
	<li class="dropdown">
    	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
        	<i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-messages">
        	<li>
            	<a href="#">
            		<div>
                    	<strong>John Smith</strong>
                        <span class="pull-right text-muted">
                        	<em>Ontem</em>
                       	</span>
                	</div>
                   	<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                </a>
       		</li>
     	    <li class="divider"></li>
        	<li>
	   	   		<a href="#">
	            	<div>
	  					<strong>John Smith</strong>
						<span class="pull-right text-muted">
							<em>Ontem</em>
						</span>
					</div>
					<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
				</a>
			</li>
			<li class="divider"></li>
			<li>
		    	<a href="#">
		        	<div>
		            	<strong>John Smith</strong>
		            	<span class="pull-right text-muted">
		                	<em>Ontem</em>
		            	</span>
		        	</div>
		        	<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
		    	</a>
			</li>
			<li class="divider"></li>
			<li>
		    	<a class="text-center" href="#">
		        	<strong>Todas Mensagens</strong>
		        	<i class="fa fa-angle-right"></i>
		    	</a>
			</li>
	  	</ul>
 	</li>	
  	<li class="dropdown">
     	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
         	<i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
      	</a>
      	<ul class="dropdown-menu dropdown-user">
          	<li>
          		<a href="#"><i class="fa fa-user fa-fw"></i> Perfil de Usuário</a>
          	</li>
          	<li>
          		<a href="#"><i class="fa fa-gear fa-fw"></i> Configurações</a>
          	</li>
          	<li class="divider"></li>
          	<li>
          		<a href="<c:url value='/j_spring_security_logout'/>"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
          	</li>
      	</ul>
  	</li>
</ul>