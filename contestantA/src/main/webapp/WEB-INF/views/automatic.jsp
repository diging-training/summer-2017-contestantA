<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
<head>
<title>HTTP Header Request Example</title>
</head>

<body>
	<h2>Whose turn is it?</h2>
	<h2>The current number is: ${game2.getCurrentNumber()}</h2>

	<table width="50%" border="1" align="center">
		<tr bgcolor="#000066">
			<th><font color="White">Player 1</font></th>
		</tr>
		<c:forEach items="${ game2.getListOfANumbers() }" var="myItem" >
			<tr bgcolor="Silver">
				<td><font color="red">-${ myItem }</font></td>

			</tr>
		</c:forEach>
		</table>
		<table width="50%" border="1" align="center">
		<tr bgcolor="#000066">
			<th><font color="White">Player 2</font></th>
		</tr>
		<c:forEach items="${ game2.getListOfBNumbers() }" var="myItem2">
			<tr bgcolor="Silver">

				<td><font color="red">-${ myItem2 }</font></td>
			</tr>
		</c:forEach>

	</table>
</html>

<div class="row">
	<div class="col-md-12">
		<hr style="margin-bottom: 25px;">
		<p class="text-muted pull-left">
		<p class="text-muted">
		<form action="<c:url value="/automatic" />" method="POST">
			<button class="btn btn-default btn-sm" type="submit" title="Play">
				 Play
			</button>
		</form>
		</p>
	</div>
</div>
