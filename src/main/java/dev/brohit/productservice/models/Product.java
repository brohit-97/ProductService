package dev.brohit.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Entity
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel{

    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    @ManyToOne
    private Category category;

}


// SQL insert queries for the data.sql file:

// INSERT INTO category (name) VALUES ('Electronics');
// INSERT INTO category (name) VALUES ('Clothing');
// INSERT INTO category (name) VALUES ('Furniture');

// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ((S), '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'iPhone 12', 'Apple iPhone 12', '799.99', 'https://images.unsplash.com/photo-1602522558517-9f8b7c33b6c5?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aXBob25lJTIwMTJ8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80', '1');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('3', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Samsung Galaxy S20', 'Samsung Galaxy, 2020', '599.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c2Ftc3VuZyUyMGdhbGF4eSUyMHN2aWV3JTIwc2hpcnQlMjBzJTIwc2FsZSUyMGdhbGF4eSUyMHN2aWV3JTIwc2hpcnQ=', '1');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('4', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Samsung Galaxy S10', 'Samsung Galaxy, 2019', '499.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c2Ftc3VuZyUyMGdhbGF4eSUyMHN2aWV3JTIwc2hpcnQlMjBzJTIwc2FsZSUyMGdhbGF4eSUyMHN2aWV3JTIwc2hpcnQ=', '1');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('5', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Samsung Galaxy S9', 'Samsung Galaxy, 2018', '399.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c2Ftc3VuZyUyMGdhbGF4eSUyMHN2aWV3JTIwc2hpcnQlMjBzJTIwc2FsZSUyMGdhbGF4eSUyMHN2aWV3JTIwc2hpcnQ=', '1');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('6', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Samsung Galaxy S8', 'Samsung Galaxy, 2017', '299.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c2Ftc3VuZyUyMGdhbGF4eSUyMHN2aWV3JTIwc2hpcnQlMjBzJTIwc2FsZSUyMGdhbGF4eSUyMHN2aWV3JTIwc2hpcnQ=', '1');

// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('7', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'T-Shirt', 'T-Shirt', '19.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8d', '2');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('8', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Polo Shirt', 'Polo Shirt', '29.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8d', '2');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('9', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Jeans', 'Jeans', '39.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8d', '2');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('10', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Shorts', 'Shorts', '49.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8d', '2');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('11', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Sweatshirt', 'Sweatshirt', '59.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8d', '2');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('12', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Hoodie', 'Hoodie', '69.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8d', '2');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('13', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Jacket', 'Jacket', '79.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8d', '2');

// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('14', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Chair', 'Chair', '99.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Y2hhaXIlMjBjaGFpcnN8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80', '3');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('15', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Table', 'Table', '199.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8dGFibGUlMjB0YWJsZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80', '3');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('16', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Sofa', 'Sofa', '299.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c29mYSUyMHNvZmElMjB0YWJsZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80', '3');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('17', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Dining Table', 'Dining Table', '499.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=Mnw','3');
// INSERT INTO product (id, created_at, updated_at, title, description, price, image_url, category_id) VALUES ('18', '2021-08-01 00:00:00', '2021-08-01 00:00:00', 'Dining Chair', 'Dining Chair', '599.99', 'https://images.unsplash.com/photo-1581090406932-1a1e6eac8b9e?ixid=Mnw','3');
