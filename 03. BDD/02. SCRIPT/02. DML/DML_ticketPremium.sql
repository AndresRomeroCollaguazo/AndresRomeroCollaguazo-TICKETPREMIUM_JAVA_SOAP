--
-- Dumping data for table `factura`
--

INSERT INTO `factura` (`FAC_CODIGO`, `PAR_CODIGO`, `FAC_NOMBRE_CLIENTE`, `FAC_CEDULA`, `FAC_FECHA`, `FAC_DIRECCION`, `FAC_LOC_PALCO`, `FAC_LOC_TRIBUNA`, `FAC_LOC_GENERAL`, `FAC_LOC_GENERAL_VISITA`, `FAC_TOTAL`) VALUES
(1, 1, '-', '-', '2024-01-04', '-', 10, 0, 0, 0, 150.6),
(2, 1, 'IVETTE', '1752768661', '2024-01-04', 'Checa', 2, 3, 2, 0, 132.272),
(3, 1, '-', '-', '2024-01-04', '-', 0, 10, 0, 0, 173.6),
(4, 1, '-', '-', '2024-01-04', '-', 1, 0, 0, 0, 140.56),
(5, 1, '-', '-', '2024-01-04', '-', 3, 0, 0, 0, 421.68),
(6, 1, '-', '-', '2024-01-04', '-', 0, 0, 4, 0, 24.64),
(7, 1, '-', '-', '2024-01-04', '-', 2, 2, 0, 0, 33.839999999999996);
--
-- Dumping data for table `localidad_partido`
--

INSERT INTO `localidad_partido` (`LOP_CODIGO`, `ESP_CODIGO`, `LOP_NOMBRE`, `LOP_DISPONIBILIDAD`, `LOP_PRECIO`, `PAR_CODIGO`, `LOP_ASIENTOS`) VALUES
(1, 1, 'Tribuna', 50, 15.5, 1, '22,34,35,36,56,,11,42,43'),
(2, 1, 'Palco', 51, 30.3, 1, '31,32,67,70,'),
(3, 1, 'General', 57, 5.5, 1, '12,13,14,15,45,46,47,67,7,8,9,'),
(4, 1, 'General Visitante', 63, 5, 1, '2,3,4,54,55,56,1,,,,'),
(5, 2, 'Tribuna', 72, 12.75, 2, '10,11,12'),
(6, 2, 'Palco', 68, 24.8, 2, '40,41,42,56,57,70,71'),
(7, 2, 'General', 69, 7.7, 2, '1,2,3,24,25,67,68'),
(8, 2, 'General Visitante', 66, 7.5, 2, '15,16,17,25,26,27,56,57,58'),
(9, 3, 'Tribuna', 72, 11.2, 3, '1,2,3'),
(10, 3, 'Palco', 73, 20.5, 3, '20,21'),
(11, 3, 'General', 73, 7.1, 3, '45,46'),
(12, 3, 'General Visitante', 71, 7.25, 3, '13,14,15,16'),
(13, 3, 'Palco', 7, 95.2, 1, '1,3,5,8,9,11,12,15,13,19,20,25,28,30,31,35,38,40,41,42,45,50,52,51,60'),
(14, 3, 'Tribuna', 10, 150.8, 2, ''),
(15, 3, 'General', 70, 25.3, 12, ''),
(16, 4, 'General Visitante', 50, 20, 11, ''),
(17, 4, 'Tribuna', 20, 30.1, 3, ''),
(18, 4, 'Palco', 150, 100.5, 4, ''),
(19, 4, 'Tribuna', 25, 50, 10, ''),
(20, 4, 'General', 60, 30, 8, ''),
(21, 3, 'Palco', 30, 45, 5, '');

-- --------------------------------------------------------

--
-- Dumping data for table `partido_de_futbol`
--

INSERT INTO `partido_de_futbol` (`PAR_CODIGO`, `ESP_CODIGO`, `PAR_EQUIPO_VISITA`, `PAR_EQUIPO_LOCAL`, `PAR_FECHA`, `PAR_HORA`) VALUES
(1, 1, 'Barcelona', 'LDU', '2024-01-05', '19:00'),
(2, 2, 'Emelec', 'LDU', '2023-09-28', '14:30'),
(3, 3, 'Independiente del Valle', 'LDU', '2023-10-01', '18:30'),
(4, 4, 'Barcelona', 'Mushuc Runa', '2024-01-12', '15:00'),
(5, 4, 'Aucas', 'Delfín', '2024-01-04', '17:30'),
(6, 4, 'Cumbayá', 'Deportivo Cuenca', '2024-01-05', '12:00'),
(7, 3, 'Nacional', 'Emelec', '2024-01-03', '18:30'),
(8, 3, 'Gualaceo', 'Liga Deportiva Universitaria', '2024-01-07', '20:30'),
(9, 2, 'Barcelona S.C.', 'Emelec', '2024-01-07', '11:00'),
(10, 2, 'LDU', 'Aucas', '2024-01-03', '10:30'),
(11, 2, 'Guayaquil City', 'Orense', '2024-01-02', '10:00'),
(12, 1, 'Técnico Universitario', 'Universidad Católica', '2024-01-01', '21:00');
