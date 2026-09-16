# Chiaway Agro — Asistente Fitosanitario IA

Sistema inteligente integrador para la automatización del diagnóstico fitosanitario
mediante agentes inteligentes y visión artificial (https://chiaway.com).

**Universidad Privada San Juan Bautista — Facultad de Ingeniería — Escuela Profesional de Ingeniería de Sistemas**
Ciclo X — 2026

## Integrantes
- Andrade Chávez Jhon Allinson
- Ávalos Yataco Melani Yanet
- Felipa Márquez Harol
- Guanilo Ramos Ronaldo Paul
- Valencia Carpio Ayrton


## Stack tecnológico

- **Backend:** Spring Boot 3.3 (Java 17), arquitectura en capas (controlador / servicio / repositorio / modelo)
- **Base de datos:** MySQL
- **Visión artificial:** API Pl@ntNet + filtro de calidad de imagen con OpenCV
- **Clima:** API Open-Meteo
- **Agente inteligente:** LLM (GPT-4o mini)
- **Frontend:** Widget embebido en chiaway.com (HTML/CSS/JS)

## Paquete base

```
upsjb.chiawayagro
```

## Estructura de carpetas

```
src/main/java/upsjb/chiawayagro/
├── controlador/      Endpoints REST (Autenticacion, Consulta, Diagnostico, Usuario, CasoAdministrador)
├── servicio/         Logica de negocio (calidad de imagen, clima, agente IA, escalamiento)
├── repositorio/       Acceso a datos (Spring Data JPA)
├── modelo/            Entidades JPA (Usuario, Consulta, Diagnostico, PlagaEnfermedad, Tratamiento, RegistroClima)
├── dto/               Objetos de transferencia de datos
└── configuracion/     Configuracion (seguridad, CORS)
```

