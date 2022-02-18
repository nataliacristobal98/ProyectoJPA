package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.Mundo;
import es.natalia.proyecto_final.entidades.Nivel;
import es.natalia.proyecto_final.entidades.Pregunta;
import es.natalia.proyecto_final.entidades.Test;
import es.natalia.proyecto_final.repositorio.MundoRepository;
import es.natalia.proyecto_final.repositorio.NivelRepository;
import es.natalia.proyecto_final.repositorio.TestRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class MundoService {

    @Inject
    MundoRepository mundoRepository;

    @Inject
    NivelRepository nivelRepository;

    @Inject
    TestRepository testRepository;

    public List<Mundo> findAll() {
        return mundoRepository.findAll();
    }

    public Optional<Mundo> buscarPorId(Long id) {
        return mundoRepository.findOptionalBy(id);
    }

    public void guardar(Mundo mundo){mundoRepository.save(mundo);}

    // La busqueda del listado de niveles
    public List<Nivel> buscarNiveles(Mundo mundo) {
        return nivelRepository.findByMundo(mundo);
    }

    public Optional<Nivel> buscarPorIdNivel(Long id) {
        return nivelRepository.findOptionalBy(id);
    }

    // Encontrar el test asociado al nivel
    public Optional<Test> buscarTest(Optional<Nivel> nivel) {return nivelRepository.findByNivel(nivel);}

    // La busqueda del listado de preguntas por niveles
    public Set<Pregunta> buscarPreguntas(Test test) {
        return testRepository.findByPreguntas(test);
    }

}
