/* -------------------------------------------����Department������------------------------------- */
INSERT 
INTO Department(departmentNo,departmentName,deptLocation,managerEmployeeNo)
VALUES('GL001','������','����·д��¥501','0010001');

INSERT 
INTO Department(departmentNo,departmentName,deptLocation,managerEmployeeNo)
VALUES('SC002','��������','����·д��¥502','0020002');

INSERT 
INTO Department(departmentNo,departmentName,deptLocation,managerEmployeeNo)
VALUES('SJ003','��Ʋ���','����·д��¥503','0030003');

INSERT 
INTO Department(departmentNo,departmentName,deptLocation,managerEmployeeNo)
VALUES('WL004','��������','����·д��¥504','0040004');

INSERT 
INTO Department(departmentNo,departmentName,deptLocation,managerEmployeeNo)
VALUES('YL005','ԭ�ϲ���','����·д��¥505','0050005');


/* -------------------------------------------����Employee������------------------------------- */
INSERT
INTO Employee(employeeNo,title,firstName,middleName,lastName,address,workTelExt,homeTelNo,empEmailAddress,socialSecurityNumber,DOB,position,sex,salary,dateStarted,dateLeft,departmentNo,supervisorEmployeeNo)
VALUES('0010001','����ʦ','����������',null,'����','����ʡ�人��','02158321321','02158001321','mire@163.com','500101199701211233','1997-01-01','��Ӧ�̹�����ʦ','��',50000.00,'2013-11-27','2019-10-10','GL001','0010001');

INSERT
INTO Employee(employeeNo,title,firstName,middleName,lastName,address,workTelExt,homeTelNo,empEmailAddress,socialSecurityNumber,DOB,position,sex,salary,dateStarted,dateLeft,departmentNo,supervisorEmployeeNo)
VALUES('0020002',null,'����',null,'��','����ʡ�人��','02158321322','02158001322','feilonglan@163.com','500101199801011233','1998-01-01','�������߳�','��',6000.00,'2017-10-28',null,'SC002','0020002');

INSERT
INTO Employee(employeeNo,title,firstName,middleName,lastName,address,workTelExt,homeTelNo,empEmailAddress,socialSecurityNumber,DOB,position,sex,salary,dateStarted,dateLeft,departmentNo,supervisorEmployeeNo)
VALUES('0030003',null,'��',null,'��','����ʡ�人��','02158321323','02158001323','wankaiding@qq.com','500101199905011233','1999-05-01','����鳤','��',6000.00,'2015-03-05',null,'SJ003','0030003');

INSERT
INTO Employee(employeeNo,title,firstName,middleName,lastName,address,workTelExt,homeTelNo,empEmailAddress,socialSecurityNumber,DOB,position,sex,salary,dateStarted,dateLeft,departmentNo,supervisorEmployeeNo)
VALUES('0040004',null,'��ΰ',null,'��','����ʡ�人��','02158321324','02158001324','chengweipu@qq.com','500101199506021233','1995-06-02','���������鳤','��',6000.00,'2016-09-30',null,'WL004','0040004');

INSERT
INTO Employee(employeeNo,title,firstName,middleName,lastName,address,workTelExt,homeTelNo,empEmailAddress,socialSecurityNumber,DOB,position,sex,salary,dateStarted,dateLeft,departmentNo,supervisorEmployeeNo)
VALUES('0050005',null,'С��',null,'��','�人�������','02158321325','02158001325','xiaohongma@163.com','500101199112121234','1991-12-12','ԭ�ϲ�����','Ů',10000.00,'2015-11-30',null,'YL005','0050005');

/* -------------------------------------------����Grade������------------------------------- */
INSERT 
INTO Grade(gradeNo,validFromDate,validToDate,gradeDescrible,gradesalary,noDaysLeaveEntitlement,positionTypeNo)
VALUES('A','2014-11-27','2019-10-10','AΪ��ͨ�ȼ�������',2000.00,10,'gysgl');

INSERT 
INTO Grade(gradeNo,validFromDate,validToDate,gradeDescrible,gradesalary,noDaysLeaveEntitlement,positionTypeNo)
VALUES('B','2018-10-28',null,'BΪһ��ȼ�������',3000.00,20,'scx');

