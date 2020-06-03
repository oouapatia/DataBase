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

public class GradePost_query extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    // ArrayList储存GradePost的信息
    public static String [] gradeNo_Arr = new String[1];
    public static String [] validFromDate_Arr = new String[1];
    public static String [] postNo_Arr = new String[1];
    public static String [] availableFromDate_Arr = new String[1];;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String postNo = request.getParameter("postNo");
        String gradeNo,validFromDate,availableFromDate;

        //  查询等级信息
        ResultSet sqlRes;     // 结果集对象
        DBean db = new DBean();
        boolean juge = false;
        String sql_user = "SELECT * FROM GradePost WHERE postNo='" + postNo +"'";
        sqlRes = db.Query(sql_user);
        try {
            if (sqlRes.next()) {
                juge = true;
                gradeNo_Arr[0] = sqlRes.getString("gradeNo").trim();                        // 等级编号
                
                validFromDate_Arr[0] = sqlRes.getString("validFromDate").trim();            // 有效开始日期
                
                postNo_Arr[0] = sqlRes.getString("postNo").trim();                          // 岗位编号
                
                availableFromDate_Arr[0] = sqlRes.getString("availableFromDate").trim();    // 开始日期
                
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        db.closeDB(sqlRes);
        if(juge == true)
            response.sendRedirect("GradePost/gradePost_viewSingle.jsp");
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"不存在该岗位！\");");
            out.println("document.location.href=\"GradePost/gradePost_query.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
