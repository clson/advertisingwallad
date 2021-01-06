package userView;

import control.UpdateAdvertisement;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class HandleUpdateContent implements ActionListener {
    UpdateContentView view;
    UpdateAdvertisement updateAdvertisement;
    File file;
    public HandleUpdateContent(){
        updateAdvertisement =new UpdateAdvertisement();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        updateAdvertisement.setLoginResp(view.loginResp);
        if(view.loginResp.getLoginSuccess() == false){
            JOptionPane.showMessageDialog
                    (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(e.getSource()==view.inputPictureFile) {
            JFileChooser fileDialog=new JFileChooser();
            int state=fileDialog.showOpenDialog(null);
            if(state==JFileChooser.APPROVE_OPTION) {
                try{
                    File dir=fileDialog.getCurrentDirectory();
                    String name=fileDialog.getSelectedFile().getName();
                    file=new File(dir,name);
                }
                catch(Exception exp){}
            }
        }
        if(e.getSource()==view.submit) {
            String number = view.inputSerialNumber.getText();
            String content = view.inputWord.getText();
            if (StringUtils.isBlank(content))
                content=null;
            boolean  b=updateAdvertisement.updateAd(content,file,number);
            if (b){
                view.hintMess.setText("修改成功");
            }else {
                view.hintMess.setText("修改失败，请确保自己有该条广告");
            }
            //提交之后清空输入框及图片文件
            view.inputSerialNumber.setText("");
            view.inputWord.setText("");
            file=null;
        }

    }

    public void setView(UpdateContentView updateContentView) {
        this.view=updateContentView;
    }
}
