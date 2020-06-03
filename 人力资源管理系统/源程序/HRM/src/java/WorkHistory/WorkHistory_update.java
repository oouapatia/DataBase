
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

public class WorkHistory_update extends HttpServlet {

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
        String employeeNo = request.getParameter("employeeNo");
        String prevPosition = request.getParameter("prevPosition");
        String prevGrade = request.getParameter("prevGrade");
        String prevSalary = request.getParameter("prevSalary");
        String prevLocation = request.getParameter("prevLocation");
        String prevResponsibilities = request.getParameter("prevResponsibilities");

        if (employeeNo.equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入员工编号！\");");
            out.println("document.location.href=\"WorkHistory/workHistory_update.jsp\";");
            out.println("</script>");
        }

        // 判断员工编号是否存在
        DBean db = new DBean();
        ResultSet sqlRes = null;        // 结果集对象
        String select_user = "SELECT employeeNo FROM WorkHistory WHERE employeeNo="+ employeeNo;
        boolean juge_user = true;
        sqlRes = db.Query(select_user);
        try {
            if (!sqlRes.next()) {   juge_user = false;  }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        boolean juge_comNo = true;
        if(!prevCompanyNo.equals("")){
            // 查询前公司编号是否存在
            String select_comNo = "SELECT prevCompanyNo FROM WorkHistory WHERE prevCompanyNo='"+ prevCompanyNo+"'";
            sqlRes = db.Query(select_comNo);
            try {
                while (!sqlRes.next()) {
                    juge_comNo = false;
                    break;
                }
            } catch (SQLException ex) {
                out.println(ex.toString());
            }
        }
        if (juge_user == true && juge_comNo == true) {
            // 更新语句
            String update_prevCompanyNo = "UPDATE WorkHistory SET prevCompanyNo='" + prevCompanyNo + "' WHERE employeeNo=" + employeeNo;
            String update_prevPosition = "UPDATE WorkHistory SET prevPosition='" + prevPosition + "' WHERE employeeNo=" + employeeNo;
            String update_prevGrade = "UPDATE WorkHistory SET prevGrade='" + prevGrade + "' WHERE employeeNo=" + employeeNo;
            String update_prevSalary = "UPDATE WorkHistory SET prevSalary='" + prevSalary + "' WHERE employeeNo=" + employeeNo;
            String update_prevLocation = "UPDATE WorkHistory SET prevLocation='" + prevLocation + "' WHERE employeeNo=" + employeeNo;
            String update_prevRespons = "UPDATE WorkHistory SET prevResponsibilities='" + prevResponsibilities + "' WHERE employeeNo=" + employeeNo;
        
            int[] result = new int[]{1, 1, 1, 1, 1,1}; // 标记是否更新成功
            // 判断是否为空，然后判断是否更新
            if (!prevCompanyNo.equals(""))          result[0] = db.Update(update_prevCompanyNo);
            if (!prevPosition.equals(""))           result[1] = db.Update(update_prevPosition);
            if (!prevGrade.equals(""))              result[2] = db.Update(update_prevGrade);
            if (!prevSalary.equals(""))             result[3] = db.Update(update_prevSalary);
            if (!prevLocation.equals(""))           result[4] = db.Update(update_prevLocation);
            if (!prevResponsibilities.equals(""))   result[5] = db.Update(update_prevRespons);
            
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
                out.println("document.location.href=\"WorkHistory/workHistory_update.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改失败！\");");
                out.println("document.location.href=\"WorkHistory/workHistory_update.jsp\";");
                out.println("</script>");
            }
        } else if(juge_user == false) {
                db.closeDB(sqlRes);
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"请输入正确的员工编号！\");");
                out.println("document.location.href=\"WorkHistory/workHistory_update.jsp\";");
                out.println("</script>");
            }
            else if(juge_comNo == false){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"请输入正确的公司编号！\");");
                out.println("document.location.href=\"WorkHistory/workHistory_update.jsp\";");
                out.println("</script>");
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
