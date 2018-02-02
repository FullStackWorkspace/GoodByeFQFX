DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  account      VARCHAR(24) UNIQUE NOT NULL
  COMMENT '帐号',
  password     VARCHAR(32)        NOT NULL
  COMMENT '密码',
  name         VARCHAR(24)
  COMMENT '姓名',
  status       INTEGER
  COMMENT '状态 1学生/2教师',
  faculty      VARCHAR(36)
  COMMENT '院系',
  major        VARCHAR(36)
  COMMENT '专业',
  is_deleted   INTEGER,
  gmt_create   DATETIME,
  gmt_modified DATETIME
);

INSERT INTO `user`
(account, password, name, status, faculty, major, is_deleted, gmt_create, gmt_modified)
VALUES
  ('118532014058', 'w123456', '王基鸿', 1, '电信学院', '计算机科学与技术', 0, now(), now()),
  ('118532014059', 'w123456', '杨鸿智', 1, '电信学院', '计算机科学与技术', 0, now(), now()),
  ('teach123456', 'w123456', '郭永宁', 2, '电信学院', NULL, 0, now(), now());

DROP TABLE IF EXISTS user_log;
CREATE TABLE user_log (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id      BIGINT NOT NULL,
  login_time   DATETIME,
  login_ip     VARCHAR(20),
  gmt_create   DATETIME,
  gmt_modified DATETIME
);