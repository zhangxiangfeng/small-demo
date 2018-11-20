DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor` (
  `id`          int(11) NOT NULL,
  `name`        varchar(45) DEFAULT NULL,
  `update_time` datetime    DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
INSERT INTO `actor` (`id`, `name`, `update_time`)
VALUES (1, 'a', '20171222 15:27:18'),
       (2, 'b', '20171222 15:27:18'),
       (3, 'c', '20171222 15:27:18');
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `id`   int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10)      DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
INSERT INTO `film` (`id`, `name`)
VALUES (3, 'film0'),
       (1, 'film1'),
       (2, 'film2');
DROP TABLE IF EXISTS `film_actor`;
CREATE TABLE `film_actor` (
  `id`       int(11) NOT NULL,
  `film_id`  int(11) NOT NULL,
  `actor_id` int(11) NOT NULL,
  `remark`   varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_film_actor_id` (`film_id`, `actor_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
INSERT INTO `film_actor` (`id`, `film_id`, `actor_id`)
VALUES (1, 1, 1),
       (2, 1, 2),
       (3, 2, 1);
CREATE TABLE `employees` (
  `id`        int(11)     NOT NULL AUTO_INCREMENT,
  `name`      varchar(24) NOT NULL DEFAULT ''
  COMMENT '姓名',
  `age`       int(11)     NOT NULL DEFAULT '0'
  COMMENT '年龄',
  `position`  varchar(20) NOT NULL DEFAULT ''
  COMMENT '职位',
  `hire_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '入职时间',
  PRIMARY KEY (`id`),
  KEY `idx_name_age_position` (`name`, `age`, `position`) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8
  COMMENT = '员工记录表';
INSERT INTO employees (name, age, position, hire_time)
VALUES ('LiLei', 22, 'manager', NOW());
INSERT INTO employees (name, age, position, hire_time)
VALUES ('HanMeimei', 23, 'dev', NOW());
INSERT INTO employees (name, age, position, hire_time)
VALUES ('Lucy', 23, 'dev', NOW());