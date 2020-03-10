# Dump of table dial
# ------------------------------------------------------------

DROP TABLE IF EXISTS `dial`;

CREATE TABLE `dial` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `aip` varchar(255) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `date` date DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

LOCK TABLES `dial` WRITE;
/*!40000 ALTER TABLE `dial` DISABLE KEYS */;

INSERT INTO `dial` (`id`, `aip`, `created_on`, `date`, `value`)
VALUES
        (1,'100','2020-01-19 00:00:00','2020-01-19','200'),
        (7,'200',NULL,'2020-01-22','300');

/*!40000 ALTER TABLE `dial` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table email
# ------------------------------------------------------------

DROP TABLE IF EXISTS `email`;

CREATE TABLE `email` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `click` varchar(255) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `date` date DEFAULT NULL,
  `open` varchar(255) DEFAULT NULL,
  `sent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;

INSERT INTO `email` (`id`, `click`, `created_on`, `date`, `open`, `sent`)
VALUES
        (1,'300','2020-01-19 00:00:00','2020-01-19','200','100'),
        (3,'400',NULL,'2020-01-23','200','100');

/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `passwordconfirm` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `email`, `firstname`, `lastname`, `password`, `passwordconfirm`, `role`)
VALUES
        (1,'admin@gmail.com','rob','thomas','$2a$10$G0Kk.vrKvTgJggLq06OF.ueGyyXvu2HQDQ8Rnj8X3FejTc/xs8W5i','$2a$10$G0Kk.vrKvTgJggLq06OF.ueGyyXvu2HQDQ8Rnj8X3FejTc/xs8W5i','ADMIN'),
        (2,'dev@dev.com','rob','thomas','$2a$10$G0Kk.vrKvTgJggLq06OF.ueGyyXvu2HQDQ8Rnj8X3FejTc/xs8W5i','$2a$10$G0Kk.vrKvTgJggLq06OF.ueGyyXvu2HQDQ8Rnj8X3FejTc/xs8W5i','USER');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

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


