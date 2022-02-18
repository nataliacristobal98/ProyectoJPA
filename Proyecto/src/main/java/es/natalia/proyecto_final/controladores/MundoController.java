package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Mundo;
import es.natalia.proyecto_final.entidades.Nivel;
import es.natalia.proyecto_final.entidades.Pregunta;
import es.natalia.proyecto_final.entidades.Test;
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
import java.util.Set;

@Slf4j
@Path("/mundos/mundo")
@Controller
@RequestScoped
public class MundoController {

    @Inject
    private Models models;

    @Inject
    MundoService mundoService;

    // Listado de Mundos, en esta pantalla se accese a los niveles
    @GET
    @Path("/")
    public String index() {
        // Llamamos al método findAll() para el listado de Mundos disponibles en la BD
        models.put("mundos", mundoService.findAll());
        return "mundos/mundos-listado";
    }

    // Listado de Niveles por el Mundo seleccionado. Se pasa el id del Mundo para rescatar los Niveles asociado a este.
    @GET
    @Path("{id}")
    public String detalle(@PathParam("id") @NotNull Long id) {

        Optional<Mundo> mundo = mundoService.buscarPorId(id);

        if (mundo.isPresent()) {
            // Si el Mundo existe, se hará la busqueda de Niveles pertinente, para ello llamamos al método correspondiente
            List<Nivel> niveles = mundoService.buscarNiveles(mundo.get());

            //
            models.put("mundo", mundo.get());
            // Mandamos los datos de los Niveles para usarlos en la pantalla
            models.put("niveles", niveles);
            return "mundos/mundo-nivel";
        }
        return "redirect:mundos/mundo-listado";
    }

    // Para ver las preguntas
    @GET
    @Path("{idM}/{idN}")
    public String editar(@PathParam("idM") Long idM, @PathParam("idN") Long idN) {

        Optional<Mundo> mundo = mundoService.buscarPorId(idM);

        if (mundo.isPresent()) {
            Optional<Nivel> nivel = mundoService.buscarPorIdNivel(idN);
            Optional<Test> test = mundoService.buscarTest(nivel);

            Set<Pregunta> preguntas = mundoService.buscarPreguntas(test.get());


            models.put("preguntas", preguntas);
            return "mundos/nivel-test";
        }
        return "redirect:mundos/mundo-nivel";
    }


}
