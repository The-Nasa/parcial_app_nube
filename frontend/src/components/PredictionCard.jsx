import React from 'react';
import { Users, Info, ShieldCheck } from 'lucide-react';

export const PredictionCard = ({ prediction, date }) => {
  if (!prediction) return null;

  const getBadgeClass = (level) => {
    switch (level) {
      case 'BAJA': return 'badge-low';
      case 'MODERADA': return 'badge-moderate';
      case 'ALTA': return 'badge-high';
      default: return 'badge-very-high';
    }
  };

  return (
    <div className="glass-card fade-in" style={{ display: 'flex', flexDirection: 'column', gap: '1.2rem', background: 'linear-gradient(135deg, rgba(20, 28, 49, 0.8), rgba(6, 182, 212, 0.12))' }}>
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
        <h3 style={{ color: 'var(--text-muted)', fontSize: '0.95rem', fontWeight: 500 }}>Afluencia Estimada de Visitantes</h3>
        <Users color="var(--emerald-jungle)" size={28} />
      </div>

      <div>
        <div style={{ display: 'flex', alignItems: 'baseline', gap: '0.8rem' }}>
          <span style={{ fontSize: '3.5rem', fontWeight: 800, color: '#ffffff', letterSpacing: '-0.03em' }}>
            {prediction.estimatedVisitors}
          </span>
          <span style={{ color: 'var(--text-muted)', fontWeight: 600, fontSize: '1.2rem' }}>
            personas estimadas
          </span>
        </div>

        <div style={{ marginTop: '0.5rem', display: 'flex', gap: '0.6rem', flexWrap: 'wrap' }}>
          <span className={`badge ${getBadgeClass(prediction.crowdLevel)}`}>
            Afluencia {prediction.crowdLevel}
          </span>
          <span className="badge badge-moderate">
            {prediction.season}
          </span>
          {prediction.isWeekend && (
            <span className="badge badge-high">Fin de Semana</span>
          )}
        </div>
      </div>

      <div style={{ background: 'rgba(255, 255, 255, 0.04)', padding: '0.9rem', borderRadius: '12px', borderLeft: '3px solid var(--emerald-jungle)', display: 'flex', gap: '0.6rem' }}>
        <ShieldCheck size={20} color="var(--emerald-jungle)" style={{ flexShrink: 0, marginTop: '2px' }} />
        <p style={{ fontSize: '0.88rem', color: 'var(--text-muted)', lineHeight: '1.4' }}>
          {prediction.recommendation}
        </p>
      </div>
    </div>
  );
};
