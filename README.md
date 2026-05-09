# Sistema de Gestión de Residencias e Incidencias

Backend API desarrollada con Spring Boot y MySQL para la administración de comunidades residenciales.

## 1. Descripción del Proyecto
Este proyecto es una API REST diseñada para gestionar la estructura de condominios. Permite la administración de ubicaciones (Regiones y Comunas), la creación de Residencias, la gestión de Usuarios y la asignación de estos a sus respectivos hogares. Además, incluye un sistema para el reporte y seguimiento de incidencias.

## 2. Estudiantes
* **Estudiante 1:** Matias Alejandro Contreras 
* **Estudiante 2:** Joel Etienn Sangster
* **Estudiante 3:** Román Valentino Oliva

## 3. Funcionalidades Implementadas
* **Módulo Geográfico:** Registro de Regiones y Comunas.
* **Módulo de Inmuebles:** Gestión de Residencias y su vinculación geográfica.
* **Módulo de Usuarios:** Registro de datos personales y contacto.
* **Módulo de Asignaciones:** Relación dinámica entre Residentes y Residencias mediante `@PathVariable`.
* **Módulo de Incidencias:** (En implementación) Gestión de tipos de incidencia y reportes.

## 4. Requisitos
* Java 17 o superior.
* Maven.
* MySQL (Recomendado Laragon).
* Postman para pruebas.

## 5. Pasos para ejecutar
1. **Base de Datos:** Iniciar MySQL y crear la base de datos `db_gestion`.
2. **Propiedades:** Revisar `src/main/resources/application.properties` para asegurar que el usuario y contraseña de la BD son correctos.
3. **Compilación:** Ejecutar `mvn clean install` o simplemente dar a "Run" en la clase principal desde VS Code.
4. **Acceso:** La API corre por defecto en `http://localhost:8080/api/v1/`.

## 6. Endpoints Principales
* `GET /api/v1/region`: Listar regiones.
* `POST /api/v1/comuna`: Crear comuna (requiere objeto region).
* `POST /api/v1/residencias/residencia/{resId}/usuario/{userId}`: Asignar usuario a residencia.
