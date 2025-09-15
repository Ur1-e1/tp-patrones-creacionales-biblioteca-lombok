package org.example;
import FactoryMethod.LogisticaLibro;
import Builder.Usuario;
import FactoryMethod.LibroIntarface;
import P1_Singleton.DataBase;
import P1_Singleton.Libro;
import P_AbstracFactory.*;
import Prototype.Prestamo;




public class Main {
   
    public static void main(String[] args) {

    //Punto 1 singleton
        //1.	Crear la clase Database como Singleton.
        System.out.println("\n=== PRUEBA SINGLETON ===");
        DataBase db1 = P1_Singleton.DataBase.getInstance();
        //Ahora voy a ver si la instancia es la misma
        DataBase db2 = P1_Singleton.DataBase.getInstance();
        
        //2.Implementar métodos para agregar y listar libros.
        Libro libro1 = new Libro("El Principito");
        Libro libro2 = new Libro("1984");
        Libro libro3 = new Libro("Fahrenheit 451");
        db1.añadirLibroBD(libro1);
        db1.añadirLibroBD(libro2);
        db1.añadirLibroBD(libro3);
        for (Libro libro: db1.getLibros()) {
            System.out.println(libro.getNombre());
        }

        //3.	Probar que múltiples llamadas devuelvan la misma instancia.
        System.out.println("\n¿Son la misma instancia? " + (db1 == db2));
        System.out.println("Contador de instancias de DataBase: " + P1_Singleton.DataBase.getContadorBD());         

    //Fin Punto 1

    //Parte 2 method factory

        //Objetivo: Crear diferentes tipos de libros sin acoplar el cliente a la clase concreta.
        //1. Crear la interfaz Libro y las clases concretas LibroFisico y LibroDigital.
            //Esto ya lo hice en los archivos correspondientes.

        //2. Crear el método fábrica en LogisticaLibro que devuelva la instancia correcta según un parámetro.
            //Tambien, esto ya esta hecho, pero tengo una duda, si cuando llamo el metodo y paso el tipo pero con mayuscula, lo tomara? ya que se evalua con misuculas

        //3. Probar la creación de varios libros y mostrar su tipo en consola.
        System.out.println("\n=== PRUEBA FACTORY METHOD ===");
        
        // Crear varios libros usando el factory method
        LibroIntarface libroFisico1 = LogisticaLibro.crearLibro("FISICO", "Don Quijote", "Miguel de Cervantes");
        LibroIntarface libroDigital1 = LogisticaLibro.crearLibro("digital", "El Señor de los Anillos", "J.R.R. Tolkien");

        // Mostrar el tipo de cada libro
        System.out.println("Libro 1:");
        libroFisico1.mostrarTipo();
        System.out.println("Libro 2:");
        libroDigital1.mostrarTipo();
    //Fin Parte 2 
    
    //Parte 3 – Abstract Factory
        System.out.println("\n=== PRUEBA ABSTRACT FACTORY ===");
        //Objetivo: Crear familias de objetos relacionados (ej: UI o métodos de envío) según el tipo de usuario.
        //1. Crear interfaces InterfazUI y MetodoEnvio.
        //2. Implementar AdminUI/UsuarioUI y EnvioNormal/EnvioExpress.
        //3. Crear AbstractFactory y fábricas concretas (AdminFactory, UsuarioFactory).
        //4. Usar la fábrica para crear objetos correctos según el tipo de usuario y mostrar información en consola.

        AbstractFactory adminFactory = new AdminFactory(); //En esta parte elijo que fabrica voy a usar 
        InterfaceUI adminUI = adminFactory.crearIU(); //Esta es la parte del patron donde yo solo pido objetos a la fabrica y no le mando la clase concreta
        MetodoEnvio adminEnvio = adminFactory.crearEnvio();
        adminUI.mostrarUI();
        adminEnvio.enviar();

        AbstractFactory usuarioFactory = new UsuarioFactory();
        InterfaceUI usuarioUI = usuarioFactory.crearIU();       
        MetodoEnvio usuarioEnvio = usuarioFactory.crearEnvio();
        usuarioUI.mostrarUI();
        usuarioEnvio.enviar();
    //Fin Parte 3

    //Parte 4 – Builder
    //Objetivo: Construir objetos complejos de manera clara y flexible.
    //Tareas:
        //1. Crear la clase Usuario con atributos opcionales: nombre, email, dirección, teléfono, fecha de nacimiento.
        //2. Implementar la clase Usuario.Builder para construir instancias.
        //3. Crear al menos 2 usuarios con distintos atributos y mostrar la información.
      
        System.out.println("\n=== PRUEBA BUILDER ===");
        Usuario usuario1 = new Usuario.UsuarioBuilder()
            .setNombre("Juan")
            .setDireccion("Tupungato Mendoza")
            .build();

        Usuario usuario2 = new Usuario.UsuarioBuilder()
            .setNombre("Ana")
            .setEmail("Ana@gmail.com")
            .setTelefono("123456789")
            .build();

        Usuario usuario3 = new Usuario.UsuarioBuilder()
            .setNombre("Pedro")
            .setTelefono("987654321")
            .build();

        System.out.println(usuario1);
        System.out.println(usuario2);
        System.out.println(usuario3);
    //Fin Parte 4

    //Parte 5 – Prototype
        //Objetivo: Clonar objetos existentes para crear nuevos objetos similares.
        System.out.println("\n=== PRUEBA PROTOTYPE ===");
        //1. Crear la clase Prestamo con atributos: libro, usuario, fechaInicio, fechaFin.
        //2. Implementar clone() (shallow o deep).
        //3. Crear un prestamo prototipo y clonar al menos dos veces, modificando solo algunos atributos.

        Prestamo prestamoOriginal = new Prestamo (libro1, usuario1, "2024-10-01", "2024-10-15");
        Prestamo prestamoClonado1 = prestamoOriginal.clone();

        //Cambiarmos algunos atributos del clon
        prestamoClonado1.setFechaInicio("12/12/2024");
        Prestamo prestamoClonado2 = prestamoOriginal.clone();
        prestamoOriginal.mostrarPrestamo();
        prestamoClonado1.mostrarPrestamo();
        prestamoClonado2.mostrarPrestamo();
        //4. Mostrar en consola que los clones son independientes del original.
    //Fin Parte 5    

    }
}