<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="jumbotron col-md-12">

<sec:authorize access="isAnonymous()">
<h1>Congratulation!</h1>
<p>
You did it. This basic webapp is all set up now. Try to login as "admin" with password "admin".
</p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<h1>Whoohoo!</h1>
<p>You are logged in.</p>
<table id="pointsTable" border="1">
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
</script>
</sec:authorize>
</div>