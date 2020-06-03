package WorkHistory;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkHistory_query extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
                
        String employeeNo = request.getParameter("employeeNo");

        if (employeeNo.equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入员工编号！\");");
            out.println("document.location.href=\"WorkHistory/workHistory_query.jsp\";");
            out.println("</script>");
        }

        //  查询员工信息
        ResultSet sqlRes;     // 结果集对象
        DBean db = new DBean();
        boolean juge = false;
        String prevCompanyNo,prevPosition,prevGrade,prevSalary,prevLocation,prevResponsibilities;
        String sql_user = "SELECT * FROM WorkHistory WHERE employeeNo='" + employeeNo + "'";
        sqlRes = db.Query(sql_user);
        try {
            if (sqlRes.next()) {
                juge = true;
                prevCompanyNo = sqlRes.getString("prevCompanyNo").trim();                 // 前公司编号
                request.getServletContext().setAttribute("prevCompanyNo",prevCompanyNo);
                
                request.getServletContext().setAttribute("employeeNo",employeeNo);
                
                if (sqlRes.getString("prevPosition") != null)                             // 前任公司职位
                    prevPosition = sqlRes.getString("prevPosition").trim();
                else prevPosition = "";
                request.getServletContext().setAttribute("prevPosition",prevPosition);    
                
                if (sqlRes.getString("prevGrade") != null)                                // 前任公司岗位等级
                    prevGrade = sqlRes.getString("prevGrade").trim();
                else prevGrade = "";
                request.getServletContext().setAttribute("prevGrade",prevGrade);
                
                if (sqlRes.getString("prevSalary") != null)                               // 前任公司薪水
                    prevSalary = sqlRes.getString("prevSalary").trim();
                else prevSalary = "";
                request.getServletContext().setAttribute("prevSalary",prevSalary);
                
                if (sqlRes.getString("prevLocation") != null)                             // 前任公司位置
                    prevLocation = sqlRes.getString("prevLocation").trim();
                else prevLocation = "";
                request.getServletContext().setAttribute("prevLocation",prevLocation);  
                
                if (sqlRes.getString("prevResponsibilities") != null)                    // 在前任公司负责内容
                    prevResponsibilities = sqlRes.getString("prevResponsibilities").trim();
                else prevResponsibilities = "";
                request.getServletContext().setAttribute("prevResponsibilities",prevResponsibilities);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkHistory_query.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(juge == true){
            db.closeDB(sqlRes);
            response.sendRedirect("WorkHistory/workHistory_viewSingle.jsp");
        }
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"不存在该员工的工作历史信息！\");");
            out.println("document.location.href=\"WorkHistory/workHistory_query.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
