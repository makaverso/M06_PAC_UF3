package BaseDatos;

import java.sql.*;

public class BDJava {

    private String BBDD = "jdbc:mysql://localhost:3306/M06";
    private String USER = "root";
    private String PASS = "ThePassword";


    public void connectToBD() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection(BBDD, USER, PASS);
        Statement sentencia = connect.createStatement();
        //CREAMOS LA BASE DE DATOS
        String crearDB = "CREATE DATABASE M06;";
        sentencia.executeUpdate(crearDB);
        //CREAMOS LA TABLA ALUMNOS
        String crearTabla = "USE M06; CREATE TABLE Alumnos(id_alumno INT AUTO_INCREMENT PRIMARY KEY, nombre varchar(255) NOT NULL);";
        sentencia.executeUpdate(crearTabla);
        //REALIZAMOS LA CONSULTA
        String consulta = "Select * from Alumnos";
        ResultSet result = sentencia.executeQuery(consulta);
        while (result.next()) {
            System.out.println("ID: " + result.getInt(1) + ", Nombre: " + result.getString(2));
        }

        result.close();
        sentencia.close();
        connect.close();

    }

}
