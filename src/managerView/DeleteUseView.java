package managerView;

import manager.ManagerService;
import model.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUseView  extends JPanel implements ActionListener {
    JTextField userID;
    JButton submit;
    JTextField hintMess;
    Manager manager;
    public void setLogin(Manager manager){
        this.manager=manager;
    }
    public DeleteUseView(){
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        userID = new JTextField(20);
        submit = new JButton("删除");
        add(new JLabel("请输入要删除的用户ID："));
        add(userID);
        add(submit);
        add(hintMess);
        submit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ManagerService managerService = new ManagerService();
        boolean b = managerService.deleteUser(manager, userID.getText());
        if (manager.isLoginSuccess()==false){
            JOptionPane.showMessageDialog
                    (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (b)
            hintMess.setText("删除成功");
        else
            hintMess.setText("删除失败");

    }
}
