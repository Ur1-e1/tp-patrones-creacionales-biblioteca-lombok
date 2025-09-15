package FactoryMethod;

public class LogisticaLibro {

    public static LibroIntarface crearLibro(String tipo, String nombre, String autor) {
        if (tipo.equalsIgnoreCase("fisico")) {
            return new LibroFisico(nombre, autor);
        } else if (tipo.equalsIgnoreCase("digital")) {
            return new LibroDigital(nombre, autor);
        } else {
            throw new IllegalArgumentException("Tipo de libro no soportado: " + tipo);
        }
    }

}
 //Aca es donde se crea el metodo fabrica que segun el parametro que le pase me devuelve un tipo de libro u otro, por eso el tipo es importante en esta parte
 //ademas de que este metodo esta enfocado en mejorar la escalabilidad y bajar el acoplamiento para hacerlo mas versatiil