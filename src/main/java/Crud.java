import java.util.LinkedList;
import java.util.List;

public class Crud {
    private static List<Estudiante> estudiantes;

    public Crud(){
        estudiantes = new LinkedList<Estudiante>();
        estudiantes.add(new Estudiante("Shantall", "Giron", 20130940, "8095820034"));
    }

    public List<Estudiante> obtenerTodosEstudiantes(){
        return estudiantes;
    }

    public Estudiante obtenerEstudiante(int matricula){
        Estudiante estudiante = null;
        for(Estudiante estudiante1 : estudiantes){
            if(estudiante1.getMatricula() == matricula){
                estudiante = estudiante1;
            }
        }
        return estudiante;
    }

    public Estudiante crearEstudiante(String nombre, String apellido, int matricula, String telefono){
        Estudiante estudiante = new Estudiante(nombre, apellido, matricula, telefono);
        estudiantes.add(estudiante);
        return estudiante;
    }

    public Estudiante editarEstudiante(int matricula, String nombre, String apellido, String telefono){
        Estudiante estudiante = null;
        for(Estudiante estudiante1 : estudiantes){
            if(estudiante1.getMatricula() == matricula){
                estudiante1.setNombre(nombre);
                estudiante1.setApellido(apellido);
                estudiante1.setTelefono(telefono);
                estudiante = estudiante1;
            }
        }

        return estudiante;
    }

    public void eliminarEstudiante(int matricula){
        Estudiante estudiante = null;
        for(Estudiante estudiante1 : estudiantes){
            if(estudiante1.getMatricula() == matricula){
                estudiante = estudiante1;
            }
        }
        if(estudiante != null){
            estudiantes.remove(estudiante);
        }
    }
}