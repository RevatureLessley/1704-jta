CREATE TABLE employee (
    employeeId NUMBER(10),
    position VARCHAR2(20),
    username VARCHAR2(30), 
    password VARCHAR2(30), 
    CONSTRAINT PK_EMPLOYEE PRIMARY KEY(employeeId),
    CONSTRAINT UK_USERNAME UNIQUE (username)
);

CREATE TABLE info (
    employeeId NUMBER(10), 
    firstName VARCHAR2(30) NOT NULL,
    lastName VARCHAR2(30) NOT NULL,
    DOB DATE,
    salary NUMBER(10),
    email VARCHAR2(50),
    CONSTRAINT PK_INFO PRIMARY KEY (employeeId)
);

CREATE TABLE reimbursement (
    reimbursementId NUMBER(10),
    requestorId NUMBER(10) NOT NULL,
    approverId NUMBER(10),
    category VARCHAR2(20),
    status VARCHAR2(20) DEFAULT 'pending',
    CONSTRAINT PK_REIMBURSEMENT PRIMARY KEY(reimbursementId),
    CONSTRAINT FK_EMPLOYEE FOREIGN KEY(requestorId) REFERENCES employee(employeeId),
    CONSTRAINT FK_FINANCE_MANAGER FOREIGN KEY(approverId) REFERENCES employee(employeeId)
);

ALTER TABLE info
ADD FOREIGN KEY(employeeId) REFERENCES employee(employeeId);

CREATE SEQUENCE employeeId_sequence
    MINVALUE 500
    MAXVALUE 10000
    START WITH 500
    INCREMENT BY 1
    NOCACHE; 
    

CREATE OR REPLACE FUNCTION GET_USER_HASH(USERNAME VARCHAR2, PASSWORD VARCHAR2) RETURN VARCHAR2
IS
EXTRA VARCHAR2(10) := 'SALT';
BEGIN
  RETURN TO_CHAR(DBMS_OBFUSCATION_TOOLKIT.MD5(
  INPUT => UTL_I18N.STRING_TO_RAW(DATA => USERNAME || PASSWORD || EXTRA)));
END;
/

CREATE OR REPLACE TRIGGER employee_insert
    BEFORE INSERT
    ON employee
    FOR EACH ROW
    BEGIN
        IF :new.employeeId IS NULL THEN 
            SELECT employeeId_sequence.nextval INTO :new.employeeId FROM dual;
        END IF;
    SELECT GET_USER_HASH(:new.username, :new.password) INTO :new.password FROM dual;
END;
/

CREATE SEQUENCE reimbursementId_sequence
    MINVALUE 1
    MAXVALUE 10000
    START WITH 1
    INCREMENT BY 1
    NOCACHE; 
    
CREATE OR REPLACE TRIGGER reimbursement_insert
    BEFORE INSERT
    ON reimbursement
    FOR EACH ROW
    BEGIN
        IF :new.reimbursementId IS NULL THEN 
            SELECT reimbursementId_sequence.nextval INTO :new.reimbursementId FROM dual;
        END IF;
END;
/    

CREATE OR REPLACE PROCEDURE insert_reimbursement(new_requestorId IN NUMBER, new_category IN VARCHAR2, new_amount IN NUMBER)
AS 
BEGIN
    INSERT INTO reimbursement (requestorId, category, amount)
    VALUES(new_requestorId, new_category, new_amount);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE update_reimbursement(new_reimbursementId IN NUMBER, new_approverId IN NUMBER, new_status IN VARCHAR2)
AS
BEGIN
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    UPDATE reimbursement
    SET approverId = new_approverId, status = new_status, resolutionDate = SYSDATE
    WHERE reimbursementId = new_reimbursementId;
    COMMIT;
END;
/
    

CREATE OR REPLACE FUNCTION get_current_time RETURN TIMESTAMP
AS
    time_right_now TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO time_right_now FROM dual;
    dbms_output.put_line('The current time is ' || time_right_now);
    return time_right_now;
END;
/

CREATE OR REPLACE PROCEDURE update_info(new_employeeId IN NUMBER, new_firstName IN VARCHAR2, new_lastName IN VARCHAR2)
AS
BEGIN
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    UPDATE info
    SET firstName = new_firstName, lastName = new_lastName
    WHERE employeeId = new_employeeId;
    COMMIT;
END;
/

ALTER TABLE reimbursement
    ADD (submissionDate DATE,
        approval_denialDate DATE);

ALTER TABLE reimbursement
MODIFY submissionDate VARCHAR2(50) DEFAULT SYSDATE;
ALTER TABLE employee
MODIFY password VARCHAR2(150);
ALTER TABLE info
MODIFY DOB VARCHAR2(20);
ALTER TABLE reimbursement
MODIFY amount NUMBER(8, 2);


INSERT INTO employee (position, username, password)
VALUES ('Financial Manager', 'Alex', 'password');

INSERT INTO employee (position, username, password)
VALUES ('Employee', 'Bob', 'password');

INSERT INTO info (employeeId, firstName, lastName, DOB, salary)
VALUES (501, 'Alex', 'Smith', '1/1/1990', 50000);

INSERT INTO info (employeeId, firstName, lastName, DOB, salary)
VALUES (502, 'Bob', 'Smith', '1/1/1988', 45000);

INSERT INTO employee (position, username, password)
VALUES ('Employee', 'Carrie', 'password');

INSERT INTO info (employeeId, firstName, lastName, DOB, salary)
VALUES (503, 'Carrie', 'Fisher', '3/36/1978', 48000);

select * from employee;
select * from info;

commit;
SELECT e.employeeId, position, username, password, firstName, lastName, DOB, salary  FROM employee e JOIN info i ON e.employeeId = i.employeeId;
   