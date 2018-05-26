CREATE TABLE Employee
(
  eId       NUMBER PRIMARY KEY,
  username  VARCHAR2(64)                     NOT NULL,
  userpass  VARCHAR2(64)                     NOT NULL,
  firstName VARCHAR2(32)                     NOT NULL,
  lastName  VARCHAR2(32)                     NOT NULL,
  role      VARCHAR2(64) DEFAULT 'Associate' NOT NULL
);
/

CREATE TABLE Reimbursement
(
  rId                 NUMBER PRIMARY KEY,
  requesterId         NUMBER                         NOT NULL,
  resolverId          NUMBER,
  reimbursementAmount NUMBER(11, 2) DEFAULT 0        NOT NULL,
  category            VARCHAR2(32),
  status              VARCHAR2(16) DEFAULT 'pending' NOT NULL,
  submitDate          DATE,
  submitComment       VARCHAR2(256),
  resolveDate         DATE,
  resolveComment      VARCHAR2(256)
);
/

CREATE TABLE Pictures
(
    pId number PRIMARY KEY,
    rId number NOT NULL,
    picture BLOB
);

-- Set Date Format and Timezone
ALTER SESSION SET TIME_ZONE = '-4:0';
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';

-- Apply Key Constraints

ALTER TABLE REIMBURSEMENT
  ADD CONSTRAINT REIMBURSEMENT_EMPLOYEE_fk
FOREIGN KEY (REQUESTERID) REFERENCES EMPLOYEE (EID) ON DELETE CASCADE;
/

ALTER TABLE REIMBURSEMENT
  ADD CONSTRAINT REIMBURSEMENT_FM_fk
FOREIGN KEY (RESOLVERID) REFERENCES EMPLOYEE (EID) ON DELETE CASCADE;
/

-- Apply Unique Constraints

CREATE UNIQUE INDEX PROJECT1_ADMIN.EMPLOYEE_USERNAME_uindex
  ON EMPLOYEE (USERNAME);
/


-- Create Sequences

CREATE SEQUENCE employeeId_sequence
  MINVALUE 0
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE;
/

CREATE SEQUENCE reimbursementId_sequence
  MINVALUE 0
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE;
/

CREATE SEQUENCE pId_sequence
  MINVALUE 0
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE;
/

-- Procedures

Create OR REPLACE PROCEDURE updateEmployee(oldUserId IN NUMBER, newUsername IN VARCHAR2, newFirstName IN VARCHAR2, newLastName IN VARCHAR2, newUserpass IN VARCHAR2)
AS
  BEGIN
    UPDATE EMPLOYEE
    SET username = newUsername, firstName = newFirstName, lastName = newLastName, userpass = GET_USER_HASH(newUsername, newUserpass)
    WHERE eId = oldUserId;
    COMMIT;
  END;
/


CREATE OR REPLACE PROCEDURE insertReimbursement(newRequester IN NUMBER, newAmount IN NUMBER, newCategory IN VARCHAR2,
                                                newComment   IN VARCHAR2) AS
  BEGIN
    INSERT INTO Reimbursement (rId, requesterId, reimbursementAmount, category, submitDate, submitComment)
    VALUES (null, newRequester, newAmount, newCategory, CURRENT_DATE, newComment);
    COMMIT;
  END;
/

CREATE OR REPLACE PROCEDURE acceptReimbursement(oldReimbursementId IN NUMBER, newFinancialManagerId IN NUMBER,
                                                newDecisionComment IN VARCHAR2) AS
  BEGIN
    UPDATE REIMBURSEMENT
    SET status       = 'accepted', resolverId = newFinancialManagerId, resolveDate = CURRENT_DATE,
      resolveComment = newDecisionComment
    WHERE rId = oldReimbursementId;
    COMMIT;
  END;
/

