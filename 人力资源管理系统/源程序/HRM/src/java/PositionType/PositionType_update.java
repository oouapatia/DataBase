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

public class PositionType_update extends HttpServlet {

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
        String positionTypeNo = request.getParameter("positionTypeNo");
        String positionTypeDescription = request.getParameter("positionTypeDescription");

        boolean juge_positionTypeNo = false;    // 判断职位类型编号是否已在职位类型表中，初值为不在
        
        DBean db = new DBean();
        // 查询职位类型编号是否在职位类型表中
        ResultSet sqlRes_positionTypeNo;
        String select_positionTypeNo = "SELECT positionTypeNo FROM PositionType WHERE positionTypeNo='"+ positionTypeNo +"'";
        sqlRes_positionTypeNo = db.Query(select_positionTypeNo);
        try {
            while (sqlRes_positionTypeNo.next()) {    
                juge_positionTypeNo = true; 
                break;  
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        
        if (juge_positionTypeNo) {
            // 更新语句
            String update_description = "UPDATE PositionType SET positionTypeDescription='" + positionTypeDescription + "' WHERE positionTypeNo='" + positionTypeNo+"'";
            int[] result = new int[]{1}; // 标记是否更新成功
            // 判断是否为空，然后判断是否更新
            if (!positionTypeNo.equals(""))         result[0] = db.Update(update_description);
            
            db.closeDB(sqlRes_positionTypeNo);
            boolean juge_update = true;
            for (int i : result) {
                if (i == 0) {
                    juge_update = false;
                    break;
                }
            }

            if (juge_update) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改成功！\");");
                out.println("document.location.href=\"PositionType/positionType_update.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改失败！\");");
                out.println("document.location.href=\"PositionType/positionType_update.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes_positionTypeNo);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的职位类型编号！\");");
            out.println("document.location.href=\"PositionType/positionType_update.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
