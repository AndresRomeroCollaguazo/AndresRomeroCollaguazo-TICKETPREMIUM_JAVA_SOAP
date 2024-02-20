-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2024 at 05:02 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ticket_premium`
--

-- --------------------------------------------------------

--
-- Table structure for table `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `direccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `usuario`, `contrasena`, `nombres`, `apellidos`, `cedula`, `direccion`) VALUES
(2, 'iyroman', '827ccb0eea8a706c4c34a16891f84e7b', 'IVETTE', 'ROMAN', '1724701402', 'AV NAPO');

-- --------------------------------------------------------

--
-- Table structure for table `estadio`
--

CREATE TABLE `estadio` (
  `ESP_CODIGO` int(11) NOT NULL,
  `ESP_NOMBRE` char(30) DEFAULT NULL,
  `ESP_DISPONIBILIDAD` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `estadio`
--

INSERT INTO `estadio` (`ESP_CODIGO`, `ESP_NOMBRE`, `ESP_DISPONIBILIDAD`) VALUES
(1, 'RODRIGO PAZ', 1),
(2, 'ESTADIO IDV', 1),
(3, 'ESTADIO BARCELONA', 1),
(4, 'ESTADIO EMELEC', 1);

-- --------------------------------------------------------

--
-- Table structure for table `factura`
--

CREATE TABLE `factura` (
  `FAC_CODIGO` int(11) NOT NULL,
  `PAR_CODIGO` int(11) NOT NULL,
  `FAC_NOMBRE_CLIENTE` char(30) NOT NULL,
  `FAC_CEDULA` char(30) NOT NULL,
  `FAC_FECHA` date NOT NULL,
  `FAC_DIRECCION` char(30) NOT NULL,
  `FAC_LOC_PALCO` int(11) NOT NULL,
  `FAC_LOC_TRIBUNA` int(11) NOT NULL,
  `FAC_LOC_GENERAL` int(11) NOT NULL,
  `FAC_LOC_GENERAL_VISITA` int(11) NOT NULL,
  `FAC_TOTAL` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Table structure for table `localidad_partido`
--

CREATE TABLE `localidad_partido` (
  `LOP_CODIGO` int(11) NOT NULL,
  `ESP_CODIGO` int(11) NOT NULL,
  `LOP_NOMBRE` char(30) NOT NULL,
  `LOP_DISPONIBILIDAD` int(11) NOT NULL,
  `LOP_PRECIO` double NOT NULL,
  `PAR_CODIGO` int(11) NOT NULL,
  `LOP_ASIENTOS` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
-- Table structure for table `partido_de_futbol`
--

CREATE TABLE `partido_de_futbol` (
  `PAR_CODIGO` int(11) NOT NULL,
  `ESP_CODIGO` int(11) NOT NULL,
  `PAR_EQUIPO_VISITA` char(30) NOT NULL,
  `PAR_EQUIPO_LOCAL` char(30) NOT NULL,
  `PAR_FECHA` date NOT NULL,
  `PAR_HORA` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `estadio`
--
ALTER TABLE `estadio`
  ADD PRIMARY KEY (`ESP_CODIGO`);

--
-- Indexes for table `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`FAC_CODIGO`),
  ADD KEY `FK_GENERA` (`PAR_CODIGO`);

--
-- Indexes for table `localidad_partido`
--
ALTER TABLE `localidad_partido`
  ADD PRIMARY KEY (`LOP_CODIGO`),
  ADD KEY `FK_TIENE` (`ESP_CODIGO`);

--
-- Indexes for table `partido_de_futbol`
--
ALTER TABLE `partido_de_futbol`
  ADD PRIMARY KEY (`PAR_CODIGO`),
  ADD KEY `FK_JUEGA` (`ESP_CODIGO`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `factura`
--
ALTER TABLE `factura`
  MODIFY `FAC_CODIGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `FK_GENERA` FOREIGN KEY (`PAR_CODIGO`) REFERENCES `partido_de_futbol` (`PAR_CODIGO`);

--
-- Constraints for table `localidad_partido`
--
ALTER TABLE `localidad_partido`
  ADD CONSTRAINT `FK_TIENE` FOREIGN KEY (`ESP_CODIGO`) REFERENCES `estadio` (`ESP_CODIGO`);

--
-- Constraints for table `partido_de_futbol`
--
ALTER TABLE `partido_de_futbol`
  ADD CONSTRAINT `FK_JUEGA` FOREIGN KEY (`ESP_CODIGO`) REFERENCES `estadio` (`ESP_CODIGO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
