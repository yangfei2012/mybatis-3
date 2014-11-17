package org.apache.ibatis.demo;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        testJDBCQuery();
    }

    public static void testJDBCQuery() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "1");

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from testdb.user");

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("age"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch(SQLException se) {
                    se.printStackTrace();
                }
                rs = null;
            }
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch(SQLException se) {
                    se.printStackTrace();
                }
                stmt=null;
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch(SQLException se) {
                    se.printStackTrace();
                }
                conn=null;
            }
        }
    }

    public static void testJDBCTransaction() {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "1");

            conn.setAutoCommit(false);

            stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            String SQL = "INSERT INTO Employees VALUES (106, 20, 'Rita', 'Tez')";
            stmt.executeUpdate(SQL);

            SQL = "INSERT INTO Employees VALUES (107, 22, 'Sita', 'Singh')";
            stmt.executeUpdate(SQL);

            conn.commit();

        }catch(SQLException se){
            // ...

            try {
                if(conn!=null)
                    conn.rollback();
            } catch(SQLException se2){
                se2.printStackTrace();
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException se2) { }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }
}
