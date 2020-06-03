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

public class Review_query extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    // ArrayList储存Reviewe的信息
    public static String [] revieweeEmployeeNo_Arr = new String[1];
    public static String [] reviewerEmployeeNo_Arr = new String[1];
    public static String [] reviewDate_Arr = new String[1];
    public static String [] comments_Arr = new String[1];

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
                
        String revieweeEmployeeNo = request.getParameter("revieweeEmployeeNo");
        String reviewerEmployeeNo = request.getParameter("reviewerEmployeeNo");
        String reviewDate = request.getParameter("reviewDate");
        String comments = request.getParameter("comments");

        //  查询员工评价信息
        ResultSet sqlRes;     // 结果集对象
        DBean db = new DBean();
        boolean juge = false;
        String del_reviewe = "SELECT * FROM Review WHERE reviewerEmployeeNo='" + reviewerEmployeeNo 
                    + "' AND revieweeEmployeeNo='" + revieweeEmployeeNo +"'";
        
        sqlRes = db.Query(del_reviewe);
        try {
            if (sqlRes.next()) {
                juge = true;
                revieweeEmployeeNo_Arr[0] = sqlRes.getString("revieweeEmployeeNo").trim();  // 被评价者编号
                
                reviewerEmployeeNo_Arr[0] = sqlRes.getString("reviewerEmployeeNo").trim();  // 评价者编号
                
                reviewDate_Arr[0] = sqlRes.getString("reviewDate").trim();                  // 评价日期
                
                comments_Arr[0] = sqlRes.getString("comments").trim();                      // 评价
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        db.closeDB(sqlRes);
        if(juge == true)
            response.sendRedirect("Review/review_viewSingle.jsp");
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"不存在该员工的评价信息！\");");
            out.println("document.location.href=\"Review/review_query.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
