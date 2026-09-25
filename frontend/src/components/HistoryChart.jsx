import React from 'react';
import { AreaChart, Area, XAxis, YAxis, Tooltip, ResponsiveContainer, CartesianGrid } from 'recharts';
import { TrendingUp } from 'lucide-react';

export const HistoryChart = ({ history }) => {
  if (!history || history.length === 0) return null;

  const chartData = [...history].reverse().map(item => ({
    fecha: item.date,
    visitantes: item.actualVisitors,
    lluvia: item.rainMm
  }));

  return (
    <div className="glass-card fade-in" style={{ marginTop: '1.5rem' }}>
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: '1.2rem' }}>
        <div>
          <h3 style={{ fontSize: '1.1rem', fontWeight: 700 }}>Histórico de Afluencia Turística</h3>
          <p style={{ color: 'var(--text-muted)', fontSize: '0.85rem' }}>Comparativa diaria de personas registradas en Catarata Derrepente (Datos Supabase DB)</p>
        </div>
        <div style={{ background: 'rgba(16, 185, 129, 0.1)', padding: '0.5rem', borderRadius: '10px' }}>
          <TrendingUp color="var(--emerald-jungle)" size={22} />
        </div>
      </div>

      <div style={{ width: '100%', height: 260 }}>
        <ResponsiveContainer width="100%" height="100%">
          <AreaChart data={chartData} margin={{ top: 10, right: 10, left: -20, bottom: 0 }}>
            <defs>
              <linearGradient id="colorVisitors" x1="0" y1="0" x2="0" y2="1">
                <stop offset="5%" stopColor="var(--cyan-waterfall)" stopOpacity={0.8}/>
                <stop offset="95%" stopColor="var(--cyan-waterfall)" stopOpacity={0}/>
              </linearGradient>
            </defs>
            <CartesianGrid strokeDasharray="3 3" stroke="rgba(255,255,255,0.05)" />
            <XAxis dataKey="fecha" stroke="var(--text-muted)" fontSize={11} />
            <YAxis stroke="var(--text-muted)" fontSize={11} />
            <Tooltip
              contentStyle={{ background: 'var(--bg-dark-secondary)', border: '1px solid rgba(255,255,255,0.1)', borderRadius: '10px', color: '#fff' }}
              labelStyle={{ color: 'var(--cyan-waterfall)', fontWeight: 'bold' }}
            />
            <Area type="monotone" dataKey="visitantes" stroke="var(--cyan-waterfall)" strokeWidth={3} fillOpacity={1} fill="url(#colorVisitors)" />
          </AreaChart>
        </ResponsiveContainer>
      </div>
    </div>
  );
};
