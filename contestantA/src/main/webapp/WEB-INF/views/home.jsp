<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="jumbotron col-md-12">


	<sec:authorize access="isAnonymous()">
		<h1>Congratulations!</h1>
		<p>You did it. This basic webapp is all set up now. Try to login
			as "admin" with password "admin".</p>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<p>Choose a game to play:</p>
		<!-- <li role="presentation"> -->
		<form action="<c:url value="/manual" />" method="POST">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button class="btn btn-default btn-sm" type="submit" title="Manual">
				<i> <!--  class="fa fa-sign-out" aria-hidden="true"> -->
				</i> Manual
			</button>
		</form>
		<!-- </li> -->
		<p>
		<p>
			<!-- <li role="presentation"> -->
		<form action="<c:url value="/automatic" />" method="POST">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button class="btn btn-default btn-sm" type="submit"
				title="Automatic">
				<i> <!--  class="fa fa-sign-out" aria-hidden="true"> -->
				</i> Automatic
			</button>
		</form>
		<!-- </li> -->
	</sec:authorize>
</div>