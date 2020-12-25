package userView;

import control.DelAdvertisement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleDelAdvertisement implements ActionListener {
    DelAdvertisementView view ;
    DelAdvertisement delAdvertisement;
    public HandleDelAdvertisement(){
        delAdvertisement = new DelAdvertisement();
    }
    public void actionPerformed(ActionEvent e) {
        delAdvertisement.setLoginResp(view.loginResp);
        if(view.loginResp.getLoginSuccess() == false){
            JOptionPane.showMessageDialog
                    (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String number = view.inputSerialNumber.getText().trim();
        boolean boo = delAdvertisement.delAdvertisement(number);
        if(boo)
            view.hintMess.setText("删除成功");
        else
            view.hintMess.setText("删除失败，没有该广告");
    }
    public void setView(DelAdvertisementView view) {
        this.view = view;
    }
}
