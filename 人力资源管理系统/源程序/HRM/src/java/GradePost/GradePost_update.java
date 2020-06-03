package GradePost;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GradePost_update extends HttpServlet {

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
        String postNo = request.getParameter("postNo");
        String gradeNo = request.getParameter("gradeNo");
        String validFromDate = request.getParameter("validFromDate");
        
        DBean db = new DBean();
        boolean juge_postNo = true; // 判断此岗位编号是否存在
        boolean juge_gradeNo = false;   // 判断等级编号是否存在
        boolean juge_validFromDate = false; // 判断有效开始日期
        
        ResultSet sqlRes_postNo;        // 结果集对象
        String select_postNo = "SELECT postNo FROM Post WHERE postNo='" + postNo + "'";
        sqlRes_postNo = db.Query(select_postNo);
        
        ResultSet sqlRes_gradeNo;        // 结果集对象
        String select_gradeNo = "SELECT gradeNo FROM Grade WHERE gradeNo='" + gradeNo + "'";
        sqlRes_gradeNo = db.Query(select_gradeNo);
        
        ResultSet sqlRes_validFromDate;        // 结果集对象
        String select_validFromDate = "SELECT validFromDate FROM Grade WHERE gradeNo='" + gradeNo + "'";
        sqlRes_validFromDate = db.Query(select_validFromDate);
                
        try {
            if (!sqlRes_postNo.next())          { juge_postNo = false;  }
            if (sqlRes_gradeNo.next())          { juge_gradeNo = true;  }
            if (sqlRes_validFromDate.next())    { juge_validFromDate = true;  }
            if(!sqlRes_validFromDate.getString("validFromDate").equals(validFromDate))  { 
                juge_validFromDate = false; }      // 输入的时间与表中时间进行比较
        } catch (SQLException ex) {
            out.println(ex.toString());
        }   
        
        if (juge_postNo && juge_gradeNo && juge_validFromDate) {
            // 更新语句
            String update = "UPDATE GradePost SET gradeNo='" + gradeNo + "',validFromDate='" + validFromDate + "' WHERE postNo='" + postNo +"'";
            int result = db.Update(update);

            db.closeDB(sqlRes_postNo);
            db.closeDB(sqlRes_gradeNo);
            db.closeDB(sqlRes_validFromDate);

            boolean juge_update = true;
            if (result == 0)
                juge_update = false;

            if (juge_update) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改成功！\");");
                out.println("document.location.href=\"GradePost/gradePost_update.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改失败！\");");
                out.println("document.location.href=\"GradePost/gradePost_update.jsp\";");
                out.println("</script>");
            }
        }

        db.closeDB(sqlRes_postNo);
        db.closeDB(sqlRes_gradeNo);
        db.closeDB(sqlRes_validFromDate);
            
        if(!juge_postNo){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的岗位编号！\");");
            out.println("document.location.href=\"GradePost/gradePost_update.jsp\";");
            out.println("</script>");
        }

        if(!juge_gradeNo){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的等级编号！\");");
            out.println("document.location.href=\"GradePost/gradePost_update.jsp\";");
            out.println("</script>");
        }
        if(!juge_validFromDate){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入与等级编号对应的的有效开始日期！\");");
            out.println("document.location.href=\"GradePost/gradePost_update.jsp\";");
            out.println("</script>");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
