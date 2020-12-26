package Test;

import control.HandleLogin;
import control.QueryoneUserAd;
import model.Advertisement;
import model.LoginResp;

import java.util.List;


public class queryOneTest {
    public static void main(String[] args) {
        LoginResp loginResp = new LoginResp();
        loginResp.setId("小陈");
        loginResp.setPassword("123456");
        QueryoneUserAd queryoneUserAd = new QueryoneUserAd();
        LoginResp loginResp1 = new HandleLogin().handleLogin(loginResp);
        queryoneUserAd.setLoginResp(loginResp1);
        List<Advertisement> advertisements = queryoneUserAd.queryOneUser(loginResp.getId());
        for (Advertisement advertisement : advertisements) {
            System.out.println(advertisement);
        }
//       QueryAllUserAD queryAllUserAD = new QueryAllUserAD();
//        queryAllUserAD.setLoginResp(loginResp);
//        List<Advertisement> list = queryAllUserAD.queryAllUser();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println(advertisements.get(0));
        System.out.println();
//        Advertisement advertisement = new Advertisement();
//        advertisement = advertisements.get(0);
//        System.out.println(advertisement);
        Advertisement[] ad=null;
        ad=new  Advertisement[advertisements.size()];
//        System.out.println(advertisements.get(0));
//        System.out.println(advertisements.get(1));
//        System.out.println();
        for (int i = 0; i < advertisements.size(); i++) {
            Advertisement advertisement = advertisements.get(i);
            ad[i]=advertisement;
        }
        for (Advertisement advertisement : ad) {
            System.out.println(advertisement);
        }

    }
}
