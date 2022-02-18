package es.natalia.proyecto_final.dao;

import es.natalia.proyecto_final.entidades.Alumno;

import java.util.List;
import java.util.Optional;

public class AlumnoDAOImpl extends GenericDAOImpl<Alumno, Long> implements AlumnoDAO {

    public AlumnoDAOImpl(Class<Alumno> entityClass) {
        super(entityClass);
    }

    @Override
    public Integer puntuacionPorNivel(Long nivel, Alumno alumno) {
        return null;
    }

    @Override
    public Integer puntuacionTotal(Long alumno) {
        return null;
    }
}
