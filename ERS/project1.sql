drop table employee cascade constraints purge;
drop table manager cascade constraints purge;
drop table information cascade constraints purge;
drop table reimbursement cascade constraints purge;
drop sequence pks_employee;
drop sequence pks_information;
drop sequence pks_manager;
drop sequence pks_reimbursement;

create table manager(
    managerid number not null,
    username varchar2(100) not null unique,
    password varchar2(100) not null,
    constraint pk_managerid primary key(managerid)
);

create table employee(
    employeeid number not null,
    username varchar2(100) not null unique,
    password varchar2(100) not null,
    constraint pk_employeeid primary key(employeeid)
);

create table information(
    informationid number,
    employeeid number,
    firstname varchar2(100),
    middlename varchar2(100),
    lastname varchar2(100),
    constraint pk_informationid primary key(informationid),
    constraint fk_information_employeeid foreign key(employeeid) references employee
);

create table reimbursement(
    reimbursementid number,
    requestor varchar2(100) not null,
    manager varchar2(100),
    status varchar2(100) not null,
    image blob,
    category varchar2(100),
    constraint pk_reimbursementid primary key(reimbursementid)
);

create sequence pks_employee
    minvalue 0
    maxvalue 999
    start with 0
    increment by 1
    nocache;

create sequence pks_information
    minvalue 0
    maxvalue 999
    start with 0
    increment by 1
    nocache;

create sequence pks_manager
    minvalue 0
    maxvalue 999
    start with 0
    increment by 1
    nocache;

create sequence pks_reimbursement
    minvalue 0
    maxvalue 999
    start with 0
    increment by 1
    nocache;

create or replace function hash
    (in_username varchar2, in_password varchar2) return varchar2
is
extra varchar2(10) := 'pepper';
begin
    return to_char(DBMS_OBFUSCATION_TOOLKIT.MD5(
        input => UTL_I18N.STRING_TO_RAW(data => in_username || in_password || extra)));
end;
/

create or replace trigger before_create_employee
before insert
on employee
for each row
begin
    if :new.employeeid is null then
        select pks_employee.nextval into :new.employeeid from dual;
    end if;
    select hash(:new.username, :new.password) into :new.password from dual;
end;
/

create or replace trigger before_update_employee
before update
on employee
for each row
begin
    select hash(:new.username, :new.password) into :new.password from dual;
end;
/

create or replace trigger before_create_information
before insert
on information
for each row
begin
    if :new.informationid is null then
        select pks_information.nextval into :new.informationid from dual;
    end if;
end;
/

create or replace trigger before_create_manager
before insert
on manager
for each row
begin
    if :new.managerid is null then
        select pks_manager.nextval into :new.managerid from dual;
    end if;
    select hash(:new.username, :new.password) into :new.password from dual;
end;
/

create or replace trigger before_update_manager
before update
on manager
for each row
begin
    select hash(:new.username, :new.password) into :new.password from dual;
end;
/

create or replace trigger before_create_reimbursement
before insert
on reimbursement
for each row
begin
    if :new.reimbursementid is null then
        select pks_reimbursement.nextval into :new.reimbursementid from dual;
    end if;
end;
/

create or replace procedure create_employee
    (in_username varchar2, in_password varchar2)
as
begin
    insert into employee(employeeid, username, password)
        values(null, in_username, in_password);
    commit;
end;
/

create or replace procedure create_information
    (in_username varchar2, in_firstname varchar2, in_middlename varchar2, in_lastname varchar2)
as
    in_employeeid number;
    in_informationid number;
begin
    select employeeid into in_employeeid from employee where username=in_username;
    insert into information(informationid, employeeid, firstname, middlename, lastname)
        values(in_informationid, in_employeeid, in_firstname, in_middlename, in_lastname);
    commit;
end;
/

create or replace procedure create_manager
    (in_username varchar2, in_password varchar2)
as
begin
    insert into manager(managerid, username, password)
        values(null, in_username, in_password);
    commit;
end;
/

create or replace procedure create_reimbursement
    (in_username varchar2, in_status varchar2, in_image blob, in_category varchar2)
as
begin
    insert into reimbursement(reimbursementid, requestor, manager, status, image, category)
        values(null, in_username, null, in_status, in_image, in_category);
    commit;
end;
/

create or replace procedure update_employee
    (in_managerusername varchar2, in_username varchar2, in_password varchar2)
as
begin
    update employee 
        set username=in_username, password=in_password
        where username=in_username;
    commit;
end;
/

create or replace procedure update_information
    (in_username varchar2, in_firstname varchar2, in_middlename varchar2, in_lastname varchar2)
as
    in_informationid number;
begin
    select informationid into in_informationid from information i, employee e
        where i.employeeid=e.employeeid and username=in_username;
    update information
        set firstname=in_firstname, middlename=in_middlename, lastname=in_lastname
        where informationid=in_informationid;
    commit;
end;
/

create or replace procedure update_reimbursement
    (in_reimbursementid number, in_status varchar2, in_manager varchar2)
as
    in_requestor varchar2(100);
begin
    select requestor into in_requestor from reimbursement where reimbursementid=in_reimbursementid;
    if in_manager = in_requestor then
        raise VALUE_ERROR;
    end if;
    update reimbursement
        set manager=in_manager, status=in_status
        where reimbursementid=in_reimbursementid;
    commit;
end;
/

create or replace procedure delete_employee
    (in_username varchar2)
as
begin
    delete from employee where username=in_username;
    commit;
end;
/

create or replace procedure delete_information
    (in_username varchar2)
as
begin
    delete from information where employeeid=
        (select employeeid from employee where username=in_username);
    commit;
end;
/

create or replace procedure delete_manager
    (in_username varchar2)
as
begin
    delete from manager where username=in_username;
    commit;
end;
/

create or replace procedure delete_reimbursement
    (in_username varchar2)
as
begin
    delete from reimbursement where requestor=in_username;
    commit;
end;
/

begin
create_manager('william', 'password');
create_employee('andrew', 'password');
create_employee('daniel', 'password');
create_information('andrew', 'first', 'middle', 'last');
create_information('daniel', 'first', 'middle', 'last');
create_reimbursement('andrew', 'approved', null, 'travel');
create_reimbursement('andrew', 'rejected', null, 'food');
create_reimbursement('daniel', 'pending', null, 'lodging');
create_reimbursement('william', 'other', null, 'other');
update_reimbursement(0, 'approved', 'william');
update_reimbursement(1, 'rejected', 'william');
end;
/

select * from employee;
select * from manager;
select * from information;
select * from reimbursement;

/* all employees */
select * from employee;

/* all reimbursements from all employees */
select * from reimbursement;

/* one reimbursement by id */
select * from reimbursement where reimbursementid=0;
    