insert into course (id, name, created_time, updated_time) values (10001, 'SpringBoot and JPA course', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course (id, name, created_time, updated_time) values (10002, 'Spring Framework', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course (id, name, created_time, updated_time) values (10003, 'SpringBoot and microservices course', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into passport (id, number) values (40001,'AB1234567');
insert into passport (id, number) values (40002,'LP0909090');
insert into passport (id, number) values (40003,'XX9019019');

insert into student (id, name, passport_id) values (20001,'Mirek', 40001);
insert into student (id, name, passport_id) values (20002,'Ania', 40002);
insert into student (id, name, passport_id) values (20003,'Adam', 40003);


insert into review (id, rating, description) values (50001,'5', 'Great course');
insert into review (id, rating, description) values (50002,'4', 'Awesome');
insert into review (id, rating, description) values (50003,'3', 'could be better');
insert into review (id, rating, description) values (50004,'2', 'Not good');