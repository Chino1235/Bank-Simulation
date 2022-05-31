package banksimulate;

import javax.swing.*;
import java.sql.*;

public class SqlOptions {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/bank";
    public static final String DBURL1 = "jdbc:mysql://localhost:3306/bank_log";
    public static final String DBUSER = "root";
    public static final String DBPASS = "root";

    public static void executeSql(String sql) throws ClassNotFoundException,SQLException{
        //try {
            Connection conn = null;
            Statement stat = null;
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
            stat =conn.createStatement();
            stat.executeUpdate(sql);
            stat.close();
            conn.close();
        /*} catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"系统错误","错误",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQL错误","错误",JOptionPane.ERROR_MESSAGE);
        }*/
    }

    public static double queryProfile(String account) throws ClassNotFoundException,SQLException{
        //try {
        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;
        String sql = "SELECT bank.client.profile from client where account='"+account+"';";
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stat =conn.createStatement();
        resultSet = stat.executeQuery(sql);
        resultSet.next();
        double profile = resultSet.getDouble("profile");
        stat.close();
        conn.close();
        return profile;
        /*} catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"系统错误","错误",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQL错误","错误",JOptionPane.ERROR_MESSAGE);
        }*/
    }

    public static String queryPassword(String account) throws ClassNotFoundException,SQLException{
        //try {
        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;
        String sql = "SELECT bank.client.password from client where account='"+account+"';";
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stat =conn.createStatement();
        resultSet = stat.executeQuery(sql);
        resultSet.next();
        String password = resultSet.getString("password");
        stat.close();
        conn.close();
        return password;
        /*} catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"系统错误","错误",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQL错误","错误",JOptionPane.ERROR_MESSAGE);
        }*/
    }

    public static String queryName(String account) throws ClassNotFoundException,SQLException{
        //try {
        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;
        String sql = "SELECT bank.client.name from client where account='"+account+"';";
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stat =conn.createStatement();
        resultSet = stat.executeQuery(sql);
        resultSet.next();
        String name = resultSet.getString("password");
        stat.close();
        conn.close();
        return name;
        /*} catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"系统错误","错误",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQL错误","错误",JOptionPane.ERROR_MESSAGE);
        }*/
    }

    public static boolean accountExist(String account) throws ClassNotFoundException,SQLException{
        //try {
        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;
        String sql = "SELECT bank.client.account from client where account='"+account+"';";
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stat =conn.createStatement();
        resultSet = stat.executeQuery(sql);
        stat.close();
        conn.close();
        return resultSet.next();

        /*} catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"系统错误","错误",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQL错误","错误",JOptionPane.ERROR_MESSAGE);
        }*/
    }

    public static ResultSet queryClientLog(String account) throws ClassNotFoundException,SQLException{
        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;
        String sql = "SELECT * from bank_log.banklog where account='"+account+"';";
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stat =conn.createStatement();
        resultSet = stat.executeQuery(sql);
        stat.close();
        conn.close();
        return resultSet;
    }

    public static ResultSet queryAllLog() throws ClassNotFoundException,SQLException {
        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;
        String sql = "SELECT * from bank_log.banklog;";
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stat =conn.createStatement();
        resultSet = stat.executeQuery(sql);
        stat.close();
        conn.close();
        return resultSet;
    }

    public static ResultSet queryFinancialProd(String column,String value) throws ClassNotFoundException,SQLException {
        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;
        String sql = "SELECT * from bank.financial_products where "+column+"='"+value+"';";
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stat =conn.createStatement();
        resultSet = stat.executeQuery(sql);
        stat.close();
        conn.close();
        return resultSet;
    }

}
