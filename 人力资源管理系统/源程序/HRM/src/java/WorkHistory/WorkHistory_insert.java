/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkHistory;

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

public class WorkHistory_insert extends HttpServlet {

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
        String prevCompanyNo = request.getParameter("prevCompanyNo");
        String employeeNo = request.getParameter("employeeNo");
        String prevPosition = request.getParameter("prevPosition");
        String prevGrade = request.getParameter("prevGrade");
        String prevSalary = request.getParameter("prevSalary");
        String prevLocation = request.getParameter("prevLocation");
        String prevResponsibilities = request.getParameter("prevResponsibilities");
        
        DBean db = new DBean();
        ResultSet sqlRes;        // 结果集对象

        // 前公司编号是否存在
        ResultSet super_sqlRes;
        boolean juge_prevComp = false;
        String select_prevCompanyNo = "SELECT prevCompanyNo FROM PrevCompany WHERE prevCompanyNo='"+prevCompanyNo+"'";
        super_sqlRes = db.Query(select_prevCompanyNo);
        try {
           while (super_sqlRes.next()) {
                juge_prevComp = true;   // 存在
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        if(juge_prevComp == false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"输入的公司编号不存在！\");");
            out.println("document.location.href=\"WorkHistory/workHistory_insert.jsp\";");
            out.println("</script>");
        }
        
        // 判断员工编号是否在Employee表中
        boolean juge_Emp = false;
        String select_EmpEmployeeNo = "SELECT employeeNo FROM Employee WHERE employeeNo='"+employeeNo+"'";
        sqlRes = db.Query(select_EmpEmployeeNo);
        try {
            while (sqlRes.next()) {
                juge_Emp = true;        // 存在
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        if(juge_Emp == false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"此员工不存在！\");");
            out.println("document.location.href=\"WorkHistory/workHistory_insert.jsp\";");
            out.println("</script>");
        }
        
        // 判断员工编号是否已在WorkHistory表中
        boolean juge_Work = false;
        String select_employeeNo = "SELECT employeeNo FROM WorkHistory WHERE employeeNo='"+employeeNo+"'";
        sqlRes = db.Query(select_employeeNo);
        try {
            while (sqlRes.next()) {
                juge_Work = true;   // 已有记录
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        if(juge_Work == true){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"此员工已有工作历史记录！\");");
            out.println("document.location.href=\"WorkHistory/workHistory_insert.jsp\";");
            out.println("</script>");
        }
       
        if (juge_prevComp == true && juge_Emp == true && juge_Work == false) {
            
            Format format = new Format();
            prevCompanyNo = format.FormatSql(prevCompanyNo);
            employeeNo = format.FormatSql(employeeNo);
            prevPosition = format.FormatSql(prevPosition);
            prevGrade = format.FormatSql(prevGrade);
            prevSalary = format.FormatSql(prevSalary);
            prevLocation = format.FormatSql(prevLocation);
            prevResponsibilities = format.FormatSql(prevResponsibilities);
            
            // 更新语句
            String insert_sql = "INSERT INTO WorkHistory VALUES(" + prevCompanyNo + "," + employeeNo 
                    + "," + prevPosition + "," + prevGrade + "," + prevSalary + "," + prevLocation + ","+ prevResponsibilities+ ")";
            int result = db.Update(insert_sql);
            if (result != 0) {
                db.closeDB(sqlRes);
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加成功！\");");
                out.println("document.location.href=\"WorkHistory/workHistory_insert.jsp\";");
                out.println("</script>");
            } else {
                db.closeDB(sqlRes);
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加失败！\");");
                out.println("document.location.href=\"WorkHistory/workHistory_insert.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该员工信息已存在！\");");
            out.println("document.location.href=\"WorkHistory/workHistory_insert.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
