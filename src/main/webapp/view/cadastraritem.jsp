<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="layouttopo.jsp"></jsp:include>

<div class="row">
    <div class="card">

        <!-- 🔥 classe SÓ dessa tela -->
        <div class="cadastro-itens">

            <h1>Cadastro de itens</h1>

            <form:form action="/cadastraritem" modelAttribute="item">

                <label for="nome">Nome do produto:</label>
                <input type="text" id="nome" name="nome" maxlength="100" required>

                <label for="data">Data:</label>
                <input type="date" id="data" name="data" required>

                <label for="descricao">Observação:</label>
                <input type="text" id="descricao" name="descricao" maxlength="150">

                <label for="categoria">Categoria:</label>
                <select id="categoria" name="categoria">
                    <option value="Proteinas">Proteínas</option>
                    <option value="Verduras">Verduras</option>
                    <option value="Carboidratos">Carboidratos</option>
                    <option value="Frutas">Frutas</option>
                    <option value="Bebidas">Bebidas</option>
                    <option value="Limpeza">Limpeza</option>
                    <option value="Outros">Outros</option>
                </select>

                <label for="quantidade">Quantidade:</label>
                <input type="number" id="quantidade" name="quantidade" min="1" value="1">

                <!-- 🔥 LINHA FINAL -->
                <div class="linha-acoes-cadastro">

                    <label class="label-check">
                        <input type="checkbox" name="comprado">
                        Já comprado
                    </label>

                    <button type="submit">Cadastrar</button>

                </div>

            </form:form>

        </div>

    </div>
</div>

<jsp:include page="layoutrodape.jsp"></jsp:include>