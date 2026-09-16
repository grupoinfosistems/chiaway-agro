package upsjb.chiawayagro.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
    private String correo;
    private String celular;
    private String contrasenaHash;

    @Enumerated(EnumType.STRING)
    private Rol rol; // CLIENTE, ESPECIALISTA, ADMINISTRADOR

    public enum Rol { CLIENTE, ESPECIALISTA, ADMINISTRADOR }

    // Los getters y setters se implementarán en la fase de desarrollo.
}
