package es.natalia.proyecto_final.dao;

import es.natalia.proyecto_final.entidades.Alumno;

public class ProfesorDAOImpl extends GenericDAOImpl<Alumno, Long> implements ProfesorDAO {

    public ProfesorDAOImpl(Class<Alumno> entityClass) {
        super(entityClass);
    }


    @Override
    public Integer listadoDeAlumnos(Long idProfesor) {
        return em.createQuery("SELECT count(p) FROM Alumno p WHERE p.profesor.id=:idPro", Integer.class)
                .setParameter("idPro", idProfesor)
                .getSingleResult();
    }
}
