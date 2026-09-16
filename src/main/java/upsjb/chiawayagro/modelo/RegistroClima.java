package upsjb.chiawayagro.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "registros_clima")
public class RegistroClima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

    private Double temperatura;
    private Double humedad;
}