INSERT
INTO Grade(gradeNo,validFromDate,validToDate,gradeDescrible,gradesalary,noDaysLeaveEntitlement,positionTypeNo)
VALUES('C','2016-03-05',null,'CΪ����ȼ�������',6000.00,30,'sj');

INSERT 
INTO Grade(gradeNo,validFromDate,validToDate,gradeDescrible,gradesalary,noDaysLeaveEntitlement,positionTypeNo)
VALUES('D','2017-09-30',null,'DΪ�߼��ȼ�������',10000.00,40,'wlys');

INSERT 
INTO Grade(gradeNo,validFromDate,validToDate,gradeDescrible,gradesalary,noDaysLeaveEntitlement,positionTypeNo)
VALUES('E','2016-11-30',null,'EΪ����ȼ�������',15000.00,50,'ylb');

/* -------------------------------------------����Post������------------------------------- */
INSERT 
INTO Post(postNo,availableFromDate,availableToDate,postDescription,salariedHourly,fullPartTime,temporaryPermanent,freeLaborStandardsActExempt,departmentNo)
VALUES('gysgl001','2014-11-27','2019-11-27','��Ӧ�������������ֳ����졢���ۡ���',5000.00,'ȫְ','��ʽԱ��','��','GL001');

INSERT 
INTO Post(postNo,availableFromDate,availableToDate,postDescription,salariedHourly,fullPartTime,temporaryPermanent,freeLaborStandardsActExempt,departmentNo)
VALUES('scx002','2018-10-28',null,'�����������ϵ����������',3000.00,'ȫְ','��ʽԱ��','��','SC002');

INSERT 
INTO Post(postNo,availableFromDate,availableToDate,postDescription,salariedHourly,fullPartTime,temporaryPermanent,freeLaborStandardsActExempt,departmentNo)
VALUES('sj003','2016-03-05',null,'��ƹ���ͼֽ',3500.00,'ȫְ','��ʽԱ��','��','SJ003');

INSERT 
INTO Post(postNo,availableFromDate,availableToDate,postDescription,salariedHourly,fullPartTime,temporaryPermanent,freeLaborStandardsActExempt,departmentNo)
VALUES('wlys004','2017-09-30',null,'�����������䡣��',5000.00,'ȫְ','��ʽԱ��','��','WL004');

INSERT 
INTO Post(postNo,availableFromDate,availableToDate,postDescription,salariedHourly,fullPartTime,temporaryPermanent,freeLaborStandardsActExempt,departmentNo)
VALUES('ylb005','2016-11-30',null,'ԭ�ϵĲɹ����¼����',6000.00,'��ְ','ʵϰ��','��','YL005');


/* -------------------------------------------����GradePost������------------------------------- */
INSERT
INTO GradePost(gradeNo,validFromDate,postNo,availableFromDate)
VALUES('A','2014-11-27','gysgl001','2014-11-27');

INSERT 
INTO GradePost(gradeNo,validFromDate,postNo,availableFromDate)
VALUES('B','2018-10-28','scx002','2018-10-28');

INSERT 
INTO GradePost(gradeNo,validFromDate,postNo,availableFromDate)
VALUES('C','2016-03-05','sj003','2016-03-05');

INSERT 
INTO GradePost(gradeNo,validFromDate,postNo,availableFromDate)
VALUES('D','2017-09-30','wlys004','2017-09-30');

INSERT
INTO GradePost(gradeNo,validFromDate,postNo,availableFromDate)
VALUES('E','2016-11-30','ylb005','2016-11-30');


