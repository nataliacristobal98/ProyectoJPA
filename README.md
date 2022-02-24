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

 - Código del alumno: A002 / Contraseña: mArtE_08

**Para crear una cuenta nueva simplemente habría que clickar en el botón Sign Up:**
 
  - Introducir el nombre del usuario.

  - Introducir la contraseña de acceso.

   - Elegir un icono de perfil.

   - Elegir el profesor.

El código de alumno se generará automaticamente y se añadirá a la base de datos en función del profesor escogido.

Una vez iniciada la sesión, se podrá acceder al perfil de usuario, donde se especifica los datos del usuario. 

En esta, también se podrá consultar el código de alumno para el inicio de las sesiones, los nuevos usuarios serán redirigidos directamente a esta pantalla para que vean dicho código.

#### 3.2. Control de mundos y niveles

Una vez inicias sesión con una cuenta, podrás acceder a la pantalla de mundos. Estos se cargarán en función de si están desbloqueados con el usuario que está conectado.

Se podrá seleccionar nivel de la misma forma, y cada uno de estos cuenta con una lección y un test relacionado.

El test tiene un mecanismo de preguntas y respuestas, un formulario donde se debe seleccionar la opción correcta y se anotará los puntos obtenidos tanto en el perfil de jugador como en la BD. 

Estos puntos desbloquearán los siguientes niveles y mundos mediante consultas entre sí.
