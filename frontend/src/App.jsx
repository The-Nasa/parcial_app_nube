import React, { useState } from 'react';
import { Header } from './components/Header';
import { DateSelector } from './components/DateSelector';
import { WeatherCard } from './components/WeatherCard';
import { PredictionCard } from './components/PredictionCard';
import { SafetyBanner } from './components/SafetyBanner';
import { HistoryChart } from './components/HistoryChart';
import { Footer } from './components/Footer';
import { useForecast } from './hooks/useForecast';
import { Loader2 } from 'lucide-react';

export const App = () => {
  const todayStr = new Date().toISOString().split('T')[0];
  const [selectedDate, setSelectedDate] = useState(todayStr);

  const { data, history, loading, error } = useForecast(selectedDate);

  return (
    <div className="container">
      <Header />
      
      <DateSelector 
        selectedDate={selectedDate} 
        onDateChange={(newDate) => setSelectedDate(newDate)} 
      />

      {loading ? (
        <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', padding: '5rem 0', gap: '1rem' }}>
          <Loader2 className="spin" size={42} color="var(--cyan-waterfall)" />
          <p style={{ color: 'var(--text-muted)' }}>Procesando pronóstico climático y estimación con IA...</p>
        </div>
      ) : error ? (
        <div className="glass-card" style={{ marginTop: '1.5rem', borderColor: 'var(--alert-danger)', color: 'var(--alert-danger)' }}>
          <p>{error}</p>
        </div>
      ) : data ? (
        <>
          <SafetyBanner 
            safetyStatus={data.prediction.safetyStatus} 
            recommendation={data.prediction.recommendation} 
          />

          <div className="dashboard-grid">
            <WeatherCard weather={data.weather} />
            <PredictionCard prediction={data.prediction} date={data.date} />
          </div>

          <HistoryChart history={history} />
        </>
      ) : null}

      <Footer />
    </div>
  );
};
