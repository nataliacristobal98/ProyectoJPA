package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.*;
import es.natalia.proyecto_final.servicios.NivelService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Path("/niveles/nivel")
@Controller
@RequestScoped
public class NivelesController {

    @Inject
    private Models models;

    @Inject
    NivelService nivelService;

    // Menú de Nivel -> Con su Lección y su Test correspondiente
    @GET
    @Path("{id}")
    public String editar(@PathParam("id") Long id) {

        Nivel nivel = nivelService.buscarPorId(id);


            Test test = nivelService.buscarTest(nivel);
            Leccion leccion = nivelService.buscarLeccion(nivel);


            models.put("mundo", nivel.getMundo().getId());
            models.put("nivel", nivel);
            models.put("leccion", leccion);
            models.put("test", test);
            return "niveles/nivel-menu";
    }

    @GET
    @Path("{idN}/{idT}")
    public String editar(@PathParam("idN") Long idN, @PathParam("idT") Long idT) {

        Nivel nivel = nivelService.buscarPorId(idN);

        Test test = nivelService.buscarPorIdTest(idT);
        List<Pregunta> preguntas = nivelService.buscarPreguntas(test);

        List<Respuesta> respuestas = nivelService.buscarRespuestas();


        models.put("nivel", nivel);
        models.put("test", test);
        models.put("preguntas", preguntas);
        models.put("respuestas", respuestas);
        return "niveles/nivel-test";
    }
}
