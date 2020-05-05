USE HRM
GO
/* User用户登录信息表 */
CREATE TABLE Login
(
	userName CHAR(20) NOT NULL,
	passWord CHAR(12) NOT NULL,
	
	CONSTRAINT userName PRIMARY KEY(userName)
);

/* Department表 */
CREATE TABLE Department
(
	departmentNo CHAR(5) NOT NULL,
	departmentName CHAR(30) NOT NULL,
	deptLocation VARCHAR(50),
	managerEmployeeNo CHAR(7) NOT NULL,
	
	CONSTRAINT PK_Department_key PRIMARY KEY(departmentNo)
);

/* Employee表 */
CREATE TABLE Employee
(
	employeeNo CHAR(7) NOT NULL,
	title CHAR(20),
	firstName CHAR(20) NOT NULL,
	middleName CHAR(10),
	lastName CHAR(10) NOT NULL,
	address VARCHAR(100),
	workTelExt CHAR(11),
	homeTelNo CHAR(11),
	empEmailAddress VARCHAR(32),
	socialSecurityNumber CHAR(18) NOT NULL,
	DOB	DATE,
	position CHAR(30),
	sex	CHAR(2),
	salary NUMERIC(8,2),
	dateStarted	DATE,
	dateLeft DATE,
	departmentNo CHAR(5) NOT NULL,
	supervisorEmployeeNo CHAR(7) NOT NULL,
	
	CONSTRAINT PK_Employee_Key PRIMARY KEY(employeeNo)
);

/* Grade表 */
CREATE TABLE Grade
(
	gradeNo CHAR(1) NOT NULL,
	validFromDate DATE NOT NULL,
	validToDate DATE,
	gradeDescrible VARCHAR(100),
	gradesalary	NUMERIC(8,2),
	noDaysLeaveEntitlement SMALLINT,
	positionTypeNo CHAR(10) NOT NULL,
	
	CONSTRAINT PK_Grade_Key PRIMARY KEY(gradeNo,validFromDate)
);

/* GradePost表 */
CREATE TABLE GradePost
(
	gradeNo CHAR(1) NOT NULL,
	validFromDate	DATE NOT NULL,
	postNo	CHAR(10) NOT NULL,
	availableFromDate DATE NOT NULL,
	
	CONSTRAINT PK_GradePost_Key PRIMARY KEY(gradeNo,validFromDate,postNo,availableFromDate)
);

/* Institution表 */
CREATE TABLE Institution
(
	institutionNo CHAR(19) NOT NULL, 
	institutionName	VARCHAR(60) NOT NULL,
	instAddress	VARCHAR(100),
	instTelNo CHAR(11),
	instFaxNo CHAR(11),
	instWbeAddress CHAR(30),
	contactName CHAR(20) NOT NULL,
	contactTelNo CHAR(11) NOT NULL,
	contactFaxNo CHAR(11),
	contactEmailAddress	VARCHAR(32),
	
	CONSTRAINT PK_Institution_Key PRIMARY KEY(institutionNo)
);

/* Position表 */
CREATE TABLE Position
(
	employeeNo CHAR(7) NOT NULL,
	postNo CHAR(10) NOT NULL,
	startDate DATE NOT NULL,
	endDate DATE,
	
	CONSTRAINT PK_Position_Key PRIMARY KEY (employeeNo,postNo,startDate)	
);

/* PositionType表 */
CREATE TABLE PositionType
(
	positionTypeNo CHAR(10) NOT NULL,
	positionTypeDescription VARCHAR(100),
	
	CONSTRAINT PK_PositionType_Key PRIMARY KEY (positionTypeNo)
);

/* Post表 */
CREATE TABLE Post
(
	postNo CHAR(10) NOT NULL,
	availableFromDate DATE NOT NULL,
	availableToDate DATE,
	postDescription VARCHAR(100),
	salariedHourly NUMERIC(6,2),
	fullPartTime CHAR(4),
	temporaryPermanent CHAR(8),
	freeLaborStandardsActExempt CHAR(2),
	departmentNo CHAR(5) NOT NULL,
	
	CONSTRAINT PK_Post_Key PRIMARY KEY (postNo,availableFromDate)
);

/* PrevCompany表 */
CREATE TABLE PrevCompany
(
	prevCompanyNo CHAR(19) NOT NULL,
	pCompanyName VARCHAR(60) NOT NULL,
	pCompanyStreet VARCHAR(50),
	pCompanyCity CHAR(20),
	pCompanyState CHAR(30),
	pCompanyZipCode CHAR(6),
	pCompanyTelNo CHAR(12),
	pCompanyFaxNo CHAR(12),
	pCompanyWebAddress CHAR(30),
	contactName CHAR(20) NOT NULL,
	contactTelNo CHAR(11) NOT NULL,
	contactFaxNo CHAR(11),
	contactEmailAddress VARCHAR(32),
	
	CONSTRAINT PK_PrevCompany_Key PRIMARY KEY (prevCompanyNo)
);

/* Qualification表 */
CREATE TABLE Qualification
(
	qualificationName CHAR(10) NOT NULL,
	employeeNo CHAR(7) NOT NULL,
	gradeObtained CHAR(1),
	startQualDate DATE,
	endQualDate DATE,
	gpa	NUMERIC(3,2),
	insititutionNo CHAR(19) NOT NULL,
	
	CONSTRAINT PK_Qualification_Key PRIMARY KEY (qualificationName,employeeNo)
);

/* Review表 */
CREATE TABLE Review
(
	revieweeEmployeeNo CHAR(7) NOT NULL,
	reviewerEmployeeNo CHAR(7) NOT NULL,
	reviewDate DATE NOT NULL,	
	comments VARCHAR(255),
	
	CONSTRAINT PK_Review_Key PRIMARY KEY (revieweeEmployeeNo,reviewerEmployeeNo,reviewDate)
);

/* WorkHistory表 */
CREATE TABLE WorkHistory
(
	prevCompanyNo CHAR(19) NOT NULL,
	employeeNo CHAR(7) NOT NULL,
	prevPosition CHAR(30),
	prevGrade CHAR(1),
	prevSalary NUMERIC(8,2),
	prevLocation VARCHAR(60),
	prevResponsibilities VARCHAR(100)
	
	CONSTRAINT PK_WorkHistory_Key PRIMARY KEY (prevCompanyNo,employeeNo)
);
GO
