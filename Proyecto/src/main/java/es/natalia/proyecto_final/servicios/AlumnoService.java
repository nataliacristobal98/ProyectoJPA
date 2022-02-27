package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.entidades.Mundo;
import es.natalia.proyecto_final.repositorio.AlumnoRepository;
import es.natalia.proyecto_final.repositorio.MundoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AlumnoService {

    @Inject
    AlumnoRepository alumnoRepository;

    @Inject
    MundoRepository mundoRepository;

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno buscarPorId(Long id) {
        return alumnoRepository.findBy(id);
    }

    public void guardar(Alumno alumno){

        // Comprobar puntos y desbloqueos
        /*
        List<Mundo> mundos = mundoRepository.findAll();
        for (int i = 0; i < mundos.size() -1; i++) {
            if(alumno.getPuntos() >= mundos.get(i).getPuntosDesbloqueo()){
                alumno.setMundos(mundos.get(i));
            }
        }
        */

        alumnoRepository.save(alumno);
    }

    public Alumno buscarAlumno(String codigo){return alumnoRepository.findByCodigoAlumno(codigo);}
}
