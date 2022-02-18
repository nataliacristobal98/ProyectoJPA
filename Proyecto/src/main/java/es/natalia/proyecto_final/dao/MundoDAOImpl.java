package es.natalia.proyecto_final.dao;

import es.natalia.proyecto_final.entidades.Mundo;

public class MundoDAOImpl extends GenericDAOImpl<Mundo, Long> implements MundoDAO {

    public MundoDAOImpl(Class<Mundo> entityClass) {
        super(entityClass);
    }

}
