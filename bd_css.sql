CREATE DATABASE  IF NOT EXISTS `bd_css` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bd_css`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_css
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.25-MariaDB

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
-- Table structure for table `carrinho`
--

DROP TABLE IF EXISTS `carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrinho` (
  `id_car` int(11) NOT NULL,
  `id_prod` int(11) NOT NULL,
  `qtd_car` int(11) NOT NULL,
  `valor_car` decimal(8,2) NOT NULL,
  PRIMARY KEY (`id_car`),
  KEY `fk_produto_idx` (`id_prod`),
  CONSTRAINT `fk_produto` FOREIGN KEY (`id_prod`) REFERENCES `produto` (`id_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_car`) REFERENCES `usuarios` (`id_usu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho`
--

LOCK TABLES `carrinho` WRITE;
/*!40000 ALTER TABLE `carrinho` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cli` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome_cli` varchar(45) DEFAULT NULL,
  `endereco_cli` varchar(45) DEFAULT NULL,
  `cpf_cli` varchar(45) DEFAULT NULL,
  `rg_cli` varchar(45) DEFAULT NULL,
  `telefone_cli` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_cli`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `id_log` int(11) NOT NULL AUTO_INCREMENT,
  `id_usu` int(11) NOT NULL,
  `desc_log` varchar(128) NOT NULL,
  `data_log` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_log`),
  KEY `fk_usuario_log_idx` (`id_usu`),
  CONSTRAINT `fk_usuario_log` FOREIGN KEY (`id_usu`) REFERENCES `usuarios` (`id_usu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `id_prod` int(11) NOT NULL AUTO_INCREMENT,
  `nome_prod` varchar(32) NOT NULL,
  `desc_produto` varchar(128) DEFAULT NULL,
  `qtd_prod` int(11) DEFAULT '0',
  `valor_prod` decimal(8,2) NOT NULL,
  `cat_prod` varchar(16) NOT NULL,
  `create_time_prod` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status_prod` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_prod`),
  UNIQUE KEY `nome_prod_UNIQUE` (`nome_prod`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Teste','Teste',0,1.99,'Teste','2018-09-28 22:42:25',0),(2,'O teste','Teste 2',2,2.99,'Teste','2018-09-28 22:42:25',1),(4,'Teste 1','Isso é um teste',43,1.99,'Um teste','2018-09-29 01:15:42',1),(5,'adadad','adadad',1,1.00,'dsda','2018-09-29 01:55:23',1),(6,'Teste 3','Teste 2',2,2.99,'Teste','2018-09-29 04:36:17',1),(8,'Teste 0','Teste',1,1.99,'Teste','2018-09-29 04:39:46',1),(9,'Um produto','Teste',10,1.99,'Teste','2018-10-01 20:55:54',1),(10,'Produto','Este é um produto',15,2.99,'Teste','2018-10-01 22:15:38',1),(11,'Blusa','É uma blusa',31,1.25,'Roupa','2018-10-04 22:54:47',1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `select_active`
--

DROP TABLE IF EXISTS `select_active`;
/*!50001 DROP VIEW IF EXISTS `select_active`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `select_active` AS SELECT 
 1 AS `ID`,
 1 AS `Nome`,
 1 AS `Descrição`,
 1 AS `Quantidade`,
 1 AS `Valor`,
 1 AS `Categoria`,
 1 AS `create_time_prod`,
 1 AS `status_prod`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usu` int(11) NOT NULL AUTO_INCREMENT,
  `login_usu` varchar(16) NOT NULL,
  `nome_usu` varchar(45) NOT NULL,
  `email_usu` varchar(255) NOT NULL,
  `senha_usu` varchar(32) NOT NULL,
  `tipo_usu` tinyint(1) NOT NULL DEFAULT '0',
  `create_time_usu` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_usu`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','Admin','admin@teste.com','admin',1,'2018-08-10 00:59:14'),(4,'teste','Teste','teste@teste.com','teste',0,'2018-10-04 22:35:30'),(5,'bia','Ana B','bia@teste.com','1234',1,'2018-10-04 22:40:28');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `id_usu` int(11) NOT NULL,
  `id_prod` int(11) NOT NULL,
  `valor_venda` decimal(8,2) NOT NULL,
  `data_venda` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_venda`),
  KEY `fk_usuario_venda_idx` (`id_usu`),
  KEY `fk_produto_venda_idx` (`id_prod`),
  CONSTRAINT `fk_produto_venda` FOREIGN KEY (`id_prod`) REFERENCES `produto` (`id_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_venda` FOREIGN KEY (`id_usu`) REFERENCES `usuarios` (`id_usu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bd_css'
--

--
-- Final view structure for view `select_active`
--

/*!50001 DROP VIEW IF EXISTS `select_active`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `select_active` AS select `produto`.`id_prod` AS `ID`,`produto`.`nome_prod` AS `Nome`,`produto`.`desc_produto` AS `Descrição`,`produto`.`qtd_prod` AS `Quantidade`,`produto`.`valor_prod` AS `Valor`,`produto`.`cat_prod` AS `Categoria`,`produto`.`create_time_prod` AS `create_time_prod`,`produto`.`status_prod` AS `status_prod` from `produto` where (`produto`.`status_prod` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-04 20:16:51
