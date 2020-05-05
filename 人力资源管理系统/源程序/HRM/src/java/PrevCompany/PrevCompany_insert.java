/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrevCompany;

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

public class PrevCompany_insert extends HttpServlet {

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
        String prevCompanyNo = request.getParameter("prevCompanyNo");
        String pCompanyName = request.getParameter("pCompanyName");
        String pCompanyStreet = request.getParameter("pCompanyStreet");
        String pCompanyCity = request.getParameter("pCompanyCity");
        String pCompanyState = request.getParameter("pCompanyState");
        String pCompanyZipCode = request.getParameter("pCompanyZipCode");
        String pCompanyTelNo = request.getParameter("pCompanyTelNo");
        String pCompanyFaxNo = request.getParameter("pCompanyFaxNo");
        String pCompanyWebAddress = request.getParameter("pCompanyWebAddress");
        String contactName = request.getParameter("contactName");
        String contactTelNo = request.getParameter("contactTelNo");
        String contactFaxNo = request.getParameter("contactFaxNo");
        String contactEmailAddress = request.getParameter("contactEmailAddress");

        // 判断公司编号是否存在 
        DBean db = new DBean();
        ResultSet sqlRes;        // 结果集对象
        boolean juge_exist = false; // 初值为false，即不存在
        String select_prevCompanyNo = "SELECT prevCompanyNo FROM PrevCompany WHERE prevCompanyNo='" + prevCompanyNo +"'";
        sqlRes = db.Query(select_prevCompanyNo);
        try {
            if (sqlRes.next()) {
                juge_exist = true;  // 代表存在
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        // 格式化数据
        Format format = new Format();
        prevCompanyNo = format.FormatSql(prevCompanyNo);
        pCompanyName = format.FormatSql(pCompanyName);
        pCompanyStreet = format.FormatSql(pCompanyStreet);
        pCompanyCity = format.FormatSql(pCompanyCity);
        pCompanyState = format.FormatSql(pCompanyState);
        pCompanyZipCode = format.FormatSql(pCompanyZipCode);
        pCompanyTelNo = format.FormatSql(pCompanyTelNo);
        pCompanyFaxNo = format.FormatSql(pCompanyFaxNo);
        pCompanyWebAddress = format.FormatSql(pCompanyWebAddress);
        contactName = format.FormatSql(contactName);
        contactTelNo = format.FormatSql(contactTelNo);
        contactFaxNo = format.FormatSql(contactFaxNo);
        contactEmailAddress = format.FormatSql(contactEmailAddress);
        
        if (juge_exist == false) {
            // 插入语句
            String insert_sql = "INSERT INTO PrevCompany"
                    + " VALUES(" + prevCompanyNo + "," + pCompanyName + "," + pCompanyStreet + ","
                    + pCompanyCity + "," + pCompanyState + "," + pCompanyZipCode + "," + pCompanyTelNo + ","
                    + pCompanyFaxNo + "," + pCompanyWebAddress + "," + contactName + ","
                    + contactTelNo + "," + contactFaxNo + "," + contactEmailAddress +")";

            int result = db.Update(insert_sql);
            db.closeDB(sqlRes);
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加成功！\");");
                out.println("document.location.href=\"PrevCompany/prevCompany_insert.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加失败！\");");
                out.println("document.location.href=\"PrevCompany/prevCompany_insert.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该公司编号已存在！\");");
            out.println("document.location.href=\"PrevCompany/prevCompany_insert.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
