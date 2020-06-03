
package Employee;

import com.DBean;
import com.Format;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Employee_insert extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();

        //获取参数
        String employeeNo = request.getParameter("employeeNo");
        String title = request.getParameter("title");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String middleName = request.getParameter("middleName");
        String address = request.getParameter("address");
        String workTelExt = request.getParameter("workTelExt");
        String homeTelNo = request.getParameter("homeTelNo");
        String empEmailAddress = request.getParameter("empEmailAddress");
        String socialSecurityNumber = request.getParameter("socialSecurityNumber");
        String DOB = request.getParameter("DOB");
        String position = request.getParameter("position");
        String sex = request.getParameter("sex");
        String salary = request.getParameter("salary");
        String dateStarted = request.getParameter("dateStarted");
        String dateLeft = request.getParameter("dateLeft");
        String departmentNo = request.getParameter("departmentNo");
        String supervisorEmployeeNo = request.getParameter("supervisorEmployeeNo");

        boolean juge_employee = false;     // 判断员工编号是否在Employee表中，初值为不存在
        boolean juge_Security = false;   // 判断身份证是否在Employee表中，即是否唯一，初值为不存在
        boolean juge_super = false;     // 判断主管员工编号是否在Employee表中，初值为不存在
        boolean juge_depart = false;    // 判断部门编号是否在Department表中，初值为不存在
        
        DBean db = new DBean();
        
        // 查询员工编号是否在Employee表中
        ResultSet sqlRes_employee;        // 结果集对象
        String select_employeeNo = "SELECT employeeNo FROM Employee WHERE employeeNo ='" + employeeNo +"'";
        sqlRes_employee = db.Query(select_employeeNo);
        
        // 查询员工身份证号码是否在Employee表中
        ResultSet sqlRes_SecurityNumber;
        String select_SecurityNumber = "SELECT socialSecurityNumber FROM Employee WHERE socialSecurityNumber='" + socialSecurityNumber +"'";
        sqlRes_SecurityNumber = db.Query(select_SecurityNumber);
        
        // 查询部门编号是否在Department表中
        ResultSet sqlRes_departmentNo;
        String select_departmentNo = "SELECT departmentNo FROM Department WHERE departmentNo ='" + departmentNo +"'";
        sqlRes_departmentNo = db.Query(select_departmentNo);
        
        // 查看主管员工编号是否在Employee表中
        ResultSet sqlRes_super;
        String select_super = "SELECT supervisorEmployeeNo FROM Employee WHERE supervisorEmployeeNo ='" + supervisorEmployeeNo +"'";
        sqlRes_super = db.Query(select_super);

        try {
            if (sqlRes_employee.next())          { juge_employee = true; }
            if (sqlRes_SecurityNumber.next())    { juge_Security = true; }
            if (sqlRes_departmentNo.next())      { juge_depart = true;  }
            if (sqlRes_super.next())             { juge_super = true;   }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
                
        // 格式化数据
        Format format = new Format();
        employeeNo = format.FormatSql(employeeNo);
        title = format.FormatSql(title);
        firstName = format.FormatSql(firstName);
        middleName = format.FormatSql(middleName);
        lastName = format.FormatSql(lastName);
        address = format.FormatSql(address);
        workTelExt = format.FormatSql(workTelExt);
        homeTelNo = format.FormatSql(homeTelNo);
        empEmailAddress = format.FormatSql(empEmailAddress);
        socialSecurityNumber = format.FormatSql(socialSecurityNumber);
        DOB = format.FormatSql(DOB);
        position = format.FormatSql(position);
        sex = format.FormatSql(sex);
        salary = format.FormatSql(salary);
        dateStarted = format.FormatSql(dateStarted);
        dateLeft = format.FormatSql(dateLeft);
        departmentNo = format.FormatSql(departmentNo);
        supervisorEmployeeNo = format.FormatSql(supervisorEmployeeNo);
        
        if (!juge_employee && !juge_Security && juge_depart && juge_super) {
            // 更新语句
            String insert_sql = "INSERT INTO Employee"
                    + " VALUES(" + employeeNo + "," + title + "," + firstName + "," + middleName + "," + lastName + "," + address + ","
                    + workTelExt + "," + homeTelNo + "," + empEmailAddress + "," + socialSecurityNumber + "," + DOB + ","
                    + position + "," + sex + "," + salary + "," + dateStarted + "," + dateLeft + "," + departmentNo + "," + supervisorEmployeeNo + ")";
            
            int result = db.Update(insert_sql);

            db.closeDB(sqlRes_employee);
            db.closeDB(sqlRes_SecurityNumber);
            db.closeDB(sqlRes_departmentNo);
            db.closeDB(sqlRes_super);

            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加成功！\");");
                out.println("document.location.href=\"Employee/employee_insert.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加失败！\");");
                out.println("document.location.href=\"Employee/employee_insert.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes_employee);
            db.closeDB(sqlRes_SecurityNumber);
            db.closeDB(sqlRes_departmentNo);
            db.closeDB(sqlRes_super);

            if (juge_employee){   
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"该员工已存在！\");");
                out.println("document.location.href=\"Employee/employee_insert.jsp\";");
                out.println("</script>");
            }
            if (juge_Security) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"输入的身份证号码已存在！\");");
                out.println("document.location.href=\"Employee/employee_insert.jsp\";");
                out.println("</script>");
            } 
            if (!juge_super) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"输入的主管员工编号错误！\");");
                out.println("document.location.href=\"Employee/employee_insert.jsp\";");
                out.println("</script>");
            }
            if (!juge_depart) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"输入的部门编号错误！\");");
                out.println("document.location.href=\"Employee/employee_insert.jsp\";");
                out.println("</script>");
            }
        }   
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
