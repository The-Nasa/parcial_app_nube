import axios from 'axios';

const API_BASE = '/api/v1';

export const fetchForecast = async (dateStr) => {
  const url = dateStr ? `${API_BASE}/predictions/forecast?date=${dateStr}` : `${API_BASE}/predictions/forecast`;
  const response = await axios.get(url);
  return response.data;
};

export const fetchHistory = async () => {
  const response = await axios.get(`${API_BASE}/history`);
  return response.data;
};
