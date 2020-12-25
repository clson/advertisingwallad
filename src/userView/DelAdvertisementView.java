package userView;

import model.LoginResp;

import javax.swing.*;

public class DelAdvertisementView extends JPanel {
    LoginResp loginResp;
    JTextField inputSerialNumber;
    JButton submit;
    JTextField hintMess;
    HandleDelAdvertisement handleDelAdvertisement;
    DelAdvertisementView() {
        initView();
        registerListener() ;
    }
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
    }
    private void initView() {
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        inputSerialNumber = new JTextField(20);
        submit = new JButton("删除广告");
        add(new JLabel("输入广告的序列号"));
        add(inputSerialNumber);
        add(submit);
        add(hintMess);
    }
    private void registerListener() {
        handleDelAdvertisement = new HandleDelAdvertisement();
        handleDelAdvertisement.setView(this);
        submit.addActionListener(handleDelAdvertisement);
    }
}
