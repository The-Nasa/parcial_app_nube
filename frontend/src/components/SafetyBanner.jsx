import React from 'react';
import { AlertTriangle, ShieldAlert } from 'lucide-react';

export const SafetyBanner = ({ safetyStatus, recommendation }) => {
  if (!safetyStatus || safetyStatus === 'SEGURO') return null;

  const isDanger = safetyStatus === 'ALERTA_PELIGRO';

  return (
    <div className="fade-in" style={{
      marginTop: '1.5rem',
      background: isDanger ? 'rgba(239, 68, 68, 0.15)' : 'rgba(245, 158, 11, 0.15)',
      border: `1px solid ${isDanger ? 'var(--alert-danger)' : 'var(--alert-warning)'}`,
      borderRadius: '16px',
      padding: '1.2rem',
      display: 'flex',
      alignItems: 'center',
      gap: '1rem',
      color: '#ffffff'
    }}>
      {isDanger ? <ShieldAlert size={36} color="var(--alert-danger)" /> : <AlertTriangle size={36} color="var(--alert-warning)" />}
      <div>
        <h4 style={{ fontSize: '1.1rem', fontWeight: 700, color: isDanger ? 'var(--alert-danger)' : 'var(--alert-warning)' }}>
          {isDanger ? '¡ALERTA DE SEGURIDAD CLIMÁTICA!' : 'Aviso de Precaución por Lluvia'}
        </h4>
        <p style={{ fontSize: '0.92rem', color: 'var(--text-main)', marginTop: '0.2rem' }}>
          {recommendation}
        </p>
      </div>
    </div>
  );
};
