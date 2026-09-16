package upsjb.chiawayagro.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnosticos")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

    private String especieDetectada;

    @ManyToOne
    @JoinColumn(name = "plaga_id")
    private PlagaEnfermedad plagaEnfermedad;

    private Double nivelConfianza;
    private boolean escalado;
}
