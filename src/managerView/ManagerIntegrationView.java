package managerView;

import model.Manager;

import javax.swing.*;
import java.awt.*;

public class ManagerIntegrationView extends JFrame{
    Manager manager;
    JTabbedPane tabbedPane;
    ManagerLoginView managerLoginView;
    ManagerUpdatePwView managerUpdatePwView;
    DeleteUseView deleteUseView;
    DeleteAdvertisementView deleteAdvertisementView;
    ManagerRegisterView managerRegisterView;
    public ManagerIntegrationView(){
        this.setTitle("管理员界面");
        manager=new Manager();
        managerLoginView=new ManagerLoginView();
        managerUpdatePwView=new ManagerUpdatePwView();
        deleteUseView=new DeleteUseView();
        deleteAdvertisementView=new DeleteAdvertisementView();
        managerRegisterView=new ManagerRegisterView();
        managerLoginView.setLogin(manager);
        managerUpdatePwView.setLogin(manager);
        deleteUseView.setLogin(manager);
        deleteAdvertisementView.setLogin(manager);
        tabbedPane=
                new JTabbedPane(JTabbedPane.LEFT);
        tabbedPane.add("登录",managerLoginView);
        tabbedPane.add("注册",managerRegisterView);
        tabbedPane.add("修改密码",managerUpdatePwView);
        tabbedPane.add("删除用户",deleteUseView);
        tabbedPane.add("删除广告",deleteAdvertisementView);
        tabbedPane.validate();
        add(tabbedPane, BorderLayout.CENTER);
        setBounds(400,250,700,500);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
