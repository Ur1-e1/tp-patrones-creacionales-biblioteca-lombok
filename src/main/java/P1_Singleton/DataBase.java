package P1_Singleton;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    // Instancia única de la clase (Singleton), osea clase guarda una única instancia de Database
    private static DataBase instance;
    private List<Libro> libros;
    private static int contadorBD = 0;  //Se me ocurre esto para saber que me devuelve la misma instancia cada vez

    // Constructor privado para evitar instanciación directa
    private DataBase() {
        // Inicialización de la base de datos
        this.libros = new ArrayList<>();
        System.out.println("Base de datos inicializada");
    }

    //Para poder visualizar en las pruebas 
    public static int getContadorBD() {
        return contadorBD;
    }

    // Método público para obtener la instancia única
    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase(); //Sí nunca se creó la instancia se crea xd
            DataBase.contadorBD ++;
        }
        return instance; //Sino se devuelve la instancia que fue creada
    }
    
    //Método para agregar libros a la lista de libros
    public void añadirLibroBD(Libro libro){
        if (libro != null) {
            libros.add(libro);
            System.out.println("Libro '" + libro.getNombre() + "' agregado a la base de datos con código: " + libro.getCodLibro());
        } else {
            System.out.println("Error: No se puede agregar un libro nulo a la base de datos");
        }
    }

    public List<Libro> getLibros() {
        return libros;
    }

    // Métodos de ejemplo para la base de datos
    public void conectar() {
        System.out.println("Conectando a la base de datos...");
    }
    
    public void desconectar() {
        System.out.println("Desconectando de la base de datos...");
    }


}
