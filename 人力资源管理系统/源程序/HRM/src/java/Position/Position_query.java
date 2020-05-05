package Position;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Position_query extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    // ArrayList储存Position的信息
    public static String [] employeeNo_Arr = new String[1];
    public static String [] postNo_Arr = new String[1];
    public static String [] startDate_Arr = new String[1];
    public static String [] endDate_Arr = new String[1];

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
                
        String employeeNo = request.getParameter("employeeNo");
        String postNo,startDate,endDate;
        if (employeeNo.equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入员工编号！\");");
            out.println("document.location.href=\"Position/position_query.jsp\";");
            out.println("</script>");
        }

        //  查询员工职位信息
        ResultSet sqlRes;     // 结果集对象
        DBean db = new DBean();
        boolean juge = false;
        String sql_user = "SELECT * FROM Position WHERE employeeNo='" + employeeNo +"'";
        sqlRes = db.Query(sql_user);
        try {
            while (sqlRes.next()) {
                juge = true;
                employeeNo_Arr[0] = sqlRes.getString("employeeNo").trim();      // 员工编号
                
                postNo_Arr[0] = sqlRes.getString("postNo").trim();              // 职位编号
                
                startDate_Arr[0] = sqlRes.getString("startDate").trim();        // 入职时间
                
                if(sqlRes.getString("endDate") != null)                         // 离职时间
                    endDate = sqlRes.getString("endDate").trim();
                else    endDate = "";
                endDate_Arr[0] = endDate;
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        db.closeDB(sqlRes);
        if(juge == true)
            response.sendRedirect("Position/position_viewSingle.jsp");
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"不存在该员工的职位信息！\");");
            out.println("document.location.href=\"Position/position_query.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
