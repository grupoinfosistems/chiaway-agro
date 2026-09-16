package upsjb.chiawayagro.modelo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Respuesta manual que un especialista registra para una consulta escalada
 * (cuando la confianza del modelo de IA fue menor al 70%).
 */
@Entity
@Table(name = "respuestas_especialista")
public class RespuestaEspecialista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "especialista_id")
    private Usuario especialista;

    private String diagnosticoConfirmado;
    private String recomendacion;
    private LocalDateTime fechaRespuesta;
}
