<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="layouttopo.jsp"></jsp:include>

<div class="row">
    <div class="card" id="relatorio">
        <h1>Lista de Compras</h1>

        <!-- 🔍 PESQUISA (ALINHADA À DIREITA) -->
        <form method="GET" action="/pesquisaritem" class="pesquisa-lista">
            <input type="text" name="pesquisa" id="pesquisa" placeholder="Buscar item...">
            <button type="submit">Pesquisar</button>
        </form>

        <table>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Categoria</th>
                    <th>Quantidade</th>
                    <th>Observação</th>
                    <th>Data</th>
                    <th>Comprado</th>
                    <th>Ações</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${listaItens}" var="item">
                    <tr>
                        <td>${item.codigo}</td>
                        <td>${item.nome}</td>
                        <td>${item.categoria}</td>
                        <td>${item.quantidade}</td>
                        <td>${item.descricao}</td>
                        <td>${item.data}</td>
                        <td>
                            <c:choose>
                                <c:when test="${item.comprado}">
                                    ✔️
                                </c:when>
                                <c:otherwise>
                                    ❌
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a href="alteraritem?codigo=${item.codigo}">Alterar</a> |
                            <a href="excluiritem?codigo=${item.codigo}" 
                               onclick="return confirm('Tem certeza que deseja excluir este item?')">
                               Excluir
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button onclick="window.print()">Imprimir</button>

    </div>
</div>

<jsp:include page="layoutrodape.jsp"></jsp:include>