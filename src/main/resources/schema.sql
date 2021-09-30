insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10001,'in 28 minuts',sysdate(),sysdate());
insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10002,'in 28 minuts',sysdate(),sysdate());
insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10003,'in 28 minuts',sysdate(),sysdate());
insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10004,'Spring 50 minuts',sysdate(),sysdate());
insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10005,'Spring 100 minuts',sysdate(),sysdate());
insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10006,'Spring 100 minuts',sysdate(),sysdate());
insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10007,'Dummy1',sysdate(),sysdate());
insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10008,'Dummy2',sysdate(),sysdate());
insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10009,'Dummy3',sysdate(),sysdate());
insert into COURSE_DETAILS (id, name, created_date, last_updated_date) 
values(10010,'Dummy4',sysdate(),sysdate());


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




insert into review (id, rating, description,course_id, student_id)
values (50001,'5','Great Course',10001,20001);
insert into review (id, rating, description, course_id, student_id)
values (50002,'4','Wonderful course', 10001, 20001);
insert into review (id, rating, description, course_id, student_id)
values (50003,'5','Awesome course', 10002, 20003);


insert into student_course(student_id, course_id) 
values(20001,10001);
insert into student_course(student_id, course_id) 
values(20002,10001);
insert into student_course(student_id, course_id) 
values(20003,10001);
insert into student_course(student_id, course_id) 
values(20001,10003);
