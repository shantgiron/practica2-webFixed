<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Práctica #2</title>
</head>
<body>
<form action="/editar/${estudiante.getMatriculaFormateada()}" method="post">
    <div>
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" value="${estudiante.getNombre()}">
    </div>
    <div>
        <label for="nombre">Apellido:</label>
        <input type="text" name="apellido" value="${estudiante.getApellido()}">
    </div>
    <div>
        <label for="nombre">Telefono:</label>
        <input type="text" name="telefono" value="${estudiante.getTelefono()}">
    </div>
    <div>
        <label for="nombre">Matrícula:</label>
        <input type="text" name="matricula" value="${estudiante.getMatriculaFormateada()}" readonly>
    </div>
    <div>
        <button type="submit">Actualizar</button>
        <a href="/estudiantes">Ver todos los estudiantes registrados</a>
    </div>
</form>
</body>
</html>