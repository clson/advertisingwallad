package managerView;

import manager.ManagerService;
import model.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerLoginView  extends JPanel implements ActionListener {
    JTextField inputID;
    JPasswordField inputPassword;
    JButton buttonLogin;
    JButton buttonExit;
    Manager manager;
    public void setLogin(Manager manager){
        this.manager=manager;
    }
    ManagerLoginView(){
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
                manager.setLoginSuccess(false);
            }});
        buttonLogin.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        manager.setId(inputID.getText());
        manager.setPassword(new String(inputPassword.getPassword()));
        manager= new ManagerService().login(manager);
        if (manager.isLoginSuccess()==true)
            JOptionPane.showMessageDialog
                    (null,"登录成功","消息对话成功框", JOptionPane.WARNING_MESSAGE);
        else
            JOptionPane.showMessageDialog
                    (null,"登录失败","消息对话成功框", JOptionPane.WARNING_MESSAGE);
    }
}
