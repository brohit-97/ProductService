-- Category Table Data

INSERT INTO category (id,name) VALUES (gen_random_uuid (),'Electronics');
INSERT INTO category (id,name) VALUES (gen_random_uuid (),'Clothing');
INSERT INTO category (id,name) VALUES (gen_random_uuid (),'Furniture');

-- Product Table Data

INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Samsung Galaxy S10',1000,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Electronics'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Samsung Galaxy S20',1200,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Electronics'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Samsung Galaxy S30',1300,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Electronics'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Samsung Galaxy S40',1400,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Electronics'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Samsung Galaxy S50',1500,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Electronics'));

INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Nike Air Max',100,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Clothing'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Nike Air Max 2',200,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Clothing'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Nike Air Max 3',300,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Clothing'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Nike Air Max 4',400,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Clothing'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Nike Air Max 5',500,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Clothing'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Nike Air Max 6',600,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Clothing'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Nike Air Max 7',700,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Clothing'));

INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Table',100,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Furniture'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Chair',200,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Furniture'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Sofa',300,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Furniture'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Bed',400,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Furniture'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Wardrobe',500,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Furniture'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Dining Table',600,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Furniture'));
INSERT INTO product (id,title,price,image_url,category_id) VALUES (gen_random_uuid (),'Dining Chair',700,'https://images-na.ssl-images-amazon.com/images/I/61bIq6yXJqL._AC_SL1000_.jpg',(SELECT id FROM category WHERE name='Furniture'));