CREATE OR REPLACE PROCEDURE denyReimbursement(oldReimbursementId IN NUMBER, newFinancialManagerId IN NUMBER,
                                              newDecisionComment IN VARCHAR2) AS
  BEGIN
    UPDATE REIMBURSEMENT
    SET status       = 'denied', resolverId = newFinancialManagerId, resolveDate = CURRENT_DATE,
      resolveComment = newDecisionComment
    WHERE rId = oldReimbursementId;
    COMMIT;
  END;
/


-- User defined functions

CREATE OR REPLACE FUNCTION GET_USER_HASH(USERNAME VARCHAR2, USERPASS VARCHAR2)
  RETURN VARCHAR2
IS
  EXTRA VARCHAR2(10) := 'SALT';
  BEGIN
    RETURN TO_CHAR(DBMS_OBFUSCATION_TOOLKIT.MD5(
                       INPUT => UTL_I18N.STRING_TO_RAW(DATA => USERNAME || USERPASS || EXTRA)));
  END;
/

-- Auto-increment Triggers

CREATE OR REPLACE TRIGGER eId_b_insert
  BEFORE INSERT
  ON EMPLOYEE
  FOR EACH ROW
  BEGIN
    IF :new.eId Is NULL
    THEN
      SELECT employeeId_sequence.nextval
      INTO :new.eId
      FROM dual;
    end if;
    SELECT GET_USER_HASH(:new.username, :new.userpass)
    INTO :new.userpass
    FROM dual;
  end;
/

CREATE OR REPLACE TRIGGER rId_b_insert
  BEFORE INSERT
  ON REIMBURSEMENT
  FOR EACH ROW
  BEGIN
    IF :new.rId Is NULL
    THEN
      SELECT reimbursementId_sequence.nextval
      INTO :new.rId
      FROM dual;
    end if;
  end;
/

-- Insert values for Employee Table

insert into Employee (eId, username, userpass, firstName, lastName, role)
values (null, 'kirk', 'kirk123', 'Kirk', 'Legarda', 'Financial Manager');
insert into Employee (eId, username, userpass, firstName, lastName, role)
values (null, 'jack', 'jack123', 'Jack', 'Hedan', 'Associate');
insert into Employee (eId, username, userpass, firstName, lastName, role)
values (null, 'jill', 'jill123', 'Jill', 'Hedan', 'Financial Manager');
insert into Employee (eId, username, userpass, firstName, lastName, role)
values (null, 'hill', 'hill123', 'Hill', 'Kirkup', 'Associate');
insert into Employee (eId, username, userpass, firstName, lastName, role)
values (null, 'edranfield4', 'mxuOpQRoK', 'Esme', 'Dranfield', 'Associate');
insert into Employee (eId, username, userpass, firstName, lastName, role)
values (null, 'pedmands5', 'XTucMQxB08es', 'Pennie', 'Edmands', 'Associate');
insert into Employee (eId, username, userpass, firstName, lastName, role)
values (null, 'ngoad6', 'ZimNNQkfvWh', 'Norry', 'Goad', 'Associate');
insert into Employee (eId, username, userpass, firstName, lastName, role)
values (null, 'zgoldsworthy7', 'pn8Zy2K', 'Zerk', 'Goldsworthy', 'Associate');
insert into Employee (eId, username, userpass, firstName, lastName, role)
values (null, 'lkleinmann8', 'MnEmYhNwL7', 'Lurline', 'Kleinmann', 'Associate');
insert into Employee (eId, username, userpass, firstName, lastName, role)
values (null, 'bkisbee9', 'OdUDeKF8g', 'Bea', 'Kisbee', 'Financial Manager');

--Insert values for Reimbursement Table

insert into Reimbursement (rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment)
values (null, 7, 1, 98.28, 'travel', 'denied', TO_DATE('2007-08-21 09:10:37'), null, TO_DATE('2007-09-21 09:10:37'),
        'Duis at velit eu est congue elementum.');
