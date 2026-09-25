import React from 'react';
import { Calendar } from 'lucide-react';

export const DateSelector = ({ selectedDate, onDateChange }) => {
  const todayStr = new Date().toISOString().split('T')[0];

  const getOffsetDate = (days) => {
    const d = new Date();
    d.setDate(d.getDate() + days);
    return d.toISOString().split('T')[0];
  };

  return (
    <div className="glass-card" style={{ marginTop: '1.5rem', display: 'flex', alignItems: 'center', justifyContent: 'space-between', flexWrap: 'wrap', gap: '1rem' }}>
      <div style={{ display: 'flex', alignItems: 'center', gap: '0.6rem' }}>
        <Calendar color="var(--cyan-waterfall)" size={22} />
        <span style={{ fontWeight: 600 }}>Seleccionar Fecha de Viaje:</span>
      </div>

      <div style={{ display: 'flex', alignItems: 'center', gap: '0.8rem', flexWrap: 'wrap' }}>
        <input
          type="date"
          value={selectedDate || todayStr}
          min={todayStr}
          onChange={(e) => onDateChange(e.target.value)}
          style={{
            background: 'var(--bg-dark-primary)',
            color: 'var(--text-main)',
            border: '1px solid rgba(255,255,255,0.15)',
            padding: '0.5rem 1rem',
            borderRadius: '10px',
            fontFamily: 'inherit',
            fontSize: '0.95rem',
            outline: 'none',
            cursor: 'pointer'
          }}
        />

        <div style={{ display: 'flex', gap: '0.4rem' }}>
          <button
            onClick={() => onDateChange(todayStr)}
            style={buttonStyle(selectedDate === todayStr)}
          >
            Hoy
          </button>
          <button
            onClick={() => onDateChange(getOffsetDate(1))}
            style={buttonStyle(selectedDate === getOffsetDate(1))}
          >
            Mañana
          </button>
          <button
            onClick={() => onDateChange(getOffsetDate(2))}
            style={buttonStyle(selectedDate === getOffsetDate(2))}
          >
            En 2 Días
          </button>
        </div>
      </div>
    </div>
  );
};

const buttonStyle = (isActive) => ({
  background: isActive ? 'var(--cyan-waterfall)' : 'rgba(255, 255, 255, 0.06)',
  color: isActive ? '#ffffff' : 'var(--text-muted)',
  border: 'none',
  padding: '0.5rem 0.9rem',
  borderRadius: '8px',
  cursor: 'pointer',
  fontWeight: 600,
  fontSize: '0.85rem',
  transition: 'all 0.2s ease'
});
