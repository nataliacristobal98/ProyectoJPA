package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Mundo;
import es.natalia.proyecto_final.entidades.Nivel;
import es.natalia.proyecto_final.entidades.Test;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NivelRepository extends EntityRepository<Nivel, Long> {

    // Buscamos el nivel por el mundo que tenga relacionado
    List<Nivel> findByMundo(Mundo mundo);

    //Obetener el test del nivel
    Optional<Test> findByNivel(Optional<Nivel> nivel);


}
