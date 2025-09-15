package P_AbstracFactory;

public class EnvioNormal implements MetodoEnvio {

    @Override
    public void enviar() {
        System.out.println("Envío normal");
    }

}
