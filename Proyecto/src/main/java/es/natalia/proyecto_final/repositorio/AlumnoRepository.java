package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Alumno;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends EntityRepository<Alumno, Long> {

}