package userView;

import model.LoginResp;

import javax.swing.*;
import java.awt.*;

public class QueryAllUserADView extends JPanel {
    public LoginResp loginResp;
    JButton submit;
    public AdvertisingBoardView  pCenter ;
    HandleQueryAllUserAD  handleQueryAllUserAD;
    QueryAllUserADView() {
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
        submit = new JButton("浏览全部广告");
        pNorth.add(submit);
        add(pNorth, BorderLayout.NORTH);
        add(pCenter,BorderLayout.CENTER);
    }
    private void registerListener() {
        handleQueryAllUserAD = new HandleQueryAllUserAD();
        handleQueryAllUserAD.setView(this);
        submit.addActionListener(handleQueryAllUserAD);
    }
}
