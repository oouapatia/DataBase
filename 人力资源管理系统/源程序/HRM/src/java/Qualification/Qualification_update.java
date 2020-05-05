package Qualification;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Qualification_update extends HttpServlet {

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
        String qualificationName = request.getParameter("qualificationName");
        String gradeObtained = request.getParameter("gradeObtained");
        String startQualDate = request.getParameter("startQualDate");
        String endQualDate = request.getParameter("endQualDate");
        String gpa = request.getParameter("gpa");
        String institutionNo = request.getParameter("institutionNo");
        
        boolean juge_employeeNo = false;            // 判断员工编号是否存在，初值为不在
        boolean juge_institutionNo = false;        // 判断机构编号是否存在，初值为不在
        
        DBean db = new DBean();
        // 查询员工编号是否在Qualification表中
        ResultSet sqlRes_quaEmployeeNo;        // 结果集对象
        String select_quaEmployeeNo = "SELECT employeeNo FROM Qualification WHERE employeeNo ='" + employeeNo +"'";
        sqlRes_quaEmployeeNo = db.Query(select_quaEmployeeNo);
        
        // 查询机构编号是否在Institution表中
        ResultSet sqlRes_institutionNo;
        String select_institutionNo = "SELECT institutionNo FROM Institution WHERE institutionNo ='" + institutionNo +"'";
        sqlRes_institutionNo = db.Query(select_institutionNo);
        
        try {
            while (sqlRes_quaEmployeeNo.next()) { juge_employeeNo = true; break;  }
            while (sqlRes_institutionNo.next() || "".equals(institutionNo)) { juge_institutionNo = true; break;  }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        if (juge_employeeNo == true && juge_institutionNo == true) {
            // 更新语句
            String update_qualificationName = "UPDATE Qualification SET qualificationName='" + qualificationName + "' WHERE employeeNo='" + employeeNo +"'";
            String update_gradeObtained = "UPDATE Qualification SET gradeObtained='" + gradeObtained + "' WHERE employeeNo='" + employeeNo +"'";
            String update_startQualDate = "UPDATE Qualification SET startQualDate='" + startQualDate + "' WHERE employeeNo='" + employeeNo +"'";
            String update_endQualDate = "UPDATE Qualification SET endQualDate='" + endQualDate + "' WHERE employeeNo='" + employeeNo +"'";
            String update_gpa = "UPDATE Qualification SET gpa='" + gpa + "' WHERE employeeNo='" + employeeNo +"'";
            String update_institutionNo = "UPDATE Qualification SET institutionNo='" + institutionNo + "' WHERE employeeNo='" + employeeNo +"'";
            
            int[] result = new int[]{1, 1, 1, 1, 1, 1}; // 标记是否更新成功
            // 判断是否为空，然后判断是否更新
            if (!qualificationName.equals(""))      result[0] = db.Update(update_qualificationName);
            if (!gradeObtained.equals(""))          result[1] = db.Update(update_gradeObtained);
            if (!startQualDate.equals(""))          result[2] = db.Update(update_startQualDate);
            if (!endQualDate.equals(""))            result[3] = db.Update(update_endQualDate);
            if (!gpa.equals(""))                    result[4] = db.Update(update_gpa);
            if (!institutionNo.equals(""))          result[5] = db.Update(update_institutionNo);
            
            db.closeDB(sqlRes_quaEmployeeNo);
            db.closeDB(sqlRes_institutionNo);
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
                out.println("document.location.href=\"Qualification/qualification_update.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改失败！\");");
                out.println("document.location.href=\"Qualification/qualification_update.jsp\";");
                out.println("</script>");
            }
        }
        
        db.closeDB(sqlRes_quaEmployeeNo);
        db.closeDB(sqlRes_institutionNo);
        if(juge_employeeNo == false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的员工编号！\");");
            out.println("document.location.href=\"Qualification/qualification_update.jsp\";");
            out.println("</script>");
        }
        if(juge_institutionNo == false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的机构编号！\");");
            out.println("document.location.href=\"Qualification/qualification_update.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
