<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <table id="pointsTable" border="1">
	<tr>
		<td>You</td>
		<td>Other</td>
	</tr>
</table>
<script type="text/javascript">

  function addRow() {

		var table = document.getElementById(pointsTable);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		cell1.innerHTML = Date();

		var cell2 = row.insertCell(1);
		cell2.innerHTML = rowCount + 1;

	}
</script> -->
<%@ page import="java.io.*,java.util.*"%>


<html>
<head>
<title>HTTP Header Request Example</title>
</head>

<body>
	<center>
		<h2>It's your turn!</h2>

		<table width="100%" border="1" align="center">
			<tr bgcolor="#949494">
				<th>Player 1</th>
				<th>Number</th>
				<th>Player 2</th>
			</tr>
			<%-- <%
               Enumeration headerNames = request.getHeaderNames();
               while(headerNames.hasMoreElements()) {
                  String paramName = (String)headerNames.nextElement();
                  out.print("<tr><td>" + paramName + "</td>\n");
                  String paramValue = request.getHeader(paramName);
                  out.println("<td> " + paramValue + "</td></tr>\n");
               }
            %> --%>
		</table>
	</center>

</body>
</html>

<div class="row">
	<div class="col-md-12">
		<hr style="margin-bottom: 25px;">
		<p class="text-muted pull-left">
		<p class="text-muted">
		<form name='f' class="form-inline pull-left"
			action="<c:url value="/manual" />" method="POST">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> Enter a number between x and y: <input
				placeholder="input" class="form-control input-sm" type="text"
				id="username" name="username" />
			<button type="submit" class="btn btn-default btn-sm">submit</button>
		</form>
		</p>
	</div>
</div>