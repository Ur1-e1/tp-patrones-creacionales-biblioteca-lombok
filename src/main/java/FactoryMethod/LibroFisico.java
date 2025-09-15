package FactoryMethod;
import lombok.*;

@Data

public class LibroFisico implements LibroIntarface {
    private String nombre;
    private String autor;

    public LibroFisico(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    public void mostrarTipo() {
        System.out.println("Soy un libro de tipo físico");
    }
}
