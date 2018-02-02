DROP TABLE IF EXISTS title;
CREATE TABLE title (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  parent_id    BIGINT
  COMMENT '父级导航id',
  name         VARCHAR(24)
  COMMENT '导航名称',
  link_url     VARCHAR(128)
  COMMENT '链接地址',
  gmt_create   DATETIME,
  gmt_modified DATETIME
);

INSERT INTO title
(parent_id, name, link_url, gmt_create, gmt_modified)
VALUES
  (NULL, '教学天地', NULL, now(), now()),
  (1, '课程教学', 'http://www.baidu.com', now(), now()),
  (1, '实验教学', 'http://www.baidu.com', now(), now()),
  (NULL, '成果展示', NULL, now(), now()),
  (NULL, '科学文献', NULL, now(), now());

DROP TABLE IF EXISTS article;
CREATE TABLE article (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  title_id     BIGINT,
  name         VARCHAR(128)
  COMMENT '文章标题',
  upload_time  DATETIME
  COMMENT '上传文章时间',
  content      TEXT
  COMMENT '文章内容',
  is_deleted   INTEGER,
  gmt_create   DATETIME,
  gmt_modified DATETIME
);

DROP TABLE IF EXISTS image;
CREATE TABLE image (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  name         VARCHAR(128)
  COMMENT '图片标题',
  upload_time  DATETIME
  COMMENT '上传图片时间',
  url          VARCHAR(128)
  COMMENT '图片URL',
  is_deleted   INTEGER,
  gmt_create   DATETIME,
  gmt_modified DATETIME
);