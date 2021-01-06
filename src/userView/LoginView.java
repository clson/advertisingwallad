package userView;

import control.HandleLogin;
import model.LoginResp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JPanel implements ActionListener {
    LoginResp loginResp;
    JTextField inputID;
    JPasswordField inputPassword;
    JButton buttonLogin;
    JButton buttonExit;
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
    }
    LoginView() {
        inputID = new JTextField(12);
        inputPassword = new JPasswordField(12);
        buttonLogin = new JButton("登录");
        buttonExit = new JButton("退出登录");
        add(new JLabel("ID:"));
        add(inputID);
        add(new JLabel("密码:"));
        add(inputPassword);
        add(buttonLogin);
        add(buttonExit);
        buttonExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loginResp.setLoginSuccess(false);
                JOptionPane.showMessageDialog
                        (null,"您的账号已退出","消息对话成功框", JOptionPane.WARNING_MESSAGE);
                inputID.setText("");
                inputPassword.setText("");
            }});
        buttonLogin.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        loginResp.setId(inputID.getText());
        char [] pw =inputPassword.getPassword();
        loginResp.setPassword(new String(pw));
        HandleLogin handleLogin = new HandleLogin();
        loginResp=handleLogin.handleLogin(loginResp);
        if(loginResp.getLoginSuccess() == true) {
            JOptionPane.showMessageDialog
                    (null,"登录成功","消息对话成功框", JOptionPane.WARNING_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog
                    (null,"登录失败，账号或密码错误","消息对话成功框", JOptionPane.WARNING_MESSAGE);
        }
    }
}
