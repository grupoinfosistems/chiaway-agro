package upsjb.chiawayagro.modelo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String urlImagen;
    private String canal; // WEB
    private LocalDateTime fechaCreacion;
    private String estado; // PENDIENTE, RESUELTA_IA, ESCALADA, RESPONDIDA_ESPECIALISTA
}
