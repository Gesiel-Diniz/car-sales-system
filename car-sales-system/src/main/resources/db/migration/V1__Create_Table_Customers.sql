CREATE TABLE `customers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `street_address` varchar(100) NOT NULL,
  `number_address` varchar(10) NOT NULL,
  `neighborhood` varchar(100) NOT NULL,
  `zip_code_address` varchar(10) NOT NULL,
  `city_address` varchar(100) NOT NULL,
  `state_address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;