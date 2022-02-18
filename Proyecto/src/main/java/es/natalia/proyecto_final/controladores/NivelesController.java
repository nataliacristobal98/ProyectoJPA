package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Mundo;
import es.natalia.proyecto_final.servicios.MundoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Path("/niveles/nivel")
@Controller
@RequestScoped
public class NivelesController {

    @Inject
    private Models models;

    @Inject
    MundoService mundoService;

    @GET
    @Path("{id}")
    public String detalle(@PathParam("id") @NotNull Long id) {

        Optional<Mundo> mundo = mundoService.buscarPorId(id);
        //List<Nivel> niveles = mundoService.buscarNiveles(id);

        if (mundo.isPresent()) {
            models.put("mundo", mundo.get());
            //models.put("niveles", niveles);
            return "mundos/mundo-nivel";
        }
        return "redirect:mundos/mundo-listado";
    }
}
