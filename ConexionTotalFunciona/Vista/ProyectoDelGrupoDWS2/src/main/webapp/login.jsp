<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/cs.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<nav class="navegador2">
		<!-- Enlace con Thymeleaf -->
		<a href="${pageContext.request.contextPath}/"> <svg
				xmlns="http://www.w3.org/2000/svg" width="60" height="60"
				fill="currentColor" class="bi bi-arrow-left-circle"
				viewBox="0 0 16 16">
                <path fill-rule="evenodd"
					d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5z" />
            </svg>
		</a>
	</nav>

	<main class="container2 w-100">
		<div class="row zonaLogin">
			<div class="col zonaLoginForm">

				<!-- Formulario con Thymeleaf -->
				<form class="w-100 formulario"
					action="${pageContext.request.contextPath}/login" method="post">
					<h1 class="nombreLogin">LOGIN</h1>
					<div class="contenidoLogin">
						<div class="divCorreo">
							<!-- Campo de correo con Thymeleaf -->
							<input type="email" placeholder="Correo electrónico"
								class="correo" name="correoUsu" value="${usuarios.correoUsu}"
								required />
						</div>
						<div class="divContra">
							<!-- Campo de contraseña con Thymeleaf -->
							<input type="password" placeholder="Contraseña"
								class="contrasenia" name="contraseniaUsu"
								value="${usuarios.contraseniaUsu}" required />
						</div>
						<div class="form-check divCheckbox">
							<!-- Checkbox con Thymeleaf -->
							<input class="form-check-input recuerdame" type="checkbox"
								value="" id="flexCheckDefault" /> <label
								class="form-check-label labelRecuerdame" for="flexCheckDefault">
								Recuérdame </label>
						</div>
						<div class="divBoton">
							<!-- Botón de acceso -->
							<button type="submit" class="botonParaAcceder">Acceder</button>
						</div>
					</div>
				</form>
			</div>

			<div class="col d-lg-block d-none zonaLoginImagenes">
				<!-- Imágenes con Thymeleaf -->
				<div class="image-box1 top">
					<img src="${pageContext.request.contextPath}/images/motoAzul.jpg"
						alt="Imagen de moto 1" class="imagen1" />
				</div>
				<div class="image-box">
					<img src="${pageContext.request.contextPath}/images/descarga.jpg"
						alt="Imagen de moto 2" class="imagen2" />
				</div>
			</div>
		</div>
	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<!-- Ruta de archivo JavaScript con Thymeleaf -->
	<script src="${pageContext.request.contextPath}/js/javascript.js"></script>
</body>
</html>
