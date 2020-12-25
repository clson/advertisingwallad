package userView;

import model.LoginResp;

import javax.swing.*;

public class UpdatePwView extends JPanel {
    LoginResp loginResp;
    JPasswordField inputNewPw;
    JButton submit;
    JTextField hintMess;
    HandleUpdatePW handleUpdatePW;
    UpdatePwView(){
        initView();
        registerListener();

    }
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
    }
    private void registerListener() {
         handleUpdatePW = new HandleUpdatePW();
        handleUpdatePW.setView(this);
        submit.addActionListener(handleUpdatePW);
    }

    private void initView() {
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        inputNewPw = new JPasswordField(20);
        submit = new JButton("修改密码");
        add(new JLabel("输入新密码"));
        add(inputNewPw);
        add(submit);
        add(hintMess);
    }
}
