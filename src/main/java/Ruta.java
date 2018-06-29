import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Ruta {
    //Para crear todas las rutas a utilizar
    public Ruta() {
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Ruta.class, "/");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        Crud crud = new Crud();

        port(getPuertoHeroku());

        get("/", (request, response) -> {
            response.redirect("/estudiantes");
            return null;
        });

        //Ruta para ver todos los estudiantes
        get("/estudiantes", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiantes", crud.obtenerTodosEstudiantes());

            return new ModelAndView(attributes, "estudiantes.ftl");
        }, freeMarkerEngine);

        //Ruta para crear un nuevo estudiante
        get("/nuevoestudiante", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();


            return new ModelAndView(attributes, "nuevoestudiante.ftl");
        }, freeMarkerEngine);

        //Ruta para crear un nuevo estudiante via post
        post("/nuevoestudiante", (request, response) -> {
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");
            int matricula = Integer.parseInt(request.queryParams("matricula"));

            crud.crearEstudiante(nombre, apellido, matricula, telefono);

            response.redirect("/estudiantes");
            return null;
        });

        //Ruta para borrar un estudiante via get
        get("/borrar/:matricula", (request, response) -> {
            int matricula = Integer.parseInt(request.params("matricula"));

            crud.eliminarEstudiante(matricula);

            response.redirect("/estudiantes");
            return null;
        });

        //Ruta para editar un estudiante
        get("/editar/:matricula", (request, response) -> {
            int matricula = Integer.parseInt(request.params("matricula"));

            Estudiante estudiante = crud.obtenerEstudiante(matricula);

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);

            return new ModelAndView(attributes, "editarestudiante.ftl");
        }, freeMarkerEngine);

        //Ruta para actualizar un estudiante via post
        post("/editar/:matricula", (request, response) -> {
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");
            int matricula = Integer.parseInt(request.queryParams("matricula"));

            crud.editarEstudiante(matricula, nombre, apellido, telefono);

            response.redirect("/estudiantes");
            return null;
        });
    }

    private int getPuertoHeroku() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //En caso de no pasar la información, toma el puerto 4567
    }
}
