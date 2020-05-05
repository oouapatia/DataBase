
package Department;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Department_query extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    // ArrayList储存employee的信息
    public static String [] departmentNo_Arr = new String[1];
    public static String [] departmentName_Arr = new String[1];
    public static String [] deptLocation_Arr = new String[1];
    public static String [] managerEmployeeNo_Arr = new String[1];

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
                
        String departmentNo = request.getParameter("departmentNo");
        String departmentName,deptLocation,managerEmployeeNo;

        //  查询员工信息
        ResultSet sqlRes;     // 结果集对象
        DBean db = new DBean();
        boolean juge = false;
        String sql_depart = "SELECT * FROM Department WHERE departmentNo='" + departmentNo +"'";
        sqlRes = db.Query(sql_depart);
        try {
            while (sqlRes.next()) {
                juge = true;
                departmentNo_Arr[0] = sqlRes.getString("departmentNo").trim();      // 部门编号
                
                if(sqlRes.getString("departmentName") != null)                      // 部门名字
                    departmentName = sqlRes.getString("departmentName").trim();
                else    departmentName = "";
                departmentName_Arr[0] = departmentName;

                if(sqlRes.getString("deptLocation") != null)                        // 部门位置
                    deptLocation = sqlRes.getString("deptLocation").trim();
                else    deptLocation = "";
                deptLocation_Arr[0] = deptLocation;

                if(sqlRes.getString("managerEmployeeNo") != null)                  // 管理人员编号
                    managerEmployeeNo = sqlRes.getString("managerEmployeeNo").trim();
                else    managerEmployeeNo = "";
                managerEmployeeNo_Arr[0] = managerEmployeeNo;
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        db.closeDB(sqlRes);
        if(juge == true){
                response.sendRedirect("Department/department_viewSingle.jsp");
        }
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该部门编号不存在！\");");
            out.println("document.location.href=\"Department/department_query.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
