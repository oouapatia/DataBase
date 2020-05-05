/* -------------------------------------------插入Department表数据------------------------------- */
INSERT 
INTO Department(departmentNo,departmentName,deptLocation,managerEmployeeNo)
VALUES('GL001','管理部门','长青路写字楼501','0010001');

INSERT 
INTO Department(departmentNo,departmentName,deptLocation,managerEmployeeNo)
VALUES('SC002','生产部门','长青路写字楼502','0020002');

INSERT 
INTO Department(departmentNo,departmentName,deptLocation,managerEmployeeNo)
VALUES('SJ003','设计部门','长青路写字楼503','0030003');

INSERT 
INTO Department(departmentNo,departmentName,deptLocation,managerEmployeeNo)
VALUES('WL004','物流部门','长青路写字楼504','0040004');

INSERT 
INTO Department(departmentNo,departmentName,deptLocation,managerEmployeeNo)
VALUES('YL005','原料部门','长青路写字楼505','0050005');


/* -------------------------------------------插入Employee表数据------------------------------- */
INSERT
INTO Employee(employeeNo,title,firstName,middleName,lastName,address,workTelExt,homeTelNo,empEmailAddress,socialSecurityNumber,DOB,position,sex,salary,dateStarted,dateLeft,departmentNo,supervisorEmployeeNo)
VALUES('0010001','工程师','夏提亚里坤',null,'米热','湖北省武汉市','02158321321','02158001321','mire@163.com','500101199701211233','1997-01-01','供应商管理工程师','男',50000.00,'2013-11-27','2019-10-10','GL001','0010001');

INSERT
INTO Employee(employeeNo,title,firstName,middleName,lastName,address,workTelExt,homeTelNo,empEmailAddress,socialSecurityNumber,DOB,position,sex,salary,dateStarted,dateLeft,departmentNo,supervisorEmployeeNo)
VALUES('0020002',null,'飞龙',null,'蓝','湖北省武汉市','02158321322','02158001322','feilonglan@163.com','500101199801011233','1998-01-01','生产线线长','男',6000.00,'2017-10-28',null,'SC002','0020002');

INSERT
INTO Employee(employeeNo,title,firstName,middleName,lastName,address,workTelExt,homeTelNo,empEmailAddress,socialSecurityNumber,DOB,position,sex,salary,dateStarted,dateLeft,departmentNo,supervisorEmployeeNo)
VALUES('0030003',null,'万开',null,'丁','湖北省武汉市','02158321323','02158001323','wankaiding@qq.com','500101199905011233','1999-05-01','设计组长','男',6000.00,'2015-03-05',null,'SJ003','0030003');

INSERT
INTO Employee(employeeNo,title,firstName,middleName,lastName,address,workTelExt,homeTelNo,empEmailAddress,socialSecurityNumber,DOB,position,sex,salary,dateStarted,dateLeft,departmentNo,supervisorEmployeeNo)
VALUES('0040004',null,'承伟',null,'蒲','湖北省武汉市','02158321324','02158001324','chengweipu@qq.com','500101199506021233','1995-06-02','物流运输组长','男',6000.00,'2016-09-30',null,'WL004','0040004');

INSERT
INTO Employee(employeeNo,title,firstName,middleName,lastName,address,workTelExt,homeTelNo,empEmailAddress,socialSecurityNumber,DOB,position,sex,salary,dateStarted,dateLeft,departmentNo,supervisorEmployeeNo)
VALUES('0050005',null,'小红',null,'马','武汉市武昌区','02158321325','02158001325','xiaohongma@163.com','500101199112121234','1991-12-12','原料部部长','女',10000.00,'2015-11-30',null,'YL005','0050005');

/* -------------------------------------------插入Grade表数据------------------------------- */
INSERT 
INTO Grade(gradeNo,validFromDate,validToDate,gradeDescrible,gradesalary,noDaysLeaveEntitlement,positionTypeNo)
VALUES('A','2014-11-27','2019-10-10','A为普通等级，。。',2000.00,10,'gysgl');

