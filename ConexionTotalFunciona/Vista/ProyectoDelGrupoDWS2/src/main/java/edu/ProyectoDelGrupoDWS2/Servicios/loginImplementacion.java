//package edu.ProyectoDelGrupoDWS2.Servicios;
//
//import java.util.regex.Pattern;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;
//import edu.ProyectoDelGrupoDWS2.Util.utilidades;
//import jakarta.ws.rs.client.ClientBuilder;
//
//@Service
//public class loginImplementacion {
//
//	private utilidades util = new utilidades();
//
//	// representa un patrón de expresión regular para luego compararla
//	private Pattern email1 = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.(com|net|es)$");

	/**
	 * Metodo privado que valida el email correctamente
	 *
	 * @author jpribio - 19/11/24
	 * @param correo electronico introducido por el usuario
	 * @return devuelve el email validado
	 */
	/*private boolean validarEmail(String email) {
		if (email == null) {
			return false;
		}
		return email1.matcher(email).matches();
	}

	public ModelAndView enviarDatosLogin(UsuariosDto usuario) throws Exception {

		if (!validarEmail(usuario.getCorreoUsu())) {
			System.out.println("Error al validar la contraseña");
		}

		usuario.setContraseniaUsu(util.encriptarContrasenia(usuario.getContraseniaUsu()));

		ModelAndView vista = new ModelAndView();

		ObjectMapper objetoMapeador = new ObjectMapper();
		String formatoJson = objetoMapeador.writeValueAsString(usuario);

		jakarta.ws.rs.client.Client cliente = ClientBuilder.newClient();

		jakarta.ws.rs.core.Response respuestaApi = cliente
				.target("http://localhost:8081/api/ProyectoDWS/verificarUsuario?correoUsuario=" + usuario.getCorreoUsu()
						+ "&contraseniaUsuario=" + usuario.getContraseniaUsu())
				.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get();

		System.out.println(respuestaApi.getStatus());
		if (respuestaApi.getStatus() == 200) {

			UsuariosDto respuestaCuerpoApi = respuestaApi.readEntity(UsuariosDto.class);

			if (respuestaCuerpoApi.EsAdmin()) {

				vista.setViewName("index");

			} else {
				vista.setViewName("index");
			}
		} else {
			vista.setViewName("login");
		}
	}*/
	
	package edu.ProyectoDelGrupoDWS2.Servicios;

	import java.util.regex.Pattern;

	import org.springframework.stereotype.Service;
	import org.springframework.web.servlet.ModelAndView;

	import com.fasterxml.jackson.databind.ObjectMapper;

	import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;
	import edu.ProyectoDelGrupoDWS2.Util.utilidades;
	import jakarta.ws.rs.client.ClientBuilder;

	@Service
	public class loginImplementacion {

		private utilidades util = new utilidades();

		// representa un patrón de expresión regular para luego compararla
		private Pattern email1 = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.(com|net|es)$");

		/**
		 * Metodo privado que valida el email correctamente
		 *
		 * @author jpribio - 19/11/24
		 * @param correo electronico introducido por el usuario
		 * @return devuelve el email validado
		 */
		private boolean validarEmail(String email) {
			if (email == null) {
				return false;
			}
			return email1.matcher(email).matches();
		}

		public ModelAndView enviarDatosLogin(UsuariosDto usuario) throws Exception {
		    ModelAndView vista = new ModelAndView();

		    // Validación del correo electrónico
		    if (!validarEmail(usuario.getCorreoUsu())) {
		        System.out.println("Correo electrónico inválido.");
		        vista.setViewName("login");
		        return vista; // Aseguramos el retorno
		    }

		    // Encriptar contraseña
		    usuario.setContraseniaUsu(util.encriptarContrasenia(usuario.getContraseniaUsu()));

		    // Configuración de la solicitud API
		    jakarta.ws.rs.client.Client cliente = ClientBuilder.newClient();
		    String url = "http://localhost:8081/api/ProyectoDWS/verificarUsuario?correoUsuario=" + usuario.getCorreoUsu()
		            + "&contraseniaUsuario=" + usuario.getContraseniaUsu();

		    jakarta.ws.rs.core.Response respuestaApi = cliente
		            .target(url)
		            .request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
		            .get();

		    // Log de la respuesta
		    System.out.println("Respuesta de la API: " + respuestaApi.getStatus());

		    if (respuestaApi.getStatus() == 200) {
		        // Mapear la respuesta al objeto UsuariosDto
		        try {
		            UsuariosDto respuestaCuerpoApi = respuestaApi.readEntity(UsuariosDto.class);

		            // Validar si es admin
		            if (respuestaCuerpoApi.EsAdmin()) {
		                vista.setViewName("index");
		            } else {
		                vista.setViewName("index");
		            }
		        } catch (Exception e) {
		            System.err.println("Error al procesar la respuesta de la API: " + e.getMessage());
		            vista.setViewName("login");
		        }
		    } else {
		        System.err.println("Error en la solicitud: Código " + respuestaApi.getStatus());
		        vista.setViewName("login");
		    }

		    // Retorno garantizado en todas las rutas de ejecución
		    return vista;
		}



}
