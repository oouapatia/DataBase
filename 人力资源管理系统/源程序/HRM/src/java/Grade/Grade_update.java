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

public class Grade_update extends HttpServlet {

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
        String positionTypeNo = request.getParameter("positionTypeNo");
        String gradeNo = request.getParameter("gradeNo");
        String validFromDate = request.getParameter("validFromDate");
        String validToDate = request.getParameter("validToDate");
        String gradeDescrible = request.getParameter("gradeDescrible");
        String gradesalary = request.getParameter("gradesalary");
        String noDaysLeave = request.getParameter("noDaysLeaveEntitlement");
        
        boolean juge_type = false;      // 判断职位类型编号是否存在，初值为不在

        DBean db = new DBean();
        // 查询职位类型编号编号是否存在
        String select_typeNo = "SELECT positionTypeNo FROM PositionType WHERE positionTypeNo='" + positionTypeNo + "'";
        ResultSet sqlRes_typeNo = db.Query(select_typeNo);
        
        
        try {
            if (sqlRes_typeNo.next()) {    juge_type = true;  }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        if (juge_type == true) {
            // 更新语句
            String update_gradeNo = "UPDATE Grade SET gradeNo='" + gradeNo + "' WHERE positionTypeNo='" + positionTypeNo +"'";
            String update_validFromDate = "UPDATE Grade SET validFromDate='" + validFromDate + "' WHERE positionTypeNo='" + positionTypeNo +"'";
            String update_validToDate = "UPDATE Grade SET validToDate='" + validToDate + "' WHERE positionTypeNo='" + positionTypeNo +"'";
            String update_gradeDescrible = "UPDATE Grade SET gradeDescrible='" + gradeDescrible + "' WHERE positionTypeNo='" + positionTypeNo +"'";
            String update_gradesalary = "UPDATE Grade SET gradesalary='" + gradesalary + "' WHERE positionTypeNo='" + positionTypeNo +"'";
            String update_noDaysLeave = "UPDATE Grade SET noDaysLeaveEntitlement='" + noDaysLeave + "' WHERE positionTypeNo='" + positionTypeNo +"'";

            int[] result = new int[]{1, 1, 1, 1, 1, 1}; // 标记是否更新成功
            // 判断是否为空，然后判断是否更新
            if (!gradeNo.equals(""))            result[0] = db.Update(update_gradeNo);
            if (!validFromDate.equals(""))      result[1] = db.Update(update_validFromDate);
            if (!validToDate.equals(""))        result[2] = db.Update(update_validToDate);
            if (!gradeDescrible.equals(""))     result[3] = db.Update(update_gradeDescrible);
            if (!gradesalary.equals(""))        result[4] = db.Update(update_gradesalary);
            if (!noDaysLeave.equals(""))        result[5] = db.Update(update_noDaysLeave);
            
            db.closeDB(sqlRes_typeNo);
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
                out.println("document.location.href=\"Grade/grade_update.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改失败！\");");
                out.println("document.location.href=\"Grade/grade_update.jsp\";");
                out.println("</script>");
            }
        }
        
        db.closeDB(sqlRes_typeNo);
        if(juge_type == false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"不存在该职位类型的等级信息！\");");
            out.println("document.location.href=\"Grade/grade_update.jsp\";");
            out.println("</script>");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
