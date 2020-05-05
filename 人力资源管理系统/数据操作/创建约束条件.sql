/* --------------------------------Department表约束-------------------------------------------- */	
/* 创建CHECK约束 */
ALTER TABLE Department	/* 员工编号必须在0000000到9999999之间 */
	ADD CONSTRAINT CK_Department_managerEmployeeNo 
	CHECK (managerEmployeeNo BETWEEN 0000000 AND 9999999);


/* --------------------------------Employee表约束-------------------------------------------- */
/* 创建外键 */
ALTER TABLE Employee
	ADD CONSTRAINT FK_Employee_supervisorEmployeeNo
	FOREIGN KEY (supervisorEmployeeNo) REFERENCES Employee(employeeNo);
	
ALTER TABLE Employee
	ADD CONSTRAINT FK_Employee_departmentNo
	FOREIGN KEY (departmentNo) REFERENCES Department(departmentNo);

/* 创建Unique约束 */
ALTER TABLE Employee	/* 身份证号唯一 */
	ADD CONSTRAINT UK_Employee_socialSecurityNumber UNIQUE (socialSecurityNumber);

/* 创建CHECK约束 */
ALTER TABLE Employee	/* 性别只能为男或者女 */
	ADD CONSTRAINT CK_Employee_sex 
	CHECK (sex IN('男','女'));			

ALTER TABLE Employee	/* 薪水大于0 */
	ADD CONSTRAINT CK_Employee_salary 
	CHECK (salary > 0);			

ALTER TABLE Employee	/* 入职时间小于离职时间 */
	ADD CONSTRAINT CK_Employee_Date 
	CHECK (dateStarted <= dateLeft);	
	
/* --------------------------------Grade表约束-------------------------------------------- */
/* 创建外键 */
ALTER TABLE Grade
	ADD CONSTRAINT FK_Grade_positionTypeNo
	FOREIGN KEY (positionTypeNo) REFERENCES PositionType(positionTypeNo)
		ON UPDATE CASCADE  
		ON DELETE CASCADE;

/* 创建CHECK约束 */
ALTER TABLE Grade	/* 等级编号为A到E */
	ADD CONSTRAINT CK_Grade_gradeNo
	CHECK (gradeNo BETWEEN 'A' AND 'E');
	
ALTER TABLE Grade	/* 有效开始日期小于有效截止日期 */
	ADD CONSTRAINT CK_Grade_Date 
	CHECK (validFromDate < validToDate);							
	
ALTER TABLE Grade	/* 薪水大于0 */
	ADD CONSTRAINT CK_Grade_gradesalary
	CHECK (gradesalary > 0);
	
ALTER TABLE Grade	/* 休假天数大于0 */
	ADD CONSTRAINT CK_Grade_noDaysLeaveEntitlement
	CHECK (noDaysLeaveEntitlement > 0);
	
/* --------------------------------GradePost表约束-------------------------------------------- */
/* 创建外键 */
ALTER TABLE GradePost
	ADD CONSTRAINT FK_GradePost_grade
	FOREIGN KEY (gradeNo,validFromDate) REFERENCES Grade(gradeNo,validFromDate)
		ON UPDATE CASCADE  
		ON DELETE CASCADE;

ALTER TABLE GradePost
	ADD CONSTRAINT FK_GradePost_post
	FOREIGN KEY (postNo,availableFromDate) REFERENCES Post(postNo,availableFromDate)
		ON UPDATE CASCADE  
		ON DELETE CASCADE;
	
/* --------------------------------Position表约束-------------------------------------------- */
/* 创建外键 */
ALTER TABLE Position
	ADD CONSTRAINT FK_Position_employeeNo
	FOREIGN KEY (employeeNo) REFERENCES Employee(employeeNo)
		ON UPDATE CASCADE
		ON DELETE CASCADE;

ALTER TABLE Position
	ADD CONSTRAINT FK_Position_post
	FOREIGN KEY (postNo,startDate) REFERENCES Post(postNo,availableFromDate)
		ON UPDATE CASCADE
		ON DELETE CASCADE;
	
ALTER TABLE Position	/* 入职时间小于离职时间 */
	ADD CONSTRAINT CK_Position_Date 
	CHECK (startDate < endDate);	
	
/* --------------------------------Post表约束-------------------------------------------- */
/* 创建外键 */
ALTER TABLE Post
	ADD CONSTRAINT FK_Post
	FOREIGN KEY (departmentNo) REFERENCES Department(departmentNo);

