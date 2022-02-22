# Proyecto JPA/Hibernate: Documentación del despliegue

*Realizado por Natalia Cristóbal Rodríguez*

## 1. Introducción del proyecto

Mi propuesta para este proyecto sería crear una web con temática interactiva donde se enseña a los niños programación básica, con una dinámica parecida a un videojuego de preguntas y respuestas. Por cada nivel desbloqueado se puede ir avanzando a los siguientes y desbloquear recompensas aleatorias.

*Al estar enfocado de cara al TFG, esto sería una fase inicial simple. La estética y mecanismo de los test y lecciones.*

## 2. Despliegue del proyecto


## 3. Dinámica de uso

#### 3.1. Acceso

La aplicación comienza con una pantalla de inicio, en la cual puedes iniciar sesión o crear una cuenta nueva.

**Las cuentas disponibles para iniciar sesión son:**
 
 - Código del alumno: A001 / Contraseña: flora123

 - Código del alumno: A002 / 

**Para crear una cuenta nueva simplemente habría que clickar en el botón Sign Up:**
 
  - Introducir el nombre del usuario.

  - Introducir la contraseña de acceso.

   - Elegir un icono de perfil.

   - Elegir el profesor.

El código de alumno se generará automaticamente y se añadirá a la base de datos en función del profesor escogido.

#### 3.2. Control de mundos

Una vez inicias sesión con una cuenta, podrás acceder a la pantalla de mundos. Estos se cargarán en función de si están desbloqueados con el usuario que está conectado.
