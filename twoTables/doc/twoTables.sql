-- データベース名: twoTables
-- ユーザー名: sa
-- パスワード: (none)

DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS dept;

--
-- dept表
--
CREATE TABLE dept (
  id   CHAR(3)     PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);

-- 
-- employees表
-- 
CREATE TABLE employees (
  `id` CHAR(6) PRIMARY KEY,
  `name` VARCHAR(100) NOT NULL,
  `age` INT NOT NULL,
  `dept_id` CHAR(3)
);

-- 
-- 外部キー設定
-- 
ALTER TABLE employees
ADD
  CONSTRAINT fk_dept_id
  FOREIGN KEY (dept_id)
  REFERENCES dept (id);

--
-- データを挿入
--
INSERT INTO dept VALUES
('D01', '総務部'),
('D02', '経理部'),
('D03', '営業部'),
('D04', '開発部');

SELECT * FROM dept;

INSERT INTO employees VALUES
('EMP001', '湊 雄輔',     23, 'D01'),
('EMP002', '綾部 みゆき', 22, 'D02'),
('EMP003', '染谷 翔太',   24, 'D03'),
('EMP004', '二階堂 ふみ', 25, 'D04'),
('EMP005', '渡辺 哲',     26, 'D01');

SELECT * FROM employees;

--
-- 結合表
--
SELECT
  e.id AS id,
  e.name AS name,
  e.age AS age,
  d.id AS did,
  d.name AS dname
FROM employees e
  INNER JOIN dept d
  ON e.dept_id = d.id
ORDER BY e.id
