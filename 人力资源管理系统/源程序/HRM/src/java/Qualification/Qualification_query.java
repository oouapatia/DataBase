package Qualification;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Qualification_query extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    // ArrayList储存Qualification的信息
    public static String [] qualificationName_Arr = new String[1];
    public static String [] employeeNo_Arr = new String[1];
    public static String [] gradeObtained_Arr = new String[1];
    public static String [] startQualDate_Arr = new String[1];
    public static String [] endQualDate_Arr = new String[1];
    public static String [] gpa_Arr = new String[1];
    public static String [] insititutionNo_Arr = new String[1];

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String employeeNo = request.getParameter("employeeNo");
        String qualificationName,gradeObtained,startQualDate,endQualDate,gpa,insititutionNo;

        //  查询学历信息
        ResultSet sqlRes;     // 结果集对象
        DBean db = new DBean();
        boolean juge = false;
        String sql_employeeNo = "SELECT * FROM Qualification WHERE employeeNo='" + employeeNo +"'";
        sqlRes = db.Query(sql_employeeNo);
        try {
            while (sqlRes.next()) {
                juge = true;
                qualificationName_Arr[0] = sqlRes.getString("qualificationName").trim();    // 学历名称
                
                employeeNo_Arr[0] = sqlRes.getString("employeeNo").trim();                  // 员工编号
                
                if(sqlRes.getString("gradeObtained") != null)                               // 获得的等级
                    gradeObtained = sqlRes.getString("gradeObtained").trim();
                else    gradeObtained = "";
                gradeObtained_Arr[0] = gradeObtained;
                
                if(sqlRes.getString("startQualDate") != null)                               // 合格开始时间
                    startQualDate = sqlRes.getString("startQualDate").trim();
                else    startQualDate = "";
                startQualDate_Arr[0] = startQualDate;
                
                if(sqlRes.getString("endQualDate") != null)                                 // 合格结束时间
                    endQualDate = sqlRes.getString("endQualDate").trim();
                else    endQualDate = "";
                endQualDate_Arr[0] = endQualDate;
                
                if(sqlRes.getString("gpa") != null)                                         // 绩点
                    gpa = sqlRes.getString("gpa").trim();
                else    gpa = "";
                gpa_Arr[0] = gpa;
                
                insititutionNo_Arr[0] = sqlRes.getString("institutionNo").trim();          // 机构编号
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        db.closeDB(sqlRes);
        if(juge == true)
            response.sendRedirect("Qualification/qualification_viewSingle.jsp");
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"不存在该员工编号的学历信息！\");");
            out.println("document.location.href=\"Qualification/qualification_query.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
