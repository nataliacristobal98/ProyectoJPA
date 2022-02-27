package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.entidades.Profesor;
import es.natalia.proyecto_final.servicios.AlumnoService;
import es.natalia.proyecto_final.servicios.ProfesorService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.persistence.NoResultException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

import java.text.Normalizer;
import java.util.List;
import java.util.Random;

@Slf4j
@Path("/signup")
@Controller
@RequestScoped
public class SignupController {

    @Inject
    AlumnoService alumnoService;

    @Inject
    ProfesorService profesorService;

    // Crear la sesión para el control de datos
    @Inject
    HttpServletRequest request;

    @Inject
    private Models models;

    @Path("/")
    @GET
    public String registro() {
        // Mandamos una lista de los Profesores disponibles para su selección
        List<Profesor> profesores = profesorService.findAll();
        try {
            models.put("profesores", profesores);
        } catch (NoResultException e) {
            System.out.println(e);
            return "sesion/signup";
        }

        // Controlamos que haya una sesión activa. Si la hay, no se puede acceder a esta pantalla ya que causará errores.
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("iniciada").equals(true)) {
                // Redirección a la pantalla principal
                return "redirect:portada";
            }
        } catch (NullPointerException e) {
            // Si no hay una sesión, se permite el acceso o crear una.
            return "sesion/signup";
        }
        return "sesion/signup";
    }

    @POST
    @Path("/signup")
    public String registroHecho(@FormParam(value = "nombre") String nombre, @FormParam(value = "contrasena") String contrasena, @FormParam(value = "icono") String icono, @FormParam(value = "profesor") String profesor) {

        // Creamos al Alumno nuevo en base a los datos mandados
        try {
            Profesor profesorEncontrado = profesorService.findById(Long.parseLong(profesor));

            // Generamos un código random para el alumno junto a la inicial del Profesor asignado
            Random random = new Random();
            int x = random.nextInt(900) + 100;
            String codigoAlumnoNuevo = profesorEncontrado.getCodigoProfesor() + x;

            if(icono.equals("icono1")){
                icono = "/proyecto_final/resources/img/icono1.jpg";
            }else if(icono.equals("icono2")){
                icono = "/proyecto_final/resources/img/icono2.jpg";
            } else{
                icono = "/proyecto_final/resources/img/icono3.jpg";
            }

            String cadenaNormalize = Normalizer.normalize(nombre, Normalizer.Form.NFD);
            String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

            // Guardamos el Alumno nuevo
            Alumno alumnoNuevo = new Alumno(cadenaSinAcentos, contrasena, icono, codigoAlumnoNuevo, profesorEncontrado);
            alumnoService.guardar(alumnoNuevo);

            // Iniciamos la sesión
            HttpSession session = request.getSession();
            session.setAttribute("iniciada", true);
            session.setAttribute("alumno", alumnoNuevo.getCodigoAlumno());
            session.setAttribute("id", alumnoNuevo.getId());
            return "redirect:perfil";

        } catch (NoResultException e) {
            System.out.println(e);
            return "redirect:perfil";
        }

    }

}
