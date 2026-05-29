<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="layouttopo.jsp"></jsp:include>
	<div class="row">
		<div class="card">
			<h1>Cadastrar Novo Usuário</h1>
			<form action="/cadastrarusuario" method="post">
				<div>
					<label for="username">Nome de Usuário:</label>
					<input type="text" id="username" name="username" required>
				</div>
				<br>
				<div>
					<label for="password">Senha:</label>
					<input type="password" id="password" name="password" required>
				</div>
				<br>
				<div>
					<label for="confirmPassword">Confirmar Senha:</label>
					<input type="password" id="confirmPassword" name="confirmPassword" required>
				</div>
				<br>
				<div>
					<button type="submit">Cadastrar</button>
				</div>
			</form>
		</div>
	</div>
<jsp:include page="layoutrodape.jsp"></jsp:include>