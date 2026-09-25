# Spec Frontend 02: Especificación de Componentes UI/UX

## 1. Detalle de Componentes Visuales

### 1.1 `DateSelector.jsx`
- Input de fecha HTML5 `<input type="date">` con límites dinámicos (`min=hoy`, `max=hoy+7d`).
- Botones de selección rápida: "Hoy", "Mañana", "Sábado", "Domingo".

### 1.2 `WeatherCard.jsx`
- Muestra temperatura en °C (ej: `28.5 °C`), lluvia en milímetros (`1.2 mm`), probabilidad de lluvia, humedad y viento.
- Estado climático ilustrado con íconos animados.

### 1.3 `PredictionCard.jsx`
- Métrica destacada en texto gigante: `135 Visitantes Estimados`.
- Badge dinámico con color HSL según la afluencia (`BAJA`, `MODERADA`, `ALTA`, `MUY_ALTA`).
- Recomendaciones de viaje personalizadas.

### 1.4 `SafetyBanner.jsx`
- Componente de alerta de peligro con fondo rojo/amarillo cuando `safetyStatus` sea `PRECAUCION` o `ALERTA_PELIGRO`.

### 1.5 `HistoryChart.jsx`
- Gráfico de áreas/líneas interactivo renderizando datos pasados desde Supabase (`/api/v1/history`).
