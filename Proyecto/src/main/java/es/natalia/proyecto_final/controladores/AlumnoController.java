package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.servicios.AlumnoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/login/alumno")
@Controller
@RequestScoped
public class AlumnoController {

    @Inject
    private Models models;

    @Inject
    AlumnoService alumnoService;

    @Path("/")
    @GET
    public String index() {
        models.put("alumnos", alumnoService.findAll());
        return "login/prueba";
    }


}
