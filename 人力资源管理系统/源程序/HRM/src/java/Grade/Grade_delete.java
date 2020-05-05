
package Grade;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Grade_delete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();        
        String positionTypeNo = request.getParameter("positionTypeNo");

        boolean juge = false;   // 用来判断等级编号是否存在
        
        // 判断等级编号是否存在
        DBean db = new DBean();
        String select_grade = "SELECT positionTypeNo FROM Grade WHERE positionTypeNo='" + positionTypeNo + "'";
        ResultSet sqlRes  = db.Query(select_grade);
        try {
            while (sqlRes.next()) {
                juge = true;
                break;
            }
        } catch (SQLException ex) {
           out.println(ex.toString());
        }
        if (juge == true) {
            String del_grade = "DELETE Grade WHERE positionTypeNo='" + positionTypeNo + "'";
            int result = db.Update(del_grade);
            db.closeDB(sqlRes);
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除成功！\");");
                out.println("document.location.href=\"Grade/grade_delete.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除失败！\");");
                out.println("document.location.href=\"Grade/grade_delete.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的等级编号！\");");
            out.println("document.location.href=\"Grade/grade_delete.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
