package licai.ShoppingSystem;

//��Ʒ�ࣺ��Ʒ��š���Ʒ���ۡ���Ʒ����
public class Good {
    private int id;
    private double pirce;
    private String name;

    //�޲ι��췽��
    public Good() {
    }

    //�вι��췽��
    public Good(int id, double pirce, String name) {
        this.id = id;
        this.pirce = pirce;
        this.name = name;
    }


    //��toString������д
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

