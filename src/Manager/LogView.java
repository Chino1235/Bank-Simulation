package Manager;

import banksimulate.SqlOptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogView {

    public static void LogView(String[] args) {

        SqlOptions dbdriver = new SqlOptions();

        try {
            //要执行的SQL语句
            String sql = "select * from bank_log.banklog";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = dbdriver.queryAllLog();
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println("账户" + "\t" + "配置" + "\t" + "财务" + "\t");
            System.out.println("-----------------");

            String account = null;
            String profile = null;
            String option = null;

            while (rs.next()) {
                //获取account这列数据
                account = rs.getString("account");
                //获取profile这列数据
                profile = rs.getString("profile");
                //获取option这列数据
                option = rs.getString("profile");
                //输出结果
                System.out.println(profile + "\t" + account + "\t" + option + "\t");
            }
            rs.close();
        } catch (ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }
    }

}