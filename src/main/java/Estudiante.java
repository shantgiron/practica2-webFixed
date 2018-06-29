import java.io.Serializable;

public class Estudiante implements Serializable {
    private String nombre;
    private String apellido;
    private int matricula;
    private String telefono;

    public Estudiante() {
    }


    public Estudiante(String nombre, String apellido, int matricula, String telefono) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMatriculaFormateada() {
        return this.matricula + "";
    }

}

