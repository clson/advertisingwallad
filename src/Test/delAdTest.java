package Test;

import control.HandleLogin;
import control.UpdateContent;
import model.LoginResp;

public class delAdTest {
    public static void main(String[] args) {
        LoginResp loginResp = new LoginResp();
        loginResp.setId("王林");
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
        UpdateContent updateContent = new UpdateContent();
        updateContent.setLoginResp(loginResp);
        boolean b = updateContent.updateContent("李白", "A006");
        if (b){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

}
