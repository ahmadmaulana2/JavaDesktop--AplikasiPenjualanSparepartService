-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 18 Agu 2020 pada 16.59
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 7.1.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualansparepartservice`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_dtservice`
--

CREATE TABLE `tb_dtservice` (
  `id_tmpnomor` int(5) NOT NULL,
  `kd_pelanggan` varchar(10) NOT NULL,
  `nm_pelanggan` varchar(50) NOT NULL,
  `kd_mekanik` varchar(10) NOT NULL,
  `nm_mekanik` varchar(50) NOT NULL,
  `kd_kendaraan` varchar(10) NOT NULL,
  `nm_kendaraan` varchar(50) NOT NULL,
  `kd_sparepart` char(7) NOT NULL,
  `nm_sparepartklr` varchar(50) NOT NULL,
  `hargasparepartklr` bigint(20) NOT NULL,
  `tambahpesanan` int(5) NOT NULL,
  `jenis_service` enum('Servis Besar','Servis Ringan','Pengecekan') NOT NULL,
  `harga` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Trigger `tb_dtservice`
--
DELIMITER $$
CREATE TRIGGER `buy` AFTER INSERT ON `tb_dtservice` FOR EACH ROW BEGIN
UPDATE tb_sparepart SET stk = stk - NEW.tambahpesanan
WHERE nm_sparepart = NEW.nm_sparepartklr;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `cancel` AFTER DELETE ON `tb_dtservice` FOR EACH ROW BEGIN
UPDATE tb_sparepart SET stk = stk + OLD.tambahpesanan
WHERE nm_sparepart = OLD.nm_sparepartklr;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kendaraan`
--

CREATE TABLE `tb_kendaraan` (
  `kd_kendaraan` varchar(10) NOT NULL,
  `nm_kendaraan` varchar(50) NOT NULL,
  `kd_pelanggan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_kendaraan`
--

INSERT INTO `tb_kendaraan` (`kd_kendaraan`, `nm_kendaraan`, `kd_pelanggan`) VALUES
('B3265EIW', 'Honda Beat', 'Draco');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_login`
--

CREATE TABLE `tb_login` (
  `id_login` varchar(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `role` enum('Service Advisor','Partman','Admin') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_login`
--

INSERT INTO `tb_login` (`id_login`, `username`, `password`, `email`, `role`) VALUES
('LG0001', 'Rizki Eka Mawardewi', 'ekamawar22', 'rizkiekamawar@gmail.com', 'Service Advisor'),
('LG0002', 'Ahmad Maulana', '50403823', 'maulana.ahmd79@gmail.com', 'Partman'),
('LG0003', 'adminasmo', 'asmo0001', 'astramotorjkt@co.id', 'Admin'),
('LG0004', 'kiki', 'asd', 'kiki@gmail.com', 'Service Advisor');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_mekanik`
--

CREATE TABLE `tb_mekanik` (
  `kd_mekanik` varchar(10) NOT NULL,
  `nm_mekanik` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `no_telp` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_mekanik`
--

INSERT INTO `tb_mekanik` (`kd_mekanik`, `nm_mekanik`, `alamat`, `no_telp`) VALUES
('MK0001', 'asd', 'as', 'as');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pelanggan`
--

CREATE TABLE `tb_pelanggan` (
  `kd_pelanggan` varchar(10) NOT NULL,
  `nm_pelanggan` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `no_telp` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_pelanggan`
--

INSERT INTO `tb_pelanggan` (`kd_pelanggan`, `nm_pelanggan`, `alamat`, `no_telp`) VALUES
('PL0001', 'Alan', 'Jakarta', '0813-8183-6548'),
('PL0002', 'Draco', 'Depok	', '0857-1000-6933'),
('PL0003', 'Severus', 'Citayem', '0899-897-189'),
('PL0004', 'Roni', 'Bekasi', '0812-1598-7819'),
('PL0005', 'Aris', 'Tambun', '0812-7894-4159');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pemasok`
--

CREATE TABLE `tb_pemasok` (
  `kd_pemasok` varchar(10) NOT NULL,
  `nm_pemasok` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `email` text NOT NULL,
  `no_telp` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_pemasok`
--

INSERT INTO `tb_pemasok` (`kd_pemasok`, `nm_pemasok`, `alamat`, `email`, `no_telp`) VALUES
('SP001', 'Astra', 'Jakarta	', 'astra@astra.co.id', '021-489578');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_penjualansparepart`
--

CREATE TABLE `tb_penjualansparepart` (
  `id_tmpnomor` int(5) NOT NULL,
  `kd_sparepart` char(7) NOT NULL,
  `nm_sparepartklr` varchar(50) NOT NULL,
  `hargasparepartklr` bigint(20) NOT NULL,
  `tambahpesanan` int(5) NOT NULL,
  `harga` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Trigger `tb_penjualansparepart`
--
DELIMITER $$
CREATE TRIGGER `batal` AFTER DELETE ON `tb_penjualansparepart` FOR EACH ROW BEGIN
UPDATE tb_sparepart SET stk = stk + OLD.tambahpesanan
WHERE nm_sparepart = OLD.nm_sparepartklr;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `beli` AFTER INSERT ON `tb_penjualansparepart` FOR EACH ROW BEGIN
UPDATE tb_sparepart SET stk = stk - NEW.tambahpesanan
WHERE nm_sparepart = NEW.nm_sparepartklr;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_service`
--

CREATE TABLE `tb_service` (
  `no_faktur` varchar(25) NOT NULL,
  `kd_pelanggan` varchar(10) NOT NULL,
  `nm_pelanggan` varchar(50) NOT NULL,
  `kd_mekanik` varchar(10) NOT NULL,
  `nm_mekanik` varchar(50) NOT NULL,
  `kd_kendaraan` varchar(10) NOT NULL,
  `nm_kendaraan` varchar(50) NOT NULL,
  `kd_sparepart` char(7) NOT NULL,
  `nm_sparepartklr` varchar(50) NOT NULL,
  `hargasparepartklr` bigint(20) NOT NULL,
  `jenis_service` enum('Servis Besar','Servis Ringan','Pengecekan') NOT NULL,
  `tambahpesanan` int(5) NOT NULL,
  `harga` bigint(20) NOT NULL,
  `bayar` varchar(20) NOT NULL,
  `kembalian` varchar(20) NOT NULL,
  `tgl` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_service`
--

INSERT INTO `tb_service` (`no_faktur`, `kd_pelanggan`, `nm_pelanggan`, `kd_mekanik`, `nm_mekanik`, `kd_kendaraan`, `nm_kendaraan`, `kd_sparepart`, `nm_sparepartklr`, `hargasparepartklr`, `jenis_service`, `tambahpesanan`, `harga`, `bayar`, `kembalian`, `tgl`) VALUES
('S0001', 'PL0001', 'Alan', 'MK0001', 'asdada', '0978', 'hgf', 'PRT0002', 'asda', 1454, 'Servis Ringan', 2, 2908, '5000', '2092', '2020-07-25'),
('S0002', 'PL0002', 'Draco', 'MK0004', 'adcsdv', '123', 'asd', 'PRT0001', 'asda22', 123, 'Servis Besar', 2, 246, '5000', '4754', '2020-07-25'),
('S0003', 'PL0003', 'Severus', 'MK0004', 'adcsdv', '234', 'asd', 'PRT0001', 'asda22', 123, 'Servis Besar', 5, 615, '1000', '385', '2020-07-25'),
('S0004', 'PL0004', 'Roni', 'MK0006', 'bbgbgbg', '44', 'dd', 'PRT0001', 'asda22', 123, 'Pengecekan', 5, 615, '1000', '385', '2020-07-25'),
('S0005', 'PL0001', 'Alan', 'MK0001', 'asdada', '0978', 'hgf', 'PRT0001', 'asda22', 123, 'Servis Besar', 4, 492, '1000', '508', '2020-07-26'),
('S0006', 'PL0002', 'Draco', 'MK0001', 'asd', 'B3265EIW', 'Honda Beat', 'PRT0001', 'asda22', 123, 'Servis Besar', 17, 2091, '5000', '2909', '2020-08-18');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_sparepart`
--

CREATE TABLE `tb_sparepart` (
  `kd_sparepart` char(7) NOT NULL,
  `nm_sparepart` varchar(50) NOT NULL,
  `merk` varchar(50) NOT NULL,
  `harga` bigint(20) NOT NULL,
  `stk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_sparepart`
--

INSERT INTO `tb_sparepart` (`kd_sparepart`, `nm_sparepart`, `merk`, `harga`, `stk`) VALUES
('PRT0001', 'asda22', 'asda', 123, 15),
('PRT0002', 'asda', 'asda4', 1454, 16);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_sparepartkeluar`
--

CREATE TABLE `tb_sparepartkeluar` (
  `id_brgklr` varchar(11) NOT NULL,
  `kd_sparepart` char(7) NOT NULL,
  `nm_sparepartklr` varchar(50) NOT NULL,
  `hargasparepartklr` bigint(20) NOT NULL,
  `tambahpesanan` int(5) NOT NULL,
  `harga` bigint(20) NOT NULL,
  `bayar` varchar(20) NOT NULL,
  `kembalian` varchar(20) NOT NULL,
  `tgl` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_sparepartkeluar`
--

INSERT INTO `tb_sparepartkeluar` (`id_brgklr`, `kd_sparepart`, `nm_sparepartklr`, `hargasparepartklr`, `tambahpesanan`, `harga`, `bayar`, `kembalian`, `tgl`) VALUES
('G0001', 'PRT0002', 'asda', 1454, 2, 2908, '5000', '2092', '2020-07-25'),
('G0002', 'PRT0002', 'asda', 1454, 3, 4362, '5000', '638', '2020-07-25'),
('G0003', 'PRT0002', 'asda', 1454, 2, 2908, '5000', '2092', '2020-07-25'),
('G0004', 'PRT0002', 'asda', 1454, 2, 2908, '5000', '1600', '2020-07-26'),
('G0004', 'PRT0001', 'asda22', 123, 4, 492, '5000', '1600', '2020-07-26'),
('G0005', 'PRT0002', 'asda', 1454, 10, 14540, '15000', '460', '2020-08-18');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_sparepartmasuk`
--

CREATE TABLE `tb_sparepartmasuk` (
  `id_sparepartmsk` int(5) NOT NULL,
  `nm_sparepartmsk` varchar(50) NOT NULL,
  `kd_sparepartmsk` char(7) NOT NULL,
  `tambahstk` int(11) NOT NULL,
  `tglmasuk` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_sparepartmasuk`
--

INSERT INTO `tb_sparepartmasuk` (`id_sparepartmsk`, `nm_sparepartmsk`, `kd_sparepartmsk`, `tambahstk`, `tglmasuk`) VALUES
(1, 'asda22', 'PRT0001', 2, '2020-07-24'),
(2, 'asda', 'PRT0002', 5, '2020-07-24'),
(3, 'asda', 'PRT0002', 2, '2020-07-26'),
(4, 'asda', 'PRT0002', 10, '2020-07-31'),
(5, 'asda', 'PRT0002', 10, '2020-08-18');

--
-- Trigger `tb_sparepartmasuk`
--
DELIMITER $$
CREATE TRIGGER `tambahstk` AFTER INSERT ON `tb_sparepartmasuk` FOR EACH ROW BEGIN
UPDATE tb_sparepart SET stk = stk +NEW.tambahstk
WHERE nm_sparepart = NEW.nm_sparepartmsk;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_dtservice`
--
ALTER TABLE `tb_dtservice`
  ADD PRIMARY KEY (`id_tmpnomor`),
  ADD KEY `tb_dtservice1` (`kd_kendaraan`),
  ADD KEY `tb_dtservice2` (`kd_mekanik`),
  ADD KEY `tb_dtservice3` (`kd_pelanggan`),
  ADD KEY `tb_dtservice4` (`kd_sparepart`);

--
-- Indeks untuk tabel `tb_kendaraan`
--
ALTER TABLE `tb_kendaraan`
  ADD PRIMARY KEY (`kd_kendaraan`),
  ADD KEY `tb_kendaraan1` (`kd_pelanggan`);

--
-- Indeks untuk tabel `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`id_login`);

--
-- Indeks untuk tabel `tb_mekanik`
--
ALTER TABLE `tb_mekanik`
  ADD PRIMARY KEY (`kd_mekanik`);

--
-- Indeks untuk tabel `tb_pelanggan`
--
ALTER TABLE `tb_pelanggan`
  ADD PRIMARY KEY (`kd_pelanggan`);

--
-- Indeks untuk tabel `tb_pemasok`
--
ALTER TABLE `tb_pemasok`
  ADD PRIMARY KEY (`kd_pemasok`);

--
-- Indeks untuk tabel `tb_penjualansparepart`
--
ALTER TABLE `tb_penjualansparepart`
  ADD PRIMARY KEY (`id_tmpnomor`);

--
-- Indeks untuk tabel `tb_service`
--
ALTER TABLE `tb_service`
  ADD PRIMARY KEY (`no_faktur`);

--
-- Indeks untuk tabel `tb_sparepart`
--
ALTER TABLE `tb_sparepart`
  ADD PRIMARY KEY (`kd_sparepart`);

--
-- Indeks untuk tabel `tb_sparepartmasuk`
--
ALTER TABLE `tb_sparepartmasuk`
  ADD PRIMARY KEY (`id_sparepartmsk`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_dtservice`
--
ALTER TABLE `tb_dtservice`
  MODIFY `id_tmpnomor` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tb_penjualansparepart`
--
ALTER TABLE `tb_penjualansparepart`
  MODIFY `id_tmpnomor` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tb_sparepartmasuk`
--
ALTER TABLE `tb_sparepartmasuk`
  MODIFY `id_sparepartmsk` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tb_dtservice`
--
ALTER TABLE `tb_dtservice`
  ADD CONSTRAINT `tb_dtservice1` FOREIGN KEY (`kd_kendaraan`) REFERENCES `tb_kendaraan` (`kd_kendaraan`),
  ADD CONSTRAINT `tb_dtservice2` FOREIGN KEY (`kd_mekanik`) REFERENCES `tb_mekanik` (`kd_mekanik`),
  ADD CONSTRAINT `tb_dtservice3` FOREIGN KEY (`kd_pelanggan`) REFERENCES `tb_pelanggan` (`kd_pelanggan`),
  ADD CONSTRAINT `tb_dtservice4` FOREIGN KEY (`kd_sparepart`) REFERENCES `tb_sparepart` (`kd_sparepart`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
