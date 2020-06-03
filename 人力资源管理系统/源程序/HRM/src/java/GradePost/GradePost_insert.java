
package GradePost;

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

public class GradePost_insert extends HttpServlet {

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
        String postNo = request.getParameter("postNo");
        String availableFromDate = request.getParameter("availableFromDate");

        boolean juge_postNo = false;    // 初值为不存在，即可以插入
        boolean juge_gradeNo = false;   
        boolean juge_validFromDate = false;
        boolean juge_availableFromDate = false;
        
        DBean db = new DBean();
        
        //判断岗位编号是否存在
        ResultSet sqlRes_postNo;
        String select_postNo = "SELECT postNo FROM GradePost WHERE postNo ='" + postNo +"'";
        sqlRes_postNo = db.Query(select_postNo);
        
        //判断等级编号是否存在
        ResultSet sqlRes_gradeNo;        // 结果集对象
        String select_gradeNo = "SELECT gradeNo FROM Grade WHERE gradeNo ='" + gradeNo +"'";
        sqlRes_gradeNo = db.Query(select_gradeNo);
    
        //判断有效开始日期是否与等级编号匹配
        ResultSet sqlRes_validFromDate;
        String select_validFromDate = "SELECT validFromDate FROM Grade WHERE gradeNo ='" + gradeNo +"'";
        sqlRes_validFromDate = db.Query(select_validFromDate);
        
        //判断开始日期是否与岗位编号匹配
        ResultSet sqlRes_availableFromDate;
        String select_availableFromDate = "SELECT availableFromDate FROM Post WHERE postNo ='" + postNo +"'";
        sqlRes_availableFromDate = db.Query(select_availableFromDate);
        
        try {
            if (sqlRes_postNo.next())            { juge_postNo = true; }
            if (sqlRes_gradeNo.next())           { juge_gradeNo = true; }
            if (sqlRes_validFromDate.next())     { juge_validFromDate = true; }
            if (sqlRes_availableFromDate.next()) { juge_availableFromDate = true; }
            
            if(!sqlRes_validFromDate.getString("validFromDate").equals(validFromDate))  { 
                juge_validFromDate = false; }           // 输入的时间与表中时间进行比较
            if(!sqlRes_availableFromDate.getString("availableFromDate").equals(availableFromDate))  { 
                juge_availableFromDate = false; }      // 输入的时间与表中时间进行比较
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        // 格式化数据
        Format format = new Format();
        gradeNo = format.FormatSql(gradeNo);
        validFromDate = format.FormatSql(validFromDate);
        postNo = format.FormatSql(postNo);
        availableFromDate = format.FormatSql(availableFromDate);
        
        if (!juge_postNo && juge_validFromDate && juge_gradeNo && juge_availableFromDate) {
            // 更新语句
            String insert_sql = "INSERT INTO GradePost"
                    + " VALUES(" + gradeNo + "," + validFromDate + "," + postNo + "," + availableFromDate+ ")";

            int result = db.Update(insert_sql);
            
            db.closeDB(sqlRes_gradeNo);
            db.closeDB(sqlRes_validFromDate);
            db.closeDB(sqlRes_postNo);
            db.closeDB(sqlRes_availableFromDate);
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加成功！\");");
                out.println("document.location.href=\"GradePost/gradePost_insert.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加失败！\");");
                out.println("document.location.href=\"GradePost/gradePost_insert.jsp\";");
                out.println("</script>");
            }
        }
        
        db.closeDB(sqlRes_gradeNo);
        db.closeDB(sqlRes_validFromDate);
        db.closeDB(sqlRes_postNo);
        db.closeDB(sqlRes_availableFromDate);

        if(juge_postNo) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该岗位编号不存在！\");");
            out.println("document.location.href=\"GradePost/gradePost_insert.jsp\";");
            out.println("</script>");
        }
        
        if(!juge_gradeNo) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该等级已存在！\");");
            out.println("document.location.href=\"GradePost/gradePost_insert.jsp\";");
            out.println("</script>");
        }
        
        if(!juge_validFromDate){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"输入的有效开始日期与等级编号不匹配！\");");
            out.println("document.location.href=\"GradePost/gradePost_insert.jsp\";");
            out.println("</script>");
        }
        
        if(!juge_availableFromDate){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"输入的开始日期与岗位编号不匹配！\");");
            out.println("document.location.href=\"GradePost/gradePost_insert.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
