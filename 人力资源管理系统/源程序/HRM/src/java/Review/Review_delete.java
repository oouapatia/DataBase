
package Review;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Review_delete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();     
        
        String reviewerEmployeeNo = request.getParameter("reviewerEmployeeNo");
        String revieweeEmployeeNo = request.getParameter("revieweeEmployeeNo");

        boolean juge_reviewer = false;  // 判断评价者编号是否已在评价表中，初值为不在
        boolean juge_reviewee = false;  // 判断被评价者编号是否已在评价表中，初值为不在
        
        // 判断评价者编号是否存在
        DBean db = new DBean();
        ResultSet sqlRes_reviewer = null;        // 结果集对象
        String select_reviewer = "SELECT reviewerEmployeeNo FROM Review WHERE reviewerEmployeeNo='" + reviewerEmployeeNo   + "'";
        sqlRes_reviewer = db.Query(select_reviewer);
        
        // 判断被评价者编号是否存在
        ResultSet sqlRes_reviewee = null;        // 结果集对象
        String select_reviewee = "SELECT revieweeEmployeeNo FROM Review WHERE revieweeEmployeeNo='" + revieweeEmployeeNo   + "'";
        sqlRes_reviewee = db.Query(select_reviewee);
        try {
            while (sqlRes_reviewer.next()) {    juge_reviewer = true;   break;  }
            while (sqlRes_reviewee.next()) {    juge_reviewee = true;   break;  }
        } catch (SQLException ex) {
           out.println(ex.toString());
        }
        if (juge_reviewer == true && juge_reviewee == true) {
            String del_reviewe = "DELETE Review WHERE reviewerEmployeeNo='" + reviewerEmployeeNo 
                    + "' AND revieweeEmployeeNo='" + revieweeEmployeeNo +"'";
            int result = db.Update(del_reviewe);
            
            db.closeDB(sqlRes_reviewer);
            db.closeDB(sqlRes_reviewee);
            
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除成功！\");");
                out.println("document.location.href=\"Review/review_delete.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除失败！\");");
                out.println("document.location.href=\"Review/review_delete.jsp\";");
                out.println("</script>");
            }
        }
        
        db.closeDB(sqlRes_reviewer);
        db.closeDB(sqlRes_reviewee);
            
        if(juge_reviewer == false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的评价者编号！\");");
            out.println("document.location.href=\"Review/review_delete.jsp\";");
            out.println("</script>");
        }
        if(juge_reviewee == false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的被评价者编号！\");");
            out.println("document.location.href=\"Review/review_delete.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
