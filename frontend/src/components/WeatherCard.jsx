import React from 'react';
import { Sun, CloudRain, Thermometer, Wind, Droplets } from 'lucide-react';

export const WeatherCard = ({ weather }) => {
  if (!weather) return null;

  const isRainy = weather.precipitationMm > 0;

  return (
    <div className="glass-card fade-in" style={{ display: 'flex', flexDirection: 'column', gap: '1rem' }}>
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
        <h3 style={{ color: 'var(--text-muted)', fontSize: '0.95rem', fontWeight: 500 }}>Pronóstico del Clima (Tingo María)</h3>
        {isRainy ? <CloudRain color="var(--cyan-waterfall)" size={28} /> : <Sun color="var(--amber-sun)" size={28} />}
      </div>

      <div style={{ display: 'flex', alignItems: 'baseline', gap: '0.6rem' }}>
        <span style={{ fontSize: '3rem', fontWeight: 800, background: 'linear-gradient(to right, #ffffff, var(--cyan-waterfall))', WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent' }}>
          {weather.tempCelsius}°C
        </span>
        <span style={{ color: 'var(--text-muted)', fontWeight: 500, fontSize: '1.1rem' }}>
          {weather.condition}
        </span>
      </div>

      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '0.8rem', paddingTop: '0.8rem', borderTop: '1px solid rgba(255,255,255,0.06)' }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', fontSize: '0.85rem', color: 'var(--text-muted)' }}>
          <CloudRain size={16} color="var(--cyan-waterfall)" />
          <span>Precipitación: <strong style={{ color: '#fff' }}>{weather.precipitationMm} mm</strong></span>
        </div>
        <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', fontSize: '0.85rem', color: 'var(--text-muted)' }}>
          <Droplets size={16} color="var(--emerald-jungle)" />
          <span>Humedad: <strong style={{ color: '#fff' }}>{weather.humidityPercentage}%</strong></span>
        </div>
        <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', fontSize: '0.85rem', color: 'var(--text-muted)' }}>
          <Wind size={16} color="var(--text-muted)" />
          <span>Viento: <strong style={{ color: '#fff' }}>{weather.windKmH} km/h</strong></span>
        </div>
        <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', fontSize: '0.85rem', color: 'var(--text-muted)' }}>
          <Thermometer size={16} color="var(--amber-sun)" />
          <span>Sensación: <strong style={{ color: '#fff' }}>Templado</strong></span>
        </div>
      </div>
    </div>
  );
};
