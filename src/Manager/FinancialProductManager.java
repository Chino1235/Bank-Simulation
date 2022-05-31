package Manager;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

import static banksimulate.SqlOptions.executeSql;

public class FinancialProductManager implements Manager{
    String name;
    String confirm;
    String annual_yield;
    Scanner scanner = new Scanner(System.in);
    String id;

    @Override
    public void add() {
        System.out.println("增添");
        System.out.println("理财产品名称：");
        name = scanner.nextLine();
        System.out.println("理财产品年收益：");
        annual_yield = scanner.nextLine();
        try {
            if (Objects.equals(confirm, name)) {
                executeSql("INSERT INTO bank.financial_products(name,annual_yield) VALUES ('" + name + "','" + annual_yield + "');");
                System.out.println("产品添加成功！");
            }else{
                System.out.println("请重新输入！");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.println("删除");
        System.out.println("理财产品序号");
        id  = scanner.nextLine();
        try {
            if (Objects.equals(confirm, id)) {
                executeSql("delete from bank.financial_products where id = "+id);
                System.out.println("产品删除成功！");
            }else{
                System.out.println("请重新输入！");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change() {
        System.out.println("修改");
        System.out.println("理财产品序号");
        id  = scanner.nextLine();
        System.out.println("产品名称");
        name = scanner.nextLine();
        System.out.println("理财产品年收益");
        annual_yield = scanner.nextLine();
        try {
            if (Objects.equals(confirm, id)) {
                executeSql("update bank.financial_products set name = "+name+" annual_yield = "+annual_yield+" where id = "+id);
                System.out.println("产品修改成功！");
            }else{
                System.out.println("请重新输入！");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void query() {
        System.out.println("查找");
        System.out.println("1按产品序号查找输入1");
        System.out.println("2按产品名称查找输入2");
        System.out.println("3按产品年收益查找输入3");

        int a = Integer.parseInt(scanner.nextLine());
        switch(a){
            case 1:
                System.out.println("请输入产品序号");
                id = scanner.nextLine();
                try{
                    if (Objects.equals(confirm, id)) {
                        executeSql("select * from annual_yield where id = "+id);
                        System.out.println("产品查找成功！");
                    }else{
                        System.out.println("请重新输入！");
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("请输入产品名称");
                name = scanner.nextLine();
                try{
                    if (Objects.equals(confirm, name)) {
                        executeSql("select * from annual_yield where name = "+name);
                        System.out.println("产品查找成功！");
                    }else{
                        System.out.println("请重新输入！");
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }

                break;
            case 3:
                System.out.println("请输入产品年收益");
                annual_yield = scanner.nextLine();
                try{
                    if (Objects.equals(confirm, annual_yield)) {
                        executeSql("select * from annual_yield where annual_yield = "+annual_yield);
                        System.out.println("产品查找成功！");
                    }else{
                        System.out.println("请重新输入！");
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
                break;
        }


    }
}
