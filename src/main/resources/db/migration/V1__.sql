CREATE TABLE category
(
    id   BINARY(16)   NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE j_mentor
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255)          NULL,
    email      VARCHAR(255)          NULL,
    avg_rating DOUBLE                NOT NULL,
    CONSTRAINT pk_j_mentor PRIMARY KEY (id)
);

CREATE TABLE j_student
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255)          NULL,
    email VARCHAR(255)          NULL,
    psp   DOUBLE                NOT NULL,
    CONSTRAINT pk_j_student PRIMARY KEY (id)
);

CREATE TABLE j_ta
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255)          NULL,
    email      VARCHAR(255)          NULL,
    ta_session VARCHAR(255)          NULL,
    CONSTRAINT pk_j_ta PRIMARY KEY (id)
);

CREATE TABLE j_user
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255)          NULL,
    email VARCHAR(255)          NULL,
    CONSTRAINT pk_j_user PRIMARY KEY (id)
);

CREATE TABLE ms_mentor
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255)          NULL,
    email      VARCHAR(255)          NULL,
    avg_rating DOUBLE                NOT NULL,
    CONSTRAINT pk_ms_mentor PRIMARY KEY (id)
);

CREATE TABLE ms_student
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255)          NULL,
    email VARCHAR(255)          NULL,
    psp   DOUBLE                NOT NULL,
    CONSTRAINT pk_ms_student PRIMARY KEY (id)
);

CREATE TABLE ms_ta
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255)          NULL,
    email      VARCHAR(255)          NULL,
    ta_session VARCHAR(255)          NULL,
    CONSTRAINT pk_ms_ta PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id BINARY(16) NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE orders_products
(
    orders_id   BINARY(16) NOT NULL,
    products_id BINARY(16) NOT NULL
);

CREATE TABLE price
(
    id       BINARY(16)   NOT NULL,
    currency VARCHAR(255) NULL,
    value    DOUBLE       NOT NULL,
    CONSTRAINT pk_price PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BINARY(16)   NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    image         VARCHAR(255) NULL,
    category_id   BINARY(16)   NOT NULL,
    price_id      BINARY(16)   NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE st_mentor
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255)          NULL,
    email      VARCHAR(255)          NULL,
    avg_rating DOUBLE                NOT NULL,
    CONSTRAINT pk_st_mentor PRIMARY KEY (id)
);

CREATE TABLE st_student
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255)          NULL,
    email VARCHAR(255)          NULL,
    psp   DOUBLE                NOT NULL,
    CONSTRAINT pk_st_student PRIMARY KEY (id)
);

CREATE TABLE st_ta
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255)          NULL,
    email      VARCHAR(255)          NULL,
    ta_session VARCHAR(255)          NULL,
    CONSTRAINT pk_st_ta PRIMARY KEY (id)
);

CREATE TABLE st_user
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    user_type INT                   NULL,
    name      VARCHAR(255)          NULL,
    email     VARCHAR(255)          NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id         BIGINT       NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    avg_rating DOUBLE       NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_student
(
    id    BIGINT       NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp   DOUBLE       NOT NULL,
    CONSTRAINT pk_tpc_student PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id         BIGINT       NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    ta_session VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id    BIGINT       NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PRICE FOREIGN KEY (price_id) REFERENCES price (id);

ALTER TABLE orders_products
    ADD CONSTRAINT fk_ordpro_on_orders FOREIGN KEY (orders_id) REFERENCES orders (id);

ALTER TABLE orders_products
    ADD CONSTRAINT fk_ordpro_on_product FOREIGN KEY (products_id) REFERENCES product (id);