package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.dao.NivelDAO;
import es.natalia.proyecto_final.dao.NivelDAOImpl;
import es.natalia.proyecto_final.entidades.Mundo;
import es.natalia.proyecto_final.entidades.Nivel;
import es.natalia.proyecto_final.repositorio.MundoRepository;
import es.natalia.proyecto_final.repositorio.NivelRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MundoService {

    @Inject
    MundoRepository mundoRepository;

    @Inject
    NivelRepository nivelRepository;

    public List<Mundo> findAll() {
        return mundoRepository.findAll();
    }

    public Optional<Mundo> buscarPorId(Long id) {
        return mundoRepository.findOptionalBy(id);
    }

    public void guardar(Mundo mundo){mundoRepository.save(mundo);}

    // La busqueda del listado de niveles
    public List<Nivel> buscarNiveles(Mundo mundo) {
        return nivelRepository.findByMundo(mundo);
    }

}
