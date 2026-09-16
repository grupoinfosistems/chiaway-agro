package upsjb.chiawayagro.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Gestión del perfil del cliente registrado.
 */
@RestController
@RequestMapping("/api/usuarios")
public class ControladorUsuario {
    // GET  /mi-perfil    -> perfil del usuario autenticado
    // PUT  /mi-perfil    -> actualizar datos de perfil
}
