package Grade;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Grade_query extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    // ArrayList储存Grade的信息
    public static String [] gradeNo_Arr = new String[1];
    public static String [] validFromDate_Arr = new String[1];
    public static String [] validToDate_Arr = new String[1];
    public static String [] gradeDescrible_Arr = new String[1];
    public static String [] gradesalary_Arr = new String[1];
    public static String [] noDaysLeaveEntitlement_Arr = new String[1];
    public static String [] positionTypeNo_Arr = new String[1];

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String positionTypeNo = request.getParameter("positionTypeNo");
        String gradeNo,validFromDate,validToDate,gradeDescrible,gradesalary,noDaysLeaveEntitlement;

        //  查询等级信息
        DBean db = new DBean();
        boolean juge = false;   // 用来判断是否存在改职位的等级信息
        String sql_gradeNo = "SELECT * FROM Grade WHERE positionTypeNo='" + positionTypeNo +"'";
        ResultSet sqlRes = db.Query(sql_gradeNo);
        try {
            if (sqlRes.next()) {
                juge = true;
                gradeNo_Arr[0] = sqlRes.getString("gradeNo").trim();                // 等级编号
                
                validFromDate_Arr[0] = sqlRes.getString("validFromDate").trim();    // 有效开始日期
                
                if(sqlRes.getString("validToDate") != null)                         // 有效截止日期
                    validToDate = sqlRes.getString("validToDate").trim();
                else    validToDate = "";
                validToDate_Arr[0] = validToDate;
                
                if(sqlRes.getString("gradeDescrible") != null)                      // 等级描述
                    gradeDescrible = sqlRes.getString("gradeDescrible").trim();
                else    gradeDescrible = "";
                gradeDescrible_Arr[0] = gradeDescrible;
                
                if(sqlRes.getString("gradesalary") != null)                         // 等级薪水
                    gradesalary = sqlRes.getString("gradesalary").trim();
                else    gradesalary = "";
                gradesalary_Arr[0] = gradesalary;
                
                if(sqlRes.getString("noDaysLeaveEntitlement") != null)              // 休假时间天数
                    noDaysLeaveEntitlement = sqlRes.getString("noDaysLeaveEntitlement").trim();
                else    noDaysLeaveEntitlement = "";
                noDaysLeaveEntitlement_Arr[0] = noDaysLeaveEntitlement;
                
                positionTypeNo_Arr[0] = sqlRes.getString("positionTypeNo").trim();    // 职位类型编号
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        db.closeDB(sqlRes);
        if(juge == true)
            response.sendRedirect("Grade/grade_viewSingle.jsp");
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"不存在该职位的等级信息！\");");
            out.println("document.location.href=\"Grade/grade_query.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
