
package Post;

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

public class Post_insert extends HttpServlet {

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
        String postNo = request.getParameter("postNo");
        String availableFromDate = request.getParameter("availableFromDate");
        String availableToDate = request.getParameter("availableToDate");
        String postDescription = request.getParameter("postDescription");
        String salariedHourly = request.getParameter("salariedHourly");
        String fullPartTime = request.getParameter("fullPartTime");
        String temporaryPermanent = request.getParameter("temporaryPermanent");
        String freeLabor = request.getParameter("freeLaborStandardsActExempt");
        String departmentNo = request.getParameter("departmentNo");

        boolean juge_postNo = false;         // 判断岗位编号是否存在，初值为不存在
        boolean juge_departmentNo = false;  // 判断部门编号是否存在，初值为不存在
        
        DBean db = new DBean();
        
        // 判断岗位编号是否存在
        ResultSet sqlRes_postNo;        // 结果集对象
        String select_postNo = "SELECT postNo FROM Post WHERE postNo ='" + postNo +"'";
        sqlRes_postNo = db.Query(select_postNo);
        
        // 判断部门编号是否存在
        ResultSet sqlRes_departmentNo;
        String select_departmentNo = "SELECT departmentNo FROM Department WHERE departmentNo ='" + departmentNo +"'";
        sqlRes_departmentNo = db.Query(select_departmentNo);
        
        
        try {
            if (sqlRes_postNo.next()) { juge_postNo = true;   }
            if (sqlRes_departmentNo.next()) { juge_departmentNo = true;   }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        // 格式化数据
        Format format = new Format();
        postNo = format.FormatSql(postNo);
        availableFromDate = format.FormatSql(availableFromDate);
        availableToDate = format.FormatSql(availableToDate);
        postDescription = format.FormatSql(postDescription);
        salariedHourly = format.FormatSql(salariedHourly);
        fullPartTime = format.FormatSql(fullPartTime);
        temporaryPermanent = format.FormatSql(temporaryPermanent);
        freeLabor = format.FormatSql(freeLabor);
        departmentNo = format.FormatSql(departmentNo);

        if (juge_postNo == false && juge_departmentNo == true ) {
            // 更新语句
            String insert_sql = "INSERT INTO Post"
                    + " VALUES(" + postNo + "," + availableFromDate + "," + availableToDate + "," 
                    + postDescription + "," + salariedHourly + "," + fullPartTime + "," 
                    + temporaryPermanent + "," + freeLabor + "," + departmentNo + ")";
            int result = db.Update(insert_sql);
            
            db.closeDB(sqlRes_postNo);
            db.closeDB(sqlRes_departmentNo);
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加成功！\");");
                out.println("document.location.href=\"Post/post_insert.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"添加失败！\");");
                out.println("document.location.href=\"Post/post_insert.jsp\";");
                out.println("</script>");
            }
        }
        
        db.closeDB(sqlRes_postNo);
        db.closeDB(sqlRes_departmentNo);
        
        if(juge_postNo == true) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该岗位已存在！\");");
            out.println("document.location.href=\"Post/post_insert.jsp\";");
            out.println("</script>");
        }
        if(juge_departmentNo == false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该部门编号不存在！\");");
            out.println("document.location.href=\"Post/post_insert.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
