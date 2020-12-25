package userView;

import control.UpdateUserPW;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleUpdatePW implements ActionListener {
    UpdatePwView view;
    UpdateUserPW updateUserPW;

    public HandleUpdatePW(){
        updateUserPW =new UpdateUserPW();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        updateUserPW.setLoginResp(view.loginResp);
        if(view.loginResp.getLoginSuccess() == false){
            JOptionPane.showMessageDialog
                    (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String pw = view.inputNewPw.getText().trim();
        boolean boo = updateUserPW.updatePw(pw);
        if(boo)
            view.hintMess.setText("修改成功，请重新登录");
        else
            view.hintMess.setText("修改失败");
    }

    public void setView(UpdatePwView updatePwView) {
        this.view=updatePwView;
    }
}
