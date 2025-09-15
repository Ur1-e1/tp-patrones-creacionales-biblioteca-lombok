package P_AbstracFactory;

public class AdminFactory implements AbstractFactory {

    @Override
    public InterfaceUI crearIU() {
        return new AdminIU();
    }

    @Override
    public MetodoEnvio crearEnvio() {
        return new EnvioExpress();
    }

}
