package licai.dao;

import licai.domain.User;

public interface UserDao {
    //����ӿڱ�֤��������

    //ע��
    public abstract void regist(User user);
    //��¼
    public abstract boolean isLogin(String userName,String passWord);

}
