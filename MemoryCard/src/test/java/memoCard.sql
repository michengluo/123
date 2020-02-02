use memo_card;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `wx_open_id` varchar(255) DEFAULT NULL COMMENT '微信openId',
  `qq_open_id` varchar(255) DEFAULT NULL COMMENT 'QQopenId',
  `code` varchar(255) DEFAULT NULL COMMENT '微信code',
  `card_no` varchar(255) NOT NULL COMMENT '卡号',
  `qq_no` varchar(255) NOT NULL COMMENT 'QQ',
  `school_code` varchar(255) DEFAULT '0' COMMENT '学校代号',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_wx_open_id` (`wx_open_id`),
  UNIQUE KEY `uk_qq_open_id` (`qq_open_id`),
  UNIQUE KEY `uk_user_card_no_a_school_code` (`card_no`,`school_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='卡记录信息';