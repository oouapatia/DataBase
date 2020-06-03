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

public class Employee_update extends HttpServlet {

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
        String address = request.getParameter("address");
        String workTelExt = request.getParameter("workTelExt");
        String homeTelNo = request.getParameter("homeTelNo");
        String empEmailAddress = request.getParameter("empEmailAddress");
        String DOB = request.getParameter("DOB");
        String position = request.getParameter("position");
        String sex = request.getParameter("sex");
        String salary = request.getParameter("salary");
        String dateStarted = request.getParameter("dateStarted");
        String dateLeft = request.getParameter("dateLeft");

        if (employeeNo.equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入员工编号！\");");
            out.println("document.location.href=\"Employee/employee_update.jsp\";");
            out.println("</script>");
        }

        // 判断此员工编号是否存在
        DBean db = new DBean();
        boolean juge = true;
        ResultSet sqlRes = null;        // 结果集对象
        String select_user = "SELECT employeeNo FROM Employee WHERE employeeNo='" + employeeNo + "'";
        sqlRes = db.Query(select_user);
        try {
            if (!sqlRes.next())
                juge = false;
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        if (juge == true) {
            // 更新语句
            String update_title = "UPDATE Employee SET title='" + title + "' WHERE employeeNo='" + employeeNo +"'";
            String update_address = "UPDATE Employee SET address='" + address + "' WHERE employeeNo='" + employeeNo +"'";
            String update_workTelExt = "UPDATE Employee SET workTelExt='" + workTelExt + "' WHERE employeeNo='" + employeeNo +"'";
            String update_homeTelNo = "UPDATE Employee SET homeTelNo='" + homeTelNo + "' WHERE employeeNo='" + employeeNo +"'";
            String update_empEmailAddress = "UPDATE Employee SET empEmailAddress='" + empEmailAddress + "' WHERE employeeNo='" + employeeNo +"'";
            String update_DOB = "UPDATE Employee SET DOB='" + DOB + "' WHERE employeeNo='" + employeeNo +"'";
            String update_position = "UPDATE Employee SET position='" + position + "' WHERE employeeNo='" + employeeNo +"'";
            String update_sex = "UPDATE Employee SET sex='" + sex + "' WHERE employeeNo='" + employeeNo +"'";
            String update_salary = "UPDATE Employee SET salary='" + salary + "' WHERE employeeNo='" + employeeNo +"'";
            String update_dateStarted = "UPDATE Employee SET dateStarted='" + dateStarted + "' WHERE employeeNo='" + employeeNo +"'";
            String update_dateLeft = "UPDATE Employee SET dateStarted='" + dateLeft + "' WHERE employeeNo='" + employeeNo +"'";
            
            int[] result = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // 标记是否更新成功
            // 判断是否为空，然后判断是否更新
            if (!title.equals(""))           result[0] = db.Update(update_title);
            if (!address.equals(""))         result[1] = db.Update(update_address);
            if (!workTelExt.equals(""))      result[2] = db.Update(update_workTelExt);
            if (!homeTelNo.equals(""))       result[3] = db.Update(update_homeTelNo);
            if (!empEmailAddress.equals("")) result[4] = db.Update(update_empEmailAddress);
            if (!DOB.equals(""))             result[5] = db.Update(update_DOB);
            if (!position.equals(""))        result[6] = db.Update(update_position);
            if (!sex.equals(""))             result[7] = db.Update(update_sex);
            if (!salary.equals(""))          result[8] = db.Update(update_salary);
            if (!dateStarted.equals(""))     result[9] = db.Update(update_dateStarted);
            if (!dateLeft.equals(""))        result[10] = db.Update(update_dateLeft);
            
            db.closeDB(sqlRes);
            boolean juge_update = true;
            for (int i : result) {
                if (i == 0) {
                    juge_update = false;
                    break;
                }
            }

            if (juge_update) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改成功！\");");
                out.println("document.location.href=\"Employee/employee_update.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改失败！\");");
                out.println("document.location.href=\"Employee/employee_update.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的员工编号！\");");
            out.println("document.location.href=\"Employee/employee_update.jsp\";");
            out.println("</script>");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
