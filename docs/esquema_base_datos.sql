-- ==========================================================
-- Chiaway Agro - Asistente Fitosanitario IA
-- Script de creacion de tablas (MySQL 8)
-- Corresponde a las entidades del paquete upsjb.chiawayagro.modelo
-- ==========================================================

CREATE DATABASE IF NOT EXISTS chiaway_agro
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE chiaway_agro;

CREATE TABLE usuarios (
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_completo   VARCHAR(150) NOT NULL,
    correo            VARCHAR(150) UNIQUE,
    celular           VARCHAR(20),
    contrasena_hash   VARCHAR(255) NOT NULL,
    rol               ENUM('CLIENTE', 'ESPECIALISTA', 'ADMINISTRADOR') NOT NULL
) ENGINE=InnoDB;

CREATE TABLE consultas (
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id        BIGINT NOT NULL,
    url_imagen        VARCHAR(500),
    canal             VARCHAR(20) DEFAULT 'WEB',
    fecha_creacion    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    estado            ENUM('PENDIENTE', 'RESUELTA_IA', 'ESCALADA', 'RESPONDIDA_ESPECIALISTA')
                        NOT NULL DEFAULT 'PENDIENTE',
    CONSTRAINT fk_consultas_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
) ENGINE=InnoDB;

CREATE TABLE plagas_enfermedades (
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_comun        VARCHAR(150) NOT NULL,
    nombre_cientifico   VARCHAR(150),
    descripcion         TEXT,
    nivel_severidad     VARCHAR(20)
) ENGINE=InnoDB;

CREATE TABLE diagnosticos (
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    consulta_id         BIGINT NOT NULL UNIQUE,
    especie_detectada   VARCHAR(150),
    plaga_id            BIGINT,
    nivel_confianza     DECIMAL(5,2) NOT NULL,
    escalado            BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_diagnosticos_consulta FOREIGN KEY (consulta_id) REFERENCES consultas(id),
    CONSTRAINT fk_diagnosticos_plaga FOREIGN KEY (plaga_id) REFERENCES plagas_enfermedades(id)
) ENGINE=InnoDB;

CREATE TABLE tratamientos (
    id                    BIGINT AUTO_INCREMENT PRIMARY KEY,
    plaga_id              BIGINT NOT NULL,
    nombre_producto        VARCHAR(150) NOT NULL,
    ingrediente_activo     VARCHAR(150),
    dosis                  VARCHAR(150),
    metodo_aplicacion      VARCHAR(255),
    CONSTRAINT fk_tratamientos_plaga FOREIGN KEY (plaga_id) REFERENCES plagas_enfermedades(id)
) ENGINE=InnoDB;

CREATE TABLE registros_clima (
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    consulta_id       BIGINT NOT NULL UNIQUE,
    temperatura       DECIMAL(5,2),
    humedad           DECIMAL(5,2),
    CONSTRAINT fk_clima_consulta FOREIGN KEY (consulta_id) REFERENCES consultas(id)
) ENGINE=InnoDB;

CREATE TABLE codigos_verificacion (
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id          BIGINT NOT NULL,
    codigo              VARCHAR(6) NOT NULL,
    fecha_creacion      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_expiracion    DATETIME NOT NULL,
    usado               BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_codigos_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
) ENGINE=InnoDB;

CREATE TABLE respuestas_especialista (
    id                        BIGINT AUTO_INCREMENT PRIMARY KEY,
    consulta_id               BIGINT NOT NULL UNIQUE,
    especialista_id           BIGINT NOT NULL,
    diagnostico_confirmado    VARCHAR(255),
    recomendacion             TEXT,
    fecha_respuesta           TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_respuestas_consulta FOREIGN KEY (consulta_id) REFERENCES consultas(id),
    CONSTRAINT fk_respuestas_especialista FOREIGN KEY (especialista_id) REFERENCES usuarios(id)
) ENGINE=InnoDB;

-- Regla de negocio: umbral minimo de confianza para diagnostico automatico.
-- Si diagnosticos.nivel_confianza < 0.70, diagnosticos.escalado debe ser TRUE,
-- consultas.estado debe pasar a 'ESCALADA', y el caso queda pendiente de que
-- un usuario con rol ESPECIALISTA registre una fila en respuestas_especialista.
-- (logica implementada en ServicioEscalamiento y ControladorCasoAdministrador).