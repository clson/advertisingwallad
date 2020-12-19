package Test;

import control.HandleLogin;
import control.QueryAllUserAD;
import control.QueryoneUserAd;
import model.Advertisement;
import model.Login;

import java.util.List;


public class queryOneTest {
    public static void main(String[] args) {
        Login login = new Login();
        login.setId("王林");
        login.setPassword("123456");
        QueryoneUserAd queryoneUserAd = new QueryoneUserAd();
        Login login1 = new HandleLogin().handleLogin(login);
        queryoneUserAd.setLogin(login1);
        List<Advertisement> advertisements = queryoneUserAd.queryOneUser(login.getId());
        for (Advertisement advertisement : advertisements) {
            System.out.println(advertisement);
        }
//       QueryAllUserAD queryAllUserAD = new QueryAllUserAD();
//        queryAllUserAD.setLogin(login);
//        List<Advertisement> list = queryAllUserAD.queryAllUser();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
    }
}
