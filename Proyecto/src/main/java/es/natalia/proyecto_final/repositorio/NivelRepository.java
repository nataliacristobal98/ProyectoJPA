package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Mundo;
import es.natalia.proyecto_final.entidades.Nivel;
import jakarta.persistence.Query;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository
public interface NivelRepository extends EntityRepository<Nivel, Long> {
    // Buscamos el nivel por el mundo que tenga relacionado
    public List<Nivel> findByMundo(Mundo mundo);
}
