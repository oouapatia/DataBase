package com;

import java.io.PrintWriter;
import java.sql.*;

public class DBean {
    PrintWriter out;
    static Connection conn = null;
    static Statement sqlState = null;   // 语句对象
    static ResultSet sqlRes = null;     // 结果集对象
    
    public Connection getconn() {
        try {
            String dbURL = "jdbc:sqlserver://127.0.0.1; DatabaseName = HRM";
            String dataBaseName = "sa"; // 数据库用户名
            String dataBasePwd = "123"; // 数据库密码
            conn = DriverManager.getConnection(dbURL, dataBaseName, dataBasePwd);
        } catch (Exception e) {
            out.println(e.toString());
        }
        return conn;
    }
    
    //SELSECT
    public ResultSet Query(String sql) {
	try {
            DBean db = new DBean();
            conn = db.getconn();
            sqlState = conn.createStatement();  // 创建sqlState对象
            sqlRes = sqlState.executeQuery(sql);
        } catch (SQLException e) {
            out.println(e.toString());
        } 
        return sqlRes;
    }
    
    //INSERT、UPDATE、DELETE
    public int Update(String sql) {
	int result = 0;
	try {
            DBean db = new DBean();
            conn = db.getconn();
            sqlState = conn.createStatement();  // 创建sqlState对象
            result = sqlState.executeUpdate(sql);
        } catch (SQLException e) {
            out.println(e.toString());
	}
	return result;
    }
    
    public void closeDB(ResultSet sqlRes) {
        if (sqlRes != null) {
            try {
                if (sqlRes != null) {
                    sqlRes.close(); // 关闭结果集对象连接
                }
                if (sqlState != null) {
                    sqlState.close();   // 关闭sqlState对象连接
                }
                if (conn != null) {
                    conn.close();   // 关闭数据库连接
                }
            } catch (SQLException e) {
                out.println(e.toString());
            }
        }
    }
}

