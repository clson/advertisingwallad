package userView;

import model.LoginResp;

import javax.swing.*;
import java.awt.*;

public class QueryOneUserADView extends JPanel {
    public LoginResp loginResp;
    public JTextField inputID;
    JButton submit;
    public AdvertisingBoardView  pCenter ; //广告牌
    HandleQueryOneUserAD  handleQueryOneUserAD;
    QueryOneUserADView() {
        initView();
        registerListener() ;
    }
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
    }
    private void initView() {
        setLayout(new BorderLayout());
        JPanel pNorth = new JPanel();
        pCenter = new AdvertisingBoardView();
        inputID = new JTextField(12);
        submit = new JButton("提交");
        pNorth.add(new JLabel("输入某用户ID，查询该ID做的广告"));
        pNorth.add(inputID);
        pNorth.add(submit);
        add(pNorth,BorderLayout.NORTH);
        add(pCenter,BorderLayout.CENTER);
    }
    private void registerListener() {
        handleQueryOneUserAD = new HandleQueryOneUserAD();
        handleQueryOneUserAD.setView(this);
        submit.addActionListener(handleQueryOneUserAD);
    }
}
