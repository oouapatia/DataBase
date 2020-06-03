/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Institution;

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

public class Institution_insert extends HttpServlet {

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
        String institutionNo = request.getParameter("institutionNo");
        String institutionName = request.getParameter("institutionName");
        String instAddress = request.getParameter("instAddress");
        String instTelNo = request.getParameter("instTelNo");
        String instFaxNo = request.getParameter("instFaxNo");
        String instWbeAddress = request.getParameter("instWbeAddress");
        String contactName = request.getParameter("contactName");
        String contactTelNo = request.getParameter("contactTelNo");
        String contactFaxNo = request.getParameter("contactFaxNo");
        String contactEmailAddress = request.getParameter("contactEmailAddress");

        boolean juge_exist = true;

        DBean db = new DBean();
        ResultSet sqlRes;        // 结果集对象
        // 判断机构编号是否存在
        String select_institutionNo = "SELECT institutionNo FROM Institution WHERE institutionNo='" + institutionNo +"'";
        sqlRes = db.Query(select_institutionNo);
        try {
            if (sqlRes.next()) {    juge_exist = false;     }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        // 格式化数据
        Format format = new Format();
        institutionNo = format.FormatSql(institutionNo);
        institutionName = format.FormatSql(institutionName);
        instAddress = format.FormatSql(instAddress);
        instTelNo = format.FormatSql(instTelNo);
        instFaxNo = format.FormatSql(instFaxNo);
        instWbeAddress = format.FormatSql(instWbeAddress);
        contactName = format.FormatSql(contactName);
        contactTelNo = format.FormatSql(contactTelNo);
        contactFaxNo = format.FormatSql(contactFaxNo);
        contactEmailAddress = format.FormatSql(contactEmailAddress);
        
        if (juge_exist) {
            // 更新语句
            String insert_sql = "INSERT INTO Institution"
                    + " VALUES(" + institutionNo + "," + institutionName + "," + instAddress + ","
                    + instTelNo + "," + instFaxNo + "," + instWbeAddress + "," + contactName + ","
                    + contactTelNo + "," + contactFaxNo + "," + contactEmailAddress + ")";

            int result = db.Update(insert_sql);
            if (result != 0) {
                db.closeDB(sqlRes);
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加成功！\");");
                out.println("document.location.href=\"Institution/institution_insert.jsp\";");
                out.println("</script>");
            } else {
                db.closeDB(sqlRes);
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加失败！\");");
                out.println("document.location.href=\"Institution/institution_insert.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该机构编号已存在！\");");
            out.println("document.location.href=\"Institution/institution_insert.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
