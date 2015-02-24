<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>

<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>" type="text/css"></link>
<link rel="stylesheet" href="<c:url value='/resources/css/sb-admin-2.css"'/>" type="text/css"></link>
<link rel="stylesheet" href="<c:url value='/resources/css/plugins/metisMenu/metisMenu.min.css'/>" type="text/css"></link>
<link rel="stylesheet" href="<c:url value='/resources/fonts/font-awesome/css/font-awesome.min.css'/>" type="text/css"></link>

<script src="<c:url value='/resources/js/jquery-1.11.0.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/plugins/metisMenu/metisMenu.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/sb-admin-2.js'/>" type="text/javascript"></script>
<!-- <script src="<c:url value='/resources/js/bootbox.min.js'/>" type="text/javascript"></script>  -->
<script src="<c:url value='/resources/js/jquery.maskedinput.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/suhck.js'/>" type="text/javascript" charset="ISO-8859-1"></script>

</head>
<body>
	<div id="container">
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
			<div id="header">
		    	<tiles:insertAttribute name="header" />
			</div>
			<div id="menuBar">
		    	<tiles:insertAttribute name="menu" />
			</div>
		</nav>
		<div id="page-wrapper">
			<div id="body">
				<div id="messages"></div>
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
</body>
</html>