CREATE DATABASE  IF NOT EXISTS `mfr` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mfr`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mfr
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient` (
  `ingredient_id` bigint NOT NULL AUTO_INCREMENT,
  `ingredient_name` varchar(255) NOT NULL,
  PRIMARY KEY (`ingredient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (1,'Spaghetti'),(2,'Ground Beef'),(3,'Tomato Sauce'),(4,'Chicken Breast'),(5,'Curry Powder'),(6,'Romaine Lettuce'),(7,'Croutons'),(8,'Soy Sauce'),(9,'Carrot'),(10,'Potatoes'),(11,'Flour'),(12,'Milk'),(13,'Eggs'),(14,'Salmon'),(15,'Lemon'),(16,'Tortillas'),(17,'Salsa'),(18,'Cheese'),(19,'Béchamel Sauce'),(20,'Veggie Patty');
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `recipe_id` bigint NOT NULL AUTO_INCREMENT,
  `recipe_description` text,
  `recipe_name` varchar(255) NOT NULL,
  PRIMARY KEY (`recipe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (1,'A classic Italian pasta dish with rich meat sauce.','Spaghetti Bolognese'),(2,'A spicy and flavorful curry with tender chicken.','Chicken Curry'),(3,'A fresh salad with romaine lettuce, croutons, and dressing.','Caesar Salad'),(4,'A stir fry with assorted vegetables and soy sauce.','Veggie Stir Fry'),(5,'A hearty stew with beef, potatoes, and vegetables.','Beef Stew'),(6,'Light and fluffy breakfast pancakes.','Pancakes'),(7,'A healthy grilled salmon fillet with lemon.','Grilled Salmon'),(8,'Mexican dish with seasoned meat, salsa, and tortillas.','Tacos'),(9,'Layers of pasta, meat sauce, cheese, and béchamel.','Lasagna'),(10,'A plant-based burger with various vegetables and spices.','Veggie Burger');
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe_ingredient`
--

DROP TABLE IF EXISTS `recipe_ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe_ingredient` (
  `ingredient_id` bigint NOT NULL,
  `recipe_id` bigint NOT NULL,
  PRIMARY KEY (`ingredient_id`,`recipe_id`),
  KEY `FKgu1oxq7mbcgkx5dah6o8geirh` (`recipe_id`),
  CONSTRAINT `FK9b3oxoskt0chwqxge0cnlkc29` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`ingredient_id`),
  CONSTRAINT `FKgu1oxq7mbcgkx5dah6o8geirh` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe_ingredient`
--

LOCK TABLES `recipe_ingredient` WRITE;
/*!40000 ALTER TABLE `recipe_ingredient` DISABLE KEYS */;
INSERT INTO `recipe_ingredient` VALUES (1,1),(2,1),(3,1),(4,2),(5,2),(6,3),(7,3),(8,4),(9,4),(10,4),(2,5),(9,5),(10,5),(11,6),(12,6),(13,6),(14,7),(15,7),(2,8),(16,8),(17,8),(1,9),(2,9),(18,9),(19,9),(16,10),(20,10);
/*!40000 ALTER TABLE `recipe_ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `user_password` varchar(255) NOT NULL,
  `user_uname` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'P@ssw0rd123','john_doe'),(2,'Qwerty!456','jane_smith'),(3,'AbcD#789','michael_brown'),(4,'Secure*321','emily_clark'),(5,'Pass!9876','david_jones'),(6,'Hello#4321','sophia_miller'),(7,'Test123$','liam_wilson'),(8,'Alpha@5678','olivia_davis'),(9,'Bravo!1357','noah_moore'),(10,'Charlie*2468','ava_taylor');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-13 21:00:40
