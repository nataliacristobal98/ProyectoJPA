package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Pregunta;
import es.natalia.proyecto_final.entidades.Test;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.Set;

@Repository
public interface TestRepository extends EntityRepository<Test, Long> {

    // Buscamos las Preguntas asociadas al Test
    Set<Pregunta> findByPreguntas(Test test);
}
