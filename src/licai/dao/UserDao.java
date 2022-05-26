package licai.dao;

import licai.domain.User;

public interface UserDao {
    //这个接口保证两个功能

    //注册
    public abstract void regist(User user);
    //登录
    public abstract boolean isLogin(String userName,String passWord);

}
