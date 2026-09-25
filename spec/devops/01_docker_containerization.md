# Spec DevOps 01: Containerización con Docker & Docker Compose

## 1. `backend/Dockerfile` Multi-Stage
```dockerfile
# Stage 1: Build
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## 2. `frontend/Dockerfile` Multi-Stage
```dockerfile
# Stage 1: Build React App
FROM node:18-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm ci
COPY . .
RUN npm run build

# Stage 2: Serve Nginx
FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```

---

## 3. `docker-compose.yml` (Raíz del proyecto)
```yaml
version: '3.8'

services:
  backend:
    build:
      context: ./backend
      dockerfile: Dockerfile
    container_name: derrepente-backend
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=prod
      - SUPABASE_HOST=${SUPABASE_HOST}
      - SUPABASE_USER=${SUPABASE_USER}
      - SUPABASE_PASSWORD=${SUPABASE_PASSWORD}
      - WEATHER_API_KEY=${WEATHER_API_KEY}
    restart: always

  frontend:
    build:
      context: ./frontend
      dockerfile: Dockerfile
    container_name: derrepente-frontend
    ports:
      - "80:80"
    depends_on:
      - backend
    restart: always
```
