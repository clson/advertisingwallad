package managerView;

import manager.ManagerService;
import model.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteAdvertisementView extends JPanel implements ActionListener {
    JTextField serialNumber;
    JButton submit;
    JTextField hintMess;
    Manager manager;
    public void setLogin(Manager manager){
        this.manager=manager;
    }
    public DeleteAdvertisementView(){
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        serialNumber = new JTextField(20);
        submit = new JButton("删除");
        add(new JLabel("请输入要删除的广告序列号："));
        add(serialNumber);
        add(submit);
        add(hintMess);
        submit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ManagerService managerService = new ManagerService();
        boolean b = managerService.deleteAdvertisement(manager, serialNumber.getText());
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
