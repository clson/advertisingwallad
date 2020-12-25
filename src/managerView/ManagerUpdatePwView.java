package managerView;

import manager.ManagerService;
import model.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerUpdatePwView extends JPanel implements ActionListener {
    JPasswordField inputNewPw;
    JButton submit;
    JTextField hintMess;
    Manager manager;
    public void setLogin(Manager manager){
        this.manager=manager;
    }
    public ManagerUpdatePwView(){
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        inputNewPw = new JPasswordField(20);
        submit = new JButton("修改密码");
        add(new JLabel("输入新密码"));
        add(inputNewPw);
        add(submit);
        add(hintMess);
        submit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ManagerService managerService = new ManagerService();
        if (manager.isLoginSuccess()==false){
            JOptionPane.showMessageDialog
                    (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        boolean b = managerService.updatePw(manager, inputNewPw.getText().trim());
        if (b)
            hintMess.setText("修改成功，请重新登录");
        else
            hintMess.setText("修改失败");
    }
}