insert into Reimbursement (rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment)
values (null, 2, 1, 80.95, 'lodging', 'denied', TO_DATE('2012-09-14 07:31:56'), 'Maecenas tincidunt lacus at velit.',
        TO_DATE('2012-10-14 07:31:56'), 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.');
insert into Reimbursement (rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment)
values (null, 2, 3, 415.26, 'lodging', 'denied', TO_DATE('2014-08-17 15:37:37'), 'Etiam pretium iaculis justo.',
        TO_DATE('2014-09-17 15:37:37'), 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.');
insert into Reimbursement (rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment)
values (null, 1, 3, 65.67, 'food', 'accepted', TO_DATE('2004-01-17 15:58:58'), 'Aenean fermentum.',
        TO_DATE('2004-02-17 15:58:58'), 'In hac habitasse platea dictumst.');
insert into Reimbursement (rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment)
values (null, 4, null, 711.63, 'travel', 'pending', TO_DATE('2001-01-04 16:25:42'),
        'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.',
        null, null);
insert into Reimbursement (rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment)
values (null, 6, null, 353.0, 'lodging', 'pending', TO_DATE('2009-04-17 05:53:46'),
        'Vivamus in felis eu sapien cursus vestibulum.', null, null);
insert into Reimbursement (rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment)
values (null, 9, null, 465.98, 'other', 'pending', TO_DATE('2012-02-13 06:42:34'), 'Nulla nisl.', null,
        null);
insert into Reimbursement (rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment)
values (null, 8, 1, 390.09, 'other', 'denied', TO_DATE('2004-11-20 01:50:57'), 'In hac habitasse platea dictumst.',
        TO_DATE('2004-12-20 01:50:57'), 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.');
insert into Reimbursement (rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment)
values (null, 8, 3, 104.19, 'other', 'denied', TO_DATE('2007-01-31 10:48:27'), null, TO_DATE('2007-02-28 10:48:27'),
        'Nunc rhoncus dui vel sem.');
insert into Reimbursement (rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment)
values (null, 10, null, 528.35, 'travel', 'pending', TO_DATE('2003-04-27 14:40:13'),
        'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.',
        null, null);
insert into Reimbursement (rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment)
values (null, 6, 3, 76.87, 'other', 'accepted', TO_DATE('2007-11-13 15:49:27'),
        'Duis consequat dui nec nisi volutpat eleifend.', TO_DATE('2007-12-13 15:49:27'),
        'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.');
insert into Reimbursement (rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment)
values (null, 3, null, 932.55, 'travel', 'pending', TO_DATE('2016-04-09 14:16:43'), 'In quis justo.', null,
        null);

-- Test Queries
--
-- SELECT *
-- from Employee
-- where role = 'Financial Manager'
-- order by employeeId;
--
-- SELECT *
-- FROM REIMBURSEMENT
-- WHERE status = 'pending'
-- ORDER BY REIMBURSEMENTID;
--
-- SELECT *
-- FROM REIMBURSEMENT
--
-- ORDER BY REIMBURSEMENTID;
--
-- SELECT *
-- FROM REIMBURSEMENT
-- WHERE status != 'pending'
-- ORDER BY REIMBURSEMENTID;
--
--
-- BEGIN
--   acceptReimbursement(13, 1, 'That iss okay. Approved by Kirk.');
-- end;
--
-- BEGIN
--   denyReimbursement(14, 1, 'No cake. Denied by Kirk.');
-- end;
--
-- BEGIN
--   insertReimbursement(6, 25.44, 'food', 'I bought cake.');
-- end;
--
--
-- INSERT INTO Reimbursement (reimbursementId, requestorId, reimbursementAmount, category, submitDate, submitComment)
-- VALUES (null, 30, 50.50, 'food', TO_DATE(CURRENT_DATE), 'I bought some food');
--
-- INSERT INTO Reimbursement (reimbursementId, requestorId, reimbursementAmount, category, submitDate)
-- VALUES (null, 1, 100, 'food', CURRENT_DATE);