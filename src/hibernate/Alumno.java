package hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Alumno implements Serializable {
    int idAlumno, edad;
    String nombre, nacionalidad, sexo, modulo;
    //ArrayList <String> arrayListModulos = new ArrayList<String>();


    public Alumno(){
        this.nombre="Nombre";
        this.nacionalidad="Nacionalidad";
        this.edad=00;
        this.sexo="Sexo";
        this.modulo="modulo";
        //arrayListModulos.add(modulo);
    }

    public Alumno(String nombre, String nacionalidad, int edad, String sexo, String modulo){
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
        this.edad=edad;
        this.sexo=sexo;
        this.modulo=modulo;
        //arrayListModulos.add(modulo);

    }


    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int  getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    /*public ArrayList getArrayListModulos() {
        return arrayListModulos;
    }

    public void setArrayListModulos(ArrayList arrayListModulos) {
        this.arrayListModulos = arrayListModulos;
    }*/

    @Override
    public String toString() {
        return "Alumno {" +
                "idAlumno = " + idAlumno +
                " -- Nombre = " + nombre +
                ", Nacionalidad = "+nacionalidad+
                ", Edad = "+edad+
                ", Sexo = "+sexo+
                "\n     Módulos = "+modulo;
    }
}