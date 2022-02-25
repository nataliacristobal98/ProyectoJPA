package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.*;
import es.natalia.proyecto_final.repositorio.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class NivelService {
    @Inject
    NivelRepository nivelRepository;

    @Inject
    LeccionRepository leccionRepository;

    @Inject
    TestRepository testRepository;

    @Inject
    PreguntaRepository preguntaRepository;

    @Inject
    RespuestaRepository respuestaRepository;

    // La busqueda del listado de niveles
    public List<Nivel> buscarNiveles(Mundo mundo) {
        return nivelRepository.findByMundo(mundo);
    }
    // Busqueda del nivel
    public Nivel buscarPorId(Long id) {
        return nivelRepository.findBy(id);
    }

    // Encontrar la leccion y el test asociado al nivel
    public Leccion buscarLeccion(Nivel nivel) {return leccionRepository.findByNivel(nivel);}
    public Test buscarTest(Nivel nivel) {return testRepository.findByNivel(nivel);}

    // Las Preguntas del Test
    public Test buscarPorIdTest(Long id) {
        return testRepository.findBy(id);
    }
    public List<Pregunta> buscarPreguntas(Test test) {return preguntaRepository.findByTest(test);}
    public Pregunta buscarIdPregunta(Long id){return preguntaRepository.findBy(id);}

    public List<Respuesta> buscarRespuestas() {
        return respuestaRepository.findAll();
    }
    public List<Respuesta> buscarRespuestasPorPregunta(Pregunta pregunta) {return respuestaRepository.findByPregunta(pregunta);}
    public Respuesta buscarIdRespuesta(Long id){return respuestaRepository.findBy(id);}
}
