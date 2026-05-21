<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="layouttopo.jsp"></jsp:include>

<div class="row">
    <div class="card">
        <h1>Alteração de Itens</h1>

        <form:form action="/alteraritem" modelAttribute="item">

            <label for="codigo">Código:</label>
            <input type="number" value="${item.getCodigo()}" disabled/>
            <input type="hidden" id="codigo" name="codigo" value="${item.getCodigo()}"/>

            <label for="nome">Nome do produto:</label>
            <input type="text" id="nome" name="nome" maxlength="100" value="${item.getNome()}" required>

            <label for="data">Data:</label>
            <input type="date" id="data" name="data" value="${item.getData()}" required>

            <label for="descricao">Observação:</label>
            <input type="text" id="descricao" name="descricao" maxlength="150" value="${item.getDescricao()}">

            <label for="categoria">Categoria:</label>
            <select id="categoria" name="categoria">
                <option value="Proteinas" ${item.getCategoria() == 'Proteinas' ? 'selected' : ''}>Proteínas</option>
                <option value="Verduras" ${item.getCategoria() == 'Verduras' ? 'selected' : ''}>Verduras</option>
                <option value="Carboidratos" ${item.getCategoria() == 'Carboidratos' ? 'selected' : ''}>Carboidratos</option>
                <option value="Frutas" ${item.getCategoria() == 'Frutas' ? 'selected' : ''}>Frutas</option>
                <option value="Bebidas" ${item.getCategoria() == 'Bebidas' ? 'selected' : ''}>Bebidas</option>
                <option value="Limpeza" ${item.getCategoria() == 'Limpeza' ? 'selected' : ''}>Limpeza</option>
                <option value="Outros" ${item.getCategoria() == 'Outros' ? 'selected' : ''}>Outros</option>
            </select>

            <label for="quantidade">Quantidade:</label>
            <input type="number" id="quantidade" name="quantidade" min="1" value="${item.getQuantidade()}">

            <label>
                <input type="checkbox" name="comprado" ${item.isComprado() ? 'checked' : ''}>
                Já comprado
            </label>

            <button>Alterar</button>

        </form:form>
    </div>
</div>

<jsp:include page="layoutrodape.jsp"></jsp:include>