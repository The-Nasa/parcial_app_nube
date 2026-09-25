import React from 'react';
import { Compass, Sparkles } from 'lucide-react';

export const Header = () => {
  return (
    <header style={{
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'space-between',
      paddingBottom: '1.5rem',
      borderBottom: '1px solid rgba(255, 255, 255, 0.08)'
    }}>
      <div style={{ display: 'flex', alignItems: 'center', gap: '0.8rem' }}>
        <div style={{
          background: 'linear-gradient(135deg, var(--emerald-jungle), var(--cyan-waterfall))',
          padding: '0.6rem',
          borderRadius: '14px',
          display: 'flex'
        }}>
          <Compass size={28} color="#ffffff" />
        </div>
        <div>
          <h1 style={{ fontSize: '1.6rem', fontWeight: 700, letterSpacing: '-0.02em' }}>
            Derrepente Tourist Forecast
          </h1>
          <p style={{ color: 'var(--text-muted)', fontSize: '0.9rem' }}>
            Catarata Derrepente • Parque Nacional Tingo María, Huánuco
          </p>
        </div>
      </div>
      <div className="badge badge-moderate">
        <Sparkles size={14} /> Spec-Driven AI Agent System
      </div>
    </header>
  );
};
