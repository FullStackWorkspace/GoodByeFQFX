DROP TABLE IF EXISTS admin;
CREATE TABLE admin (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  account      VARCHAR(24) UNIQUE NOT NULL
  COMMENT '帐号',
  password     VARCHAR(32)        NOT NULL
  COMMENT '密码',
  name         VARCHAR(24)
  COMMENT '姓名',
  status       INTEGER
  COMMENT '状态，1普通/2封禁/3超级',
  is_deleted   INTEGER,
  gmt_create   DATETIME,
  gmt_modified DATETIME
);

INSERT INTO admin
(account, password, name, status, is_deleted, gmt_create, gmt_modified)
VALUES
  ('w976228284', 'w12345', '王基鸿', 1, 0, now(), now()),
  ('admin', 'admin123', '超级管理', 3, 0, now(), now()),
  ('admin123', 'w123456', '管理员', 1, 0, now(), now());

DROP TABLE IF EXISTS admin_log;
CREATE TABLE admin_log (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  admin_id     BIGINT NOT NULL,
  login_time   DATETIME
  COMMENT '登录时间',
  login_ip     VARCHAR(20)
  COMMENT '登录IP',
  gmt_create   DATETIME,
  gmt_modified DATETIME
);