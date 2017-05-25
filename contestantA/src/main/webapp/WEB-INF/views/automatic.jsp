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
	<h2>Whose turn is it?</h2>
	<h2>The current number is: <%-- "${game.getCurrentNumber()}" --%></h2>

	<table width="50%" border="1" align="center">
		<tr bgcolor="#000066">
			<th><font color="White">Player 1</font></th>
			<th><font color="White">Player 2</font></th>
		</tr>
<%-- 		<c:forEach items="${ game.getPlayerOne() }" var="myItem" items="${ game.getPlayerTwo() }" var="myItem2">
 --%>			<tr bgcolor="Silver" >
				<td><font color="red">-2<%-- -${ myItem } --%></font></td>
				<td><font color="red">-10<%-- -${ myItem2 } --%></font></td>
			</tr>
<%-- 		</c:forEach>
 --%>
	</table>
</html>

<div class="row">
	<div class="col-md-12">
		<hr style="margin-bottom: 100px;">
		<p class="text-muted pull-left">
			<p class="text-muted"><fo rm name='f' class="form-inline pull-left"
			action="<c:url value="/automatic" />" method="POST">
			<button type="submit" class="btn btn-default btn-sm">play</button>
		</form>
		</p>
	</div>
</div>