package upsjb.chiawayagro.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Panel del especialista: casos escalados (confianza IA menor a 70%) y respuesta manual.
 */
@RestController
@RequestMapping("/api/administrador/casos")
public class ControladorCasoAdministrador {
    // GET  /escalados        -> listar casos escalados pendientes
    // POST /{id}/responder   -> registrar diagnóstico y tratamiento manual del especialista
}
