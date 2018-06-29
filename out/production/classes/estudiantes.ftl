<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Practica #2</title>
</head>
<body>
    <div>
        <a href="/nuevoestudiante">Agregar estudiante</a>
    </div>
    <div>
        <table>
            <thead>
            <tr>
                <td>Nombre</td>
                <td>Apellido</td>
                <td>Telefono</td>
                <td>Matricula</td>
                <td>Acción</td>
            </tr>
            </thead>
            <tbody>
            <#list estudiantes as estudiante>
            <tr>
                <td>${estudiante.getNombre()}</td>
                <td>${estudiante.getApellido()}</td>
                <td>${estudiante.getTelefono()}</td>
                <td>${estudiante.getMatriculaFormateada()}</td>
                <td><a href="/editar/${estudiante.getMatriculaFormateada()}">Editar</a><br><a
                        href="/borrar/${estudiante.getMatriculaFormateada()}">Borrar</a></td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</body>
</html>