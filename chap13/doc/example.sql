-- h2database: example
-- ユーザー名: sa
-- パスワード: (なし)

CREATE TABLE employees (
  id   CHAR(6) PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  age  INT NOT NULL,
  dept_id CHAR(3)
);

INSERT INTO employees 
  (id, name, age, dept_id)
VALUES
  ('EMP001', '湊 雄輔', 23, 'D01'),
  ('EMP002', '綾部 みゆき', 22, 'D02');


INSERT INTO employees 
  (id, name, age, dept_id)
VALUES
  ('EMP003', '菅原 拓馬', 34, 'D03');

  
