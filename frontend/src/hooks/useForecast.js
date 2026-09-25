import { useState, useEffect } from 'react';
import { fetchForecast, fetchHistory } from '../services/apiService';

export const useForecast = (selectedDate) => {
  const [data, setData] = useState(null);
  const [history, setHistory] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    let isMounted = true;
    setLoading(true);
    setError(null);

    Promise.all([fetchForecast(selectedDate), fetchHistory()])
      .then(([forecastData, historyData]) => {
        if (isMounted) {
          setData(forecastData);
          setHistory(historyData);
          setLoading(false);
        }
      })
      .catch((err) => {
        if (isMounted) {
          console.error("Error al obtener datos de prediccion/historia:", err);
          setError("No se pudo conectar con el servidor backend. Verifique su conexión.");
          setLoading(false);
        }
      });

    return () => {
      isMounted = false;
    };
  }, [selectedDate]);

  return { data, history, loading, error };
};
