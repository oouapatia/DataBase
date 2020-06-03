
package PositionType;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PositionType_delete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();     
        
        String positionTypeNo = request.getParameter("positionTypeNo");

        // 判断员工编号是否存在
        DBean db = new DBean();
        boolean juge = true;
        ResultSet sqlRes = null;        // 结果集对象
        String select_user = "SELECT positionTypeNo FROM PositionType WHERE positionTypeNo='" + positionTypeNo + "'";
        sqlRes = db.Query(select_user);
        try {
            if (!sqlRes.next()) {   juge = false;   }
        } catch (SQLException ex) {
           out.println(ex.toString());
        }
        if (juge) {
            String del_user = "DELETE PositionType WHERE positionTypeNo='" + positionTypeNo + "'";
            int result = db.Update(del_user);
            db.closeDB(sqlRes);
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除成功！\");");
                out.println("document.location.href=\"PositionType/positionType_delete.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除失败！\");");
                out.println("document.location.href=\"PositionType/positionType_delete.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的员工编号！\");");
            out.println("document.location.href=\"PositionType/positionType_delete.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
