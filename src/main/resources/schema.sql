insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10001,'Jpa 50 minuts',sysdate(),sysdate());
insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10002,'Spring 50 minuts',sysdate(),sysdate());
insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10003,'Spring 100 minuts',sysdate(),sysdate());

insert into passport (id, number)
values (40001,'E123564');
insert into passport (id, number)
values (40002,'T453425');
insert into passport (id, number)
values (40003,'V125365');


insert into student (id, name, passport_id)
values (20001,'Ranga', 40001);
insert into student (id, name, passport_id)
values (20002,'Adam',40002);
insert into student (id, name, passport_id)
values (20003,'Jane', 40003);




insert into review (id, rating, description)
values (50001,'5','Great Course');
insert into review (id, rating, description)
values (50002,'4','Wonderful course');
insert into review (id, rating, description)
values (50003,'5','Awesome course');