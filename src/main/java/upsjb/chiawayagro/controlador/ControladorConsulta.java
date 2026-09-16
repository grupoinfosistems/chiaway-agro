package upsjb.chiawayagro.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Recepción de la fotografía del cliente e inicio del flujo de diagnóstico.
 */
@RestController
@RequestMapping("/api/consultas")
public class ControladorConsulta {
    // POST /              -> crear nueva consulta (subir imagen)
    // GET  /{id}           -> ver detalle de una consulta
    // GET  /mis-consultas  -> historial de consultas del cliente autenticado
}
