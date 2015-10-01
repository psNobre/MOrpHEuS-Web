<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>MOrpHEuS | Registro</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/resources/css/foundation.css" />
<script src="/resources/js/vendor/modernizr.js"></script>
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
			<li class="active"><a href="home">Home</a></li>
			<li><a href="formlog">Entrar</a></li>
		</ul>
	</section>
</nav>

	<div class="row">
		<h1>Registro</h1>
	</div>
	<form action="register" method="get">
		<div class="row collapse">
			<div class="large-6 columns">
				<div class="row collapse prefix-radius">
					<div class="small-3 columns">
						<span class="prefix">Nome</span>
					</div>
					<div class="small-9 columns">
						<input type="text" placeholder="Nome" name="nome" required
							x-moz-errormessage="Ops. Voc� esqueceu de preencher seu nome.">
					</div>
				</div>
			</div>
		</div>
		<div class="row collapse">
			<div class="large-6 columns">
				<div class="row collapse prefix-radius">
					<div class="small-3 columns">
						<span class="prefix">Email</span>
					</div>
					<div class="small-9 columns">
						<input type="text" placeholder="exemplo@gmail.com" name="email"
							required
							x-moz-errormessage="N�o esque�a de preencher com seu email.">
					</div>
				</div>
			</div>
		</div>
		<div class="row collapse">
			<div class="large-6 columns">
				<div class="row collapse prefix-radius">
					<div class="small-3 columns">
						<span class="prefix">Login</span>
					</div>
					<div class="small-9 columns">
						<input type="text" placeholder="Usu�rio" name="login" required
							x-moz-errormessage="Campo obrigat�rio n�o esquece-lo.">
					</div>
				</div>
			</div>
		</div>
		<div class="row collapse">
			<div class="large-6 columns">
				<div class="row collapse prefix-radius">
					<div class="small-3 columns">
						<span class="prefix">Senha</span>
					</div>
					<div class="small-9 columns">
						<input type="password" placeholder="Senha" name="senha" required
							x-moz-errormessage="N�o esque�a sua senha.">
					</div>
				</div>
			</div>
		</div>
		<div class="row collapse">
			<div class="large-6 columns">
				<div class="row collapse prefix-radius">
					<div class="small-9 columns">
						<input class="button success" type="submit" placeholder="Value"></a>
					</div>
				</div>
			</div>
		</div>
	</form>
	

<footer class="row">
	<div class="large-12 columns">
		<hr />
		<div class="row">
			<div class="large-6 columns">
				<p>
					� Copyright 2015 <i>Pedro S�vio de Oliveira Nobre</i>.
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