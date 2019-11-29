package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.io.*;
import java.util.List;

public class HibernateMain {


    public static void main(String[] args){
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //COMENZAMOS NUESTRA TANSACCIÓN: EJECUTAMOS LAS QUERIES
        //Creamos 3 objetos en cada una de las tres clases (que serán 3 tablas en nuestra BBDD)
        Alumno a = new Alumno("Victor","español",31,"masculino");
        Profesor p = new Profesor ("Minerva","femenino");
        Modulo m = new Modulo ("Acceso a Datos","M06");

        //Guardamos cada objeto en cada una de nuestras tablas (clases)
        session.save(a);
        session.save(p);
        session.save(m);

        //Guardamos los objetos creados en un fichero
        //Recibimos por parámetros el objeto creado, y el fichero donde los guardaremos
        guardaEnFicheroBinario(a, "Registro.dat");
        guardaEnFicheroBinario(p, "Registro.dat");
        guardaEnFicheroBinario(m, "Registro.dat");

        leerFicheroBinario("Registro.dat");

        /*Query query = session.createQuery("FROM Alumno WHERE nombre =:nombre");
        query.setParameter("nombre","Juanito de las Arenas");
        List list = query.list();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }*/

        //LANZAMOS LAS QUERIES
        tx.commit();
        //CERRAMOS
        session.close();
        sessionFactory.close();
    }

    public static <T> void guardaEnFicheroBinario (T objeto, String registro){
        try{
            File archivo = new File (registro);
            FileOutputStream salida = new FileOutputStream(archivo);
            ObjectOutputStream flujo = new ObjectOutputStream(salida);

            flujo.writeObject(objeto);

            flujo.flush();
            flujo.close();
            salida.flush();
            salida.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("ERROR. No se ha podido escribir en el fichero");
        }
    }

    public static void leerFicheroBinario (String registro){
        try{
            File archivo = new File (registro);
            FileInputStream entrada = new FileInputStream(archivo);
            ObjectInputStream flujo = new ObjectInputStream(entrada);

            System.out.println("La lectura del objeto es la siguiente:" +
                    "/n---------------------------------------/n");
            System.out.println(flujo.readObject());

            flujo.close();
            entrada.close();

        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("ERROR. No se encuentra el fichero "+registro);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("ERROR. No se puede leer el fichero");
        }
    }



}