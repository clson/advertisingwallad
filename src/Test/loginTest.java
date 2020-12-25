package Test;

import control.AddAdvertisement;
import control.HandleLogin;
import model.Advertisement;
import model.LoginResp;

import java.io.File;

public class loginTest {
    public static void main(String[] args) {
        LoginResp loginResp = new LoginResp();
        loginResp.setId("王五");
        loginResp.setPassword("123456");
        HandleLogin hanleLogin = new HandleLogin();
        loginResp = hanleLogin.handleLogin(loginResp);
        if (loginResp.getLoginSuccess()==false)
            System.out.println("登录失败");
        else
            System.out.println("登录成功");
        AddAdvertisement add=new AddAdvertisement();
        add.setLoginResp(loginResp);
        Advertisement ad=new Advertisement();
        ad.setContent("天墉城");
        File file = new File("src/2.jpg");
        ad.setPictureFile(file);
        ad.setSerialNumber("AR008");
        boolean b = add.addAdvertisement(ad);
        System.out.println(b);
    }
}
