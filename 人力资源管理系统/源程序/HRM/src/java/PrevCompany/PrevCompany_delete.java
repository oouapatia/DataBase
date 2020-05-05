/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrevCompany;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrevCompany_delete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();     
        
        String prevCompanyNo = request.getParameter("prevCompanyNo");

        DBean db = new DBean();
        boolean juge = true;    // 判断前公司编号是否存在，初值为存在
        ResultSet sqlRes;        // 结果集对象
        String select_prevCompanyNo = "SELECT prevCompanyNo FROM PrevCompany WHERE prevCompanyNo='" + prevCompanyNo + "'";
        sqlRes = db.Query(select_prevCompanyNo);
        try {
            if (!sqlRes.next()) {
                juge = false;   // 未查询到结果，修改为不存在
            }
        } catch (SQLException ex) {
           out.println(ex.toString());
        }
        if (juge == true) {
            String del_prevCompanyNo = "DELETE PrevCompany WHERE prevCompanyNo='" + prevCompanyNo + "'";
            int result = db.Update(del_prevCompanyNo);
            db.closeDB(sqlRes);
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除成功！\");");
                out.println("document.location.href=\"PrevCompany/prevCompany_delete.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除失败！\");");
                out.println("document.location.href=\"PrevCompany/prevCompany_delete.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的公司编号！\");");
            out.println("document.location.href=\"PrevCompany/prevCompany_delete.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
