package PositionType;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PositionType_query extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    // ArrayList储存Position的信息
    public static String [] positionTypeNo_Arr = new String[1];
    public static String [] description_Arr = new String[1];

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
                
        String positionTypeNo = request.getParameter("positionTypeNo");
        String positionTypeDescription;

        //  查询员工职位信息
        ResultSet sqlRes;     // 结果集对象
        DBean db = new DBean();
        boolean juge = false;
        String sql_user = "SELECT * FROM PositionType WHERE positionTypeNo='" + positionTypeNo +"'";
        sqlRes = db.Query(sql_user);
        try {
            if (sqlRes.next()) {
                juge = true;
                positionTypeNo_Arr[0] = sqlRes.getString("positionTypeNo").trim();  // 职位类型编号
                
                if(sqlRes.getString("positionTypeDescription") != null)             // 职位类型描述
                    positionTypeDescription = sqlRes.getString("positionTypeDescription").trim();
                else    positionTypeDescription = "";
                description_Arr[0] = positionTypeDescription;
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        db.closeDB(sqlRes);
        if(juge == true)
            response.sendRedirect("PositionType/positionType_viewSingle.jsp");
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"不存在该职位类型信息！\");");
            out.println("document.location.href=\"PositionType/positionType_query.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
