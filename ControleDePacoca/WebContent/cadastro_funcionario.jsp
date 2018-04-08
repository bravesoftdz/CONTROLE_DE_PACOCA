<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>HTML Template</title>

	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700%7CVarela+Round" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
	<link type="text/css" rel="stylesheet" href="css/owl.carousel.css" />
	<link type="text/css" rel="stylesheet" href="css/owl.theme.default.css" />
	<link type="text/css" rel="stylesheet" href="css/magnific-popup.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<link rel="shortcut icon" href="img/logob.png" >
</head>

<body style="background-color: white;">

	<header>

		<nav id="nav" class="navbar" style="background-color: white;">
			<div class="container">

				<div class="navbar-header">
					<div class="navbar-brand" >
						<a href="index.html">
							<h2>MVControle de Paçocas</h2>
						</a>
					</div>

					<div class="nav-collapse">
						<span></span>
					</div>
				</div>

				<ul class="main-nav nav navbar-nav navbar-right">
					<li><a href="FuncionarioController?action=redirect" style="font-size: 20px;">Editar Cadastros</a></li>
					<!--<li><a href="index.html#about">About</a></li>
					<li><a href="index.html#portfolio">Portfolio</a></li>
					<li><a href="index.html#service">Services</a></li>
					<li><a href="index.html#pricing">Prices</a></li>
					<li><a href="index.html#team">Team</a></li>
					<li class="has-dropdown"><a>Blog</a>
						<ul class="dropdown">
							<li><a href="#">blog post</a></li>
						</ul>
					</li>
					<li><a href="index.html#contact">Contact</a></li>-->
				</ul>
				<!-- /Main navigation -->

			</div>
		</nav>
		<!-- /Nav -->

		<!-- header wrapper -->
		<div class="header-wrapper sm-padding bg-grey">
			<div class="container">
				<img src="img/logob.png" style="width: 12%; margin-top: 0.1%; positon: absolute;"/>
				<h2 style="margin-botton: 2%; positon: absolute;"> MVarandas Little WebSoftware</h2>
				<ul class="breadcrumb">
					<li class="breadcrumb-item"><a href="http://mvarandas.com.br/">Site Oficial</a></li>
					<li class="breadcrumb-item"><a href="http://mvarandas.com.br/blog/">Blog Oficial</a></li>
				</ul>
			</div>
		</div>
		<!-- /header wrapper -->

	</header>
	<!-- /Header -->

	<!-- Blog -->
	<div id="blog" class="section md-padding">

		<!-- Container -->
		<div class="container" style="background-color: white;">

			<!-- Row -->
			<div class="row">

				<!-- Main -->
				<main id="main" class="col-md-8">
				
					<h2>Cadastro de Paçoqueiro(a)</h2>
					
					<form role="form" action="FuncionarioController" method="post" class="form-group">
                	<div class="row">
                    <div class="form-group float-label-control col-sm-12">
                        <label for="">Nome</label>
                        <input type="text" class="form-control" name="nome" id="nome" placeholder="nome"/>
                    </div>
                    
                    <div class="form-group float-label-control col-sm-12">
                        <label for="">Setor</label>
                        <input type="text" class="form-control" name="setor" id="setor" placeholder="Setor"/>
                    </div>
                    
                    <div class="form-group float-label-control col-sm-12">
                        <label for="">Quantidade Inicial de Paçocas</label>
                        <input class="form-control" type="text" name="quant" id="quant" placeholder="Quantidade Inicial de Paçocas"/>
                    </div>
                   </div>
                    <div class="form-group float-label-control">
                        <button type="submit" class="btn btn-info btn-lg" onclick="sucesso()" style="box-shadow: 3px 3px 30px gray;">Gravar</button>
                    </div>

                </form>
				
				</main>
				<!-- /Main -->


				<!-- Aside -->
				<aside id="aside" class="col-md-3">

					<!-- Search
					<div class="widget">
						<div class="widget-search">
							<input class="search-input" type="text" placeholder="search">
							<button class="search-btn" type="button"><i class="fa fa-search"></i></button>
						</div>
					</div>
					/Search -->

					<!-- Category -->
					<div class="widget">
						<h3 class="title">Paçoqueiros(as)</h3>
						<table class="table table-hover" >
							<thead>
								<tr>
									<th>Cod</th>
									<th>Nome</th>
									<th>Setor</th>
									<th>Paçocas</th>
								</tr>
							</thead>
								<tbody>
									<c:forEach items="${funcs}" var="funcs">
										<tr>
											<td class="blacks"><c:out value="${funcs.id}" /></td>
											<td class="blacks"><c:out value="${funcs.nome}" /></td>
											<td class="blacks"><c:out value="${funcs.setor}" /></td>
											<td class="blacks"><c:out value="${funcs.quantPacocas}" /></td>
											<td><a href="FuncionarioController?action=adcpacoca&id=<c:out value='${funcs.id}'/>" class="btn btn-info" style="box-shadow: 3px 3px 30px gray; font-size: 20px; font-weight: bold;">+</a></td>
										</tr>
									</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /Category -->

					<!-- Posts sidebar -->
					<div class="widget">
						<h3 class="title">Paçoqueiro(a) Supremo</h3>
						
							<table class="table table-hover" >
							<thead>
								<tr>
									<th>Nome</th>
									<th>Paçocas</th>
								</tr>
							</thead>
								<tbody>
									<c:forEach items="${funcs}" var="funcs">
										<tr>
											<td class="blacks"><c:out value="${funcs.nome}" /></td>
											<td class="blacks"><c:out value="${funcs.quantPacocas}" /></td>
										</tr>
									</c:forEach>
							</tbody>
						</table>
						
					</div>

					</div>
					<!-- /Posts sidebar -->
					
				</aside>
				<!-- /Aside -->

			</div>
			<!-- /Row -->

		</div>
		<!-- /Container -->

	</div>
	<!-- /Blog -->

	<!-- Footer -->
	<footer id="footer" class="sm-padding bg-dark">

		<!-- Container -->
		<div class="container">

			<!-- Row -->
			<div class="row">

				<div class="col-md-12">

					<!-- footer logo -->
					<div class="footer-logo">
						<a href="index.html"><img src="img/logob.png" alt="logo"></a>
						<h2>MVarandas Tecnologia</h2>
					</div>
					<!-- /footer logo -->

					<!-- footer follow -->
					<ul class="footer-follow">
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
						<li><a href="#"><i class="fa fa-instagram"></i></a></li>
						<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
						<li><a href="#"><i class="fa fa-youtube"></i></a></li>
					</ul>
					<!-- /footer follow -->

					<!-- footer copyright -->
					<div class="footer-copyright">
						<p>Adaptado de um template do..: <a href="https://colorlib.com" target="_blank">Colorlib</a>, por Ruan D.C. Silva</p>
					</div>
					<!-- /footer copyright -->

				</div>

			</div>
			<!-- /Row -->

		</div>
		<!-- /Container -->

	</footer>
	<!-- /Footer -->

	<!-- Back to top -->
	<div id="back-to-top"></div>
	<!-- /Back to top -->

	<!-- Preloader -->
	<div id="preloader">
		<div class="preloader">
			<span></span>
			<span></span>
			<span></span>
			<span></span>
		</div>
	</div>
	<!-- /Preloader -->

	<!-- jQuery Plugins -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/owl.carousel.min.js"></script>
	<script type="text/javascript" src="js/jquery.magnific-popup.js"></script>
	<script type="text/javascript" src="js/main.js"></script>

</body>
</html>