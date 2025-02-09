-- populate table with 3 provinces and 1 territory by default
-- Populate table with 3 provinces and 1 territory by default
INSERT INTO region (territoriesAndProvinces) 
VALUES ('Ontario'), 
       ('Quebec'), 
       ('British Columbia'),
       ('Yukon');

-- populate table with 2 customers by default
INSERT INTO customer (custName, custAddress, custRegion, custCountry)
VALUES ('John Doe', '123 Main St', 'Ontario', 'Canada'),
       ('Jane Smith', '456 Queen St', 'Quebec', 'Canada');