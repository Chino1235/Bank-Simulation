package licai.ShoppingSystem;

//商品类：商品编号、商品单价、商品名称
public class Good {
    private int id;
    private double pirce;
    private String name;

    //无参构造方法
    public Good() {
    }

    //有参构造方法
    public Good(int id, double pirce, String name) {
        this.id = id;
        this.pirce = pirce;
        this.name = name;
    }


    //将toString方法重写
    @Override
    public String toString() {
        return   id +"\t" +pirce + "\t"+name ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPirce() {
        return pirce;
    }

    public void setPirce(double pirce) {
        this.pirce = pirce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

