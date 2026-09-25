# Spec Backend 03: Algoritmo de Predicción de Afluencia Turística

## 1. Fórmula de Estimación
$$V_{est} = \text{round}\left( V_{base} \times F_{clima} \times F_{dia} \times F_{estacion} \times F_{feriado} \right)$$

- **Visitas Base (\(V_{base}\)):** 50 personas/día.
- **Factor Climático (\(F_{clima}\)):**
  - Soleado (\(P = 0\) mm): **1.45**
  - Parcialmente Nublado (\(0 < P \le 2\) mm): **1.10**
  - Lluvia Ligera (\(2 < P \le 8\) mm): **0.55**
  - Lluvia Moderada (\(8 < P \le 20\) mm): **0.25**
  - Lluvia Torrencial / Tormenta (\(P > 20\) mm): **0.05**
- **Factor Día de Semana (\(F_{dia}\)):** Lunes-Jueves (1.00), Viernes (1.30), Sábado (2.25), Domingo (2.65).
- **Factor Estacional (\(F_{estacion}\)):** Temporada Seca Mayo-Octubre (1.35), Lluvias Noviembre-Abril (0.65).
- **Factor Feriado (\(F_{feriado}\)):** Día normal (1.00), Fiesta San Juan 24 Junio / Fiestas Patrias (2.80), Feriados Generales (2.10).

---

## 2. Niveles de Concurrencia y Alertas
- `< 60 personas`: `BAJA` (Color Verde)
- `60 - 150 personas`: `MODERADA` (Color Azul)
- `151 - 250 personas`: `ALTA` (Color Naranja)
- `> 250 personas`: `MUY_ALTA` (Color Púrpura)

**Alerta de Seguridad Catarata:**
- Si `precipitation_mm > 20.0` -> `ALERTA_PELIGRO`: "Acceso restringido por crecida del río en la Catarata Derrepente."