INSERT 
INTO Grade(gradeNo,validFromDate,validToDate,gradeDescrible,gradesalary,noDaysLeaveEntitlement,positionTypeNo)
VALUES('B','2018-10-28',null,'B为一般等级，。。',3000.00,20,'scx');

INSERT
INTO Grade(gradeNo,validFromDate,validToDate,gradeDescrible,gradesalary,noDaysLeaveEntitlement,positionTypeNo)
VALUES('C','2016-03-05',null,'C为优秀等级，。。',6000.00,30,'sj');

INSERT 
INTO Grade(gradeNo,validFromDate,validToDate,gradeDescrible,gradesalary,noDaysLeaveEntitlement,positionTypeNo)
VALUES('D','2017-09-30',null,'D为高级等级，。。',10000.00,40,'wlys');

INSERT 
INTO Grade(gradeNo,validFromDate,validToDate,gradeDescrible,gradesalary,noDaysLeaveEntitlement,positionTypeNo)
VALUES('E','2016-11-30',null,'E为特殊等级，。。',15000.00,50,'ylb');

/* -------------------------------------------插入Post表数据------------------------------- */
INSERT 
INTO Post(postNo,availableFromDate,availableToDate,postDescription,salariedHourly,fullPartTime,temporaryPermanent,freeLaborStandardsActExempt,departmentNo)
VALUES('gysgl001','2014-11-27','2019-11-27','供应商质量能力的现场考察、评价。。',5000.00,'全职','正式员工','是','GL001');

INSERT 
INTO Post(postNo,availableFromDate,availableToDate,postDescription,salariedHourly,fullPartTime,temporaryPermanent,freeLaborStandardsActExempt,departmentNo)
VALUES('scx002','2018-10-28',null,'管理生产线上的情况。。。',3000.00,'全职','正式员工','是','SC002');

INSERT 
INTO Post(postNo,availableFromDate,availableToDate,postDescription,salariedHourly,fullPartTime,temporaryPermanent,freeLaborStandardsActExempt,departmentNo)
VALUES('sj003','2016-03-05',null,'设计工程图纸',3500.00,'全职','正式员工','是','SJ003');

INSERT 
INTO Post(postNo,availableFromDate,availableToDate,postDescription,salariedHourly,fullPartTime,temporaryPermanent,freeLaborStandardsActExempt,departmentNo)
VALUES('wlys004','2017-09-30',null,'管理物流运输。。',5000.00,'全职','正式员工','是','WL004');

INSERT 
INTO Post(postNo,availableFromDate,availableToDate,postDescription,salariedHourly,fullPartTime,temporaryPermanent,freeLaborStandardsActExempt,departmentNo)
VALUES('ylb005','2016-11-30',null,'原料的采购与记录。。',6000.00,'兼职','实习生','否','YL005');


/* -------------------------------------------插入GradePost表数据------------------------------- */
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


