package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.repositorio.AlumnoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AlumnoService {

    @Inject
    AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> buscarPorId(Long id) {
        return alumnoRepository.findOptionalBy(id);
    }

    public void guardar(Alumno alumno){alumnoRepository.save(alumno);}

    public Alumno buscarAlumno(String codigo){return alumnoRepository.findByCodigoAlumno(codigo);}
}
