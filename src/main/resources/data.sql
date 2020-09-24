--create table person (
--    id int not null primary key,
--    name varchar(255) not null,
--    location varchar(255),
--    birth_date timestamp
--);

insert into person (id, name, location, birth_date) values (10001, 'Mirek', 'Dobron', sysdate());
insert into person (id, name, location, birth_date) values (10002, 'Ania', 'Lublin', sysdate());
insert into person (id, name, location, birth_date) values (10003, 'Adam', 'Warszawa', sysdate());
insert into person (id, name, location, birth_date) values (10004, 'Mirek', 'Dobron', sysdate());