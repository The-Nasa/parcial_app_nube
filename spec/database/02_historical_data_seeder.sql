-- Script Seeder de Datos Históricos de Afluencia en Catarata Derrepente, Tingo María
-- Para ejecutar en el SQL Editor de Supabase

INSERT INTO historical_attendance (record_date, actual_visitors, temp_celsius, precipitation_mm, weather_condition, is_weekend, is_holiday)
VALUES
('2026-09-01', 45, 27.5, 0.0, 'Soleado', false, false),
('2026-09-02', 52, 28.0, 0.0, 'Soleado', false, false),
('2026-09-03', 48, 26.8, 1.5, 'Parcialmente Nublado', false, false),
('2026-09-04', 65, 29.0, 0.0, 'Soleado', false, false),
('2026-09-05', 135, 28.5, 0.0, 'Soleado', true, false),
('2026-09-06', 180, 29.2, 0.0, 'Soleado', true, false),
('2026-09-07', 38, 24.1, 12.4, 'Lluvia Moderada', false, false),
('2026-09-08', 42, 25.0, 4.0, 'Nublado', false, false),
('2026-09-09', 50, 26.5, 0.5, 'Parcialmente Nublado', false, false),
('2026-09-10', 55, 27.0, 0.0, 'Soleado', false, false),
('2026-09-11', 70, 28.2, 0.0, 'Soleado', false, false),
('2026-09-12', 145, 29.5, 0.0, 'Soleado', true, false),
('2026-09-13', 195, 30.0, 0.0, 'Soleado', true, false),
('2026-09-14', 12, 22.0, 28.5, 'Lluvia Torrencial', false, false),
('2026-09-15', 30, 23.5, 9.0, 'Lluvia Moderada', false, false),
('2026-09-16', 48, 26.0, 1.0, 'Parcialmente Nublado', false, false),
('2026-09-17', 53, 27.2, 0.0, 'Soleado', false, false),
('2026-09-18', 68, 28.0, 0.0, 'Soleado', false, false),
('2026-09-19', 140, 28.8, 0.0, 'Soleado', true, false),
('2026-09-20', 175, 29.1, 0.0, 'Soleado', true, false)
ON CONFLICT (record_date) DO NOTHING;
