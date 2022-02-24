package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.servicios.AlumnoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Path("/perfil")
@Controller
@RequestScoped
public class PerfilAlumnoController {

    @Inject
    private Models models;

    @Inject
    AlumnoService alumnoService;

    @Inject
    HttpServletRequest request;

    public static Long convertToLong(Object o){
        String stringToConvert = String.valueOf(o);
        Long convertedLong = Long.parseLong(stringToConvert);
        return convertedLong;

    }

    @Path("/")
    @GET
    public String index() {
        HttpSession session = request.getSession();

        try {
            if (session.getAttribute("iniciada").equals(true)) {
                Long id = convertToLong(session.getAttribute("id"));

                Alumno alumno = alumnoService.buscarPorId(id);

                models.put("alumno", alumno);
                return "usuarios/perfil-alumno";
            }
        }catch (NullPointerException e){
            // Si no hay una sesión, se permite el acceso a crear una
            return "redirect:login";
        }

        return "redirect:login";
    }

    @Path("/desconectar")
    @GET
    public String desconectar(){

        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:login";
    }

}
