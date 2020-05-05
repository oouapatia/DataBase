
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

public class Department_delete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();        
        String departmentNo = request.getParameter("departmentNo");

        // 判断部门编号是否存在
        DBean db = new DBean();
        boolean juge = false;   // 初值为不存在
        String select_departmentNo = "SELECT departmentNo FROM Department WHERE departmentNo='" + departmentNo + "'";
        ResultSet sqlRes = db.Query(select_departmentNo);
        try {
            while (sqlRes.next()) {
                juge = true;
            }
        } catch (SQLException ex) {
           out.println(ex.toString());
        }
        if (juge) {
            String del_departmentNo = "DELETE Department WHERE departmentNo='" + departmentNo + "'";
            int result = db.Update(del_departmentNo);
            
            db.closeDB(sqlRes);
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除成功！\");");
                out.println("document.location.href=\"Department/department_delete.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除失败！\");");
                out.println("document.location.href=\"Department/department_delete.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的部门编号！\");");
            out.println("document.location.href=\"Department/department_delete.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
