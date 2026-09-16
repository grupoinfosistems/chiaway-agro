package upsjb.chiawayagro.modelo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Código de un solo uso (OTP) para la verificación en dos pasos (2FA)
 * durante el registro o inicio de sesión del cliente.
 */
@Entity
@Table(name = "codigos_verificacion")
public class CodigoVerificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String codigo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaExpiracion;
    private boolean usado;
}
