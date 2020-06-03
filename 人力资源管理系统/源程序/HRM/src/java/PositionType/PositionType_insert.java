
package PositionType;

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

/**
 *
 * @author pcw
 */
public class PositionType_insert extends HttpServlet {

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

        boolean juge_typeNo = false;    // 判断职位类型编号否已在职位类型表中，初值为在
        
        DBean db = new DBean();
        
        // 查询职位类型编号否是在职位类型表中
        ResultSet sqlRes_typeNo;
        String select_typeNo = "SELECT positionTypeNo FROM PositionType WHERE positionTypeNo='"+ positionTypeNo +"'";
        sqlRes_typeNo = db.Query(select_typeNo);
        try {
            if (sqlRes_typeNo.next()) {    juge_typeNo = true;  }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        // 格式化数据
        Format format = new Format();
        positionTypeNo = format.FormatSql(positionTypeNo);
        positionTypeDescription = format.FormatSql(positionTypeDescription);

        if (!juge_typeNo) {
            // 更新语句
            String insert_sql = "INSERT INTO PositionType"
                    + " VALUES(" + positionTypeNo + "," + positionTypeDescription +")";

            db.closeDB(sqlRes_typeNo);
            int result = db.Update(insert_sql);
            if (result != 0) {
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加成功！\");");
                out.println("document.location.href=\"PositionType/positionType_insert.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加失败！\");");
                out.println("document.location.href=\"PositionType/positionType_insert.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes_typeNo);
            if(juge_typeNo){ 
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"该职位类型编号已存在！\");");
                out.println("document.location.href=\"PositionType/positionType_insert.jsp\";");
                out.println("</script>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
