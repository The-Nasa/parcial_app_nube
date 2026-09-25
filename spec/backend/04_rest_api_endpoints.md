# Spec Backend 04: Endpoints REST API y Contratos DTO

## Base URL: `/api/v1`

### 1. `GET /predictions/forecast`
- **Query Param:** `date` (ISO `YYYY-MM-DD`, opcional)
- **Response `200 OK`:**
```json
{
  "location": "Catarata Derrepente, Tingo María",
  "date": "2026-09-28",
  "weather": {
    "tempCelsius": 28.5,
    "condition": "Parcialmente Nublado",
    "icon": "partly-cloudy",
    "rainProbabilityPercentage": 20.0,
    "precipitationMm": 1.2,
    "humidityPercentage": 75.0,
    "windKmH": 12.0
  },
  "prediction": {
    "estimatedVisitors": 135,
    "confidencePercentage": 88,
    "crowdLevel": "MODERADA",
    "season": "TEMPORADA_SECA",
    "isWeekend": true,
    "isHoliday": false,
    "safetyStatus": "SEGURO",
    "recommendation": "Día ideal para disfrutar de la Catarata Derrepente. Llevar calzado antideslizante."
  }
}
```

---

### 2. `GET /history`
- **Query Param:** `limit` (Integer, default 30)
- **Response `200 OK`:** Registros de Supabase DB `historical_attendance`.
