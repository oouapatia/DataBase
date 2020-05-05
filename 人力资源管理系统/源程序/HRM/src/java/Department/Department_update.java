
package Department;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Department_update extends HttpServlet {

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
        String departmentNo = request.getParameter("departmentNo");
        String departmentName = request.getParameter("departmentName");
        String deptLocation = request.getParameter("deptLocation");
        String managerEmployeeNo = request.getParameter("managerEmployeeNo");

        boolean juge_departmentNo = false;   // 判断部门编号是否存在，初值为不存在
        boolean juge_manager = false;        // 判断管理人员编号是否存在，初值为不存在
        
        DBean db = new DBean();
        
        // 查询部门编号是否存在
        ResultSet sqlRes_departmentNo;        // 结果集对象
        String select_departmentNo = "SELECT departmentNo FROM Department WHERE departmentNo='" + departmentNo + "'";
        sqlRes_departmentNo = db.Query(select_departmentNo);
        
        // 查询管理人员编号是否存在
        ResultSet sqlRes_manager;        // 结果集对象
        String select_manager = "SELECT employeeNo FROM Employee WHERE employeeNo='"+ managerEmployeeNo +"'";
        sqlRes_manager = db.Query(select_manager);
        
        try {
            while (sqlRes_departmentNo.next()) {    juge_departmentNo = true;  }
            while (sqlRes_manager.next()) {    juge_manager = true;   }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        if("".equals(managerEmployeeNo))        // 如果管理员工编号为空
            juge_manager = true;
        
        if (juge_departmentNo == true && juge_manager == true) {
            // 更新语句
            String update_name = "UPDATE Department SET departmentName='" + departmentName + "' WHERE departmentNo='" + departmentNo +"'";
            String update_location = "UPDATE Department SET deptLocation='" + deptLocation + "' WHERE departmentNo='" + departmentNo +"'";
            String update_manager = "UPDATE Department SET managerEmployeeNo='" + managerEmployeeNo + "' WHERE departmentNo='" + departmentNo +"'";
            
            int[] result = new int[]{1, 1, 1}; // 标记是否更新成功
            // 判断是否为空，然后判断是否更新
            if (!departmentName.equals(""))         result[0] = db.Update(update_name);
            if (!deptLocation.equals(""))           result[1] = db.Update(update_location);
            if (!managerEmployeeNo.equals(""))      result[2] = db.Update(update_manager);
            
            db.closeDB(sqlRes_departmentNo);
            db.closeDB(sqlRes_manager);
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
                out.println("document.location.href=\"Department/department_update.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改失败！\");");
                out.println("document.location.href=\"Department/department_update.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes_departmentNo);
            db.closeDB(sqlRes_manager);
            
            if(!juge_departmentNo){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"请输入正确的部门编号！\");");
                out.println("document.location.href=\"Department/department_update.jsp\";");
                out.println("</script>");
            }
            if(!juge_manager){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"请输入正确的管理人员编号！\");");
                out.println("document.location.href=\"Department/department_update.jsp\";");
                out.println("</script>");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
