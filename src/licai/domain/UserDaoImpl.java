package licai.domain;

import licai.dao.UserDao;

import java.util.ArrayList;

public class UserDaoImpl implements UserDao{

    //����һ�����ϣ�����Ϊ���е�
    static ArrayList<User> users=new ArrayList<User>();
    //ע�᷽�������û���Ϣ��ŵ�������
    @Override
    public void regist(User user) {
        // TODO Auto-generated method stub
        users.add(user);

    }

    //��¼���ܣ�У���û����������Ƿ���ȷ����ȷ����true�����򷵻�false
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
