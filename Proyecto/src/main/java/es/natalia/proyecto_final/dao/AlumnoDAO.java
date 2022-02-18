package es.natalia.proyecto_final.dao;

import es.natalia.proyecto_final.entidades.Alumno;

public interface AlumnoDAO extends GenericDAO<Alumno, Long>{

    // Pasa el id del nivel y el Alumno
    Integer puntuacionPorNivel(Long nivel, Alumno alumno);

    // Pasa el id del alumno
    Integer puntuacionTotal(Long alumno);

}
