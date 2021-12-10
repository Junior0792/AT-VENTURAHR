<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de Cadastro</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form action="/cadastro" method="post">
			<h3>Cadastramento de Empresa</h3>
						
			<div class="form-group">
				<label>Nome:</label>
				<input type="text" class="form-control" placeholder="Digite o seu nome" name="nome">
			</div>

			<div class="form-group">
				<label>Endereço:</label>
				<input type="text" class="form-control" placeholder="Digite o seu endereço" name="endereco">
			</div>

			<div class="form-group">
				<label>Telefone:</label>
				<input type="text" class="form-control" placeholder="(99)99999-9999" name="telefone">
			</div>

			<div class="form-group">
				<label>Email:</label>
				<input type="email" class="form-control" placeholder="Digite o seu email" name="email">
			</div>

			<div class="form-group">
				<label>Senha:</label>
				<input type="password" class="form-control" placeholder="Digite a sua senha" name="senha">
			</div>

			<div class="form-group">
				<label>Confirmar Senha:</label>
				<input type="password" class="form-control" placeholder="Digite novamente a senha" name="confirma">
			</div>

			<div class="form-group">
				<label>Razão Social:</label>
				<input type="text" class="form-control" placeholder="Digite sua razão social" name="razao">
			</div>

			<div class="form-group">
				<label>CNPJ:</label>
				<input type="text" class="form-control" placeholder="XX.XXX.XXX/0001-XX" name="cnpj">
			</div>
			
			<input type="hidden" name="tipo" value="E">			

			<hr>
			
			<button type="submit" class="btn btn-secondary">Criar Conta</button>
			
		</form>
		
		<c:if test="${not empty erros}">
			<h5> Erros: </h5>
			<c:forEach var="e" items="${erros}">
				<div class="alert alert-warning">
					<h5> ${e} </h5>
				</div>
			</c:forEach>
		</c:if>		
		
	</div>


</body>
</html>