/* 创建CHECK约束 */	
ALTER TABLE Post	/* 开始时间小于结束时间 */
	ADD CONSTRAINT CK_Post_Date 
	CHECK (availableFromDate < availableToDate);
					
ALTER TABLE Post	/* 薪水大于0 */
	ADD CONSTRAINT CK_Post_salariedHourly
	CHECK (salariedHourly > 0);
	
ALTER TABLE Post	/* fullPartTime只能为全职或者兼职 */
	ADD CONSTRAINT CK_Post_fullPartTime
	CHECK (fullPartTime IN('全职','兼职'));
	
ALTER TABLE Post	/* temporaryPermanent只能为实习生或者正式员工 */
	ADD CONSTRAINT CK_Post_temporaryPermanent
	CHECK (temporaryPermanent IN('实习生','正式员工'));	
	
ALTER TABLE Post	/* freeLaborStandardsActExempt只能为是或者否 */
	ADD CONSTRAINT CK_Post_freeLaborStandardsActExempt
	CHECK (freeLaborStandardsActExempt IN('是','否'));
	
	
/* --------------------------------Qualification表约束-------------------------------------------- */
/* 创建外键 */
ALTER TABLE Qualification
	ADD CONSTRAINT FK_Qualification_employeeNo
	FOREIGN KEY (employeeNo) REFERENCES Employee(employeeNo)
		ON UPDATE CASCADE  
		ON DELETE CASCADE;

ALTER TABLE Qualification
	ADD CONSTRAINT FK_Qualification_insititutionNo
	FOREIGN KEY (insititutionNo) REFERENCES Institution(institutionNo)
		ON UPDATE CASCADE  
		ON DELETE CASCADE;

/* 创建CHECK约束 */
ALTER TABLE Qualification	/* 合格开始时间小于合格结束时间 */
	ADD CONSTRAINT CK_Qualification_Date 
	CHECK (startQualDate < endQualDate);

ALTER TABLE Qualification	/* 等级编号为A到E */
	ADD CONSTRAINT CK_Qualification_gradeObtained
	CHECK (gradeObtained BETWEEN 'A' AND 'E');						
	
ALTER TABLE Qualification	/* 绩点大于0 */
	ADD CONSTRAINT CK_Qualification_gpa
	CHECK (gpa > 0);
	
/* --------------------------------Review表约束-------------------------------------------- */
/* 创建外键 */
ALTER TABLE Review
	ADD CONSTRAINT FK_Review_revieweeEmployeeNo
	FOREIGN KEY (revieweeEmployeeNo) REFERENCES Employee(employeeNo)
		ON UPDATE CASCADE  
		ON DELETE CASCADE;

ALTER TABLE Review
	ADD CONSTRAINT FK_Review_revieweerEmployeeNo
	FOREIGN KEY (reviewerEmployeeNo) REFERENCES Employee(employeeNo)
		ON UPDATE CASCADE  
		ON DELETE CASCADE;
	
/* 创建CHECK约束 */
ALTER TABLE Review	/* 被评价者编号不等于评价者编号 */
	ADD CONSTRAINT CK_Review_No 
	CHECK (revieweeEmployeeNo != reviewerEmployeeNo);
	
/* --------------------------------WorkHistory表约束-------------------------------------------- */
/* 创建外键 */
ALTER TABLE WorkHistory
	ADD CONSTRAINT FK_WorkHistory_prevCompanyNo
	FOREIGN KEY (prevCompanyNo) REFERENCES prevCompany(prevCompanyNo)
		ON UPDATE CASCADE  
		ON DELETE CASCADE;
	
ALTER TABLE WorkHistory
	ADD CONSTRAINT FK_WorkHistory_employeeNo
	FOREIGN KEY (employeeNo) REFERENCES Employee(employeeNo)
		ON UPDATE CASCADE  
		ON DELETE CASCADE;
	
/* 创建CHECK约束 */
ALTER TABLE WorkHistory	/* 等级编号为A到E */
	ADD CONSTRAINT CK_WorkHistory_prevGrade
	CHECK (prevGrade BETWEEN 'A' AND 'E');						
	
ALTER TABLE WorkHistory	/* 薪水大于0 */
	ADD CONSTRAINT CK_WorkHistory_prevSalary
	CHECK (prevSalary > 0);