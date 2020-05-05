
package Post;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Post_delete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();        
        String postNo = request.getParameter("postNo");

        // 判断岗位编号是否存在
        DBean db = new DBean();
        boolean juge = false;            // 判断岗位编号是否在Post表中，初值为不在
        ResultSet sqlRes = null;        // 结果集对象
        String select_post = "SELECT postNo FROM Post WHERE postNo='" + postNo + "'";
        sqlRes = db.Query(select_post);
        try {
            while (sqlRes.next()) {
                juge = true;
                break;
            }
        } catch (SQLException ex) {
           out.println(ex.toString());
        }
        if (juge) {
            String del_post = "DELETE Post WHERE postNo='" + postNo + "'";
            int result = db.Update(del_post);
            db.closeDB(sqlRes);
            if (result != 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除成功！\");");
                out.println("document.location.href=\"Post/post_delete.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"删除失败！\");");
                out.println("document.location.href=\"Post/post_delete.jsp\";");
                out.println("</script>");
            }
        } else {
            db.closeDB(sqlRes);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的岗位编号！\");");
            out.println("document.location.href=\"Post/post_delete.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
