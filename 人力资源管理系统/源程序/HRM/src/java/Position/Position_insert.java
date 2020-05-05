
package Position;

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

public class Position_insert extends HttpServlet {

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

        boolean juge_position = false;    // 判断员工编号是否已在职位表中，初值为不在
        boolean juge_employee = false;    // 判断员工编号否在员工表中，初值为不在
        boolean juge_post = false;      // 判断职位编号是否在岗位表中，初值为不在
        boolean juge_start = false;     // 判断入职时间是否在岗位表中，初值为不在
        
        DBean db = new DBean();
        
        // 查询员工编号否是在职位表中
        ResultSet sqlRes_position;
        String select1_employeeNo = "SELECT employeeNo FROM Position WHERE employeeNo='"+ employeeNo +"'";
        sqlRes_position = db.Query(select1_employeeNo);
        
        // 查询员工编号是否在员工表中
        ResultSet sqlRes_employee;
        String select2_employeeNo = "SELECT employeeNo FROM Employee WHERE employeeNo='"+ employeeNo +"'";
        sqlRes_employee = db.Query(select2_employeeNo);
        
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
            while (sqlRes_position.next()) {    juge_position = true; break;  }
            while (sqlRes_employee.next()) {    juge_employee = true; break;  }
            while (sqlRes_postNo.next())   {    juge_post = true;   break;  }
            while (sqlRes_startDate.next()) {   juge_start = true;   break;}
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        // 格式化数据
        Format format = new Format();
        employeeNo = format.FormatSql(employeeNo);
        postNo = format.FormatSql(postNo);
        startDate = format.FormatSql(startDate);
        endDate = format.FormatSql(endDate);
        
        if (!juge_position && juge_employee && juge_post && juge_start) {
            // 更新语句
            String insert_sql = "INSERT INTO Position"
                    + " VALUES(" + employeeNo + "," + postNo + "," + startDate + "," + endDate + ")";
            int result = db.Update(insert_sql);
            
            db.closeDB(sqlRes_position);
            db.closeDB(sqlRes_employee);
            db.closeDB(sqlRes_postNo);
            db.closeDB(sqlRes_startDate);
            
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加成功！\");");
                out.println("document.location.href=\"Position/position_insert.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加失败！\");");
                out.println("document.location.href=\"Position/position_insert.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes_position);
            db.closeDB(sqlRes_employee);
            db.closeDB(sqlRes_postNo);
            db.closeDB(sqlRes_startDate);
            
            if(juge_position){ 
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"该员工的职位信息已存在！\");");
                out.println("document.location.href=\"Position/position_insert.jsp\";");
                out.println("</script>");
            }
            if(!juge_employee){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"该员工不存在！\");");
                out.println("document.location.href=\"Position/position_insert.jsp\";");
                out.println("</script>");
            }
            if(!juge_post){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"职位编号不存在！\");");
                out.println("document.location.href=\"Position/position_insert.jsp\";");
                out.println("</script>");
            }
            if(!juge_start){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"入职时间与入职编号不对应！\");");
                out.println("document.location.href=\"Position/position_insert.jsp\";");
                out.println("</script>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
