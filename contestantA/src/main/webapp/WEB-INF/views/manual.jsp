<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

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



<html>
<head>
<title>HTTP Header Request Example</title>
</head>

<body>
	<%-- <center> --%>
	<h2>It's your turn!</h2>

	<table width="100%" border="1" align="center">
		<tr bgcolor="#949494">
			<th>Player 1</th>
			<th>Number</th>
			<th>Player 2</th>
		</tr>
		<c:forEach items="${ game }" var="myItem">
			<tr>
				<td>${ myItem }</td>
				<td>${ myItem }</td>
				<td>${ myItem }</td>
			</tr>
		</c:forEach>

	</table>
	<%-- </center> --%>
</html>

<div class="row">
	<div class="col-md-12">
		<hr style="margin-bottom: 25px;">
		<p class="text-muted pull-left">
			<p class="text-muted"><fo rm name='f' class="form-inline pull-left"
			action="<c:url value="/manual" />" method="POST">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> Enter a number between x and y: <input placeholder="input" class="form-control input-sm" type="text"
				id="username" name="username" />
			<button type="submit" class="btn btn-default btn-sm">submit</button>
		</form>
		</p>
	</div>
</div>