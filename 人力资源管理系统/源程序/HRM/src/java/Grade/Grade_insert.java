
package Grade;

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

public class Grade_insert extends HttpServlet {

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
        String gradeNo = request.getParameter("gradeNo");
        String validFromDate = request.getParameter("validFromDate");
        String validToDate = request.getParameter("validToDate");
        String gradeDescrible = request.getParameter("gradeDescrible");
        String gradesalary = request.getParameter("gradesalary");
        String noDaysLeaveEntitlement = request.getParameter("noDaysLeaveEntitlement");
        String positionTypeNo = request.getParameter("positionTypeNo");

        boolean juge_typeNo = false;        // 判断职位类型编号是否在PositionType表中，初值为不存在
        boolean juge_typeExist = false;     // 判断职位类型编号是否在Grade表中，初值为不存在
        
        DBean db = new DBean();
        
        // 查询职位类型编号是否在PositionType表中
        String select_typeNo = "SELECT positionTypeNo FROM PositionType WHERE positionTypeNo ='" + positionTypeNo +"'";
        ResultSet sqlRes_typeNo = db.Query(select_typeNo);
        
        // 查询职位类型编号是否在Grade表中
        String select_typeExist = "SELECT positionTypeNo FROM Grade WHERE positionTypeNo ='" + positionTypeNo +"'";
        ResultSet sqlRes_typeExist = db.Query(select_typeExist);
        
        try {
            if (sqlRes_typeNo.next()) { juge_typeNo = true;  }
            if (sqlRes_typeExist.next()) { juge_typeExist = true;  }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        // 格式化数据
        Format format = new Format();
        gradeNo = format.FormatSql(gradeNo);
        validFromDate = format.FormatSql(validFromDate);
        validToDate = format.FormatSql(validToDate);
        gradeDescrible = format.FormatSql(gradeDescrible);
        gradesalary = format.FormatSql(gradesalary);
        noDaysLeaveEntitlement = format.FormatSql(noDaysLeaveEntitlement);
        positionTypeNo = format.FormatSql(positionTypeNo);

        if (juge_typeExist == false && juge_typeNo == true) {
            // 更新语句
            String insert_sql = "INSERT INTO Grade"
                    + " VALUES(" + gradeNo + "," + validFromDate + "," + validToDate + "," 
                    + gradeDescrible + "," + gradesalary + "," + noDaysLeaveEntitlement + "," + positionTypeNo + ")";
            
            int result = db.Update(insert_sql);
            
            db.closeDB(sqlRes_typeExist);
            db.closeDB(sqlRes_typeNo);
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加成功！\");");
                out.println("document.location.href=\"Grade/grade_insert.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加失败！\");");
                out.println("document.location.href=\"Grade/grade_insert.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes_typeExist);
            db.closeDB(sqlRes_typeNo);

            if(juge_typeExist == true) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"该位类型编号等级已存在！\");");
                out.println("document.location.href=\"Grade/grade_insert.jsp\";");
                out.println("</script>");
            }
            if(juge_typeNo == false){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"该职位类型编号不存在！\");");
                out.println("document.location.href=\"Grade/grade_insert.jsp\";");
                out.println("</script>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
