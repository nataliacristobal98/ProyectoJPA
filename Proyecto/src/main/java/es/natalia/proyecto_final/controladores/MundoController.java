package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Mundo;
import es.natalia.proyecto_final.entidades.Nivel;
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

import java.util.List;
import java.util.Optional;

@Slf4j
@Path("/mundos/mundo")
@Controller
@RequestScoped
public class MundoController {

    @Inject
    private Models models;

    @Inject
    MundoService mundoService;

    @Path("/")
    @GET
    public String index() {
        models.put("mundos", mundoService.findAll());
        return "mundos/mundos-listado";
    }

    @GET
    @Path("{id}")
    public String detalle(@PathParam("id") @NotNull Long id) {

        Optional<Mundo> mundo = mundoService.buscarPorId(id);

        if (mundo.isPresent()) {
            List<Nivel> niveles = mundoService.buscarNiveles(mundo.get());
            models.put("mundo", mundo.get());
            models.put("niveles", niveles);
            return "mundos/mundo-nivel";
        }
        return "redirect:mundos/mundo-listado";
    }




}