/* -------------------------------------------����Institution������------------------------------- */
INSERT
INTO Institution(institutionNo,institutionName,instAddress,instTelNo,instFaxNo,instWbeAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/WHZGSY0001S--2011','�й�ʯ�ͻ����ɷ����޹�˾','����ʡ�人�к�ɽ��','02158006006','02158006006','http://www.zgsy.com','���ȡ�����������','15811113211','02158006006','02158006006');

INSERT
INTO Institution(institutionNo,institutionName,instAddress,instTelNo,instFaxNo,instWbeAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/FJKDWL0002S--2012','�������������˾','����ʡ������','02158006107','02158006107','http://www.kdwl.com','����','15811110010','02158006107','02158006107');

INSERT
INTO Institution(institutionNo,institutionName,instAddress,instTelNo,instFaxNo,instWbeAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/SYKY0003S--2013','������ҵ��˾','��������','02158116008','02158116008','http://www.syky.com','����','15811110010','02158116008','02158116008');

INSERT
INTO Institution(institutionNo,institutionName,instAddress,instTelNo,instFaxNo,instWbeAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/CQZLS0004S--2014','��������ˮ��˾','������������','02158561309','02158561309','http://www.cqszls.com','����','15811110010','02158561309','02158561309');

INSERT
INTO Institution(institutionNo,institutionName,instAddress,instTelNo,instFaxNo,instWbeAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/ASMY0005S--2015','��˳úҵ��˾','��˳','02158321654','02158321654','http://www.asmy.com','������','15811110010','02158321654','02158321654');


/* -------------------------------------------����Position������------------------------------- */
INSERT
INTO Position(employeeNo,postNo,startDate,endDate)
VALUES('0010001','gysgl001','2014-11-27','2019-10-12');

INSERT
INTO Position(employeeNo,postNo,startDate,endDate)
VALUES('0020002','scx002','2018-10-28',null);

INSERT
INTO Position(employeeNo,postNo,startDate,endDate)
VALUES('0030003','sj003','2016-03-05',null);

INSERT
INTO Position(employeeNo,postNo,startDate,endDate)
VALUES('0040004','wlys004','2017-09-30',null);

INSERT
INTO Position(employeeNo,postNo,startDate,endDate)
VALUES('0050005','ylb005','2016-11-30',null);

/* -------------------------------------------����PositionType������------------------------------- */
INSERT 
INTO PositionType(positionTypeNo,positionTypeDescription)
VALUES('gysgl','gysglΪ��Ӧ�̹�����ʦ��д������Ӧ�������������ֳ����졢���ۡ���');

INSERT
INTO PositionType(positionTypeNo,positionTypeDescription)
VALUES('scx','scxΪ�������߳���д������');

INSERT 
INTO PositionType(positionTypeNo,positionTypeDescription)
VALUES('sj','sjΪ����鳤��д������');

INSERT 
INTO PositionType(positionTypeNo,positionTypeDescription)
VALUES('wlys','wlysΪ���������鳤��д������');

INSERT 
INTO PositionType(positionTypeNo,positionTypeDescription)
VALUES('ylb','ylbΪԭ�ϲ�����������');

/* -------------------------------------------����PrevCompany������------------------------------- */
INSERT 
INTO PrevCompany(prevCompanyNo,pCompanyName,pCompanyStreet,pCompanyCity,pCompanyState,pCompanyZipCode,pCompanyTelNo,pCompanyFaxNo,pCompanyWebAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/WHZGSY0001S--2011','�й�ʯ�ͻ����ɷ����޹�˾','����ʡ�人��','�人','�л����񹲺͹�','430000','02158006006','02158006006','http://www.zgsy.com','���ȡ�����������','15811110011','02158006006','12312312@163.com');

INSERT 
INTO PrevCompany(prevCompanyNo,pCompanyName,pCompanyStreet,pCompanyCity,pCompanyState,pCompanyZipCode,pCompanyTelNo,pCompanyFaxNo,pCompanyWebAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/FJKDWL0002S--2012','�������������˾','����ʡ������','����','�л����񹲺͹�','350000','02158006107','02158006107','http://www.kdwl.com','����','15811110011','02158006107','sanzhang@163.com');

INSERT 
INTO PrevCompany(prevCompanyNo,pCompanyName,pCompanyStreet,pCompanyCity,pCompanyState,pCompanyZipCode,pCompanyTelNo,pCompanyFaxNo,pCompanyWebAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/SYKY0003S--2013','������ҵ��˾','��������','����','�л����񹲺͹�','110000','02158116008','02158116008','http://www.syky.com','����','15811110011','02158116008','sili@qq.com');

INSERT 
INTO PrevCompany(prevCompanyNo,pCompanyName,pCompanyStreet,pCompanyCity,pCompanyState,pCompanyZipCode,pCompanyTelNo,pCompanyFaxNo,pCompanyWebAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/CQZLS0004S--2014','��������ˮ��˾','������������','����','�л����񹲺͹�','400000','02158561309','02158561309','http://www.cqszls.com','����','15811110011','02158561309','wuwang@qq.com');

INSERT 
INTO PrevCompany(prevCompanyNo,pCompanyName,pCompanyStreet,pCompanyCity,pCompanyState,pCompanyZipCode,pCompanyTelNo,pCompanyFaxNo,pCompanyWebAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/ASMY0005S--2015','��˳úҵ��˾','��˳','��˳','�л����񹲺͹�','561000','02158321654','02158321654','http://www.asmy.com','������','15827420013','02158321654','xiaohuima@163.com');


/* -------------------------------------------����Qualification������------------------------------- */
INSERT 
INTO Qualification(qualificationName,employeeNo,gradeObtained,startQualDate,endQualDate,gpa,institutionNo)
VALUES('˶ʿ�о���','0010001','A','2014-11-27','2019-10-10',4.51,'Q/WHZGSY0001S--2011');

INSERT 
INTO Qualification(qualificationName,employeeNo,gradeObtained,startQualDate,endQualDate,gpa,institutionNo)
VALUES('��ѧ����','0020002','B','2018-10-28',null,4.63,'Q/FJKDWL0002S--2012');

INSERT 
INTO Qualification(qualificationName,employeeNo,gradeObtained,startQualDate,endQualDate,gpa,institutionNo)
VALUES('��ʿ�о���','0030003','C','2016-03-05',null,4.37,'Q/SYKY0003S--2013');

INSERT 
INTO Qualification(qualificationName,employeeNo,gradeObtained,startQualDate,endQualDate,gpa,institutionNo)
VALUES('˶ʿ�о���','0040004','D','2017-09-30',null,4.21,'Q/CQZLS0004S--2014');

INSERT 
INTO Qualification(qualificationName,employeeNo,gradeObtained,startQualDate,endQualDate,gpa,institutionNo)
VALUES('��ѧ����','0050005','E','2016-11-30',null,4.03,'Q/ASMY0005S--2015');


/* -------------------------------------------����Review������------------------------------- */
INSERT 
INTO Review(revieweeEmployeeNo,reviewerEmployeeNo,reviewDate,comments)
VALUES('0010001','0020002','2019-11-27','��������');

INSERT 
INTO Review(revieweeEmployeeNo,reviewerEmployeeNo,reviewDate,comments)
VALUES('0020002','0050005','2019-03-08','��������');

INSERT 
INTO Review(revieweeEmployeeNo,reviewerEmployeeNo,reviewDate,comments)
VALUES('0030003','0040004','2018-10-19','��������');

INSERT 
INTO Review(revieweeEmployeeNo,reviewerEmployeeNo,reviewDate,comments)
VALUES('0040004','0030003','2017-11-30','��������');

INSERT 
INTO Review(revieweeEmployeeNo,reviewerEmployeeNo,reviewDate,comments)
VALUES('0050005','0010001','2018-01-02','��������');


/* -------------------------------------------����WorkHistory������------------------------------- */
INSERT 
INTO WorkHistory(prevCompanyNo,employeeNo,prevPosition,prevGrade,prevSalary,prevLocation,prevResponsibilities)
VALUES('Q/WHZGSY0001S--2011','0010001','������������鳤','A',50000.00,'����ʡ�人��','�������������԰�ȫ������м�顣����');

INSERT 
INTO WorkHistory(prevCompanyNo,employeeNo,prevPosition,prevGrade,prevSalary,prevLocation,prevResponsibilities)
VALUES('Q/FJKDWL0002S--2012','0020002','����������','B',6000.00,'����ʡ������','�����������䣬����������⡣����');

INSERT 
INTO WorkHistory(prevCompanyNo,employeeNo,prevPosition,prevGrade,prevSalary,prevLocation,prevResponsibilities)
VALUES('Q/SYKY0003S--2013','0030003','��ҵҵ���鳤','C',6000.00,'��������','������صĿ�ҵҵ�񡣡���');

INSERT 
INTO WorkHistory(prevCompanyNo,employeeNo,prevPosition,prevGrade,prevSalary,prevLocation,prevResponsibilities)
VALUES('Q/CQZLS0004S--2014','0040004','������������鳤','D',6000.00,'������������','�������������԰�ȫ������м�顣����');

INSERT 
INTO WorkHistory(prevCompanyNo,employeeNo,prevPosition,prevGrade,prevSalary,prevLocation,prevResponsibilities)
VALUES('Q/ASMY0005S--2015','0050005','úҵ�����鳤','E',10000.00,'��˳','��ϵúҵ���۹�˾������');

