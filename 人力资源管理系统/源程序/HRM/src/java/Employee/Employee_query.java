package Employee;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Employee_query extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    // ArrayList储存employee的信息
    public static String [] employeeNo_Arr = new String[1];
    public static String [] title_Arr = new String[1];
    public static String [] name_Arr = new String[1];
    public static String [] address_Arr = new String[1];
    public static String [] workTelExt_Arr = new String[1];
    public static String [] homeTelNo_Arr = new String[1];
    public static String [] empEmailAddress_Arr = new String[1];
    public static String [] socialSecurityNumber_Arr = new String[1];
    public static String [] DOB_Arr = new String[1];
    public static String [] position_Arr = new String[1];
    public static String [] sex_Arr = new String[1];
    public static String [] salary_Arr = new String[1];
    public static String [] dateStarted_Arr = new String[1];
    public static String [] dateLeft_Arr = new String[1];
    public static String [] departmentNo_Arr = new String[1];
    public static String [] supervisorEmployeeNo_Arr = new String[1];

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
                
        String employeeNo = request.getParameter("employeeNo");
        String title,name,firstName,middleName,lastName,address,workTelExt,homeTelNo,empEmailAddress;
        String socialSecurityNumber,DOB,position,sex,salary,dateStarted,dateLeft,departmentNo,supervisorEmployeeNo;

        //  查询员工信息
        ResultSet sqlRes;     // 结果集对象
        DBean db = new DBean();
        boolean juge = false;
        String sql_user = "SELECT * FROM Employee WHERE employeeNo='" + employeeNo +"'";
        sqlRes = db.Query(sql_user);
        try {
            while (sqlRes.next()) {
                juge = true;
                employeeNo_Arr[0] = sqlRes.getString("employeeNo").trim();          // 员工编号
                
                if(sqlRes.getString("title") != null)                               // 职称
                    title = sqlRes.getString("title").trim();
                else    title = "";
                title_Arr[0] = title;

                firstName = (sqlRes.getString("firstName").trim());                 // 姓名
                if(sqlRes.getString("middleName") != null)
                    middleName = sqlRes.getString("middleName").trim();
                else    middleName = "";
                lastName = (sqlRes.getString("lastName").trim());
                name = lastName + middleName + firstName;
                name_Arr[0] = name;

                if(sqlRes.getString("address") != null)                             // 地址
                    address = sqlRes.getString("address").trim();
                else    address = "";
                address_Arr[0] = address;

                if(sqlRes.getString("workTelExt") != null)                          // 工作电传
                    workTelExt = sqlRes.getString("workTelExt").trim();
                else    workTelExt = "";
                workTelExt_Arr[0] = workTelExt;

                if(sqlRes.getString("homeTelNo") != null)                           // 家庭电话号码
                    homeTelNo = sqlRes.getString("homeTelNo").trim();
                else    homeTelNo = "";
                homeTelNo_Arr[0] = homeTelNo;

                if(sqlRes.getString("empEmailAddress") != null)                     // 员工电子邮件地址
                    empEmailAddress = sqlRes.getString("empEmailAddress").trim();
                else    empEmailAddress = "";
                empEmailAddress_Arr[0] = empEmailAddress;

                socialSecurityNumber_Arr[0] = sqlRes.getString("socialSecurityNumber").trim();   // 身份证号码

                if(sqlRes.getString("DOB") != null)                                 // 出生日期
                    DOB = sqlRes.getString("DOB").trim();
                else    DOB = "";
                DOB_Arr[0] = DOB;

                if(sqlRes.getString("position") != null)                            // 职务
                    position = sqlRes.getString("position").trim();
                else    position = "";
                position_Arr [0] = position;

                if(sqlRes.getString("sex") != null)                                 // 性别
                    sex = sqlRes.getString("sex").trim();
                else    sex = "";
                sex_Arr[0] = sex;

                if(sqlRes.getString("salary") != null)                              // 薪水
                    salary = sqlRes.getString("salary").trim();
                else    salary = "";
                salary_Arr[0] = salary;

                if(sqlRes.getString("dateStarted") != null)                         // 入职时间
                    dateStarted = sqlRes.getString("dateStarted").trim();
                else    dateStarted = "";
                dateStarted_Arr[0] = dateStarted;

                if(sqlRes.getString("dateLeft") != null)                            // 离职时间
                    dateLeft = sqlRes.getString("dateLeft").trim();
                else    dateLeft = "";
                dateLeft_Arr[0] = dateLeft;

                departmentNo_Arr[0] = sqlRes.getString("departmentNo").trim();      // 部门编号
                supervisorEmployeeNo_Arr[0] = sqlRes.getString("supervisorEmployeeNo").trim();   // 主管员工编号
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        if(juge == true){
            db.closeDB(sqlRes);
            response.sendRedirect("Employee/employee_viewSingle.jsp");
        }
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该员工编号不存在！\");");
            out.println("document.location.href=\"Employee/employee_query.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
