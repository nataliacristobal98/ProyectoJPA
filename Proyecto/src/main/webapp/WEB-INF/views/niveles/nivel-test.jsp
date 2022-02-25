<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en" class="h-100">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>5 - Test</title>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js.js"></script>

    <!-- CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/cover.css" rel="stylesheet">

</head>

<body class="d-flex h-100 text-dark bg-light">

<div class="cover-container d-flex p-3 flex-column w-100">

    <header class="mb-auto text-dark">
        <div class="text-dark">
            <a href="${mvc.basePath}/portada" class="text-dark">
                <h3 class="float-md-start mb-0">Cover</h3>
            </a>

            <nav class="nav nav-masthead float-md-end">
                <a href="${mvc.basePath}/mundos/mundo" class="nav-link active" aria-current="page" href="#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" class="bi bi-globe2" viewBox="0 0 16 16">
                        <path d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm7.5-6.923c-.67.204-1.335.82-1.887 1.855-.143.268-.276.56-.395.872.705.157 1.472.257 2.282.287V1.077zM4.249 3.539c.142-.384.304-.744.481-1.078a6.7 6.7 0 0 1 .597-.933A7.01 7.01 0 0 0 3.051 3.05c.362.184.763.349 1.198.49zM3.509 7.5c.036-1.07.188-2.087.436-3.008a9.124 9.124 0 0 1-1.565-.667A6.964 6.964 0 0 0 1.018 7.5h2.49zm1.4-2.741a12.344 12.344 0 0 0-.4 2.741H7.5V5.091c-.91-.03-1.783-.145-2.591-.332zM8.5 5.09V7.5h2.99a12.342 12.342 0 0 0-.399-2.741c-.808.187-1.681.301-2.591.332zM4.51 8.5c.035.987.176 1.914.399 2.741A13.612 13.612 0 0 1 7.5 10.91V8.5H4.51zm3.99 0v2.409c.91.03 1.783.145 2.591.332.223-.827.364-1.754.4-2.741H8.5zm-3.282 3.696c.12.312.252.604.395.872.552 1.035 1.218 1.65 1.887 1.855V11.91c-.81.03-1.577.13-2.282.287zm.11 2.276a6.696 6.696 0 0 1-.598-.933 8.853 8.853 0 0 1-.481-1.079 8.38 8.38 0 0 0-1.198.49 7.01 7.01 0 0 0 2.276 1.522zm-1.383-2.964A13.36 13.36 0 0 1 3.508 8.5h-2.49a6.963 6.963 0 0 0 1.362 3.675c.47-.258.995-.482 1.565-.667zm6.728 2.964a7.009 7.009 0 0 0 2.275-1.521 8.376 8.376 0 0 0-1.197-.49 8.853 8.853 0 0 1-.481 1.078 6.688 6.688 0 0 1-.597.933zM8.5 11.909v3.014c.67-.204 1.335-.82 1.887-1.855.143-.268.276-.56.395-.872A12.63 12.63 0 0 0 8.5 11.91zm3.555-.401c.57.185 1.095.409 1.565.667A6.963 6.963 0 0 0 14.982 8.5h-2.49a13.36 13.36 0 0 1-.437 3.008zM14.982 7.5a6.963 6.963 0 0 0-1.362-3.675c-.47.258-.995.482-1.565.667.248.92.4 1.938.437 3.008h2.49zM11.27 2.461c.177.334.339.694.482 1.078a8.368 8.368 0 0 0 1.196-.49 7.01 7.01 0 0 0-2.275-1.52c.218.283.418.597.597.932zm-.488 1.343a7.765 7.765 0 0 0-.395-.872C9.835 1.897 9.17 1.282 8.5 1.077V4.09c.81-.03 1.577-.13 2.282-.287z"/>
                    </svg>
                </a>

                <a href="${mvc.basePath}/perfil" class="nav-link text-white">
                    <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" class="bi bi-person-video2" viewBox="0 0 16 16">
                        <path d="M10 9.05a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z" />
                        <path d="M2 1a2 2 0 0 0-2 2v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2H2ZM1 3a1 1 0 0 1 1-1h2v2H1V3Zm4 10V2h9a1 1 0 0 1 1 1v9c0 .285-.12.543-.31.725C14.15 11.494 12.822 10 10 10c-3.037 0-4.345 1.73-4.798 3H5Zm-4-2h3v2H2a1 1 0 0 1-1-1v-1Zm3-1H1V8h3v2Zm0-3H1V5h3v2Z" />
                    </svg>
                </a>

                <div class="text-end mx-4">
                    <a href="${mvc.basePath}/login" class="btn btn-outline-dark me-2">Login</a>
                    <a href="${mvc.basePath}/signup" class="btn btn-danger">Sign-up</a>
                </div>
            </nav>
        </div>
    </header>


    <main>
        <div class="col-12 mt-3">


            <div class="card mb-4 rounded-3 shadow-sm">

                <div class="card-body">
                    <h3>Test</h3>

                    <form action="" method="post" id="formulario">
                    <c:forEach var="pregunta" items="${preguntas}">
                        <div class="card-header rounded-3 py-3">
                            <h3 class="my-0 fw-normal text-center">${pregunta.textoPregunta}</h3>
                        </div>
                        <div class="card-body">

                            <div class="row m-3 justify-content-center">
                            <c:forEach var="respuesta" items="${respuestas}">
                                <c:choose>
                                    <c:when test="${respuesta.pregunta.id == pregunta.id}">
                                            <div class="col-5 card-header m-2 rounded-3">
                                                <div class="form-check" id="${respuesta.id}">
                                                    <input class="form-check-input" type="radio" value="${respuesta.correcta}" name="${pregunta.codigoPregunta}" id="${respuesta.id}" required>
                                                    <label class="form-check-label" for="${pregunta.codigoPregunta}">
                                                            ${respuesta.textoRespuesta}
                                                    </label>
                                                </div>
                                            </div>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                            </div>



                        </div>
                    </c:forEach>

                        <div class=" text-center">
                            <button class="btn bg-danger text-white">Enviar</button>
                        </div>
                    </form>



                </div>


            </div>





        </div>
    </main>

    <footer class="mt-auto text-center">
        <p>Si quieres apoyar nuestro trabajo: <a href="${mvc.basePath}/donacion" class="text-danger">Donaciones</a></p>
    </footer>
</div>



</body>

</html>