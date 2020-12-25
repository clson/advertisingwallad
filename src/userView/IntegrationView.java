package userView;

import model.LoginResp;

import javax.swing.*;
import java.awt.*;

public class IntegrationView extends JFrame {
    JTabbedPane tabbedPane;
    RegisterView  regisView;
    LoginView loginView;
    AddAdvertisementView addAdvertisementView;
    DelAdvertisementView delAdvertisementView;
    QueryAllUserADView  queryAllUserADView;
    QueryOneUserADView queryOneUserADView;
    UpdatePwView updatePwView;
    UpdateContentView updateContentView;
    LoginResp loginResp;
    public IntegrationView(){
        this.setTitle("用户界面");
        regisView = new RegisterView();
        loginResp = new LoginResp();
        loginView = new LoginView();
        addAdvertisementView = new AddAdvertisementView();
        delAdvertisementView = new DelAdvertisementView();
        queryAllUserADView = new QueryAllUserADView();
        queryOneUserADView = new QueryOneUserADView();
        updatePwView=new UpdatePwView();
        updateContentView=new UpdateContentView();
        loginView.setLoginResp(loginResp);
        addAdvertisementView.setLoginResp(loginResp);
        delAdvertisementView.setLoginResp(loginResp);
        queryAllUserADView.setLoginResp(loginResp);
        queryOneUserADView.setLoginResp(loginResp);
        updatePwView.setLoginResp(loginResp);
        updateContentView.setLoginResp(loginResp);
        tabbedPane=
                new JTabbedPane(JTabbedPane.LEFT);
        tabbedPane.add("登录",loginView);
        tabbedPane.add("注册",regisView);
        tabbedPane.add("修改密码",updatePwView);
        tabbedPane.add("添加广告",addAdvertisementView);
        tabbedPane.add("删除广告",delAdvertisementView);
        tabbedPane.add("修改广告",updateContentView);
        tabbedPane.add("浏览全部用户广告",queryAllUserADView);
        tabbedPane.add("浏览某个用户广告",queryOneUserADView);

        tabbedPane.validate();
        add(tabbedPane,BorderLayout.CENTER);
        setBounds(400,250,1200,560);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
