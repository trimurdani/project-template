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
-- Table structure for table `mst_cabang`
--

DROP TABLE IF EXISTS `mst_cabang`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `mst_cabang` (
  `ID_CABANG` varchar(3) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  PRIMARY KEY  (`ID_CABANG`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `mst_produk`
--

DROP TABLE IF EXISTS `mst_produk`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `mst_produk` (
  `ID_PRODUK` varchar(30) NOT NULL,
  `HARGA_BELI` decimal(19,2) default NULL,
  `HARGA_JUAL` decimal(19,2) default NULL,
  `NAMA` varchar(90) default NULL,
  `STOK` int(11) default NULL,
  PRIMARY KEY  (`ID_PRODUK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `mst_running_number`
--

DROP TABLE IF EXISTS `mst_running_number`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `mst_running_number` (
  `ID` varchar(255) NOT NULL,
  `NUMBER` int(11) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `mst_system_property`
--

DROP TABLE IF EXISTS `mst_system_property`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `mst_system_property` (
  `ID` varchar(255) NOT NULL,
  `VAL` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `sec_menu`
--

DROP TABLE IF EXISTS `sec_menu`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `sec_menu` (
  `ID_MENU` varchar(50) NOT NULL,
  `MENU_LEVEL` int(11) NOT NULL,
  `PANEL_CLASS` varchar(70) default NULL,
  `URUTAN` int(11) NOT NULL,
  `ID_PARENT` varchar(50) default NULL,
  PRIMARY KEY  (`ID_MENU`),
  KEY `FK67C2FCAD37D2A8C2` (`ID_PARENT`),
  CONSTRAINT `FK67C2FCAD37D2A8C2` FOREIGN KEY (`ID_PARENT`) REFERENCES `sec_menu` (`ID_MENU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `sec_pengguna`
--

DROP TABLE IF EXISTS `sec_pengguna`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `sec_pengguna` (
  `ID_PENGGUNA` varchar(255) NOT NULL,
  `NAMA_LENGKAP` varchar(100) default NULL,
  `KATA_SANDI` varchar(100) NOT NULL,
  PRIMARY KEY  (`ID_PENGGUNA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `sec_peran`
--

DROP TABLE IF EXISTS `sec_peran`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `sec_peran` (
  `ID_PERAN` varchar(20) NOT NULL,
  `DESKRIPSI` varchar(255) default NULL,
  PRIMARY KEY  (`ID_PERAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `sec_peran_menu`
--

DROP TABLE IF EXISTS `sec_peran_menu`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `sec_peran_menu` (
  `ID_PERAN` varchar(20) NOT NULL,
  `ID_MENU` varchar(50) NOT NULL,
  KEY `FK55093362D0314E77` (`ID_MENU`),
  KEY `FK55093362364D277B` (`ID_PERAN`),
  CONSTRAINT `FK55093362364D277B` FOREIGN KEY (`ID_PERAN`) REFERENCES `sec_peran` (`ID_PERAN`),
  CONSTRAINT `FK55093362D0314E77` FOREIGN KEY (`ID_MENU`) REFERENCES `sec_menu` (`ID_MENU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `sec_peran_pengguna`
--

DROP TABLE IF EXISTS `sec_peran_pengguna`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `sec_peran_pengguna` (
  `ID_PERAN` varchar(20) NOT NULL,
  `ID_PENGGUNA` varchar(255) NOT NULL,
  KEY `FKB39C7F12364D277B` (`ID_PERAN`),
  KEY `FKB39C7F12F84E457` (`ID_PENGGUNA`),
  CONSTRAINT `FKB39C7F12F84E457` FOREIGN KEY (`ID_PENGGUNA`) REFERENCES `sec_pengguna` (`ID_PENGGUNA`),
  CONSTRAINT `FKB39C7F12364D277B` FOREIGN KEY (`ID_PERAN`) REFERENCES `sec_peran` (`ID_PERAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `tr_pembelian`
--

DROP TABLE IF EXISTS `tr_pembelian`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `tr_pembelian` (
  `ID_PEMBELIAN` varchar(16) NOT NULL,
  `TANGGAL` date NOT NULL,
  `TOTAL` decimal(19,2) NOT NULL,
  `VERSION` int(11) NOT NULL,
  PRIMARY KEY  (`ID_PEMBELIAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `tr_pembelian_detail`
--

DROP TABLE IF EXISTS `tr_pembelian_detail`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `tr_pembelian_detail` (
  `ID_PEMBELIAN_DETAIL` varchar(19) NOT NULL,
  `HARGA` decimal(19,2) NOT NULL,
  `KUANTITAS` int(11) NOT NULL,
  `SUB_TOTAL` decimal(19,2) default NULL,
  `ID_PEMBELIAN` varchar(16) NOT NULL,
  `ID_PRODUK` varchar(30) NOT NULL,
  PRIMARY KEY  (`ID_PEMBELIAN_DETAIL`),
  KEY `FKDA02F94CB7658619` (`ID_PRODUK`),
  KEY `FKDA02F94C1F4CC02F` (`ID_PEMBELIAN`),
  CONSTRAINT `FKDA02F94C1F4CC02F` FOREIGN KEY (`ID_PEMBELIAN`) REFERENCES `tr_pembelian` (`ID_PEMBELIAN`),
  CONSTRAINT `FKDA02F94CB7658619` FOREIGN KEY (`ID_PRODUK`) REFERENCES `mst_produk` (`ID_PRODUK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `tr_penjualan`
--

DROP TABLE IF EXISTS `tr_penjualan`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `tr_penjualan` (
  `ID_PENJUALAN` varchar(16) NOT NULL,
  `TANGGAL` date default NULL,
  `TOTAL` decimal(19,2) default NULL,
  `VERSION` int(11) NOT NULL,
  PRIMARY KEY  (`ID_PENJUALAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `tr_penjualan_detail`
--

DROP TABLE IF EXISTS `tr_penjualan_detail`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `tr_penjualan_detail` (
  `ID_PENJUALAN_DETAIL` varchar(19) NOT NULL,
  `HARGA` decimal(19,2) NOT NULL,
  `KUANTITAS` int(11) NOT NULL,
  `SUB_TOTAL` decimal(19,2) default NULL,
  `ID_PENJUALAN` varchar(16) NOT NULL,
  `ID_PRODUK` varchar(30) NOT NULL,
  PRIMARY KEY  (`ID_PENJUALAN_DETAIL`),
  KEY `FK2F57A2DFA61FC71D` (`ID_PENJUALAN`),
  KEY `FK2F57A2DFB7658619` (`ID_PRODUK`),
  CONSTRAINT `FK2F57A2DFB7658619` FOREIGN KEY (`ID_PRODUK`) REFERENCES `mst_produk` (`ID_PRODUK`),
  CONSTRAINT `FK2F57A2DFA61FC71D` FOREIGN KEY (`ID_PENJUALAN`) REFERENCES `tr_penjualan` (`ID_PENJUALAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2009-08-06 18:48:08
