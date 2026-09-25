# Spec Agent 01: Especificación del Agente Backend Java

**Rol:** Senior Java & Spring Boot Developer Agent  
**Entradas:** `spec/backend/*.md`, `spec/database/*.md`.  
**Entregable:** Proyecto completo Java Spring Boot 3 en la carpeta `backend/`.

## Instrucciones del Agente Backend:
1. Configurar Spring Data JPA con driver PostgreSQL para conectarse a Supabase DB.
2. Implementar los controladores REST `/api/v1/predictions/forecast` y `/api/v1/history`.
3. Integrar cliente HTTP para consumir OpenWeatherMap/WeatherAPI con coordenadas Tingo María (`-9.2942, -76.0003`) y caché de 30 minutos.
4. Implementar el algoritmo de predicción y guardar el log en Supabase DB.
5. Crear `backend/Dockerfile` multi-stage.
