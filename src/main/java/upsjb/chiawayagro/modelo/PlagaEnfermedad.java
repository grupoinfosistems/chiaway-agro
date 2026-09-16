package upsjb.chiawayagro.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "plagas_enfermedades")
public class PlagaEnfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreComun;
    private String nombreCientifico;
    private String descripcion;
    private String nivelSeveridad;
}
