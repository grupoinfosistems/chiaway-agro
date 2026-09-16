package upsjb.chiawayagro.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Expone el resultado del diagnóstico generado por el Asistente IA
 * (especie, anomalía, nivel de confianza y recomendación de tratamiento).
 */
@RestController
@RequestMapping("/api/diagnosticos")
public class ControladorDiagnostico {
    // GET /{idConsulta} -> obtener diagnóstico de una consulta
}
