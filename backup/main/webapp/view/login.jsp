<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="layouttopo.jsp"></jsp:include>
	<div class="row">
		<div class="card">
            <h2>Login</h2>

            <!-- Mostra mensagem de erro, se houver -->
            <c:if test="${param.error != null}">
                <div style="color:red;">Usuário ou senha inválidos.</div>
            </c:if>
            
            <!-- Mostra mensagem de logout, se houver -->
            <c:if test="${param.logout != null}">
                <div style="color:green;">Você saiu com sucesso.</div>
            </c:if>
            
            <form action="/login" method="post">
                <label for="username">Usuário:</label>
                <input type="text" id="username" name="username" required autofocus />
                <br/>
            
                <label for="password">Senha:</label>
                <input type="password" id="password" name="password" required />
                <br/>
            
                <button type="submit">Entrar</button>
            </form>            
		</div>
	</div>
<jsp:include page="layoutrodape.jsp"></jsp:include>