package Prototype;
import P1_Singleton.*;
import Builder.Usuario;
import lombok.Data;

@Data
public class Prestamo implements Cloneable {

    private Libro libro;
    private Usuario usuario;
    private String fechaInicio;
    private String fechaFin;

    public Prestamo(Libro libro, Usuario usuario, String fechaInicio, String fechaFin) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    
    }

    public void mostrarPrestamo() {
        System.out.println("Préstamo:");
        System.out.println("Libro: " + libro);
        System.out.println("Usuario: " + usuario);
        System.out.println("Fecha de Inicio: " + fechaInicio);
        System.out.println("Fecha de Fin: " + fechaFin);
    }

    @Override
    public Prestamo clone() {
        try {
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar el préstamo", e);
        }
    }
}
