package view;

import control.HandleLogin;
import model.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JPanel implements ActionListener {
    private JTextField inputID;
    private JPasswordField inputPassword;
    private JButton buttonLogin;
    private JButton buttonExit;
    Login login;

    public void setLogin(Login login){
        this.login=login;
    }
    LoginView(){
        inputID=new JTextField(12);
        inputPassword=new JPasswordField(12);
        buttonLogin=new JButton("登录");
        buttonExit=new JButton("退出登录");
        add(new JLabel("ID："));
        add(inputID);
        add(new JLabel("密码："));
        add(inputPassword);
        add(buttonLogin);
        add(buttonExit);
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.setLoginSuccess(false);
            }
        });
        buttonLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        login=new Login();
        login.setId(inputID.getText());
        char[] pw = inputPassword.getPassword();
        login.setPassword(new String((pw)));
        HandleLogin handleLogin = new HandleLogin();
        login = handleLogin.handleLogin(this.login);
        if (login.getLoginSuccess()==true){
            JOptionPane.showMessageDialog(null,"登录成功","消息对话成功框",JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null,"登录失败","消息对话成功框",JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JFrame first = new JFrame("登录");
        first.setContentPane(new LoginView());
        first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        first.setVisible(true);
        first.setSize(1000,200);
        first.setLocation(200,200);
    }
}
