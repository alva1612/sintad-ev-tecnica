-- MySQL dump 10.13  Distrib 8.0.30, for Linux (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_entidad`
--

DROP TABLE IF EXISTS `tb_entidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_entidad` (
  `id_entidad` int NOT NULL AUTO_INCREMENT,
  `id_tipo_documento` int DEFAULT NULL,
  `nro_documento` varchar(45) DEFAULT NULL,
  `razon_social` varchar(45) DEFAULT NULL,
  `nombre_comercial` varchar(45) DEFAULT NULL,
  `id_tipo_contribuyente` int DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `estado` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id_entidad`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`),
  UNIQUE KEY `razon_social_UNIQUE` (`razon_social`),
  KEY `fk_tb_entidad_1_idx` (`id_tipo_documento`),
  KEY `fk_tb_entidad_tcontribuyente_idx` (`id_tipo_contribuyente`),
  CONSTRAINT `fk_tb_entidad_tcontribuyente` FOREIGN KEY (`id_tipo_contribuyente`) REFERENCES `tb_tipo_contribuyente` (`id_tipo_contribuyente`),
  CONSTRAINT `fk_tb_entidad_tdocumento` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tb_tipo_documento` (`id_tipo_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_entidad`
--

LOCK TABLES `tb_entidad` WRITE;
/*!40000 ALTER TABLE `tb_entidad` DISABLE KEYS */;
INSERT INTO `tb_entidad` VALUES (1,1,'N000008','211123458','Nosadas Hogar',2,'Direccion','987986918',_binary ''),(27,2,'N000007','211123459','Grupo Imagen Slavenme',3,'Direcciondetelfeo','987986919',_binary '');
/*!40000 ALTER TABLE `tb_entidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_contribuyente`
--

DROP TABLE IF EXISTS `tb_tipo_contribuyente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo_contribuyente` (
  `id_tipo_contribuyente` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `estado` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id_tipo_contribuyente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_contribuyente`
--

LOCK TABLES `tb_tipo_contribuyente` WRITE;
/*!40000 ALTER TABLE `tb_tipo_contribuyente` DISABLE KEYS */;
INSERT INTO `tb_tipo_contribuyente` VALUES (1,'Persona Natural',_binary ''),(2,'Empresa',_binary ''),(3,'Asociación',_binary '\0');
/*!40000 ALTER TABLE `tb_tipo_contribuyente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_documento`
--

DROP TABLE IF EXISTS `tb_tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo_documento` (
  `id_tipo_documento` int NOT NULL,
  `codigo` varchar(20) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  `estado` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id_tipo_documento`),
  UNIQUE KEY `id_tipo_documento_UNIQUE` (`id_tipo_documento`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_documento`
--

LOCK TABLES `tb_tipo_documento` WRITE;
/*!40000 ALTER TABLE `tb_tipo_documento` DISABLE KEYS */;
INSERT INTO `tb_tipo_documento` VALUES (1,'TD1','RUC','RUC de Empresa',_binary ''),(2,'TD2','RUC15','RUC de personas con carné de extranjería',_binary '\0'),(3,'TD3','DNI','Documento Nacional de identidad',_binary '');
/*!40000 ALTER TABLE `tb_tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_rol` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rol_id` bigint DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe3kd49gu3mhj2ty5kl44qsytp` (`rol_id`),
  KEY `FKktsemf1f6awjww4da0ocv4n32` (`usuario_id`),
  CONSTRAINT `FKe3kd49gu3mhj2ty5kl44qsytp` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKktsemf1f6awjww4da0ocv4n32` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
INSERT INTO `usuario_rol` VALUES (1,1,1);
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'a@gmail.com',_binary '','123456','alvaro');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-19  3:40:07
