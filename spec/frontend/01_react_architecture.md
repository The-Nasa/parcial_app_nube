# Spec Frontend 01: Arquitectura React + Vite

## 1. Stack Tecnológico Frontend
- **Framework/Build:** React 18 + Vite
- **Cliente HTTP:** Axios / Fetch
- **Visualización de Datos:** Recharts / Chart.js
- **Iconografía:** Lucide React / FontAwesome Icons
- **Estilos:** Vanilla CSS con Variables HSL / Tailwind CSS

---

## 2. Estructura del Proyecto Frontend (`frontend/src/`)

```
src/
├── assets/
│   ├── derrepente_hero.jpg    # Imagen Catarata Derrepente
│   └── weather_icons/
├── components/
│   ├── Header.jsx             # Bar superior branding
│   ├── DateSelector.jsx       # Picker interactivo
│   ├── WeatherCard.jsx        # Tarjeta del clima Tingo María
│   ├── PredictionCard.jsx     # Tarjeta afluencia de personas
│   ├── SafetyBanner.jsx       # Banner de seguridad y riesgos
│   ├── HistoryChart.jsx       # Gráfico afluencia vs clima
│   └── Footer.jsx
├── services/
│   └── apiService.js          # Llamadas Axios a Spring Boot Backend
├── hooks/
│   └── useForecast.js         # Custom Hook con estado de carga, data y error
├── App.jsx
├── main.jsx
└── index.css                  # Design Tokens, variables HSL, temas
```
