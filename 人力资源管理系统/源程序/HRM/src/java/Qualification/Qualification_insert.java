
package Qualification;

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

public class Qualification_insert extends HttpServlet {

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

        boolean juge_quaEmployeeNo = false;     // 判断员工编号是否在Qualification表中，初值为不存在
        boolean juge_empEmployeeNo = false;     // 判断员工编号是否在Employee表中，初值为不存在
        boolean juge_institutionNo = false;    // 判断机构编号是否在Institution表中，初值为不存在
        
        DBean db = new DBean();
        
        // 查询员工编号是否在Qualification表中
        ResultSet sqlRes_quaEmployeeNo;        // 结果集对象
        String select_quaEmployeeNo = "SELECT employeeNo FROM Qualification WHERE employeeNo ='" + employeeNo +"'";
        sqlRes_quaEmployeeNo = db.Query(select_quaEmployeeNo);
    out.println(select_quaEmployeeNo);
    
        // 查询员工编号是否在Employee表中
        ResultSet sqlRes_empEmployeeNo;
        String select_empEmployeeNo = "SELECT employeeNo FROM Employee WHERE employeeNo ='" + employeeNo +"'";
        sqlRes_empEmployeeNo = db.Query(select_empEmployeeNo);
    out.println(select_empEmployeeNo);
    
        // 查询机构编号是否在Institution表中
        ResultSet sqlRes_institutionNo;
        String select_institutionNo = "SELECT institutionNo FROM Institution WHERE institutionNo ='" + institutionNo +"'";
        sqlRes_institutionNo = db.Query(select_institutionNo);
    out.println(select_institutionNo);
    
        try {
            if (!sqlRes_quaEmployeeNo.next()) { juge_quaEmployeeNo = true;  }
            if (sqlRes_empEmployeeNo.next()) { juge_empEmployeeNo = true; }
            if (sqlRes_institutionNo.next()) { juge_institutionNo = true; }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        // 格式化数据
        Format format = new Format();
        qualificationName = format.FormatSql(qualificationName);
        employeeNo = format.FormatSql(employeeNo);
        gradeObtained = format.FormatSql(gradeObtained);
        startQualDate = format.FormatSql(startQualDate);
        endQualDate = format.FormatSql(endQualDate);
        gpa = format.FormatSql(gpa);
        institutionNo = format.FormatSql(institutionNo);

        if (juge_quaEmployeeNo && juge_empEmployeeNo && juge_institutionNo) {
            // 更新语句
            String insert_sql = "INSERT INTO Qualification"
                    + " VALUES(" + qualificationName + "," + employeeNo + "," + gradeObtained + "," 
                    + startQualDate + "," + endQualDate + "," + gpa + ","+ institutionNo + ")";
            out.println(insert_sql);
            int result = db.Update(insert_sql);
            
            db.closeDB(sqlRes_quaEmployeeNo);
            db.closeDB(sqlRes_empEmployeeNo);
            db.closeDB(sqlRes_institutionNo);
            
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加成功！\");");
                out.println("document.location.href=\"Qualification/qualification_insert.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加失败！\");");
                out.println("document.location.href=\"Qualification/qualification_insert.jsp\";");
                out.println("</script>");
            }
        }
        
        db.closeDB(sqlRes_quaEmployeeNo);
        db.closeDB(sqlRes_empEmployeeNo);
        db.closeDB(sqlRes_institutionNo);
        
        if(!juge_quaEmployeeNo) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该员工编号信息已存在！\");");
            out.println("document.location.href=\"Qualification/qualification_insert.jsp\";");
            out.println("</script>");
        }
        if(!juge_empEmployeeNo){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该员工编号不存在！\");");
            out.println("document.location.href=\"Qualification/qualification_insert.jsp\";");
            out.println("</script>");
        }
        if(!juge_institutionNo){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该机构编号不存在！\");");
            out.println("document.location.href=\"Qualification/qualification_insert.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
