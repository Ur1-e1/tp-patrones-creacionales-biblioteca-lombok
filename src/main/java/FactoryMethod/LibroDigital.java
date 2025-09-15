package FactoryMethod;

import lombok.Data;

@Data

public class LibroDigital implements LibroIntarface {
    private String nombre;
    private String autor;

    public LibroDigital(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    
    public String getNombre() {
        return nombre;
    }

    public String getAutor(){
        return autor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarTipo() {
        System.out.println("Soy un libro digital");
    }

    public void setautor(String autor) {
        this.autor = autor;
    }
   
}
