
INSERT INTO users (id, name, username, email, role, password, created_at, updated_at,user_status,deleted_at) VALUES (1, 'Administrator', 'admin', 'admin@cowork.co.mz','ADMIN', '$2a$10$EJVw5HLLZg6njyh9M2qHQutabTtkJTLcqYuk0V30M2NhWVYd22RMa', current_timestamp, current_timestamp,'ACTIVE',null);


-- INSERT Province
INSERT INTO provinces(id,name) VALUES(1,'Maputo');

-- COUNTRY INSERTION
INSERT INTO countries(name,province_id,sub_region,region,area) VALUES('Mozambique',1,'Africa Austral','Africa','21232132 Km');
