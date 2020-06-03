package Institution;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Institution_query extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    // ArrayList储存Institution的信息
    public static String [] institutionNo_Arr = new String[1];
    public static String [] institutionName_Arr = new String[1];
    public static String [] instAddress_Arr = new String[1];
    public static String [] instTelNo_Arr = new String[1];
    public static String [] instFaxNo_Arr = new String[1];
    public static String [] instWbeAddress_Arr = new String[1];
    public static String [] contactName_Arr = new String[1];
    public static String [] contactTelNo_Arr = new String[1];
    public static String [] contactFaxNo_Arr = new String[1];
    public static String [] contactEmailAddress_Arr = new String[1];

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        
        String institutionNo = request.getParameter("institutionNo");
        String institutionName,instAddress,instTelNo,instFaxNo,instWbeAddress;
        String contactName,contactTelNo,contactFaxNo,contactEmailAddress;

        //  查询机构信息
        ResultSet sqlRes;     // 结果集对象
        DBean db = new DBean();
        boolean juge = false;
        String sql_user = "SELECT * FROM Institution WHERE institutionNo='" + institutionNo + "'";
        out.println(sql_user);
        sqlRes = db.Query(sql_user);
        try {
            if (sqlRes.next()) {
                juge = true;
                institutionNo_Arr[0] = sqlRes.getString("institutionNo").trim();        // 机构编号
                
                if(sqlRes.getString("institutionName") != null)                         // 机构名称
                    institutionName = sqlRes.getString("institutionName").trim();
                else    institutionName = "";
                institutionName_Arr[0] = institutionName;

                if(sqlRes.getString("instAddress") != null)                             // 机构地址
                    instAddress = sqlRes.getString("instAddress").trim();
                else    instAddress = "";
                instAddress_Arr[0] = instAddress;

                if(sqlRes.getString("instTelNo") != null)                               // 机构电话
                    instTelNo = sqlRes.getString("instTelNo").trim();
                else    instTelNo = "";
                instTelNo_Arr[0] = instTelNo;

                if(sqlRes.getString("instFaxNo") != null)                               // 机构传真号码
                    instFaxNo = sqlRes.getString("instFaxNo").trim();
                else    instFaxNo = "";
                instFaxNo_Arr[0] = instFaxNo;

                if(sqlRes.getString("instWbeAddress") != null)                          // 机构网址
                    instWbeAddress = sqlRes.getString("instWbeAddress").trim();
                else    instWbeAddress = "";
                instWbeAddress_Arr[0] = instWbeAddress;

                if(sqlRes.getString("contactName") != null)                             // 联系人姓名
                    contactName = sqlRes.getString("contactName").trim();
                else    contactName = "";
                contactName_Arr[0] = contactName;

                if(sqlRes.getString("contactTelNo") != null)                            // 联系人电话
                    contactTelNo = sqlRes.getString("contactTelNo").trim();
                else    contactTelNo = "";
                contactTelNo_Arr [0] = contactTelNo;

                if(sqlRes.getString("contactFaxNo") != null)                            // 联系人传真号码
                    contactFaxNo = sqlRes.getString("contactFaxNo").trim();
                else    contactFaxNo = "";
                contactFaxNo_Arr[0] = contactFaxNo;

                if(sqlRes.getString("contactEmailAddress") != null)                     // 联系人电子邮件地址
                    contactEmailAddress = sqlRes.getString("contactEmailAddress").trim();
                else    contactEmailAddress = "";
                contactEmailAddress_Arr[0] = contactEmailAddress;
            }
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
        if(juge == true){
            db.closeDB(sqlRes);
            response.sendRedirect("Institution/institution_viewSingle.jsp");
        }
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该机构编号不存在！\");");
            out.println("document.location.href=\"Institution/institution_query.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
