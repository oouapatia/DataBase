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

public class Review_update extends HttpServlet {

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
        String revieweeEmployeeNo = request.getParameter("revieweeEmployeeNo");
        String reviewerEmployeeNo = request.getParameter("reviewerEmployeeNo");
        String reviewDate = request.getParameter("reviewDate");
        String comments = request.getParameter("comments");

        boolean juge_exist = false;     // 判断评价是否已存在，初值为不在
        boolean juge_reviewer = false;  // 判断评价者编号是否已在员工表中，初值为不在
        boolean juge_reviewee = false;  // 判断被评价者编号否已在员工表中，初值为不在
        
        DBean db = new DBean();
        
        // 查询评价者编号是否在员工表中
        ResultSet sqlRes_reviewer;
        String select_reviewer = "SELECT employeeNo FROM Employee WHERE EmployeeNo='"+ reviewerEmployeeNo +"'";
        sqlRes_reviewer = db.Query(select_reviewer);
        
        // 查询员工编号是否在员工表中
        ResultSet sqlRes_reviewee;
        String select_reviewee = "SELECT employeeNo FROM Employee WHERE EmployeeNo='"+ revieweeEmployeeNo +"'";
        sqlRes_reviewee = db.Query(select_reviewee);

        // 查询评价是否在评价表中
        ResultSet sqlRes_exist;
        String select_exist = "SELECT * FROM Review WHERE reviewerEmployeeNo='" + reviewerEmployeeNo 
                    + "' AND revieweeEmployeeNo='" + revieweeEmployeeNo +"'";
        sqlRes_exist = db.Query(select_exist);
        
        try {
            while (sqlRes_reviewer.next()) {    juge_reviewer = true; break;  }
            while (sqlRes_reviewee.next()) {    juge_reviewee = true; break;  }
            while (sqlRes_exist.next()) {    juge_exist = true; break;  }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        if (juge_reviewer && juge_reviewee && juge_exist) {
            // 更新语句
            String update_revieweeEmployeeNo = "UPDATE Review SET revieweeEmployeeNo='" + revieweeEmployeeNo 
                    + "' WHERE reviewerEmployeeNo='" + reviewerEmployeeNo + "' AND revieweeEmployeeNo='" + revieweeEmployeeNo +"'";
            
            String update_reviewerEmployeeNo = "UPDATE Review SET reviewerEmployeeNo='" + reviewerEmployeeNo 
                    + "' WHERE reviewerEmployeeNo='" + reviewerEmployeeNo + "' AND revieweeEmployeeNo='" + revieweeEmployeeNo +"'";
            
            String update_reviewDate = "UPDATE Review SET reviewDate='" + reviewDate 
                    + "' WHERE reviewerEmployeeNo='" + reviewerEmployeeNo + "' AND revieweeEmployeeNo='" + revieweeEmployeeNo +"'";
            
            String update_comments = "UPDATE Review SET comments='" + comments
                    + "' WHERE reviewerEmployeeNo='" + reviewerEmployeeNo + "' AND revieweeEmployeeNo='" + revieweeEmployeeNo +"'";
            
            int[] result = new int[]{1,1,1,1}; // 标记是否更新成功
            // 判断是否为空，然后判断是否更新
            if (!revieweeEmployeeNo.equals(""))     result[0] = db.Update(update_revieweeEmployeeNo);
            if (!reviewerEmployeeNo.equals(""))     result[1] = db.Update(update_reviewerEmployeeNo);
            if (!reviewDate.equals(""))             result[2] = db.Update(update_reviewDate);
            if (!comments.equals(""))               result[3] = db.Update(update_comments);
            
            db.closeDB(sqlRes_reviewer);
            db.closeDB(sqlRes_reviewee);
            db.closeDB(sqlRes_exist);

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
                out.println("document.location.href=\"Review/review_update.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改失败！\");");
                out.println("document.location.href=\"Review/review_update.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes_reviewer);
            db.closeDB(sqlRes_reviewee);
            db.closeDB(sqlRes_exist);
            
            if(!juge_reviewer){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"评价者员工编号不存在！\");");
                out.println("document.location.href=\"Review/review_update.jsp\";");
                out.println("</script>");
            }
            if(!juge_reviewee){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"被评价者员工编号不存在！\");");
                out.println("document.location.href=\"Review/reviewe_update.jsp\";");
                out.println("</script>");
            }
            if(!juge_exist){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"评价不存在！\");");
                out.println("document.location.href=\"Review/review_update.jsp\";");
                out.println("</script>");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
