package view;
import control.HandleRegister;
import model.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegisterView extends JPanel implements ActionListener {
    private JTextField inputID;
    private JPasswordField inputPassword;
    private JPasswordField againPassword;
    private JButton buttonRegister;
    Register register;

    RegisterView(){
        register=new model.Register();
        inputID= new JTextField(12);
        inputPassword= new JPasswordField(12);
        againPassword= new JPasswordField(12);
        buttonRegister= new JButton("注册");
        add(new JLabel("输入ID："));
        add(inputID);
        add(new JLabel("设置密码："));
        add(inputPassword);
        add(new JLabel("再次输入密码"));
        add(againPassword);
        add(buttonRegister);
        buttonRegister.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String id = inputID.getText().trim();
        char[] pw = inputPassword.getPassword();
        char[] pw_again = againPassword.getPassword();
        String pwStr = new String(pw).trim();
        if (id.length()==0||pwStr.length()==0){
            JOptionPane.showMessageDialog(null,"注册失败","消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        String pw_againStr = new String(pw_again).trim();
        if (pwStr.equals(pw_againStr)){
            register.setId(id);
            register.setPassword(new String(pw));
            HandleRegister handleRegister = new HandleRegister();
            boolean b = handleRegister.handleRegister(register);
            if (b){
                JOptionPane.showMessageDialog(null,"注册成功","消息对话框",JOptionPane.WARNING_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null,"注册失败,请换一个ID再试","消息对话框",JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null,"注册失败,两次密码不一样","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void main(String[] args) {
        JFrame first = new JFrame("注册");
        first.setContentPane(new RegisterView());
        first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        first.setVisible(true);
        first.setSize(1000,200);
        first.setLocation(200,200);
    }
}
