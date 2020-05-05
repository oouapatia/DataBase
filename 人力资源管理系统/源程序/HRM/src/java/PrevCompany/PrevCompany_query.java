package PrevCompany;

import com.DBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrevCompany_query extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    // ArrayList储存PrevCompany的信息
    public static String [] prevCompanyNo_Arr = new String[1];
    public static String [] pCompanyName_Arr = new String[1];
    public static String [] pCompanyStreet_Arr = new String[1];
    public static String [] pCompanyCity_Arr = new String[1];
    public static String [] pCompanyState_Arr = new String[1];
    public static String [] pCompanyZipCode_Arr = new String[1];
    public static String [] pCompanyTelNo_Arr = new String[1];
    public static String [] pCompanyFaxNo_Arr = new String[1];
    public static String [] pCompanyWebAddress_Arr = new String[1];
    public static String [] contactName_Arr = new String[1];
    public static String [] contactTelNo_Arr = new String[1];
    public static String [] contactFaxNo_Arr = new String[1];
    public static String [] contactEmailAddress_Arr = new String[1];

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        
        String prevCompanyNo = request.getParameter("prevCompanyNo");
        String pCompanyName,pCompanyStreet,pCompanyCity,pCompanyState,pCompanyZipCode,pCompanyTelNo;
        String pCompanyFaxNo,pCompanyWebAddress,contactName,contactTelNo,contactFaxNo,contactEmailAddress;

        //  查询公司信息
        ResultSet sqlRes;     // 结果集对象
        DBean db = new DBean();
        boolean juge = false;   // 初值为false，即不存在
        String sql_user = "SELECT * FROM PrevCompany WHERE prevCompanyNo='" + prevCompanyNo + "'";
        sqlRes = db.Query(sql_user);
        try {
            if (sqlRes.next()) {
                juge = true;

                prevCompanyNo_Arr[0] = sqlRes.getString("prevCompanyNo").trim();        // 前公司编号
                                        
                pCompanyName_Arr[0] = sqlRes.getString("pCompanyName").trim();        // 前公司名称

                if(sqlRes.getString("pCompanyStreet") != null)                             // 前公司所在街道
                    pCompanyStreet = sqlRes.getString("pCompanyStreet").trim();
                else    pCompanyStreet = "";
                pCompanyStreet_Arr[0] = pCompanyStreet;

                if(sqlRes.getString("pCompanyCity") != null)                               // 前公司所在城市
                    pCompanyCity = sqlRes.getString("pCompanyCity").trim();
                else    pCompanyCity = "";
                pCompanyCity_Arr[0] = pCompanyCity;

                if(sqlRes.getString("pCompanyState") != null)                               // 前公司所在国家
                    pCompanyState = sqlRes.getString("pCompanyState").trim();
                else    pCompanyState = "";
                pCompanyState_Arr[0] = pCompanyState;

                if(sqlRes.getString("pCompanyZipCode") != null)                          // 前公司邮政编码
                    pCompanyZipCode = sqlRes.getString("pCompanyZipCode").trim();
                else    pCompanyZipCode = "";
                pCompanyZipCode_Arr[0] = pCompanyZipCode;

                if(sqlRes.getString("pCompanyTelNo") != null)                             // 前公司电话号码（座机）
                    pCompanyTelNo = sqlRes.getString("pCompanyTelNo").trim();
                else    pCompanyTelNo = "";
                pCompanyTelNo_Arr[0] = pCompanyTelNo;

                if(sqlRes.getString("pCompanyFaxNo") != null)                            // 前公司传真号码
                    pCompanyFaxNo = sqlRes.getString("pCompanyFaxNo").trim();
                else    pCompanyFaxNo = "";
                pCompanyFaxNo_Arr [0] = pCompanyFaxNo;

                if(sqlRes.getString("pCompanyWebAddress") != null)                            // 前公司网址
                    pCompanyWebAddress = sqlRes.getString("pCompanyWebAddress").trim();
                else    pCompanyWebAddress = "";
                pCompanyWebAddress_Arr[0] = pCompanyWebAddress;

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
        
        db.closeDB(sqlRes);
        if(juge == true){    
            response.sendRedirect("PrevCompany/prevCompany_viewSingle.jsp");
        }
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"该机构编号不存在！\");");
            out.println("document.location.href=\"PrevCompany/prevCompany_query.jsp\";");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
