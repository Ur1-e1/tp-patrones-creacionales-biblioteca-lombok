package P_AbstracFactory;

public class EnvioExpress implements MetodoEnvio {

    @Override
    public void enviar() {
        System.out.println("Envío express");
    }

}
