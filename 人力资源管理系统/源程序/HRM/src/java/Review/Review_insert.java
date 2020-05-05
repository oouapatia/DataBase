
package Review;

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


public class Review_insert extends HttpServlet {

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

        boolean juge_reviewer = false;    // 判断评价者编号是否已在员工表中，初值为不在
        boolean juge_reviewee = false;    // 判断被评价者编号否已在员工表中，初值为不在
        boolean juge_exist = false;       // 判断评论与被评论是否已在评论表中，初值为不在
        
        DBean db = new DBean();
        
        // 查询评价者编号是否在员工表中
        ResultSet sqlRes_reviewer;
        String select_reviewer = "SELECT employeeNo FROM Employee WHERE EmployeeNo='"+ reviewerEmployeeNo +"'";
        sqlRes_reviewer = db.Query(select_reviewer);
        
        // 查询员工编号是否在员工表中
        ResultSet sqlRes_reviewee;
        String select_reviewee = "SELECT employeeNo FROM Employee WHERE EmployeeNo='"+ revieweeEmployeeNo +"'";
        sqlRes_reviewee = db.Query(select_reviewee);
        
        // 查询评论与被评论是否已在评论表中
        ResultSet sqlRes_review;
        String select_review = "SELECT * FROM Review WHERE reviewerEmployeeNo='" + reviewerEmployeeNo 
                    + "' AND revieweeEmployeeNo='" + revieweeEmployeeNo +"'";
        sqlRes_review = db.Query(select_review);
        
        try {
            while (sqlRes_reviewer.next()) {    juge_reviewer = true; break;  }
            while (sqlRes_reviewee.next()) {    juge_reviewee = true; break;  }
            while (sqlRes_review.next())   {    juge_exist = true;   break;  }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        out.println(juge_exist);
        
        // 格式化数据
        Format format = new Format();
        revieweeEmployeeNo = format.FormatSql(revieweeEmployeeNo);
        reviewerEmployeeNo = format.FormatSql(reviewerEmployeeNo);
        reviewDate = format.FormatSql(reviewDate);
        comments = format.FormatSql(comments);
        
        if (!juge_exist && juge_reviewer && juge_reviewee) {
            // 更新语句
            String insert_sql = "INSERT INTO Review"
                    + " VALUES(" + revieweeEmployeeNo + "," + reviewerEmployeeNo + "," + reviewDate + "," + comments + ")";

            db.closeDB(sqlRes_reviewer);
            db.closeDB(sqlRes_reviewee);
            db.closeDB(sqlRes_review);

            int result = db.Update(insert_sql);
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加成功！\");");
                out.println("document.location.href=\"Review/review_insert.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加失败！\");");
                out.println("document.location.href=\"Review/review_insert.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes_reviewer);
            db.closeDB(sqlRes_reviewee);
            db.closeDB(sqlRes_review);
            
            if(!juge_reviewer){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"评价者员工编号不存在！\");");
                out.println("document.location.href=\"Review/review_insert.jsp\";");
                out.println("</script>");
            }
            if(!juge_reviewee){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"被评价者员工编号不存在！\");");
                out.println("document.location.href=\"Review/review_insert.jsp\";");
                out.println("</script>");
            }
            if(juge_exist){ 
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"该员工的评价信息已存在！\");");
                out.println("document.location.href=\"Review/review_insert.jsp\";");
                out.println("</script>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
