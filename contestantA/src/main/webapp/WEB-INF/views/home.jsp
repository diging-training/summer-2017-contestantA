<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div>
	<sec:authorize access="isAnonymous()">
		<h1>Congratulations!</h1>
		<p>You did it. This basic webapp is all set up now. Try to login
			as "admin" with password "admin".</p>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<p>Choose a game to play:</p>
		<a href="<c:url value="/manual" />">Manual </a>
		<p>
			<a href="<c:url value="/automatic" />">Automatic </a>
	</sec:authorize>
</div>