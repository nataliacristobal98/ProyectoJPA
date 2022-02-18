-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: proyectofinal
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_alumno` varchar(4) NOT NULL,
  `contrasena` varchar(20) NOT NULL,
  `icono` varchar(300) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `profesor_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_a1sgf78hr7db1g176hmdct92y` (`codigo_alumno`),
  KEY `FKhff1gqa4109u95km9o4lsrxmc` (`profesor_id`),
  CONSTRAINT `FKhff1gqa4109u95km9o4lsrxmc` FOREIGN KEY (`profesor_id`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'A001','flora123','NULL','Marina Gonzalez Mora',1),(2,'A002','mArtE_08','NULL','Felisa Domenech',1);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_mundos`
--

DROP TABLE IF EXISTS `alumno_mundos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_mundos` (
  `alumno_id` bigint NOT NULL,
  `mundos_id` bigint NOT NULL,
  PRIMARY KEY (`alumno_id`,`mundos_id`),
  KEY `FKoaxthda32flus3fi3keg38tcd` (`mundos_id`),
  CONSTRAINT `FKoaxthda32flus3fi3keg38tcd` FOREIGN KEY (`mundos_id`) REFERENCES `mundo` (`id`),
  CONSTRAINT `FKoqxoouytqqp76wmwcl3g04mgw` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_mundos`
--

LOCK TABLES `alumno_mundos` WRITE;
/*!40000 ALTER TABLE `alumno_mundos` DISABLE KEYS */;
INSERT INTO `alumno_mundos` VALUES (1,1),(2,1);
/*!40000 ALTER TABLE `alumno_mundos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leccion`
--

DROP TABLE IF EXISTS `leccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leccion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_lec` varchar(4) NOT NULL,
  `contenido` varchar(255) NOT NULL,
  `terminado` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8ugkx4foc3tx4lvm69es6okv` (`codigo_lec`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leccion`
--

LOCK TABLES `leccion` WRITE;
/*!40000 ALTER TABLE `leccion` DISABLE KEYS */;
INSERT INTO `leccion` VALUES (1,'HL01','Vamos a aprender sobre las etiquetas HTML','\0');
/*!40000 ALTER TABLE `leccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mundo`
--

DROP TABLE IF EXISTS `mundo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mundo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_mun` varchar(2) NOT NULL,
  `desbloqueado` bit(1) NOT NULL,
  `dificultad` int NOT NULL,
  `puntos_desbloqueo` int NOT NULL,
  `tematica` varchar(50) NOT NULL,
  `terminado` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3yu5ks8vkb36tyn3epxgf3h2s` (`codigo_mun`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mundo`
--

LOCK TABLES `mundo` WRITE;
/*!40000 ALTER TABLE `mundo` DISABLE KEYS */;
INSERT INTO `mundo` VALUES (1,'H','',1,0,'HTML','\0'),(2,'J','\0',2,5,'JAVA','\0');
/*!40000 ALTER TABLE `mundo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nivel`
--

DROP TABLE IF EXISTS `nivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nivel` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_nivel` varchar(4) NOT NULL,
  `desbloqueado` bit(1) NOT NULL,
  `dificultad` int NOT NULL,
  `puntuacion_max` int NOT NULL,
  `puntuacion_min` int NOT NULL,
  `puntuacion` int DEFAULT NULL,
  `terminado` bit(1) NOT NULL,
  `leccion_id` bigint NOT NULL,
  `mundo_id` bigint NOT NULL,
  `recompensa_id` bigint DEFAULT NULL,
  `test_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_a1lo1tj4wd8mqm2jgd214jd68` (`leccion_id`),
  UNIQUE KEY `UK_5nohqe7xt5cf6eytk8qofb3vw` (`test_id`),
  UNIQUE KEY `UK_smvu914go571gsnol2n6v84y3` (`codigo_nivel`),
  UNIQUE KEY `UK_bs1ll2exj37bulhc12byu3g16` (`recompensa_id`),
  KEY `FKo1rlotju7mcalmua38938bc2p` (`mundo_id`),
  CONSTRAINT `FK61rmokh9j34gs5jh3bkoirhbo` FOREIGN KEY (`recompensa_id`) REFERENCES `recompensa` (`id`),
  CONSTRAINT `FK93pwkxkc5je872n5n1gmalo02` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`),
  CONSTRAINT `FKg6gj7yfheim7u0a21fr6uiek8` FOREIGN KEY (`leccion_id`) REFERENCES `leccion` (`id`),
  CONSTRAINT `FKo1rlotju7mcalmua38938bc2p` FOREIGN KEY (`mundo_id`) REFERENCES `mundo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nivel`
--

LOCK TABLES `nivel` WRITE;
/*!40000 ALTER TABLE `nivel` DISABLE KEYS */;
INSERT INTO `nivel` VALUES (1,'H01','',1,10,5,NULL,'\0',1,1,NULL,1);
/*!40000 ALTER TABLE `nivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pregunta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `acertada` bit(1) DEFAULT NULL,
  `codigo_pr` varchar(6) NOT NULL,
  `imagen_pregunta` varchar(255) DEFAULT NULL,
  `texto_pregunta` varchar(255) NOT NULL,
  `test_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cl5gp9vyrmtlote7sms5j3tbo` (`codigo_pr`),
  KEY `FK6ln0gn1q6lmg25xx3g2vnojfv` (`test_id`),
  CONSTRAINT `FK6ln0gn1q6lmg25xx3g2vnojfv` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta`
--

LOCK TABLES `pregunta` WRITE;
/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` VALUES (1,NULL,'HP01','NULL','Pregunta 1: ¿Que etiqueta se usa para poner texto?',1),(2,NULL,'HP02','NULL','Pregunta 2: ¿Donde se debe colocar el contenido que queremos enseñar en nuestra página web?',1);
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_profesor` varchar(1) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rxmluhmk7ww0agwq2v8emrmlu` (`codigo_profesor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'A','Teresa Parraga Rodriguez'),(2,'B','Miguel Garcia Lopez'),(3,'C','Beatriz Gil Rouco');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recompensa`
--

DROP TABLE IF EXISTS `recompensa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recompensa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `desbloqueada` bit(1) NOT NULL,
  `ruta_recompensa` varchar(300) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recompensa`
--

LOCK TABLES `recompensa` WRITE;
/*!40000 ALTER TABLE `recompensa` DISABLE KEYS */;
/*!40000 ALTER TABLE `recompensa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuesta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(6) NOT NULL,
  `correcta` bit(1) NOT NULL,
  `texto_respuesta` varchar(255) NOT NULL,
  `pregunta_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_91fs739cw6ra4yatlcojjpa20` (`codigo`),
  KEY `FKd9oyrwyjw1otr38btjeevanif` (`pregunta_id`),
  CONSTRAINT `FKd9oyrwyjw1otr38btjeevanif` FOREIGN KEY (`pregunta_id`) REFERENCES `pregunta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
INSERT INTO `respuesta` VALUES (1,'HR01','','<p>',1),(2,'HR02','\0','<h1>',1),(3,'HR03','\0','<a>',1),(4,'HR04','\0','<t>',1),(5,'HR05','','Dentro de la etiqueta <body>',2),(6,'HR06','\0','Dentro de la etiqueta <head>',2),(7,'HR07','\0','Da igual donde mientras esté dentro de la etiqueta <html>',2),(8,'HR08','\0','Ninguna de las anteriores',2);
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(4) NOT NULL,
  `terminado` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lgdjyivlgb8lsu0o0c66joyai` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'HT01','\0');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'proyectofinal'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-06 16:26:14
