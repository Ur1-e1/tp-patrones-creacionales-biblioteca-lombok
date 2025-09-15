package Builder;
import java.util.Date;
import lombok.ToString;

@ToString
public class Usuario {

    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private Date fechaNacimiento;

    //Constructor privado para forzar el uso del Builder
    private Usuario(UsuarioBuilder builder) {
        this.nombre = builder.nombre;
        this.email = builder.email;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
        this.fechaNacimiento = builder.fechaNacimiento;
    }

    //Clase Builder interna y estatica
    public static class UsuarioBuilder {
        private String nombre;
        private String email;
        private String direccion;
        private String telefono;
        private Date fechaNacimiento;

        public UsuarioBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public UsuarioBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UsuarioBuilder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public UsuarioBuilder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public UsuarioBuilder setFechaNacimiento(Date fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }


}
