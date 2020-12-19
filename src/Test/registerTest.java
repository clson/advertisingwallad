package Test;

import control.HandleRegister;
import control.HandleRegister_t;
import model.Register;

public class registerTest {
    public static void main(String[] args) {
        Register register = new Register();
        register.setId("黄二欣");
        register.setPassword("123456");
        HandleRegister_t handleRegister = new HandleRegister_t();
        boolean b = handleRegister.handleRegister(register);
        if (b){
            System.out.println("注册成功");
        }
        else {
            System.out.println("注册失败,请换一个IP");
        }
    }
}
