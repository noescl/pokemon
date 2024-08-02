CREATE TABLE IF NOT EXISTS `request` (
      `id Long` int AUTO_INCREMENT  PRIMARY KEY,
      `ipOrigin` VARCHAR(10) NOT NULL,
      `time` TIMESTAMP NOT NULL,
      `method` VARCHAR(250) NOT NULL
);