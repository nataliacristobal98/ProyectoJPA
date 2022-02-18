package es.natalia.proyecto_final.dao;

import es.natalia.proyecto_final.entidades.Nivel;

import java.util.List;

public interface NivelDAO extends GenericDAO<Nivel, Long>{

    // Busca listado de niveles
    List<Nivel> buscarNiveles(Long idMundo);
}
