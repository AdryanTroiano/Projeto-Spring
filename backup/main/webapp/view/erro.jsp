<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="layouttopo.jsp"></jsp:include>
	<div class="row">
		<div class="card">
			<h1>Algo deu errado sonso! PRESTE ATENÇÃO</h1>
			<p>${mensagem}</p>
		</div>
	</div>
<jsp:include page="layoutrodape.jsp"></jsp:include>