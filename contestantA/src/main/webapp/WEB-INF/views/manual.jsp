<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
<head>
<title>HTTP Header Request Example</title>
</head>

<body>
	<h2>Whose turn is it?</h2>
	<h2>The current number is: ${game.getCurrentNumber()}</h2>

	<table width="50%" border="1" align="center">
		<tr bgcolor="#000066">
			<th><font color="White">Player 1</font></th>
		</tr>
		<c:forEach items="${ game.getListOfANumbers() }" var="myItem" >
			<tr bgcolor="Silver">
				<td><font color="red">-${ myItem }</font></td>

			</tr>
		</c:forEach>
		</table>
		<table width="50%" border="1" align="center">
		<tr bgcolor="#000066">
			<th><font color="White">Player 2</font></th>
		</tr>
		<c:forEach items="${ game.getListOfBNumbers() }" var="myItem2">
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
		<form action="<c:url value="/manual" />" method="POST">
			<input type="hidden" name="number" value="number" /> Enter a number
			between 0 and ${game.getHalfCurrentNumber()}: <input
				placeholder="input" class="form-control input-sm" type="text"
				id="userInput" name="userInput" />
			<button class="btn btn-default btn-sm" type="submit" title="Manual">
				<i> <!--  class="fa fa-sign-out" aria-hidden="true"> -->
				</i> Manual
			</button>
		</form>
		</p>
	</div>
</div>
