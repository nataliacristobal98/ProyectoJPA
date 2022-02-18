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
@Path("/")
@Controller
@RequestScoped
public class PortadaController {

    @Path("/")
    @GET
    public String index() {
        return "portada";
    }

}
