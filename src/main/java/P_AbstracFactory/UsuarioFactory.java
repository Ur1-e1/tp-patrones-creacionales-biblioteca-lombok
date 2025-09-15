package P_AbstracFactory;

public class UsuarioFactory implements AbstractFactory {

    @Override
    public InterfaceUI crearIU() {
        return new UsuarioIU();
    }

    @Override
    public MetodoEnvio crearEnvio() {
        return new EnvioNormal();
    }

}
