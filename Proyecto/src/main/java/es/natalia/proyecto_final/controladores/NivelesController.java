package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.*;
import es.natalia.proyecto_final.servicios.AlumnoService;
import es.natalia.proyecto_final.servicios.NivelService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@Path("/niveles/nivel")
@Controller
@RequestScoped
public class NivelesController {

    @Inject
    private Models models;

    @Inject
    NivelService nivelService;

    @Inject
    AlumnoService alumnoService;

    @Inject
    HttpServletRequest request;

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
        models.put("totalPreguntas", preguntas.size());
        models.put("respuestas", respuestas);
        return "niveles/nivel-test";
    }

    @POST
    @Path("/resultTest")
        public String resultadosTest(@FormParam(value="respuestas[]") List<String> respuestas) {

        System.out.println("Resultados Formulario: " + respuestas.toString());
        HttpSession session = request.getSession();
        Alumno alumno = alumnoService.buscarPorId(Long.parseLong(session.getAttribute("id").toString()));

        for (String respuestaSelect:respuestas) {
            Respuesta respuesta = nivelService.buscarIdRespuesta(Long.parseLong(respuestaSelect));

            if(respuesta.getCorrecta()){
                alumno.setPuntos(alumno.getPuntos()+1);
            }

        }
        alumnoService.guardar(alumno);

        return "redirect:portada";
    }
}
