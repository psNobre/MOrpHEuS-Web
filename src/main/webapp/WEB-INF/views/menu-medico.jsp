<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Médico | ${userLogado.nome}</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/resources/css/foundation.css" />
<script src="/resources/js/vendor/modernizr.js"></script>
</script>
</head>

<body>

	<nav class="top-bar" data-topbar role="navigation">
	<ul class="title-area">
		<li class="name">
			<h1>
				<a href="/">MOrpHEuS-Web</a>
			</h1>
		</li>
	</ul>
	<section class="top-bar-section">
	<ul class="right">
		<li><a href="infoUser">${userLogado.login}</a></li>
		<li class="active"><a href="home">Home</a></li>	
		<li><a href="logout">Sair</a></li>
	</ul>
	</section> </nav>
	
	<div class="row">
		<h1>Bem-vindo, ${userLogado.nome}!</h1>
	</div>
	
	<div class="row">
		<div class="large-12 columns">
			<hr>
			<h4>Meus Pacientes:</h4>	
				${userType.pacientes}			
		</div>
	</div>


	<footer class="row">
	<div class="large-12 columns">
		<hr />
		<div class="row">
			<div class="large-6 columns">
				<p>
					© Copyright 2015 <i>Pedro Sávio de Oliveira Nobre</i>.
				</p>
			</div>
			<div class="large-6 columns">
				<ul class="inline-list right">
					<li><a href="https://www.facebook.com/pedro.savio.3"> <img
							src="/resources/img/facebook.png" width="40" height="40"></a></li>
					<li><a
						href="https://plus.google.com/u/0/117166788613143326786/posts"><img
							src="/resources/img/googleplus.png" width="40" height="40"></a></li>
					<li><a href="https://www.linkedin.com/in/psnobre"><img
							src="/resources/img/linkedin.png" width="40" height="40"></a></li>
					<li><a href="https://github.com/psNobre/JJornal"><img
							src="/resources/img/github.png" width="40" height="40"></a></li>
				</ul>
			</div>
		</div>
	</div>
	</footer>

</body>
</html>