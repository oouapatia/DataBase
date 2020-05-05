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

public class PrevCompany_update extends HttpServlet {

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
        boolean juge = false;
        ResultSet sqlRes;        // 结果集对象
        String select_prevCompanyNo = "SELECT prevCompanyNo FROM PrevCompany WHERE prevCompanyNo='" + prevCompanyNo +"'";
        sqlRes = db.Query(select_prevCompanyNo);
        try {
            if (sqlRes.next()) {
                juge = true;
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        if (juge == true) {
            // 更新语句
            String update_pCompanyName = "UPDATE PrevCompany SET pCompanyName='" + pCompanyName + "' WHERE prevCompanyNo='" + prevCompanyNo+"'";
            String update_pCompanyStreet = "UPDATE PrevCompany SET pCompanyStreet='" + pCompanyStreet + "' WHERE prevCompanyNo='" + prevCompanyNo+"'";
            String update_pCompanyCity = "UPDATE PrevCompany SET pCompanyCity='" + pCompanyCity + "' WHERE prevCompanyNo='" + prevCompanyNo+"'";
            String update_pCompanyState = "UPDATE PrevCompany SET pCompanyState='" + pCompanyState + "' WHERE prevCompanyNo='" + prevCompanyNo+"'";
            String update_pCompanyZipCode = "UPDATE PrevCompany SET pCompanyZipCode='" + pCompanyZipCode + "' WHERE prevCompanyNo='" + prevCompanyNo+"'";
            String update_pCompanyTelNo = "UPDATE PrevCompany SET pCompanyTelNo='" + pCompanyTelNo + "' WHERE prevCompanyNo='" + prevCompanyNo+"'";
            String update_pCompanyFaxNo = "UPDATE PrevCompany SET pCompanyFaxNo='" + pCompanyFaxNo + "' WHERE prevCompanyNo='" + prevCompanyNo+"'";
            String update_pCompanyWebAddress = "UPDATE PrevCompany SET pCompanyWebAddress='" + pCompanyWebAddress + "' WHERE prevCompanyNo='" + prevCompanyNo+"'";
            String update_contactName = "UPDATE PrevCompany SET contactName='" + contactName + "' WHERE prevCompanyNo='" + prevCompanyNo+"'";
            String update_contactTelNo = "UPDATE PrevCompany SET contactTelNo='" + contactTelNo + "' WHERE prevCompanyNo='" + prevCompanyNo+"'";
            String update_contactFaxNo = "UPDATE PrevCompany SET contactFaxNo='" + contactFaxNo + "' WHERE prevCompanyNo='" + prevCompanyNo+"'";
            String update_contactEmailAddress = "UPDATE PrevCompany SET contactEmailAddress='" + contactEmailAddress + "' WHERE prevCompanyNo='" + prevCompanyNo+"'";
            
            int[] result = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1}; // 标记是否更新成功
            // 判断是否为空，然后判断是否更新
            if (!pCompanyName.equals(""))           result[0] = db.Update(update_pCompanyName);
            if (!pCompanyStreet.equals(""))         result[1] = db.Update(update_pCompanyStreet);
            if (!pCompanyCity.equals(""))           result[2] = db.Update(update_pCompanyCity);
            if (!pCompanyState.equals(""))          result[3] = db.Update(update_pCompanyState);
            if (!pCompanyZipCode.equals(""))        result[4] = db.Update(update_pCompanyZipCode);
            if (!pCompanyTelNo.equals(""))          result[5] = db.Update(update_pCompanyTelNo);
            if (!pCompanyFaxNo.equals(""))          result[6] = db.Update(update_pCompanyFaxNo);
            if (!pCompanyWebAddress.equals(""))     result[7] = db.Update(update_pCompanyWebAddress);
            if (!contactName.equals(""))            result[8] = db.Update(update_contactName);
            if (!contactTelNo.equals(""))           result[9] = db.Update(update_contactTelNo);
            if (!contactFaxNo.equals(""))           result[10] = db.Update(update_contactFaxNo);
            if (!contactEmailAddress.equals(""))    result[11] = db.Update(update_contactEmailAddress);
            
            db.closeDB(sqlRes);
            boolean juge_update = true; // 判断是否更新成功
            for (int i : result) {
                if (i == 0) {
                    juge_update = false;
                    break;
                }
            }

            if (juge_update == true) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改成功！\");");
                out.println("document.location.href=\"PrevCompany/prevCompany_update.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改失败！\");");
                out.println("document.location.href=\"PrevCompany/prevCompany_update.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的公司编号！\");");
            out.println("document.location.href=\"PrevCompany/prevCompany_update.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
