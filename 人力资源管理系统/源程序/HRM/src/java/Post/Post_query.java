package Post;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Post_query extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    // ArrayList储存Post的信息
    public static String [] postNo_Arr = new String[1];
    public static String [] availableFromDate_Arr = new String[1];
    public static String [] availableToDate_Arr = new String[1];
    public static String [] postDescription_Arr = new String[1];
    public static String [] salariedHourly_Arr = new String[1];
    public static String [] fullPartTime_Arr = new String[1];
    public static String [] temporaryPermanent_Arr = new String[1];
    public static String [] freeLabor_Arr = new String[1];
    public static String [] departmentNo_Arr = new String[1];

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String postNo = request.getParameter("postNo");
        String availableFromDate,availableToDate,postDescription,salariedHourly;
        String fullPartTime,temporaryPermanent,freeLabor,departmentNo;

        //  查询等级信息
        ResultSet sqlRes;     // 结果集对象
        DBean db = new DBean();
        boolean juge = false;
        String sql_postNo = "SELECT * FROM Post WHERE postNo='" + postNo +"'";
        sqlRes = db.Query(sql_postNo);
        try {
            while (sqlRes.next()) {
                juge = true;
                postNo_Arr[0] = sqlRes.getString("postNo").trim();                          // 岗位编号
                
                availableFromDate_Arr[0] = sqlRes.getString("availableFromDate").trim();    // 开始日期
                
                if(sqlRes.getString("availableToDate") != null)                             // 结束日期
                    availableToDate = sqlRes.getString("availableToDate").trim();
                else    availableToDate = "";
                availableToDate_Arr[0] = availableToDate;
                
                if(sqlRes.getString("postDescription") != null)                             // 岗位描述
                    postDescription = sqlRes.getString("postDescription").trim();
                else    postDescription = "";
                postDescription_Arr[0] = postDescription;
                
                if(sqlRes.getString("salariedHourly") != null)                              // 时薪
                    salariedHourly = sqlRes.getString("salariedHourly").trim();
                else    salariedHourly = "";
                salariedHourly_Arr[0] = salariedHourly;
                
                if(sqlRes.getString("fullPartTime") != null)                                // 全职或者兼职
                    fullPartTime = sqlRes.getString("fullPartTime").trim();
                else    fullPartTime = "";
                fullPartTime_Arr[0] = fullPartTime;
                
                if(sqlRes.getString("temporaryPermanent") != null)                         // 实习生或者正式员工
                    temporaryPermanent = sqlRes.getString("temporaryPermanent").trim();
                else    temporaryPermanent = "";
                temporaryPermanent_Arr[0] = temporaryPermanent;
                
                if(sqlRes.getString("freeLaborStandardsActExempt") != null)               // 五金一险
                    freeLabor = sqlRes.getString("freeLaborStandardsActExempt").trim();
                else    freeLabor = "";
                freeLabor_Arr[0] = freeLabor;
                
                departmentNo_Arr[0] = sqlRes.getString("departmentNo").trim();              // 部门编号
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        db.closeDB(sqlRes);
        if(juge == true){
            response.sendRedirect("Post/post_viewSingle.jsp");
        }
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"不存在该岗位！\");");
            out.println("document.location.href=\"Post/post_query.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
