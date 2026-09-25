# Spec Agent 05: Especificación del Agente Evaluador de Calidad SDD

**Rol:** SDD Spec Quality & QA Auditor Agent  
**Entradas:** Todas las carpetas dentro de `spec/`.  
**Entregable:** Informe de auditoría SDD y validación de entrega.

## Instrucciones del Agente de Calidad SDD:
1. Verificar que **ningún agente cree código fuente sin antes tener una especificación en `spec/`**.
2. Garantizar que los DTOs definidos en `spec/backend/` coincidan exactamente con lo que consume `spec/frontend/`.
3. Probar la integración de Supabase DB con el backend antes del despliegue en AWS EC2.
