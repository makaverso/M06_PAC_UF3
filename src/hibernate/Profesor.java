package hibernate;
import java.io.Serializable;

public class Profesor implements Serializable {
    int idProfesor;
    String nombre, sexo;

    public Profesor (String nombre, String sexo){
        this.nombre=nombre;
        this.sexo=sexo;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Profesor {" +
                "idProfesor = " + idProfesor +
                " -- Nombre = " + nombre +
                ", Sexo = "+sexo;
    }
}