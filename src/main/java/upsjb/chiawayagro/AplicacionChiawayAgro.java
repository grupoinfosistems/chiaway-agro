package upsjb.chiawayagro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada del Sistema Inteligente de Diagnóstico Fitosanitario - Chiaway Agro.
 *
 * Semana 4: solo se declara la estructura por capas (controlador, servicio,
 * repositorio, modelo, dto, configuracion). Aún no se implementa lógica de negocio.
 */
@SpringBootApplication
public class AplicacionChiawayAgro {

    public static void main(String[] args) {
        SpringApplication.run(AplicacionChiawayAgro.class, args);
    }
}
