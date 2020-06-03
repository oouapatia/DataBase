
package Position;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Position_update extends HttpServlet {

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
        String employeeNo = request.getParameter("employeeNo");
        String postNo = request.getParameter("postNo");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        if (employeeNo.equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入员工编号！\");");
            out.println("document.location.href=\"Position/position_update.jsp\";");
            out.println("</script>");
        }

        boolean juge_employee = true;    // 判断员工编号是否已在职位表中，初值为在
        boolean juge_post = true;        // 判断职位编号是否在岗位表中，初值为在
        boolean juge_start = true;       // 判断入职时间是否在岗位表中，初值为在
        
        DBean db = new DBean();
        
        // 查询员工编号否是在职位表中
        ResultSet sqlRes_employee;
        String select_employeeNo = "SELECT employeeNo FROM Position WHERE employeeNo='"+ employeeNo +"'";
        sqlRes_employee = db.Query(select_employeeNo);
        
        // 查询职位编号对否在岗位表中
        ResultSet sqlRes_postNo;
        String select_postNo = "SELECT postNo FROM Post WHERE postNo='"+ postNo +"'";
        sqlRes_postNo = db.Query(select_postNo);
        
        // 查询入职时间是否与职位编号对应,关联post表的availableFromDate
        ResultSet sqlRes_startDate;
        String select_startDate = "SELECT availableFromDate FROM Post WHERE availableFromDate='"
                + startDate +"' AND postNo='" + postNo +"'";
        sqlRes_startDate = db.Query(select_startDate);

        try {
            if (!sqlRes_employee.next()) {    juge_employee = false;   }
            if(!postNo.equals(""))
                if (!sqlRes_postNo.next()) {    juge_post = false;  }
            if(!startDate.equals(""))
                if (!sqlRes_startDate.next()) {   juge_start = false; }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        if (juge_employee && juge_post && juge_start) {
            // 更新语句
            String update_NoDate = "UPDATE Position SET postNo='" + postNo + "'," 
                    + "startDate='" + startDate + "' WHERE employeeNo='" + employeeNo +"'";
            String update_endDate = "UPDATE Position SET endDate='" + endDate + "' WHERE employeeNo='" + employeeNo +"'";

            int[] result = new int[]{1, 1, 1}; // 标记是否更新成功
            // 判断是否为空，然后判断是否更新
            if (!postNo.equals(""))         result[0] = db.Update(update_NoDate);
            if (!endDate.equals(""))        result[1] = db.Update(update_endDate);
            
            db.closeDB(sqlRes_employee);
            db.closeDB(sqlRes_postNo);
            db.closeDB(sqlRes_startDate);
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
                out.println("document.location.href=\"Position/position_update.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改失败！\");");
                out.println("document.location.href=\"Position/position_update.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes_employee);
            db.closeDB(sqlRes_postNo);
            db.closeDB(sqlRes_startDate);
            if(!juge_employee){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"请输入正确的员工编号！\");");
                out.println("document.location.href=\"Position/position_update.jsp\";");
                out.println("</script>");
            }
            if(!juge_post){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"请输入正确的职位编号！\");");
                out.println("document.location.href=\"Position/position_update.jsp\";");
                out.println("</script>");
            }
            if(!juge_start){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"入职时间与入职编号不对应！\");");
                out.println("document.location.href=\"Position/position_update.jsp\";");
                out.println("</script>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
