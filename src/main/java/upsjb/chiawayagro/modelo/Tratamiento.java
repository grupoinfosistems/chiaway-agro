package upsjb.chiawayagro.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "tratamientos")
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plaga_id")
    private PlagaEnfermedad plagaEnfermedad;

    private String nombreProducto;
    private String ingredienteActivo;
    private String dosis;
    private String metodoAplicacion;
}
