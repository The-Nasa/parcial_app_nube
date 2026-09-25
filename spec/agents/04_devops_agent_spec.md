# Spec Agent 04: Especificación del Agente DevOps & Cloud Deployment

**Rol:** DevOps & Cloud Deployment Agent  
**Entradas:** `spec/devops/*.md`.  
**Entregable:** `docker-compose.yml` y `.github/workflows/deploy.yml`.

## Instrucciones del Agente DevOps:
1. Validar la compilación multi-stage en Docker para Backend y Frontend.
2. Orquestar contenedores con `docker-compose.yml` en la raíz del repositorio.
3. Configurar el pipeline CI/CD en GitHub Actions para despliegue por SSH en AWS EC2.
