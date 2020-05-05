package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HRM {
    
    // 构造函数
    public HRM() throws SQLException{
        employee_view();
        PrevCompany_view();
        Institution_view();
    }

    // ArrayList储存employee的信息
    public ArrayList<String> employeeNo_Arr = new ArrayList<>();
    public ArrayList<String> title_Arr = new ArrayList<>();
    public ArrayList<String> firstName_Arr = new ArrayList<>();
    public ArrayList<String> middleName_Arr = new ArrayList<>();
    public ArrayList<String> lastName_Arr = new ArrayList<>();
    public ArrayList<String> address_Arr = new ArrayList<>();
    public ArrayList<String> workTelExt_Arr = new ArrayList<>();
    public ArrayList<String> homeTelNo_Arr = new ArrayList<>();
    public ArrayList<String> empEmailAddress_Arr = new ArrayList<>();
    public ArrayList<String> socialSecurityNumber_Arr = new ArrayList<>();
    public ArrayList<String> DOB_Arr = new ArrayList<>();
    public ArrayList<String> position_Arr = new ArrayList<>();
    public ArrayList<String> sex_Arr = new ArrayList<>();
    public ArrayList<String> salary_Arr = new ArrayList<>();
    public ArrayList<String> dateStarted_Arr = new ArrayList<>();
    public ArrayList<String> dateLeft_Arr = new ArrayList<>();
    public ArrayList<String> departmentNo_Arr = new ArrayList<>();
    public ArrayList<String> supervisorEmployeeNo_Arr = new ArrayList<>();
    public int employee_view() throws SQLException{
        int i = 0;
        String title,middleName,address,workTelExt,homeTelNo,empEmailAddress,DOB,position,sex,salary,dateStarted,dateLeft;
        DBean db = new DBean();
        ResultSet sqlRes;
        String selectSql = "SELECT * FROM Employee";
        sqlRes = db.Query(selectSql);
        while(sqlRes.next()) {
            employeeNo_Arr.add(sqlRes.getString("employeeNo").trim());          // 员工编号
            
            if(sqlRes.getString("title") != null)                               // 职称
                title = sqlRes.getString("title").trim();
            else
                title = "";
            title_Arr.add(title);
            
            firstName_Arr.add(sqlRes.getString("firstName").trim());            // 姓名
            if(sqlRes.getString("middleName") != null)
                middleName = sqlRes.getString("middleName").trim();
            else
                middleName = "";
            middleName_Arr.add(middleName);
            lastName_Arr.add(sqlRes.getString("lastName").trim());
            
            if(sqlRes.getString("address") != null)                             // 地址
                address = sqlRes.getString("address").trim();
            else
                address = "";
            address_Arr.add(address);
            
            if(sqlRes.getString("workTelExt") != null)                          // 工作电传
                workTelExt = sqlRes.getString("workTelExt").trim();
            else
                workTelExt = "";
            workTelExt_Arr.add(workTelExt);
            
            if(sqlRes.getString("homeTelNo") != null)                           // 家庭电话号码
                homeTelNo = sqlRes.getString("homeTelNo").trim();
            else
                homeTelNo = "";
            homeTelNo_Arr.add(homeTelNo);
            
            if(sqlRes.getString("empEmailAddress") != null)                     // 员工电子邮件地址
                empEmailAddress = sqlRes.getString("empEmailAddress").trim();
            else
                empEmailAddress = "";
            empEmailAddress_Arr.add(empEmailAddress);
            
            socialSecurityNumber_Arr.add(sqlRes.getString("socialSecurityNumber").trim());   // 身份证号码
            
            if(sqlRes.getString("DOB") != null)                                 // 出生日期
                DOB = sqlRes.getString("DOB").trim();
            else
                DOB = "";
            DOB_Arr.add(DOB);
            
            if(sqlRes.getString("position") != null)                            // 职务
                position = sqlRes.getString("position").trim();
            else
                position = "";
            position_Arr.add(position);
            
            if(sqlRes.getString("sex") != null)                                 // 性别
                sex = sqlRes.getString("sex").trim();
            else
                sex = "";
            sex_Arr.add(sex);
            
            if(sqlRes.getString("salary") != null)                              // 薪水
                salary = sqlRes.getString("salary").trim();
            else
                salary = "";
            salary_Arr.add(salary);
            
            if(sqlRes.getString("dateStarted") != null)                         // 入职时间
                dateStarted = sqlRes.getString("dateStarted").trim();
            else
                dateStarted = "";
            dateStarted_Arr.add(dateStarted);
            
            if(sqlRes.getString("dateLeft") != null)                            // 离职时间
                dateLeft = sqlRes.getString("dateLeft").trim();
            else
                dateLeft = "";
            dateLeft_Arr.add(dateLeft);
                    
            departmentNo_Arr.add(sqlRes.getString("departmentNo").trim());      // 部门编号
            
            supervisorEmployeeNo_Arr.add(sqlRes.getString("supervisorEmployeeNo").trim());   // 主管员工编号
            i++;
        }
        db.closeDB(sqlRes);
        return i;
    }

    // ArrayList储存PrevCompany的信息
    public ArrayList<String> pCompanyNo_Arr = new ArrayList<>();
    public ArrayList<String> pCompanyName_Arr = new ArrayList<>();
    public ArrayList<String> pCompanyStreet_Arr = new ArrayList<>();
    public ArrayList<String> pCompanyCity_Arr = new ArrayList<>();
    public ArrayList<String> pCompanyState_Arr = new ArrayList<>();
    public ArrayList<String> pCompanyZipCode_Arr = new ArrayList<>();
    public ArrayList<String> pCompanyTelNo_Arr = new ArrayList<>();
    public ArrayList<String> pCompanyFaxNo_Arr = new ArrayList<>();
    public ArrayList<String> pCompanyWebAddress_Arr = new ArrayList<>();
    public ArrayList<String> pCompanycontactName_Arr = new ArrayList<>();
    public ArrayList<String> pCompanycontactTelNo_Arr = new ArrayList<>();
    public ArrayList<String> pCompanycontactFaxNo_Arr = new ArrayList<>();
    public ArrayList<String> pCompanycontactEmailAddress_Arr = new ArrayList<>();
    public int PrevCompany_view() throws SQLException{
        int i = 0;
        String prevCompanyNo,pCompanyName,pCompanyStreet,pCompanyCity,pCompanyState,pCompanyZipCode;
        String pCompanyTelNo,pCompanyFaxNo,pCompanyWebAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress;
        DBean db = new DBean();
        ResultSet sqlRes;
        String selectSql = "SELECT * FROM PrevCompany";
        sqlRes = db.Query(selectSql);
        while(sqlRes.next()) {
            pCompanyNo_Arr.add(sqlRes.getString("prevCompanyNo").trim());    // 前公司编号
            
            if(sqlRes.getString("pCompanyName") != null)                        // 前公司名称
                pCompanyName = sqlRes.getString("pCompanyName").trim();
            else
                pCompanyName = "";
            pCompanyName_Arr.add(pCompanyName);
            
            if(sqlRes.getString("pCompanyStreet") != null)                      // 前公司所在街道
                pCompanyStreet = sqlRes.getString("pCompanyStreet").trim();
            else
                pCompanyStreet = "";
            pCompanyStreet_Arr.add(pCompanyStreet);
            
            if(sqlRes.getString("pCompanyCity") != null)                        // 前公司所在城市
                pCompanyCity = sqlRes.getString("pCompanyCity").trim();
            else
                pCompanyCity = "";
            pCompanyCity_Arr.add(pCompanyCity);
            
            if(sqlRes.getString("pCompanyState") != null)                       // 前公司所在国家
                pCompanyState = sqlRes.getString("pCompanyState").trim();
            else
                pCompanyState = "";
            pCompanyState_Arr.add(pCompanyState);
            
            if(sqlRes.getString("pCompanyZipCode") != null)                     // 前公司邮政编码
                pCompanyZipCode = sqlRes.getString("pCompanyZipCode").trim();
            else
                pCompanyZipCode = "";
            pCompanyZipCode_Arr.add(pCompanyZipCode);
            
            if(sqlRes.getString("pCompanyTelNo") != null)                       // 前公司电话号码（座机）
                pCompanyTelNo = sqlRes.getString("pCompanyTelNo").trim();
            else
                pCompanyTelNo = "";
            pCompanyTelNo_Arr.add(pCompanyTelNo);
            
            if(sqlRes.getString("pCompanyFaxNo") != null)                       // 前公司传真号码
                pCompanyFaxNo = sqlRes.getString("pCompanyFaxNo").trim();
            else
                pCompanyFaxNo = "";
            pCompanyFaxNo_Arr.add(pCompanyFaxNo);	

            if(sqlRes.getString("pCompanyWebAddress") != null)                  // 前公司网址
                pCompanyWebAddress = sqlRes.getString("pCompanyWebAddress").trim();
            else
                pCompanyWebAddress = "";
            pCompanyWebAddress_Arr.add(pCompanyWebAddress);
            
            if(sqlRes.getString("contactName") != null)                         // 联系人姓名
                contactName = sqlRes.getString("contactName").trim();
            else
                contactName = "";
            pCompanycontactName_Arr.add(contactName);
            
            if(sqlRes.getString("contactTelNo") != null)                        // 联系人电话
                contactTelNo = sqlRes.getString("contactTelNo").trim();
            else
                contactTelNo = "";
            pCompanycontactTelNo_Arr.add(contactTelNo);
            
            if(sqlRes.getString("contactFaxNo") != null)                        // 联系人传真号码
                contactFaxNo = sqlRes.getString("contactFaxNo").trim();
            else
                contactFaxNo = "";
            pCompanycontactFaxNo_Arr.add(contactFaxNo);
            
            if(sqlRes.getString("contactEmailAddress") != null)                  // 联系人电子邮件地址
                contactEmailAddress = sqlRes.getString("contactEmailAddress").trim();
            else
                contactEmailAddress = "";
            pCompanycontactEmailAddress_Arr.add(contactEmailAddress);
            i++;
        }
        db.closeDB(sqlRes);
        return i;
    }
    
    // ArrayList储存Institution的信息
    public ArrayList<String> institutionNo_Arr = new ArrayList<>();
    public ArrayList<String> institutionName_Arr = new ArrayList<>();
    public ArrayList<String> instAddress_Arr = new ArrayList<>();
    public ArrayList<String> instTelNo_Arr = new ArrayList<>();
    public ArrayList<String> instFaxNo_Arr = new ArrayList<>();
    public ArrayList<String> instWbeAddress_Arr = new ArrayList<>();
    public ArrayList<String> instcontactName_Arr = new ArrayList<>();
    public ArrayList<String> instContactTelNo_Arr = new ArrayList<>();
    public ArrayList<String> instContactFaxNo_Arr = new ArrayList<>();
    public ArrayList<String> instcontactEmailAddress_Arr = new ArrayList<>();
    public int Institution_view() throws SQLException{
        int i = 0;
        String institutionNo,institutionName,instAddress,instTelNo,instFaxNo;
        String instWbeAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress;
        
        DBean db = new DBean();
        ResultSet sqlRes;
        String selectSql = "SELECT * FROM Institution";
        sqlRes = db.Query(selectSql);
        while(sqlRes.next()) {
            institutionNo_Arr.add(sqlRes.getString("institutionNo").trim());    // 机构编号
            
            institutionName_Arr.add(sqlRes.getString("institutionName").trim());// 机构名称	

            if(sqlRes.getString("instAddress") != null)                         // 机构地址
                instAddress = sqlRes.getString("instAddress").trim();
            else
                instAddress = "";
            instAddress_Arr.add(instAddress);
            
            if(sqlRes.getString("instTelNo") != null)                           // 机构电话号码
                instTelNo = sqlRes.getString("instTelNo").trim();
            else
                instTelNo = "";
            instTelNo_Arr.add(instTelNo);	
            
            if(sqlRes.getString("instFaxNo") != null)                           // 机构传真号码
                instFaxNo = sqlRes.getString("instFaxNo").trim();
            else
                instFaxNo = "";
            instFaxNo_Arr.add(instFaxNo);
            
            if(sqlRes.getString("instWbeAddress") != null)                      // 机构网址
                instWbeAddress = sqlRes.getString("instWbeAddress").trim();
            else
                instWbeAddress = "";
            instWbeAddress_Arr.add(instWbeAddress);
            
            instcontactName_Arr.add(sqlRes.getString("contactName").trim());        // 联系人姓名	
            
            instContactTelNo_Arr.add(sqlRes.getString("contactTelNo").trim());   // 联系人电话号码	

            if(sqlRes.getString("contactFaxNo") != null)                        // 联系人传真号码 
                contactFaxNo = sqlRes.getString("contactFaxNo").trim();
            else
                contactFaxNo = "";
            instContactFaxNo_Arr.add(contactFaxNo);
            
            if(sqlRes.getString("contactEmailAddress") != null)                 // 联系人电子邮件地址 
                contactEmailAddress = sqlRes.getString("contactEmailAddress").trim();
            else
                contactEmailAddress = "";
            instcontactEmailAddress_Arr.add(contactEmailAddress);
            i++;
        }
        db.closeDB(sqlRes);
        return i;
    }
}
