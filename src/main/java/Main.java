import spark.Spark;

import static spark.debug.DebugScreen.enableDebugScreen;

public class Main {
    public static void main(String[] args) {
        //Para leer los archivos que estan en resources
        Spark.staticFileLocation("/");

        //Para hacer debug en development
        enableDebugScreen();

        new Crud();

        new Ruta();
    }
}