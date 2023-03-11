CREATE TABLE if not exists USER
(
    id         BIGINT unsigned NOT NULL AUTO_INCREMENT,
    name       VARCHAR(100)    NOT NULL,
    email      VARCHAR(255)    NOT NULL UNIQUE,
    password   VARCHAR(255)    NOT NULL,
    created_at DATETIME default current_timestamp,
    updated_at DATETIME default current_timestamp on update current_timestamp,
    PRIMARY KEY (id)
);

CREATE TABLE if not exists CATEGORY
(
    id   BIGINT unsigned NOT NULL AUTO_INCREMENT,
    name VARCHAR(100)    NULL,
    primary key (id)
);

CREATE TABLE if not exists PRODUCT
(
    id          BIGINT unsigned NOT NULL AUTO_INCREMENT,
    category_id BIGINT unsigned NOT NULL,
    title       VARCHAR(100)    NOT NULL,
    price       BIGINT unsigned,
    created_at  DATETIME default current_timestamp,
    updated_at  DATETIME default current_timestamp on update current_timestamp,
    primary key (id),
    foreign key (category_id) references CATEGORY (id)

);

CREATE TABLE if not exists PRODUCT_IMAGE
(
    id         BIGINT unsigned NOT NULL AUTO_INCREMENT,
    product_id BIGINT unsigned NOT NULL,
    name       VARCHAR(100)    NOT NULL,
    url        VARCHAR(255)    NOT NULL,
    created_at DATETIME default current_timestamp,
    updated_at DATETIME default current_timestamp on update current_timestamp,
    primary key (id),
    foreign key (product_id) references PRODUCT (id)
);

