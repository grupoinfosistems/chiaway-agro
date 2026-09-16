package upsjb.chiawayagro.dto;

/** Respuesta enviada al cliente con el resultado del diagnóstico. */
public class RespuestaDiagnosticoDTO {
    private String especieDetectada;
    private String plagaOEnfermedad;
    private Double nivelConfianza;
    private boolean escalado;
    private String recomendacion;
}
