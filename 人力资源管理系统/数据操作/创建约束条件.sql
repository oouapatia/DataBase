/* --------------------------------Department��Լ��-------------------------------------------- */	
/* ����CHECKԼ�� */
ALTER TABLE Department	/* Ա����ű�����0000000��9999999֮�� */
	ADD CONSTRAINT CK_Department_managerEmployeeNo 
	CHECK (managerEmployeeNo BETWEEN 0000000 AND 9999999);


/* --------------------------------Employee��Լ��-------------------------------------------- */
/* ������� */
ALTER TABLE Employee
	ADD CONSTRAINT FK_Employee_supervisorEmployeeNo
	FOREIGN KEY (supervisorEmployeeNo) REFERENCES Employee(employeeNo);
	
ALTER TABLE Employee
	ADD CONSTRAINT FK_Employee_departmentNo
	FOREIGN KEY (departmentNo) REFERENCES Department(departmentNo);

/* ����UniqueԼ�� */
ALTER TABLE Employee	/* ���֤��Ψһ */
	ADD CONSTRAINT UK_Employee_socialSecurityNumber UNIQUE (socialSecurityNumber);

/* ����CHECKԼ�� */
ALTER TABLE Employee	/* �Ա�ֻ��Ϊ�л���Ů */
	ADD CONSTRAINT CK_Employee_sex 
	CHECK (sex IN('��','Ů'));			

ALTER TABLE Employee	/* нˮ����0 */
	ADD CONSTRAINT CK_Employee_salary 
	CHECK (salary > 0);			

ALTER TABLE Employee	/* ��ְʱ��С����ְʱ�� */
	ADD CONSTRAINT CK_Employee_Date 
	CHECK (dateStarted <= dateLeft);	
	
/* --------------------------------Grade��Լ��-------------------------------------------- */
/* ������� */
ALTER TABLE Grade
	ADD CONSTRAINT FK_Grade_positionTypeNo
	FOREIGN KEY (positionTypeNo) REFERENCES PositionType(positionTypeNo)
		ON UPDATE CASCADE  
		ON DELETE CASCADE;

/* ����CHECKԼ�� */
ALTER TABLE Grade	/* �ȼ����ΪA��E */
	ADD CONSTRAINT CK_Grade_gradeNo
	CHECK (gradeNo BETWEEN 'A' AND 'E');
	
ALTER TABLE Grade	/* ��Ч��ʼ����С����Ч��ֹ���� */
	ADD CONSTRAINT CK_Grade_Date 
	CHECK (validFromDate < validToDate);							
	
ALTER TABLE Grade	/* нˮ����0 */
	ADD CONSTRAINT CK_Grade_gradesalary
	CHECK (gradesalary > 0);
	
ALTER TABLE Grade	/* �ݼ���������0 */
	ADD CONSTRAINT CK_Grade_noDaysLeaveEntitlement
	CHECK (noDaysLeaveEntitlement > 0);
	
/* --------------------------------GradePost��Լ��-------------------------------------------- */
/* ������� */
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
	
/* --------------------------------Position��Լ��-------------------------------------------- */
/* ������� */
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
	
ALTER TABLE Position	/* ��ְʱ��С����ְʱ�� */
	ADD CONSTRAINT CK_Position_Date 
	CHECK (startDate < endDate);	
	
/* --------------------------------Post��Լ��-------------------------------------------- */
/* ������� */
ALTER TABLE Post
	ADD CONSTRAINT FK_Post
	FOREIGN KEY (departmentNo) REFERENCES Department(departmentNo);

/* ����CHECKԼ�� */	
ALTER TABLE Post	/* ��ʼʱ��С�ڽ���ʱ�� */
	ADD CONSTRAINT CK_Post_Date 
	CHECK (availableFromDate < availableToDate);
					
ALTER TABLE Post	/* нˮ����0 */
	ADD CONSTRAINT CK_Post_salariedHourly
	CHECK (salariedHourly > 0);
	
ALTER TABLE Post	/* fullPartTimeֻ��Ϊȫְ���߼�ְ */
	ADD CONSTRAINT CK_Post_fullPartTime
	CHECK (fullPartTime IN('ȫְ','��ְ'));
	
ALTER TABLE Post	/* temporaryPermanentֻ��Ϊʵϰ��������ʽԱ�� */
	ADD CONSTRAINT CK_Post_temporaryPermanent
	CHECK (temporaryPermanent IN('ʵϰ��','��ʽԱ��'));	
	
ALTER TABLE Post	/* freeLaborStandardsActExemptֻ��Ϊ�ǻ��߷� */
	ADD CONSTRAINT CK_Post_freeLaborStandardsActExempt
	CHECK (freeLaborStandardsActExempt IN('��','��'));
	
	
/* --------------------------------Qualification��Լ��-------------------------------------------- */
/* ������� */
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

/* ����CHECKԼ�� */
ALTER TABLE Qualification	/* �ϸ�ʼʱ��С�ںϸ����ʱ�� */
	ADD CONSTRAINT CK_Qualification_Date 
	CHECK (startQualDate < endQualDate);

ALTER TABLE Qualification	/* �ȼ����ΪA��E */
	ADD CONSTRAINT CK_Qualification_gradeObtained
	CHECK (gradeObtained BETWEEN 'A' AND 'E');						
	
ALTER TABLE Qualification	/* �������0 */
	ADD CONSTRAINT CK_Qualification_gpa
	CHECK (gpa > 0);
	
/* --------------------------------Review��Լ��-------------------------------------------- */
/* ������� */
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
	
/* ����CHECKԼ�� */
ALTER TABLE Review	/* �������߱�Ų����������߱�� */
	ADD CONSTRAINT CK_Review_No 
	CHECK (revieweeEmployeeNo != reviewerEmployeeNo);
	
/* --------------------------------WorkHistory��Լ��-------------------------------------------- */
/* ������� */
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
	
/* ����CHECKԼ�� */
ALTER TABLE WorkHistory	/* �ȼ����ΪA��E */
	ADD CONSTRAINT CK_WorkHistory_prevGrade
	CHECK (prevGrade BETWEEN 'A' AND 'E');						
	
ALTER TABLE WorkHistory	/* нˮ����0 */
	ADD CONSTRAINT CK_WorkHistory_prevSalary
	CHECK (prevSalary > 0);