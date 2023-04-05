-- Product.product definition

CREATE TABLE `product` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `Name` varchar(255) DEFAULT NULL,
                           `Description` varchar(255) DEFAULT NULL,
                           `rating` varchar(255) DEFAULT NULL,
                           `Price` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
);