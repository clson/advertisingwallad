package Test;

import control.DelAdvertisement;
import model.Login;

public class delAdTest {
    public static void main(String[] args) {
        Login login = new Login();
        login.setId("王林");
        login.setPassword("123456");
        DelAdvertisement delAdvertisement = new DelAdvertisement();
        delAdvertisement.setLogin(login);
        boolean ar008 = delAdvertisement.delAdvertiserment("AR008");
        System.out.println(ar008);
    }
}
