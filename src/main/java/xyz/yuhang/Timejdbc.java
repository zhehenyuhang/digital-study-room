package xyz.yuhang;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Timejdbc {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        try {
            Properties properties = new Properties();
            ClassLoader classLoader = Timejdbc.class.getClassLoader();
            // System.out.println(ClassLoader.getSystemResource(""));
            InputStream resourceAsStream = classLoader.getResourceAsStream("Time.properties");
            properties.load(resourceAsStream);
            url = properties.getProperty("url");
            url = new String(url.getBytes("UTF-8"));
//            System.out.println(url);
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

            Class.forName(driver);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            return DriverManager.getConnection(url,user,password);
        }

    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt,Connection conn){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    void hdddah(){}
}
