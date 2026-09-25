import React from 'react';

export const Footer = () => {
  return (
    <footer style={{
      marginTop: '3rem',
      paddingTop: '1.5rem',
      borderTop: '1px solid rgba(255, 255, 255, 0.08)',
      textAlign: 'center',
      color: 'var(--text-muted)',
      fontSize: '0.85rem'
    }}>
      <p>Derrepente Tourist Forecast • Tingo María - Huánuco - Perú</p>
      <p style={{ marginTop: '0.3rem', fontSize: '0.8rem', opacity: 0.7 }}>
        Desarrollado con Spec-Driven Development (SDD) & AI Agents • Spring Boot 3 + React + Supabase DB + AWS EC2
      </p>
    </footer>
  );
};
