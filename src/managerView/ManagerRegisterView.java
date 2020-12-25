package managerView;

import manager.ManagerService;
import model.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerRegisterView extends JPanel implements ActionListener {
    Manager manager;
    JTextField inputID;
    JPasswordField inputPassword;
    JPasswordField againPassword;
    JButton buttonRegister;

    public ManagerRegisterView(){
        manager=new Manager();
        inputID = new JTextField(12);
        inputPassword = new JPasswordField(12);
        againPassword = new JPasswordField(12);
        buttonRegister = new JButton("注册");
        add(new JLabel("输入ID:"));
        add(inputID);
        add(new JLabel("设置密码:"));
        add(inputPassword);
        add(new JLabel("再次输入密码:"));
        add(againPassword);
        add(buttonRegister);
        buttonRegister.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String id = inputID.getText().trim();
        char [] pw =inputPassword.getPassword();
        char [] pw_again =againPassword.getPassword();
        String pw_againStr = new String(pw_again).trim();
        String pwStr = new String(pw).trim();
        if(id.length() == 0 ||pwStr.length()==0 ){
            JOptionPane.showMessageDialog
                    (null,"注册失败,ID或密码不能为空","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (pwStr.equals(pw_againStr)){
            ManagerService managerService = new ManagerService();
            manager.setId(id);
            manager.setPassword(pwStr);
            boolean boo = managerService.register(manager);
            if(boo)
                JOptionPane.showMessageDialog
                        (null,"注册成功","消息对话成功框", JOptionPane.WARNING_MESSAGE);
            else
                JOptionPane.showMessageDialog
                        (null,"注册失败，换个ID","消息对话框", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog
                    (null,"两次输入密码不同","消息对话框", JOptionPane.WARNING_MESSAGE);
        }


    }
}
