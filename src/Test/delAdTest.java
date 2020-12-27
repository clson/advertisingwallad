package Test;

import control.HandleLogin;
import control.UpdateAdvertisement;
import model.LoginResp;

import java.io.File;

public class delAdTest {
    public static void main(String[] args) {
        LoginResp loginResp = new LoginResp();
        loginResp.setId("小陈");
        loginResp.setPassword("123456");
        new HandleLogin().handleLogin(loginResp);
//        DelAdvertisement delAdvertisement = new DelAdvertisement();
//        delAdvertisement.setLoginResp(loginResp);
//        boolean ar008 = delAdvertisement.delAdvertisement("AR008");
//        System.out.println(ar008);
//        UpdateUserPW updatePW = new UpdateUserPW();
//        updatePW.setLoginResp(loginResp);
//        boolean b = updatePW.updatePw("123456");
//        if (b){
//            System.out.println("修改成功");
//        }else {
//            System.out.println("修改失败");
//        }
        UpdateAdvertisement updateAdvertisement = new UpdateAdvertisement();
        updateAdvertisement.setLoginResp(loginResp);
        File file = new File("src/2.jpg");
        boolean b = updateAdvertisement.updateAd("", file,"A001");
        if (b){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

}
