# Guía de Agentes e Instrucciones de Desarrollo SDD

Este documento detalla cómo los **Agentes de IA** (Backend Agent, Frontend Agent y DevOps Agent) deben consumir las especificaciones modulares en la carpeta `spec/` para construir la solución completa containerizada con **Docker**.

---

## 1. Estructura de Especificaciones (SDD Map)

1. [`spec/01_system_overview.md`](file:///c:/Users/ThikPad/Desktop/MESE%20VIII/DESARROLLO%20DE%20APLICACIONES%20PARA%20LA%20NUBE/parcial_1/spec/01_system_overview.md): Visión general, contexto geográfico Tingo María, casos de uso.
2. [`spec/02_backend_java_spec.md`](file:///c:/Users/ThikPad/Desktop/MESE%20VIII/DESARROLLO%20DE%20APLICACIONES%20PARA%20LA%20NUBE/parcial_1/spec/02_backend_java_spec.md): Arquitectura de paquetes, cliente API de Clima, servicios, controladores REST y DTOs Java 17.
3. [`spec/03_frontend_react_spec.md`](file:///c:/Users/ThikPad/Desktop/MESE%20VIII/DESARROLLO%20DE%20APLICACIONES%20PARA%20LA%20NUBE/parcial_1/spec/03_frontend_react_spec.md): Arquitectura de componentes React, Hook `useForecast`, diseño visual HSL selva/catarata y gráficos.
4. [`spec/04_prediction_algorithm_spec.md`](file:///c:/Users/ThikPad/Desktop/MESE%20VIII/DESARROLLO%20DE%20APLICACIONES%20PARA%20LA%20NUBE/parcial_1/spec/04_prediction_algorithm_spec.md): Fórmula matemática ponderada de estimación de afluencia.
5. [`spec/05_docker_devops_spec.md`](file:///c:/Users/ThikPad/Desktop/MESE%20VIII/DESARROLLO%20DE%20APLICACIONES%20PARA%20LA%20NUBE/parcial_1/spec/05_docker_devops_spec.md): Configuración de Dockerfiles multi-stage, `docker-compose.yml` y pipeline CI/CD GitHub Actions a AWS EC2.

---

## 2. Prompts para la Ejecución con Agentes

### A. Agente Backend Java Spring Boot
> **Instrucción para Agente:**  
> Lee las especificaciones en `spec/01_system_overview.md`, `spec/02_backend_java_spec.md` y `spec/04_prediction_algorithm_spec.md`.  
> Genera la estructura completa de código en la carpeta `backend/` con Java 17, Spring Boot, cliente HTTP para la API de clima, servicio de predicción, seeder de datos de prueba e inclusión del `Dockerfile` multi-stage.

---

### B. Agente Frontend React
> **Instrucción para Agente:**  
> Lee las especificaciones en `spec/01_system_overview.md` y `spec/03_frontend_react_spec.md`.  
> Genera la aplicación React + Vite en la carpeta `frontend/`, implementando los componentes `DateSelector`, `WeatherCard`, `PredictionCard`, `SafetyBanner` y `HistoryChart`, consumiendo los endpoints REST definidos en la especificación del backend. Incluye también el `Dockerfile` para servir con Nginx.

---

### C. Agente DevOps (Docker & AWS EC2)
> **Instrucción para Agente:**  
> Lee `spec/05_docker_devops_spec.md`.  
> Crea el archivo `docker-compose.yml` en la raíz del proyecto para orquestar los contenedores backend y frontend, y el archivo `.github/workflows/deploy.yml` para desplegar automáticamente mediante SSH en AWS EC2.
