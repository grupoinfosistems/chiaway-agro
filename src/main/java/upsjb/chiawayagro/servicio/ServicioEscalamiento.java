package upsjb.chiawayagro.servicio;

import org.springframework.stereotype.Service;

/**
 * Evalúa el nivel de confianza del diagnóstico de IA. Si es menor al 70%,
 * deriva la consulta a un especialista humano en lugar de emitir un diagnóstico automático.
 */
@Service
public class ServicioEscalamiento {
    public static final double UMBRAL_CONFIANZA = 0.70;
}
