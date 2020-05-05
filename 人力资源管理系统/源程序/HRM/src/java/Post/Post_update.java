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

public class Post_update extends HttpServlet {

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
        
        boolean juge_postNo = false;            // 判断岗位编号是否存在，初值为不在
        boolean juge_departmentNo = false;      // 判断部门编号是否存在，初值为不在
        
        DBean db = new DBean();
        // 查询岗位编号编号是否存在
        ResultSet sqlRes_postNo;        // 结果集对象
        String select_postNo = "SELECT postNo FROM Post WHERE postNo='" + postNo + "'";
        sqlRes_postNo = db.Query(select_postNo);
        
        // 查询职位类型编号编号是否存在
        ResultSet sqlRes_departmentNo;
        String select_departmentNo = "SELECT departmentNo FROM Department WHERE departmentNo='" + departmentNo + "'";
        sqlRes_departmentNo = db.Query(select_departmentNo);
        
        try {
            if (sqlRes_postNo.next()) {    juge_postNo = true;  }
            if (sqlRes_departmentNo.next() || "".equals(departmentNo)) {    juge_departmentNo = true; }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }

        if (juge_postNo && juge_departmentNo) {
            // 更新语句
            String update_availableFromDate = "UPDATE Post SET availableFromDate='" + availableFromDate + "' WHERE postNo='" + postNo +"'";
            String update_availableToDate = "UPDATE Post SET availableToDate='" + availableToDate + "' WHERE postNo='" + postNo +"'";
            String update_postDescription = "UPDATE Post SET postDescription='" + postDescription + "' WHERE postNo='" + postNo +"'";
            String update_salariedHourly = "UPDATE Post SET salariedHourly='" + salariedHourly + "' WHERE postNo='" + postNo +"'";
            String update_fullPartTime = "UPDATE Post SET fullPartTime='" + fullPartTime + "' WHERE postNo='" + postNo +"'";
            String update_temporaryPermanent = "UPDATE Post SET temporaryPermanent='" + temporaryPermanent + "' WHERE postNo='" + postNo +"'";
            String update_freeLabor = "UPDATE Post SET freeLaborStandardsActExempt='" + freeLabor + "' WHERE postNo='" + postNo +"'";
            String update_departmentNo = "UPDATE Post SET departmentNo='" + departmentNo + "' WHERE postNo='" + postNo +"'";

            int[] result = new int[]{1, 1, 1, 1, 1, 1,1,1}; // 标记是否更新成功
            // 判断是否为空，然后判断是否更新
            if (!availableFromDate.equals(""))      result[0] = db.Update(update_availableFromDate);
            if (!availableToDate.equals(""))        result[1] = db.Update(update_availableToDate);
            if (!postDescription.equals(""))     result[2] = db.Update(update_postDescription);
            if (!salariedHourly.equals(""))        result[3] = db.Update(update_salariedHourly);
            if (!fullPartTime.equals(""))        result[4] = db.Update(update_fullPartTime);
            if (!temporaryPermanent.equals(""))     result[5] = db.Update(update_temporaryPermanent);
            if (!freeLabor.equals(""))        result[4] = db.Update(update_freeLabor);
            if (!departmentNo.equals(""))     result[5] = db.Update(update_departmentNo);
            
            db.closeDB(sqlRes_postNo);
            db.closeDB(sqlRes_departmentNo);
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
                out.println("document.location.href=\"Post/post_update.jsp\";");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"修改失败！\");");
                out.println("document.location.href=\"Post/post_update.jsp\";");
                out.println("</script>");
            }
        }
        
        db.closeDB(sqlRes_postNo);
        db.closeDB(sqlRes_departmentNo);
        if(!juge_postNo){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该岗位不存在！\");");
            out.println("document.location.href=\"Post/post_update.jsp\";");
            out.println("</script>");
        }
        if(!juge_departmentNo){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"请输入正确的部门编号！\");");
            out.println("document.location.href=\"Post/post_update.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
