-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 08, 2022 at 07:32 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penelitian`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_jumt`
--

CREATE TABLE `tb_jumt` (
  `id_jumt` int(11) NOT NULL,
  `jenis_jumt` varchar(50) NOT NULL,
  `poin_jumt` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_jumt`
--

INSERT INTO `tb_jumt` (`id_jumt`, `jenis_jumt`, `poin_jumt`) VALUES
(1, '4 orang', '4');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pekerjaan`
--

CREATE TABLE `tb_pekerjaan` (
  `id_pekerjaan` int(11) NOT NULL,
  `jenis_pekerjaan` varchar(20) NOT NULL,
  `poin_pekerjaan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pekerjaan`
--

INSERT INTO `tb_pekerjaan` (`id_pekerjaan`, `jenis_pekerjaan`, `poin_pekerjaan`) VALUES
(1, 'PNS', '4');

-- --------------------------------------------------------

--
-- Table structure for table `tb_penerima`
--

CREATE TABLE `tb_penerima` (
  `id_penerima` int(11) NOT NULL,
  `Nama_penerima` varchar(50) NOT NULL,
  `id_pekerjaan` int(20) DEFAULT NULL,
  `id_sbtinggal` int(20) DEFAULT NULL,
  `id_sltinggal` int(20) DEFAULT NULL,
  `id_sumper` int(20) DEFAULT NULL,
  `id_sm` int(20) DEFAULT NULL,
  `id_jumtang` int(20) DEFAULT NULL,
  `id_penghasil` int(20) DEFAULT NULL,
  `rt_rw` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_penghasilan`
--

CREATE TABLE `tb_penghasilan` (
  `id_penghasilan` int(11) NOT NULL,
  `jenis_penghasilan` varchar(50) NOT NULL,
  `poin_penghasilan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_penghasilan`
--

INSERT INTO `tb_penghasilan` (`id_penghasilan`, `jenis_penghasilan`, `poin_penghasilan`) VALUES
(1, '500.000', '4');

-- --------------------------------------------------------

--
-- Table structure for table `tb_sbtinggal`
--

CREATE TABLE `tb_sbtinggal` (
  `id_sbtinggal` int(11) NOT NULL,
  `jenis_sbtinggal` varchar(50) NOT NULL,
  `poin_sbtinggal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_sbtinggal`
--

INSERT INTO `tb_sbtinggal` (`id_sbtinggal`, `jenis_sbtinggal`, `poin_sbtinggal`) VALUES
(1, 'Miliki sendiri', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tb_sltinggal`
--

CREATE TABLE `tb_sltinggal` (
  `id_sltinggal` int(11) NOT NULL,
  `jenis_sltinggal` varchar(50) NOT NULL,
  `poin_sltinggal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_sltinggal`
--

INSERT INTO `tb_sltinggal` (`id_sltinggal`, `jenis_sltinggal`, `poin_sltinggal`) VALUES
(1, 'mk', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tb_stm`
--

CREATE TABLE `tb_stm` (
  `id_stm` int(11) NOT NULL,
  `jenis_stm` varchar(50) NOT NULL,
  `poin_stm` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_stm`
--

INSERT INTO `tb_stm` (`id_stm`, `jenis_stm`, `poin_stm`) VALUES
(1, 'asli', '2');

-- --------------------------------------------------------

--
-- Table structure for table `tb_sumper`
--

CREATE TABLE `tb_sumper` (
  `id_sumper` int(11) NOT NULL,
  `jenis_sumper` varchar(50) NOT NULL,
  `poin_sumper` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_sumper`
--

INSERT INTO `tb_sumper` (`id_sumper`, `jenis_sumper`, `poin_sumper`) VALUES
(1, 'kayu bakar', '4');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_jumt`
--
ALTER TABLE `tb_jumt`
  ADD PRIMARY KEY (`id_jumt`);

--
-- Indexes for table `tb_pekerjaan`
--
ALTER TABLE `tb_pekerjaan`
  ADD PRIMARY KEY (`id_pekerjaan`);

--
-- Indexes for table `tb_penerima`
--
ALTER TABLE `tb_penerima`
  ADD PRIMARY KEY (`id_penerima`),
  ADD KEY `id_sbtinggal` (`id_sbtinggal`),
  ADD KEY `id_sltinggal` (`id_sltinggal`),
  ADD KEY `id_sumper` (`id_sumper`),
  ADD KEY `id_sm` (`id_sm`),
  ADD KEY `id_jumtang` (`id_jumtang`),
  ADD KEY `id_penghasil` (`id_penghasil`),
  ADD KEY `id_pekerjaan` (`id_pekerjaan`);

--
-- Indexes for table `tb_penghasilan`
--
ALTER TABLE `tb_penghasilan`
  ADD PRIMARY KEY (`id_penghasilan`);

--
-- Indexes for table `tb_sbtinggal`
--
ALTER TABLE `tb_sbtinggal`
  ADD PRIMARY KEY (`id_sbtinggal`);

--
-- Indexes for table `tb_sltinggal`
--
ALTER TABLE `tb_sltinggal`
  ADD PRIMARY KEY (`id_sltinggal`);

--
-- Indexes for table `tb_stm`
--
ALTER TABLE `tb_stm`
  ADD PRIMARY KEY (`id_stm`);

--
-- Indexes for table `tb_sumper`
--
ALTER TABLE `tb_sumper`
  ADD PRIMARY KEY (`id_sumper`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_penerima`
--
ALTER TABLE `tb_penerima`
  MODIFY `id_penerima` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_penerima`
--
ALTER TABLE `tb_penerima`
  ADD CONSTRAINT `tb_penerima_ibfk_1` FOREIGN KEY (`id_pekerjaan`) REFERENCES `tb_pekerjaan` (`id_pekerjaan`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_penerima_ibfk_2` FOREIGN KEY (`id_sbtinggal`) REFERENCES `tb_sbtinggal` (`id_sbtinggal`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_penerima_ibfk_3` FOREIGN KEY (`id_sltinggal`) REFERENCES `tb_sltinggal` (`id_sltinggal`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_penerima_ibfk_4` FOREIGN KEY (`id_sumper`) REFERENCES `tb_sumper` (`id_sumper`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_penerima_ibfk_5` FOREIGN KEY (`id_sm`) REFERENCES `tb_stm` (`id_stm`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_penerima_ibfk_6` FOREIGN KEY (`id_jumtang`) REFERENCES `tb_jumt` (`id_jumt`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_penerima_ibfk_7` FOREIGN KEY (`id_penghasil`) REFERENCES `tb_penghasilan` (`id_penghasilan`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
