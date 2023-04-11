INSERT INTO CATEGORY (id, name)
SELECT 1, 'Goods'
WHERE NOT EXISTS(SELECT * FROM CATEGORY WHERE id = 1);

INSERT INTO CATEGORY (id, name)
SELECT 2, 'Photo Card'
WHERE NOT EXISTS(SELECT * FROM CATEGORY WHERE id = 2);

INSERT INTO CATEGORY (id, name)
SELECT 3, 'album'
WHERE NOT EXISTS(SELECT * FROM CATEGORY WHERE id = 3);

INSERT INTO USER(name, email, password)
SELECT '유저1', 'test1@naver.com', '123456789a'
WHERE NOT EXISTS(select * from USER where id = 1);

INSERT INTO USER(name, email, password)
SELECT '유저2', 'test2@naver.com', '123456789aa'
WHERE NOT EXISTS(select * from USER where id = 2);

INSERT INTO PRODUCT(category_id, title, price, product_status)
SELECT 1, '상품1', 100000, 'TRADABLE'
WHERE NOT EXISTS(select * from PRODUCT where id = 1);

INSERT INTO PRODUCT(category_id, title, price, product_status)
SELECT 2, '상품2', 200000, 'SOLD_COMPLETE'
WHERE NOT EXISTS(select * from PRODUCT where id = 2);