/* -------------------------------------------插入Institution表数据------------------------------- */
INSERT
INTO Institution(institutionNo,institutionName,instAddress,instTelNo,instFaxNo,instWbeAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/WHZGSY0001S--2011','中国石油化工股份有限公司','湖北省武汉市洪山区','02158006006','02158006006','http://www.zgsy.com','米热·夏提亚里坤','15811113211','02158006006','02158006006');

INSERT
INTO Institution(institutionNo,institutionName,instAddress,instTelNo,instFaxNo,instWbeAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/FJKDWL0002S--2012','福建快递物流公司','福建省西北部','02158006107','02158006107','http://www.kdwl.com','张三','15811110010','02158006107','02158006107');

INSERT
INTO Institution(institutionNo,institutionName,instAddress,instTelNo,instFaxNo,instWbeAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/SYKY0003S--2013','沈阳矿业公司','沈阳辽林','02158116008','02158116008','http://www.syky.com','李四','15811110010','02158116008','02158116008');

INSERT
INTO Institution(institutionNo,institutionName,instAddress,instTelNo,instFaxNo,instWbeAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/CQZLS0004S--2014','重庆自来水公司','重庆市万州区','02158561309','02158561309','http://www.cqszls.com','王五','15811110010','02158561309','02158561309');

INSERT
INTO Institution(institutionNo,institutionName,instAddress,instTelNo,instFaxNo,instWbeAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/ASMY0005S--2015','安顺煤业公司','安顺','02158321654','02158321654','http://www.asmy.com','马晓辉','15811110010','02158321654','02158321654');


/* -------------------------------------------插入Position表数据------------------------------- */
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

/* -------------------------------------------插入PositionType表数据------------------------------- */
INSERT 
INTO PositionType(positionTypeNo,positionTypeDescription)
VALUES('gysgl','gysgl为供应商管理工程师简写，负责供应商质量能力的现场考察、评价。。');

INSERT
INTO PositionType(positionTypeNo,positionTypeDescription)
VALUES('scx','scx为生产线线长简写，。。');

INSERT 
INTO PositionType(positionTypeNo,positionTypeDescription)
VALUES('sj','sj为设计组长简写，。。');

INSERT 
INTO PositionType(positionTypeNo,positionTypeDescription)
VALUES('wlys','wlys为物流运输组长简写，。。');

INSERT 
INTO PositionType(positionTypeNo,positionTypeDescription)
VALUES('ylb','ylb为原料部部长，。。');

/* -------------------------------------------插入PrevCompany表数据------------------------------- */
INSERT 
INTO PrevCompany(prevCompanyNo,pCompanyName,pCompanyStreet,pCompanyCity,pCompanyState,pCompanyZipCode,pCompanyTelNo,pCompanyFaxNo,pCompanyWebAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/WHZGSY0001S--2011','中国石油化工股份有限公司','湖北省武汉市','武汉','中华人民共和国','430000','02158006006','02158006006','http://www.zgsy.com','米热·夏提亚里坤','15811110011','02158006006','12312312@163.com');

INSERT 
INTO PrevCompany(prevCompanyNo,pCompanyName,pCompanyStreet,pCompanyCity,pCompanyState,pCompanyZipCode,pCompanyTelNo,pCompanyFaxNo,pCompanyWebAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/FJKDWL0002S--2012','福建快递物流公司','福建省西北部','福建','中华人民共和国','350000','02158006107','02158006107','http://www.kdwl.com','张三','15811110011','02158006107','sanzhang@163.com');

INSERT 
INTO PrevCompany(prevCompanyNo,pCompanyName,pCompanyStreet,pCompanyCity,pCompanyState,pCompanyZipCode,pCompanyTelNo,pCompanyFaxNo,pCompanyWebAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/SYKY0003S--2013','沈阳矿业公司','沈阳辽林','沈阳','中华人民共和国','110000','02158116008','02158116008','http://www.syky.com','李四','15811110011','02158116008','sili@qq.com');

INSERT 
INTO PrevCompany(prevCompanyNo,pCompanyName,pCompanyStreet,pCompanyCity,pCompanyState,pCompanyZipCode,pCompanyTelNo,pCompanyFaxNo,pCompanyWebAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/CQZLS0004S--2014','重庆自来水公司','重庆市万州区','重庆','中华人民共和国','400000','02158561309','02158561309','http://www.cqszls.com','王五','15811110011','02158561309','wuwang@qq.com');

INSERT 
INTO PrevCompany(prevCompanyNo,pCompanyName,pCompanyStreet,pCompanyCity,pCompanyState,pCompanyZipCode,pCompanyTelNo,pCompanyFaxNo,pCompanyWebAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress)
VALUES('Q/ASMY0005S--2015','安顺煤业公司','安顺','安顺','中华人民共和国','561000','02158321654','02158321654','http://www.asmy.com','马晓辉','15827420013','02158321654','xiaohuima@163.com');


/* -------------------------------------------插入Qualification表数据------------------------------- */
INSERT 
INTO Qualification(qualificationName,employeeNo,gradeObtained,startQualDate,endQualDate,gpa,institutionNo)
VALUES('硕士研究生','0010001','A','2014-11-27','2019-10-10',4.51,'Q/WHZGSY0001S--2011');

INSERT 
INTO Qualification(qualificationName,employeeNo,gradeObtained,startQualDate,endQualDate,gpa,institutionNo)
VALUES('大学本科','0020002','B','2018-10-28',null,4.63,'Q/FJKDWL0002S--2012');

INSERT 
INTO Qualification(qualificationName,employeeNo,gradeObtained,startQualDate,endQualDate,gpa,institutionNo)
VALUES('博士研究生','0030003','C','2016-03-05',null,4.37,'Q/SYKY0003S--2013');

INSERT 
INTO Qualification(qualificationName,employeeNo,gradeObtained,startQualDate,endQualDate,gpa,institutionNo)
VALUES('硕士研究生','0040004','D','2017-09-30',null,4.21,'Q/CQZLS0004S--2014');

INSERT 
INTO Qualification(qualificationName,employeeNo,gradeObtained,startQualDate,endQualDate,gpa,institutionNo)
VALUES('大学本科','0050005','E','2016-11-30',null,4.03,'Q/ASMY0005S--2015');


/* -------------------------------------------插入Review表数据------------------------------- */
INSERT 
INTO Review(revieweeEmployeeNo,reviewerEmployeeNo,reviewDate,comments)
VALUES('0010001','0020002','2019-11-27','具体评价');

INSERT 
INTO Review(revieweeEmployeeNo,reviewerEmployeeNo,reviewDate,comments)
VALUES('0020002','0050005','2019-03-08','具体评价');

INSERT 
INTO Review(revieweeEmployeeNo,reviewerEmployeeNo,reviewDate,comments)
VALUES('0030003','0040004','2018-10-19','具体评价');

INSERT 
INTO Review(revieweeEmployeeNo,reviewerEmployeeNo,reviewDate,comments)
VALUES('0040004','0030003','2017-11-30','具体评价');

INSERT 
INTO Review(revieweeEmployeeNo,reviewerEmployeeNo,reviewDate,comments)
VALUES('0050005','0010001','2018-01-02','具体评价');


/* -------------------------------------------插入WorkHistory表数据------------------------------- */
INSERT 
INTO WorkHistory(prevCompanyNo,employeeNo,prevPosition,prevGrade,prevSalary,prevLocation,prevResponsibilities)
VALUES('Q/WHZGSY0001S--2011','0010001','紧急情况处理组长','A',50000.00,'湖北省武汉市','处理紧急情况、对安全情况进行检查。。。');

INSERT 
INTO WorkHistory(prevCompanyNo,employeeNo,prevPosition,prevGrade,prevSalary,prevLocation,prevResponsibilities)
VALUES('Q/FJKDWL0002S--2012','0020002','物流管理经理','B',6000.00,'福建省西北部','管理物流运输，处理相关问题。。。');

INSERT 
INTO WorkHistory(prevCompanyNo,employeeNo,prevPosition,prevGrade,prevSalary,prevLocation,prevResponsibilities)
VALUES('Q/SYKY0003S--2013','0030003','矿业业务组长','C',6000.00,'沈阳辽林','处理相关的矿业业务。。。');

INSERT 
INTO WorkHistory(prevCompanyNo,employeeNo,prevPosition,prevGrade,prevSalary,prevLocation,prevResponsibilities)
VALUES('Q/CQZLS0004S--2014','0040004','紧急情况处理组长','D',6000.00,'重庆市万州区','处理紧急情况、对安全情况进行检查。。。');

INSERT 
INTO WorkHistory(prevCompanyNo,employeeNo,prevPosition,prevGrade,prevSalary,prevLocation,prevResponsibilities)
VALUES('Q/ASMY0005S--2015','0050005','煤业外联组长','E',10000.00,'安顺','联系煤业销售公司。。。');

