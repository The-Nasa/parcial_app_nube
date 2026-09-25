# Spec 01: Visión General del Sistema y Casos de Uso (SDD)

## 1. Información General del Proyecto
- **Proyecto:** Derrepente Tourist Forecast System
- **Ubicación:** Catarata Derrepente, Parque Nacional Tingo María, Huánuco, Perú (`-9.2942, -76.0003`).
- **Arquitectura:** Contenedores aislados con Docker (Backend Java Spring Boot 3 + Frontend React + Nginx).
- **Base de Datos:** **PostgreSQL Container / Supabase PostgreSQL** (Contenedor Dockerizado PostgreSQL 15 con auto-inicialización DDL & Seeder).
- **Integración Externa:** Weather API (OpenWeatherMap / WeatherAPI) para datos en tiempo real de Tingo María.
- **Despliegue:** AWS EC2 orquestado con GitHub Actions CI/CD.

---

## 2. Definición del Problema
La Catarata Derrepente requiere predecir la afluencia diaria de visitantes combinando el pronóstico del clima con datos históricos de visitas, días de la semana, feriados locales (Fiesta de San Juan) y temporadas climáticas (Seca vs Lluvias).

---

## 3. Matriz de Casos de Uso

```mermaid
usecaseDiagram
    actor Turista as Turista / Operador Turístico
    actor Sistema as Sistema Backend Java
    database Supabase as Supabase DB

    Turista --> (UC-01: Consultar Pronóstico y Afluencia Estimada)
    Turista --> (UC-02: Consultar Gráfico Histórico de Visitas)
    Sistema --> (UC-03: Registrar Logs de Predicciones en Supabase)
    Sistema --> (UC-04: Consumir API de Clima con Caché 30min)
```
