# Spec Frontend 03: Sistema de Diseño y Tema HSL (Tingo María)

## 1. Tokens de Color HSL (Naturaleza & Catarata)

```css
:root {
  /* Fondos Oscuros Selva Nocturna */
  --bg-primary: hsl(222, 47%, 11%);      /* #0B132B */
  --bg-card: hsl(223, 39%, 18%);         /* #1C2541 */
  --bg-card-hover: hsl(223, 35%, 23%);

  /* Acentos de Naturaleza */
  --green-emerald: hsl(150, 75%, 42%);  /* #10B981 Selva */
  --cyan-waterfall: hsl(190, 90%, 50%); /* #06B6D4 Catarata Derrepente */
  --accent-sun: hsl(45, 93%, 47%);       /* Sol Tingo María */

  /* Estados y Alertas */
  --alert-danger: hsl(0, 84%, 60%);     /* Lluvia Torrencial / Peligro */
  --alert-warning: hsl(38, 92%, 50%);   /* Precaución Lluvia */

  /* Tipografía */
  --font-family: 'Outfit', 'Inter', system-ui, sans-serif;
  --text-primary: hsl(0, 0%, 98%);
  --text-secondary: hsl(215, 20%, 75%);
}
```

---

## 2. Animaciones y Efectos Glassmorphism
- Tarjetas con bordes sutiles `border: 1px solid rgba(255, 255, 255, 0.1);`.
- `backdrop-filter: blur(12px);` para sensación transparente moderna.
- Microanimaciones `@keyframes fadeIn` y `@keyframes pulseGlow`.
