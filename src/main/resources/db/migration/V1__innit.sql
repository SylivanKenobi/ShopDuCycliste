-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: warenkorb
-- ------------------------------------------------------
-- Server version	5.5.5-10.3.14-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `artikel`
--

DROP TABLE IF EXISTS `artikel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `artikel` (
                           `id` bigint(20) NOT NULL,
                           `aktiv` int(11) NOT NULL,
                           `model` varchar(255) NOT NULL,
                           `pfad` varchar(255) DEFAULT NULL,
                           `preis` double NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artikel`
--

LOCK TABLES `artikel` WRITE;
/*!40000 ALTER TABLE `artikel` DISABLE KEYS */;
INSERT INTO `artikel` VALUES (100,1,'Mountainbike','/mountainbike.jpg',4500),(101,1,'Rennvelo','/rennvelo.jpg',7500);
/*!40000 ALTER TABLE `artikel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bestell_position`
--

DROP TABLE IF EXISTS `bestell_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `bestell_position` (
                                    `id` bigint(20) NOT NULL,
                                    `artikel_fk` bigint(20) NOT NULL,
                                    `bestellung_fk` bigint(20) DEFAULT NULL,
                                    PRIMARY KEY (`id`),
                                    KEY `FKti97fkxvhwds6tgke5ohayh03` (`artikel_fk`),
                                    KEY `FK2cwrci8etkubly2oglbh0qo5y` (`bestellung_fk`),
                                    CONSTRAINT `FK2cwrci8etkubly2oglbh0qo5y` FOREIGN KEY (`bestellung_fk`) REFERENCES `bestellung` (`id`),
                                    CONSTRAINT `FKti97fkxvhwds6tgke5ohayh03` FOREIGN KEY (`artikel_fk`) REFERENCES `artikel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bestell_position`
--

LOCK TABLES `bestell_position` WRITE;
/*!40000 ALTER TABLE `bestell_position` DISABLE KEYS */;
/*!40000 ALTER TABLE `bestell_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bestellung`
--

DROP TABLE IF EXISTS `bestellung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `bestellung` (
                              `id` bigint(20) NOT NULL,
                              `bemerkungen` varchar(255) DEFAULT NULL,
                              `datum` datetime(6) NOT NULL,
                              `kunde_fk` bigint(20) NOT NULL,
                              PRIMARY KEY (`id`),
                              KEY `FKdeik3rb4q3366owhdpvipoffj` (`kunde_fk`),
                              CONSTRAINT `FKdeik3rb4q3366owhdpvipoffj` FOREIGN KEY (`kunde_fk`) REFERENCES `kunde` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bestellung`
--

LOCK TABLES `bestellung` WRITE;
/*!40000 ALTER TABLE `bestellung` DISABLE KEYS */;
/*!40000 ALTER TABLE `bestellung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `city` (
                        `id` bigint(20) NOT NULL,
                        `ort` varchar(255) NOT NULL,
                        `plz` varchar(255) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (100,'Bern','3000'),(101,'Hobbiton','3001');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `equipment` (
                             `id` bigint(20) NOT NULL,
                             `aktiv` int(11) NOT NULL,
                             `name` varchar(255) NOT NULL,
                             `preis` double NOT NULL,
                             `artikel_fk` bigint(20) DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `FKm5r1uxberkhnpinl6ug2we5tg` (`artikel_fk`),
                             CONSTRAINT `FKm5r1uxberkhnpinl6ug2we5tg` FOREIGN KEY (`artikel_fk`) REFERENCES `artikel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES (100,1,'CushCore',12,100),(101,1,'Pumpe',13,101),(102,1,'Tubeless',13,100),(103,1,'Bidonhalter',13,101);
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment_set`
--

DROP TABLE IF EXISTS `equipment_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `equipment_set` (
                                 `bestellposition_fk` bigint(20) NOT NULL,
                                 `equipment_fk` bigint(20) NOT NULL,
                                 PRIMARY KEY (`bestellposition_fk`,`equipment_fk`),
                                 KEY `FK2jx6qmnscuqh7241g4ormhesn` (`equipment_fk`),
                                 CONSTRAINT `FK2jx6qmnscuqh7241g4ormhesn` FOREIGN KEY (`equipment_fk`) REFERENCES `equipment` (`id`),
                                 CONSTRAINT `FKjbvj1097ultc9k2owcet6djrr` FOREIGN KEY (`bestellposition_fk`) REFERENCES `bestell_position` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_set`
--

LOCK TABLES `equipment_set` WRITE;
/*!40000 ALTER TABLE `equipment_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipment_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `flyway_schema_history` (
                                         `installed_rank` int(11) NOT NULL,
                                         `version` varchar(50) DEFAULT NULL,
                                         `description` varchar(200) NOT NULL,
                                         `type` varchar(20) NOT NULL,
                                         `script` varchar(1000) NOT NULL,
                                         `checksum` int(11) DEFAULT NULL,
                                         `installed_by` varchar(100) NOT NULL,
                                         `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
                                         `execution_time` int(11) NOT NULL,
                                         `success` tinyint(1) NOT NULL,
                                         PRIMARY KEY (`installed_rank`),
                                         KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','innit','SQL','V1__innit.sql',0,'root','2019-06-15 11:47:50',1,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kunde`
--

DROP TABLE IF EXISTS `kunde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `kunde` (
                         `id` bigint(20) NOT NULL,
                         `kunde_seit` datetime(6) DEFAULT NULL,
                         `nachname` varchar(255) NOT NULL,
                         `strasse` varchar(255) NOT NULL,
                         `tel_nr` varchar(255) DEFAULT NULL,
                         `vorname` varchar(255) NOT NULL,
                         `city_fk` bigint(20) NOT NULL,
                         PRIMARY KEY (`id`),
                         KEY `FKimd4s00ssnh7qli0v8m401hfj` (`city_fk`),
                         CONSTRAINT `FKimd4s00ssnh7qli0v8m401hfj` FOREIGN KEY (`city_fk`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kunde`
--

LOCK TABLES `kunde` WRITE;
/*!40000 ALTER TABLE `kunde` DISABLE KEYS */;
INSERT INTO `kunde` VALUES (100,NULL,'Gamgee','Strasse',NULL,'Samwise',100),(101,NULL,'Beutlin','Strasse',NULL,'Frodo',101);
/*!40000 ALTER TABLE `kunde` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_artikel`
--

DROP TABLE IF EXISTS `seq_artikel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `seq_artikel` (
                               `next_not_cached_value` bigint(21) NOT NULL,
                               `minimum_value` bigint(21) NOT NULL,
                               `maximum_value` bigint(21) NOT NULL,
                               `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
                               `increment` bigint(21) NOT NULL COMMENT 'increment value',
                               `cache_size` bigint(21) unsigned NOT NULL,
                               `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
                               `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_artikel`
--

LOCK TABLES `seq_artikel` WRITE;
/*!40000 ALTER TABLE `seq_artikel` DISABLE KEYS */;
INSERT INTO `seq_artikel` VALUES (1,1,9223372036854775806,1,50,1000,0,0);
/*!40000 ALTER TABLE `seq_artikel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_bestellung`
--

DROP TABLE IF EXISTS `seq_bestellung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `seq_bestellung` (
                                  `next_not_cached_value` bigint(21) NOT NULL,
                                  `minimum_value` bigint(21) NOT NULL,
                                  `maximum_value` bigint(21) NOT NULL,
                                  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
                                  `increment` bigint(21) NOT NULL COMMENT 'increment value',
                                  `cache_size` bigint(21) unsigned NOT NULL,
                                  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
                                  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_bestellung`
--

LOCK TABLES `seq_bestellung` WRITE;
/*!40000 ALTER TABLE `seq_bestellung` DISABLE KEYS */;
INSERT INTO `seq_bestellung` VALUES (1,1,9223372036854775806,1,50,1000,0,0);
/*!40000 ALTER TABLE `seq_bestellung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_bestellung_pos`
--

DROP TABLE IF EXISTS `seq_bestellung_pos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `seq_bestellung_pos` (
                                      `next_not_cached_value` bigint(21) NOT NULL,
                                      `minimum_value` bigint(21) NOT NULL,
                                      `maximum_value` bigint(21) NOT NULL,
                                      `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
                                      `increment` bigint(21) NOT NULL COMMENT 'increment value',
                                      `cache_size` bigint(21) unsigned NOT NULL,
                                      `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
                                      `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_bestellung_pos`
--

LOCK TABLES `seq_bestellung_pos` WRITE;
/*!40000 ALTER TABLE `seq_bestellung_pos` DISABLE KEYS */;
INSERT INTO `seq_bestellung_pos` VALUES (1,1,9223372036854775806,1,50,1000,0,0);
/*!40000 ALTER TABLE `seq_bestellung_pos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_city`
--

DROP TABLE IF EXISTS `seq_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `seq_city` (
                            `next_not_cached_value` bigint(21) NOT NULL,
                            `minimum_value` bigint(21) NOT NULL,
                            `maximum_value` bigint(21) NOT NULL,
                            `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
                            `increment` bigint(21) NOT NULL COMMENT 'increment value',
                            `cache_size` bigint(21) unsigned NOT NULL,
                            `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
                            `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_city`
--

LOCK TABLES `seq_city` WRITE;
/*!40000 ALTER TABLE `seq_city` DISABLE KEYS */;
INSERT INTO `seq_city` VALUES (1,1,9223372036854775806,1,50,1000,0,0);
/*!40000 ALTER TABLE `seq_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_inhalt`
--

DROP TABLE IF EXISTS `seq_inhalt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `seq_inhalt` (
                              `next_not_cached_value` bigint(21) NOT NULL,
                              `minimum_value` bigint(21) NOT NULL,
                              `maximum_value` bigint(21) NOT NULL,
                              `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
                              `increment` bigint(21) NOT NULL COMMENT 'increment value',
                              `cache_size` bigint(21) unsigned NOT NULL,
                              `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
                              `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_inhalt`
--

LOCK TABLES `seq_inhalt` WRITE;
/*!40000 ALTER TABLE `seq_inhalt` DISABLE KEYS */;
INSERT INTO `seq_inhalt` VALUES (1,1,9223372036854775806,1,50,1000,0,0);
/*!40000 ALTER TABLE `seq_inhalt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_kunde`
--

DROP TABLE IF EXISTS `seq_kunde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `seq_kunde` (
                             `next_not_cached_value` bigint(21) NOT NULL,
                             `minimum_value` bigint(21) NOT NULL,
                             `maximum_value` bigint(21) NOT NULL,
                             `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
                             `increment` bigint(21) NOT NULL COMMENT 'increment value',
                             `cache_size` bigint(21) unsigned NOT NULL,
                             `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
                             `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_kunde`
--

LOCK TABLES `seq_kunde` WRITE;
/*!40000 ALTER TABLE `seq_kunde` DISABLE KEYS */;
INSERT INTO `seq_kunde` VALUES (1,1,9223372036854775806,1,50,1000,0,0);
/*!40000 ALTER TABLE `seq_kunde` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-15 15:43:51
