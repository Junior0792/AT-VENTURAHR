<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela inicial</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">VenturaHR</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#">Empresas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Vagas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Contatos</a>
        </li>
      </ul>
    </div>
  </div>
</nav>


 
   <div class="jumbotron" style="background-color:gray clear">
	  <h4 class="alert-heading">Quem somos?</h4>
	  <p>A Ventura Soft trabalha há muito tempo criando estratégias para atrair novas pessoas para o mercado de trabalho.
	   A empresa está em constante mudança e criando novas formas de encontrar pessoas qualificadas para se apresentarem ao mercado de trabalho.</p>
	  <hr>
	  <p class="mb-0"></p>
   </div>
   
   <div class="container">
		<form action="/login" method="post">
			<h3>Login</h3>
			
			<div>
				<c:if test="${not empty erro}">
					<div class="alert alert-warning">
						<h3> ${erro} </h3>
					</div>
				</c:if>			
			</div>
						
			<div class="form-group">
				<label>Email:</label>
				<input type="email" class="form-control" placeholder="Digite o seu email" name="email">
			</div>
						
			<div class="form-group">
				<label>Senha:</label>
				<input type="password" class="form-control" placeholder="Digite a sua senha" name="senha">
			</div>
			
			<button type="submit" class="btn btn-secondary ">Logar</button>
			
			<hr>
		</form>
   </div>
   
   
   
   
   
  
  <div class="jumbotron" style="background-color:gray clear">
	  <h4 class="alert-heading">Você deseja participar das vagas disponiveis? Abra uma conta de Candidato!</h4>

      <font size="4"><a href="/candidato">Conta candidato</a>

  </div>
  
  <div class="jumbotron" style="background-color:gray clear">
	  <h4 class="alert-heading">Você possui uma Empresa e deseja publicar vagas então abra uma conta com a gente!</h4>

      <font size="4"><a href="/empresa">Conta empresa</a>
  </div>
 </form>


</body>
</html>