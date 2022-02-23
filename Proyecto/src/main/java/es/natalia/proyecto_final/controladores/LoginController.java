package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.servicios.AlumnoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Path("/login")
@Controller
@RequestScoped
public class LoginController {

    @Inject
    AlumnoService alumnoService;

    // Crear la sesión para el control de datos
    @Inject
    HttpServletRequest request;

    @Path("/")
    @GET
    public String index() {
        return "sesion/login";
    }

    @POST
    @Path("/login")
    public String index(@FormParam(value="codigo") String codigo, @FormParam(value="contrasena") String contrasena) {
        System.out.println(codigo + "/" + contrasena);

        try{
            Alumno alumno = alumnoService.buscarAlumno(codigo);

            if(alumno != null){
                if(alumno.getContrasena().equals(contrasena)){
                        HttpSession session = request.getSession();
                        session.setAttribute("alumno", alumno.getCodigoAlumno());
                        session.setAttribute("alumno", alumno.getCodigoAlumno());

                        System.out.println(session.getAttribute("alumno"));

                    // Redirect porque es otro controller
                    return "redirect:mundos/mundo";
                }else{
                    // Codigo error contraseña
                    return "sesion/login";
                }
            }
        }catch (NoResultException e){
            // Codigo si usuario está mal
            System.out.println(e);
            return "sesion/login";
        }

        return "sesion/login";
    }


}
