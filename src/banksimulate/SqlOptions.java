package banksimulate;

import javax.swing.*;
import java.sql.*;

public class SqlOptions {
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/resources";
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

}
