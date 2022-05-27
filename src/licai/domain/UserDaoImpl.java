package licai.domain;

import licai.dao.UserDao;

import java.util.ArrayList;

public class UserDaoImpl implements UserDao{

    //创建一个集合，定义为公有的
    static ArrayList<User> users=new ArrayList<User>();
    //注册方法：把用户信息存放到集合中
    @Override
    public void regist(User user) {
        // TODO Auto-generated method stub
        users.add(user);

    }

    //登录功能：校验用户名和密码是否正确，正确返回true，否则返回false
    @Override
    public boolean isLogin(String userName, String passWord) {
        // TODO Auto-generated method stub
        boolean flag = false;
        for (User user : users) {
            if(userName.equals(user.getUserName())&&passWord.equals(user.getPassWord())){
                flag = true;
                break;
            }
        }
        return flag;
    }

}
