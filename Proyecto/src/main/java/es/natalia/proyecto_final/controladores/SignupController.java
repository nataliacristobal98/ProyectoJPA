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
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

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

    @Inject
    private Models models;

    @Path("/")
    @GET
    public String registro() {

        List<Profesor> profesores = profesorService.findAll();

        try {
            models.put("profesores", profesores);
        }catch (NoResultException e){
            // Codigo si usuario está mal
            System.out.println(e);
            return "sesion/login";
        }

        return "sesion/signup";
    }

    @POST
    @Path("/signup")
    public String registroHecho(@FormParam(value="nombre") String nombre, @FormParam(value="contrasena") String contrasena, @FormParam(value="icono") String icono, @FormParam(value="profesor") String profesor) {

        //System.out.println(profesor);
        try{
            Profesor profesorEncontrado = profesorService.findById(Long.parseLong(profesor));
            // initialize a Random object somewhere; you should only need one
            Random random = new Random();

            // generate a random integer from 0 to 899, then add 100
            int x = random.nextInt(900) + 100;

            String codigoAlumnoNuevo = profesorEncontrado.getCodigoProfesor() + x;

            Alumno alumnoNuevo = new Alumno(nombre, contrasena, icono, codigoAlumnoNuevo, profesorEncontrado);

            alumnoService.guardar(alumnoNuevo);
            return "redirect:mundos/mundo";

        }catch (NoResultException e){
            // Codigo si usuario está mal
            System.out.println(e);
            return "sesion/login";
        }

    }

}
