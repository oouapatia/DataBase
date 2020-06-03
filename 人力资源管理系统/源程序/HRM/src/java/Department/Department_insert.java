
package Department;

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

public class Department_insert extends HttpServlet {

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

        boolean juge_departmentNo = false;  // 判断部门编号是否存在，初值为不存在
        boolean juge_manager = false;       // 判断管理人员编号是否存在，初值为不存在
        
        DBean db = new DBean();
        
        // 查询部门编号是否存在
        String select_departmentNo = "SELECT departmentNo FROM Department WHERE departmentNo='"+ departmentNo +"'";
        ResultSet sqlRes_departmentNo = db.Query(select_departmentNo);
        
        // 查询部门编号是否存在
        String select_manager = "SELECT employeeNo FROM Employee WHERE employeeNo='"+ managerEmployeeNo +"'";
        ResultSet sqlRes_manager = db.Query(select_manager);
        
        try {
            if (sqlRes_departmentNo.next()) { juge_departmentNo = true; }
            if (sqlRes_manager.next()) { juge_manager = true; }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        // 格式化数据
        Format format = new Format();
        departmentNo = format.FormatSql(departmentNo);
        departmentName = format.FormatSql(departmentName);
        deptLocation = format.FormatSql(deptLocation);
        managerEmployeeNo = format.FormatSql(managerEmployeeNo);
        
        if (!juge_departmentNo && juge_manager) {
            // 更新语句
            String insert_sql = "INSERT INTO Department"
                    + " VALUES(" + departmentNo + "," + departmentName + "," + deptLocation + "," + managerEmployeeNo + ")";
            int result = db.Update(insert_sql);
            
            // 关闭数据库
            db.closeDB(sqlRes_departmentNo);
            db.closeDB(sqlRes_manager);
            
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加成功！\");");
                out.println("document.location.href=\"Department/department_insert.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加失败！\");");
                out.println("document.location.href=\"Department/department_insert.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes_departmentNo);
            db.closeDB(sqlRes_manager);
            
            if(juge_departmentNo){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"该部门编号已存在！\");");
                out.println("document.location.href=\"Department/department_insert.jsp\";");
                out.println("</script>");
            }
            if(!juge_manager){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"管理人员编号不存在！\");");
                out.println("document.location.href=\"Department/department_insert.jsp\";");
                out.println("</script>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
