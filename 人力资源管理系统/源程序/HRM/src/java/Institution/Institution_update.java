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

public class Institution_update extends HttpServlet {

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

        // 判断此机构编号是否存在
        DBean db = new DBean();
        boolean juge = true;
        ResultSet sqlRes = null;        // 结果集对象
        String select_user = "SELECT institutionNo FROM Institution WHERE institutionNo='" + institutionNo + "'";
        sqlRes = db.Query(select_user);
        try {
            if (!sqlRes.next()) {   juge = false;   }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        if (juge == true) {
            // 更新语句
            String update_institutionName = "UPDATE Institution SET institutionName='" + institutionName + "' WHERE institutionNo='" + institutionNo+"'";
            String update_instAddress = "UPDATE Institution SET instAddress='" + instAddress + "' WHERE institutionNo='" + institutionNo+"'";
            String update_instTelNo = "UPDATE Institution SET instTelNo='" + instTelNo + "' WHERE institutionNo='" + institutionNo+"'";
            String update_instFaxNo = "UPDATE Institution SET instFaxNo='" + instFaxNo + "' WHERE institutionNo='" + institutionNo+"'";
            String update_instWbeAddress = "UPDATE Institution SET instWbeAddress='" + instWbeAddress + "' WHERE institutionNo='" + institutionNo+"'";
            String update_contactName = "UPDATE Institution SET contactName='" + contactName + "' WHERE institutionNo='" + institutionNo+"'";
            String update_contactTelNo = "UPDATE Institution SET contactTelNo='" + contactTelNo + "' WHERE institutionNo='" + institutionNo+"'";
            String update_contactFaxNo = "UPDATE Institution SET contactFaxNo='" + contactFaxNo + "' WHERE institutionNo='" + institutionNo+"'";
            String update_contactEmailAddress = "UPDATE Institution SET contactEmailAddress='" + contactEmailAddress + "' WHERE institutionNo='" + institutionNo+"'";
            
            int[] result = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}; // 标记是否更新成功
            // 判断是否为空，然后判断是否更新
            if (!institutionName.equals(""))     result[0] = db.Update(update_institutionName);
            if (!instAddress.equals(""))         result[1] = db.Update(update_instAddress);
            if (!instTelNo.equals(""))           result[2] = db.Update(update_instTelNo);
            if (!instFaxNo.equals(""))           result[3] = db.Update(update_instFaxNo);
            if (!instWbeAddress.equals(""))      result[4] = db.Update(update_instWbeAddress);
            if (!contactName.equals(""))         result[5] = db.Update(update_contactName);
            if (!contactTelNo.equals(""))        result[6] = db.Update(update_contactTelNo);
            if (!contactFaxNo.equals(""))        result[7] = db.Update(update_contactFaxNo);
            if (!contactEmailAddress.equals("")) result[8] = db.Update(update_contactEmailAddress);
            
            db.closeDB(sqlRes);
            boolean juge_update = true;
            for (int i : result) {
                if (i == 0) {
                    juge_update = false;
                    break;
                }
            }

            if (juge_update) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改成功！\");");
                out.println("document.location.href=\"Institution/institution_viewTotal.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改失败！\");");
                out.println("document.location.href=\"Institution/institution_update.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的员工编号！\");");
            out.println("document.location.href=\"Institution/institution_update.jsp\";");
            out.println("</script>");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
