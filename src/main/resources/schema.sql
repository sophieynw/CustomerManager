-- create region table
CREATE TABLE region (
    id LONG PRIMARY KEY AUTO_INCREMENT,
    territoriesAndProvinces VARCHAR2(30)
);

-- create customer table
CREATE TABLE customer (
    custId LONG PRIMARY KEY AUTO_INCREMENT,
    custName VARCHAR(255),
    custAddress VARCHAR(255),
    custRegion VARCHAR(255),
    custCountry VARCHAR(255)
);