DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(10) NOT NULL COLLATE 'utf8_general_ci',
	`age` INT(3) NOT NULL,
	`birthday` DATE NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE
) COLLATE='utf8_general_ci' ENGINE=InnoDB;
