package Test;

import manager.ManagerService;
import model.Manager;

public class ManagerTest {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setId("张三");
        manager.setPassword("123456");
        ManagerService managerService = new ManagerService();
        managerService.register(manager);
        Manager login = managerService.login(manager);
        if (!login.isLoginSuccess()){
            System.out.println("登录失败");
        }else {
            System.out.println("登录成功");
        }
//        boolean b = managerService.deleteAdvertisement(manager, "AR009");
//        System.out.println(b);
//        boolean a = managerService.deleteUser(manager, "陈林");
//        System.out.println(a);
    }
}
