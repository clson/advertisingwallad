package userView;

import control.UpdateContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleUpdateContent implements ActionListener {
    UpdateContentView view;
    UpdateContent updateContent;
    public HandleUpdateContent(){
        updateContent=new UpdateContent();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        updateContent.setLoginResp(view.loginResp);
        if(view.loginResp.getLoginSuccess() == false){
            JOptionPane.showMessageDialog
                    (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String number = view.inputSerialNumber.getText();
        String content = view.inputWord.getText();
        boolean b = updateContent.updateContent(content, number);
        if (b){
            view.hintMess.setText("修改成功");
        }else {
            view.hintMess.setText("修改失败，请确保自己有该条广告");
        }
    }

    public void setView(UpdateContentView updateContentView) {
        this.view=updateContentView;
    }
}
