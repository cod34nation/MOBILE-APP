-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 17 Des 2016 pada 16.17
-- Versi Server: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pil_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `password`, `nama`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `salt` varchar(100) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL,
  `encrypted_password` varchar(50) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `alamat_domisili` varchar(20) NOT NULL,
  `alamat_asli` text NOT NULL,
  `no_telp` varchar(20) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `foto` varchar(200) NOT NULL,
  `email` varchar(100) NOT NULL,
  `unique_id` varchar(23) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `client`
--

INSERT INTO `client` (`id_client`, `salt`, `nama`, `status`, `encrypted_password`, `jenis_kelamin`, `alamat_domisili`, `alamat_asli`, `no_telp`, `semester`, `foto`, `email`, `unique_id`, `created_at`, `updated_at`) VALUES
(14650018, '048d412019', 'Afrizal Setyo W', '', 'k5gELx0RKMUeaFqTuCBRJXN2zBkwNDhkNDEyMDE5', '', '', '', '', '', '', 'afrizal@gmail.com', '584d51f9404e70.28064441', '2016-12-11 20:17:45', '0000-00-00 00:00:00'),
(14650019, '6a2fcc28aa', 'Ahmad Fathullah', '', 'KniJSlDjQC99y+M3cNP57R1nPM02YTJmY2MyOGFh', '', '', '', '', '', '', 'Ahmad@gmail.com', '584d56e896fe96.13310875', '2016-12-11 20:38:48', '0000-00-00 00:00:00'),
(14650020, '584d0a94f4', 'Abdul Mutholib', '', 'SU+fL0bb85dWNJGzZKtD0x9QpE81ODRkMGE5NGY0', '', '', '', '', '', '', 'abdul@gmail.com', '584d612f74e046.39907327', '2016-12-11 21:22:39', '0000-00-00 00:00:00'),
(14650021, 'ebbd52f05f', 'Almarhum', '', 'Ni49ihUnkZeVTMqY0F6O/cG8c1dlYmJkNTJmMDVm', '', '', '', '', '', '', 'almarhum@gmail.com', '584d61c932b515.83877764', '2016-12-11 21:25:13', '0000-00-00 00:00:00'),
(14650022, 'c59c76ac6d', 'Sulis', '', 'UeTmh397Ug73qo4/GY5xQpPybL9jNTljNzZhYzZk', '', '', '', '', '', '', 'sulis@gmail.com', '584d62ead96d87.75585029', '2016-12-11 21:30:02', '0000-00-00 00:00:00'),
(14650023, '21871913ea', 'Fathan H', '', 'bxk7DdXbO8XJJTXIn6Q9WcQN9e0yMTg3MTkxM2Vh', '', '', '', '', '', '', 'Ahmad fathan W', '584d6aa861f0d8.87995475', '2016-12-11 22:03:04', '0000-00-00 00:00:00'),
(14650024, 'b0946fe5ca', 'Farhan', '', 'gGRI0GYmR7W/V/gqVrrCuqn86l9iMDk0NmZlNWNh', '', '', '', '', '', '', 'Farhan@gmail.com', '584d6b2ec0c036.62042614', '2016-12-11 22:05:18', '0000-00-00 00:00:00'),
(14650025, '295d96512f', 'Satryo', '', 'd97F8P96oxquK2wqVoWupDEeDHYyOTVkOTY1MTJm', '', '', '', '', '', '', 'satryo@gmail.com', '584d6b82824957.90891709', '2016-12-11 22:06:42', '0000-00-00 00:00:00'),
(14650026, 'baed0d1b55', 'Fahrul Gunawan', '', 'LWqDgMQAg9tYUtA/aSpSEQdinH1iYWVkMGQxYjU1', '', '', '', '', '', '', 'fahrul@gmail.com', '584f97a4371537.33574174', '2016-12-13 13:39:32', '0000-00-00 00:00:00'),
(14650027, '80123bec0e', 'Ifa', '', 'AhcDFmOZCFPM5PkJNXVHs3EowGM4MDEyM2JlYzBl', '', '', '', '', '', '', 'ifa@gmail.com', '584f98b1587a03.57078435', '2016-12-13 13:44:01', '0000-00-00 00:00:00'),
(14650028, 'cf1e143843', 'Novrindah', '', 'FqoYUBV6jwd9y2gAADVv8kvYc55jZjFlMTQzODQz', '', '', '', '', '', '', 'alvinovrindah@gmail.com', '584f990e40c983.40445909', '2016-12-13 13:45:34', '0000-00-00 00:00:00'),
(14650030, '05178c5be6', 'Ahmad Roihan', '', '2fzvtWh2lXP8OUo/Bf4El+TClOMwNTE3OGM1YmU2', '', '', '', '', '', '', '', '585161cc286498.06944397', '2016-12-14 22:14:20', '0000-00-00 00:00:00'),
(14650031, 'c922912b50', 'Khadijah', '', 'ibmeoxjw10BUFeAPFqiGrjXsWqFjOTIyOTEyYjUw', '', '', '', '', '', '', '', '58516261aea702.17686470', '2016-12-14 22:16:49', '0000-00-00 00:00:00'),
(14650032, 'c783e91359', 'Fitriana', '', '3/Yp4VN7iOO4sp5HktJLVpqnh09jNzgzZTkxMzU5', '', '', '', '', '', '', '', '5851652af02723.75324980', '2016-12-14 22:28:42', '0000-00-00 00:00:00'),
(14650048, '44b3768012', 'Ifa', '', 'EFHemdDOq3IkHtzrMjslrfsRnak0NGIzNzY4MDEy', '', '', '', '', '', '', '', '58536918b75af2.86360247', '2016-12-16 11:10:00', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `informasi`
--

CREATE TABLE `informasi` (
  `id_informasi` int(11) NOT NULL,
  `tanggal_post` varchar(100) NOT NULL,
  `jam` varchar(10) NOT NULL,
  `isi` varchar(1000) NOT NULL,
  `status` varchar(10) NOT NULL,
  `judul` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `informasi`
--

INSERT INTO `informasi` (`id_informasi`, `tanggal_post`, `jam`, `isi`, `status`, `judul`) VALUES
(1, '14 Dec 2016', '04:17:39pm', 'Diberitahukan bahwa akan diadakan seleksi ASLAB 2017. segera daftar paling lambat 20 Desember 2016', '', 'Pendaftaran ASLAB'),
(2, '14 Dec 2016', '04:18:29pm', 'yang merasa kehilangan kunci di lab komputer vision segera temui pak mukidi', '', 'Kehilangan Kunci'),
(3, '16 Dec 2016', '04:58:48am', 'Telah diitemukan cas laptop merek MAC Book', '', 'Kehilangan CAS LAPTOP');

-- --------------------------------------------------------

--
-- Struktur dari tabel `laboratorium`
--

CREATE TABLE `laboratorium` (
  `id_lab` int(11) NOT NULL,
  `nama_lab` varchar(20) NOT NULL,
  `penanggung_jawab` varchar(20) NOT NULL,
  `gambar` varchar(255) NOT NULL,
  `status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `laboratorium`
--

INSERT INTO `laboratorium` (`id_lab`, `nama_lab`, `penanggung_jawab`, `gambar`, `status`) VALUES
(7, 'Lab Robotika', 'Bapak Fajrul', 'C:\\xampp\\htdocs\\APLIKASI-CLIENT-SERVER\\admin\\production\\images\\media.jpg', '0'),
(9, 'Lab Research', 'Bapak Amin', '', '0'),
(11, 'Lab Hacking', 'Bapak Irvan', '', '1'),
(12, 'Lab AI', 'Bapak Afrizal', '', '0'),
(13, 'Lab Hacking', 'MRX', '', '0'),
(14, 'Lab Database', 'Bu Nindy', '', '0'),
(16, 'Lab Komputer Vision', 'Bapak Irwan', '', '0'),
(17, 'Lab Pemrograman', 'Bapak Irfan', '', '0');

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_pemakaian` int(11) NOT NULL,
  `hari` varchar(10) DEFAULT NULL,
  `jam_pemakaian` varchar(15) NOT NULL,
  `Tanggal_pinjam` varchar(20) NOT NULL,
  `Keterangan` varchar(20) DEFAULT NULL,
  `id_lab` int(11) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  `tgl_kembali` varchar(100) NOT NULL,
  `jam_kembali` varchar(100) NOT NULL,
  `status_kembali` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `peminjaman`
--

INSERT INTO `peminjaman` (`id_pemakaian`, `hari`, `jam_pemakaian`, `Tanggal_pinjam`, `Keterangan`, `id_lab`, `id_client`, `tgl_kembali`, `jam_kembali`, `status_kembali`) VALUES
(23, NULL, '10:57', '2016/12/16', NULL, 7, 14650018, '16 Desember 2016', '04:58:05am', 1),
(24, NULL, '11:13', '2016/12/16', NULL, 11, 14650048, '', '', 0);

--
-- Trigger `peminjaman`
--
DELIMITER $$
CREATE TRIGGER `peminjaman` AFTER INSERT ON `peminjaman` FOR EACH ROW UPDATE laboratorium
 SET status = 1
 WHERE
 id_lab = NEW.id_lab
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `pengembalian` AFTER UPDATE ON `peminjaman` FOR EACH ROW UPDATE laboratorium
 SET status = 0
 WHERE
 id_lab = NEW.id_lab
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesan`
--

CREATE TABLE `pesan` (
  `id_pesan` int(11) NOT NULL,
  `id_client` int(11) DEFAULT NULL,
  `tgl_kirim` varchar(100) DEFAULT NULL,
  `isi` varchar(100) DEFAULT NULL,
  `judul` varchar(20) NOT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pesan`
--

INSERT INTO `pesan` (`id_pesan`, `id_client`, `tgl_kirim`, `isi`, `judul`, `status`) VALUES
(24, 14650018, '2016/12/14', 'Tolong di tambah fasilitas lab komputer vision.', 'Fasilitas', NULL),
(25, 14650030, '2016/12/14', 'hmmmmm sepertinya kita harus menambah lab baru... segera yaa.. kami tunggu', 'Upgrade Lab', NULL),
(26, 14650032, '2016/12/14', 'Mohon untuk setiap praktikan jaga kebersihannya ya..', 'Kebersihan', NULL),
(27, 14650018, '2016/12/16', 'kami kekurangan labbbbb', 'Tambahkan labbbbb yo', NULL),
(28, 14650048, '2016/12/16', 'komputernya kurang banyak', 'Saran', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Indexes for table `informasi`
--
ALTER TABLE `informasi`
  ADD PRIMARY KEY (`id_informasi`);

--
-- Indexes for table `laboratorium`
--
ALTER TABLE `laboratorium`
  ADD PRIMARY KEY (`id_lab`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_pemakaian`),
  ADD KEY `id_lab` (`id_lab`),
  ADD KEY `id_client` (`id_client`);

--
-- Indexes for table `pesan`
--
ALTER TABLE `pesan`
  ADD PRIMARY KEY (`id_pesan`),
  ADD KEY `id_client` (`id_client`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14650049;
--
-- AUTO_INCREMENT for table `informasi`
--
ALTER TABLE `informasi`
  MODIFY `id_informasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `laboratorium`
--
ALTER TABLE `laboratorium`
  MODIFY `id_lab` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id_pemakaian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `pesan`
--
ALTER TABLE `pesan`
  MODIFY `id_pesan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`id_lab`) REFERENCES `laboratorium` (`id_lab`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pesan`
--
ALTER TABLE `pesan`
  ADD CONSTRAINT `pesan_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
