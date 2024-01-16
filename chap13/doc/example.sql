-- h2database: example
-- ユーザー名: sa
-- パスワード: (なし)

-- もし存在していたら、ユーザーを削除
DROP USER IF EXISTS 'sa'@'localhost';

-- ユーザーの作成
CREATE USER 'sa'@'localhost' IDENTIFIED BY '';
GRANT ALL ON example.* to 'sa'@'localhost';

-- データベースの作成
CREATE DATABASE IF NOT EXISTS example;
USE example;

-- テーブルの削除
DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  id   CHAR(6) PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  age  INT NOT NULL
);

INSERT INTO employees 
  (id, name, age)
VALUES
  ('EMP001', '湊 雄輔', 23),
  ('EMP002', '綾部 みゆき', 22);

  
