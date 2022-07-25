CREATE TABLE `t_user_base`
(
    `account_id`     int(11) NOT NULL AUTO_INCREMENT,
    `user_id`   varchar(50)  NOT NULL,
    `amount`    tinyint(4) NOT NULL,
    `add_dt`   varchar(100) NOT NULL,
    `update_dt`  varchar(50)  NOT NULL,
    PRIMARY KEY (`account_id`),
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;