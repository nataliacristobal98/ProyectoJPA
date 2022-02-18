package es.natalia.proyecto_final.dao;

import es.natalia.proyecto_final.entidades.Nivel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;

import java.util.List;

@ApplicationScoped
public class NivelDAOImpl  extends GenericDAOImpl<Nivel, Long> implements NivelDAO {

    public NivelDAOImpl(Class<Nivel> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Nivel> buscarNiveles(Long idMundo) {
        Query consultaQuery = em.createQuery("SELECT n FROM Nivel n WHERE n.mundo = :idMundo");

        consultaQuery.setParameter("idMundo", idMundo);

        List<Nivel> niveles = consultaQuery.getResultList();
        return niveles;
    }
}
