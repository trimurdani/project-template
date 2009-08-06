-- MySQL dump 10.11
--
-- Host: localhost    Database: posdb
-- ------------------------------------------------------
-- Server version	5.0.67

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `mst_cabang`
--

LOCK TABLES `mst_cabang` WRITE;
/*!40000 ALTER TABLE `mst_cabang` DISABLE KEYS */;
INSERT INTO `mst_cabang` (`ID_CABANG`, `NAME`) VALUES ('SYS','Cabang Default');
/*!40000 ALTER TABLE `mst_cabang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `mst_produk`
--

LOCK TABLES `mst_produk` WRITE;
/*!40000 ALTER TABLE `mst_produk` DISABLE KEYS */;
INSERT INTO `mst_produk` (`ID_PRODUK`, `HARGA_BELI`, `HARGA_JUAL`, `NAMA`, `STOK`) VALUES ('ABC','10000.00','11000.00','KECAP ABC',19),('SOYJOY','5600.00','6200.00','SOYJOY SNACK',33);
/*!40000 ALTER TABLE `mst_produk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `mst_running_number`
--

LOCK TABLES `mst_running_number` WRITE;
/*!40000 ALTER TABLE `mst_running_number` DISABLE KEYS */;
INSERT INTO `mst_running_number` (`ID`, `NUMBER`) VALUES ('ID_BELI0908',3),('ID_JUAL0908',2);
/*!40000 ALTER TABLE `mst_running_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `mst_system_property`
--

LOCK TABLES `mst_system_property` WRITE;
/*!40000 ALTER TABLE `mst_system_property` DISABLE KEYS */;
INSERT INTO `mst_system_property` (`ID`, `VAL`) VALUES ('cabang','SYS'),('tanggal_format','dd-MM-yyyy'),('tanggal_transaksi','06-08-2009');
/*!40000 ALTER TABLE `mst_system_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sec_menu`
--

LOCK TABLES `sec_menu` WRITE;
/*!40000 ALTER TABLE `sec_menu` DISABLE KEYS */;
INSERT INTO `sec_menu` (`ID_MENU`, `MENU_LEVEL`, `PANEL_CLASS`, `URUTAN`, `ID_PARENT`) VALUES ('Bantuan',0,NULL,5,NULL),('Laporan',0,NULL,3,NULL),('Master',0,NULL,1,NULL),('Master Produk',1,'com.artivisi.pos.ui.master.MasterProdukPanel',1,'Master'),('Master Running Number',1,'com.artivisi.pos.ui.master.RunningNumberPanel',2,'Master'),('Master System Property',1,'com.artivisi.pos.ui.master.SystemPropertyPanel',3,'Master'),('Menu',1,'com.artivisi.pos.ui.sekuriti.MenuPanel',3,'Sekuriti'),('Pembelian',1,'com.artivisi.pos.ui.transaksi.PembelianPanel',0,'Transaksi'),('Pengguna',1,'com.artivisi.pos.ui.sekuriti.PenggunaPanel',1,'Sekuriti'),('Penjualan',1,'com.artivisi.pos.ui.transaksi.PenjualanPanel',1,'Transaksi'),('Peran',1,'com.artivisi.pos.ui.sekuriti.PeranPanel',2,'Sekuriti'),('Sekuriti',0,NULL,4,NULL),('Transaksi',0,NULL,2,NULL);
/*!40000 ALTER TABLE `sec_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sec_pengguna`
--

LOCK TABLES `sec_pengguna` WRITE;
/*!40000 ALTER TABLE `sec_pengguna` DISABLE KEYS */;
INSERT INTO `sec_pengguna` (`ID_PENGGUNA`, `NAMA_LENGKAP`, `KATA_SANDI`) VALUES ('ADMIN','SUPER USER','f6fdffe48c908deb0f4c3bd36c032e72'),('KASIR','KASIR','c7911af3adbd12a035b289556d96470a');
/*!40000 ALTER TABLE `sec_pengguna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sec_peran`
--

LOCK TABLES `sec_peran` WRITE;
/*!40000 ALTER TABLE `sec_peran` DISABLE KEYS */;
INSERT INTO `sec_peran` (`ID_PERAN`, `DESKRIPSI`) VALUES ('KASIR','KASIR HANYA BISA PENJUALAN'),('SUPER USER','USER YANG BISA MELIHAT SEMUA MENU');
/*!40000 ALTER TABLE `sec_peran` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sec_peran_menu`
--

LOCK TABLES `sec_peran_menu` WRITE;
/*!40000 ALTER TABLE `sec_peran_menu` DISABLE KEYS */;
INSERT INTO `sec_peran_menu` (`ID_PERAN`, `ID_MENU`) VALUES ('SUPER USER','Master'),('SUPER USER','Master Produk'),('SUPER USER','Master Running Number'),('SUPER USER','Master System Property'),('SUPER USER','Transaksi'),('SUPER USER','Pembelian'),('SUPER USER','Penjualan'),('SUPER USER','Laporan'),('SUPER USER','Sekuriti'),('SUPER USER','Pengguna'),('SUPER USER','Peran'),('SUPER USER','Menu'),('SUPER USER','Bantuan'),('KASIR','Transaksi'),('KASIR','Penjualan');
/*!40000 ALTER TABLE `sec_peran_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sec_peran_pengguna`
--

LOCK TABLES `sec_peran_pengguna` WRITE;
/*!40000 ALTER TABLE `sec_peran_pengguna` DISABLE KEYS */;
INSERT INTO `sec_peran_pengguna` (`ID_PERAN`, `ID_PENGGUNA`) VALUES ('SUPER USER','ADMIN'),('KASIR','KASIR');
/*!40000 ALTER TABLE `sec_peran_pengguna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tr_pembelian`
--

LOCK TABLES `tr_pembelian` WRITE;
/*!40000 ALTER TABLE `tr_pembelian` DISABLE KEYS */;
INSERT INTO `tr_pembelian` (`ID_PEMBELIAN`, `TANGGAL`, `TOTAL`, `VERSION`) VALUES ('BLISYS090800001','2009-08-06','120000.00',0),('BLISYS090800002','2009-08-06','10000.00',0),('BLISYS090800003','2009-08-06','16800.00',0);
/*!40000 ALTER TABLE `tr_pembelian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tr_pembelian_detail`
--

LOCK TABLES `tr_pembelian_detail` WRITE;
/*!40000 ALTER TABLE `tr_pembelian_detail` DISABLE KEYS */;
INSERT INTO `tr_pembelian_detail` (`ID_PEMBELIAN_DETAIL`, `HARGA`, `KUANTITAS`, `SUB_TOTAL`, `ID_PEMBELIAN`, `ID_PRODUK`) VALUES ('BLISYS0908000011','10000.00',12,'120000.00','BLISYS090800001','ABC'),('BLISYS0908000021','10000.00',1,'10000.00','BLISYS090800002','ABC'),('BLISYS0908000031','5600.00',3,'16800.00','BLISYS090800003','SOYJOY');
/*!40000 ALTER TABLE `tr_pembelian_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tr_penjualan`
--

LOCK TABLES `tr_penjualan` WRITE;
/*!40000 ALTER TABLE `tr_penjualan` DISABLE KEYS */;
INSERT INTO `tr_penjualan` (`ID_PENJUALAN`, `TANGGAL`, `TOTAL`, `VERSION`) VALUES ('JLASYS090800001','2009-08-06','33000.00',0),('JLASYS090800002','2009-08-06','33000.00',0);
/*!40000 ALTER TABLE `tr_penjualan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tr_penjualan_detail`
--

LOCK TABLES `tr_penjualan_detail` WRITE;
/*!40000 ALTER TABLE `tr_penjualan_detail` DISABLE KEYS */;
INSERT INTO `tr_penjualan_detail` (`ID_PENJUALAN_DETAIL`, `HARGA`, `KUANTITAS`, `SUB_TOTAL`, `ID_PENJUALAN`, `ID_PRODUK`) VALUES ('JLASYS0908000011','11000.00',3,'33000.00','JLASYS090800001','ABC'),('JLASYS0908000021','11000.00',3,'33000.00','JLASYS090800002','ABC');
/*!40000 ALTER TABLE `tr_penjualan_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2009-08-06 18:48:21
