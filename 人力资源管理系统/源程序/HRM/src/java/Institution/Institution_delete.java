/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Institution;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Institution_delete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();     
        String institutionNo = request.getParameter("institutionNo");

        // 判断机构编号是否存在
        DBean db = new DBean();
        boolean juge = true;
        ResultSet sqlRes;        // 结果集对象
        String select_institutionNo = "SELECT InstitutionNo FROM Institution WHERE InstitutionNo='" + institutionNo + "'";
        sqlRes = db.Query(select_institutionNo);
        try {
            if (!sqlRes.next()) {   juge = false;   }
        } catch (SQLException ex) {
           out.println(ex.toString());
        }
        if (juge) {
            String del_institutionNo = "DELETE Institution WHERE InstitutionNo='" + institutionNo + "'";
            int result = db.Update(del_institutionNo);
            db.closeDB(sqlRes);
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除成功！\");");
                out.println("document.location.href=\"Institution/institution_delete.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除失败！\");");
                out.println("document.location.href=\"Institution/institution_delete.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的机构编号！\");");
            out.println("document.location.href=\"Institution/institution_delete.jsp\";");
            out.println("</script>");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
