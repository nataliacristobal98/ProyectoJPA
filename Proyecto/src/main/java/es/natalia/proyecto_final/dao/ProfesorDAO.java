package es.natalia.proyecto_final.dao;

import es.natalia.proyecto_final.entidades.Alumno;

public interface ProfesorDAO extends GenericDAO<Alumno, Long>{

    // Pasas el id del profesor
    Integer listadoDeAlumnos(Long idProfesor);

}
