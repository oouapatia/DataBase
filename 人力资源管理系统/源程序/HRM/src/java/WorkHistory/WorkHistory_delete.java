
package WorkHistory;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkHistory_delete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();        
        String employeeNo = request.getParameter("employeeNo");

        boolean juge = false;    // 判断员工编号是否存在，初值为不存在
        
        DBean db = new DBean();
        ResultSet sqlRes;        // 结果集对象
        String select_user = "SELECT employeeNo FROM WorkHistory WHERE employeeNo='" + employeeNo + "'";
        sqlRes = db.Query(select_user);
        try {
            if (sqlRes.next()) {   juge = true;    }
        } catch (SQLException ex) {
           out.println(ex.toString());
        }
        
        if (juge) {
            String del_user = "DELETE FROM WorkHistory WHERE employeeNo='" + employeeNo + "'";
            int result = db.Update(del_user);
            db.closeDB(sqlRes);
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除成功！\");");
                out.println("document.location.href=\"WorkHistory/workHistory_delete.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除失败！\");");
                out.println("document.location.href=\"WorkHistory/workHistory_delete.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            if(!juge){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"没有该员工的工作历史！\");");
                out.println("document.location.href=\"WorkHistory/workHistory_delete.jsp\";");
                out.println("</script>");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
