package P1_Singleton;
import lombok.Data;

@Data

public class Libro {
    private String Nombre;
    private int CodLibro;
    private static int contadorLibros = 0; //Contador de la calse para el contador de las instacias

    public Libro() {
        contadorLibros++;
        this.CodLibro = contadorLibros;
    }

    public Libro(String nombre) {
        contadorLibros++;
        this.CodLibro = contadorLibros;
        this.Nombre = nombre;
    }

    public Libro(int codLibro, String nombre) {
        CodLibro = codLibro;
        Nombre = nombre;
    }

    public int getCodLibro() {
        return CodLibro;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}

