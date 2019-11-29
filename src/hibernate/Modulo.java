package hibernate;
import java.io.Serializable;

public class Modulo implements Serializable {
    int idModulo;
    String nombre;
    String codigo;

    public Modulo(String nombre, String codigo){
        this.nombre=nombre;
        this.codigo=codigo;
    }

    public int getIdProfesor() {
        return idModulo;
    }

    public void setIdModulo(int idProfesor) {
        this.idModulo = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Módulo {" +
                "idModulo = " + idModulo +
                " -- Nombre = " + nombre +
                ", Código = "+codigo;
    }
}