package view;

import control.AddAdvertisement;
import model.Advertisement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class HandleAddAdvertisement implements ActionListener {
    AddAdvertisementView view;
    AddAdvertisement addAdvertisement;
    Advertisement ad;
    public HandleAddAdvertisement(){
        addAdvertisement=new AddAdvertisement();
        ad=new Advertisement();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addAdvertisement.setLogin(view.login);
        if (view.login.getLoginSuccess()==false){
            JOptionPane.showMessageDialog(null,"请先登录","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
        if (e.getSource()== view.inputPictureFile){
            JFileChooser fileDialog=new JFileChooser();
            int state = fileDialog.showOpenDialog(null);
            if (state==JFileChooser.APPROVE_OPTION){
                try {
                    File dir = fileDialog.getCurrentDirectory();
                    String name = fileDialog.getSelectedFile().getName();
                    File file = new File(dir, name);
                    ad.setPictureFile(file);
                }catch (Exception exp){}
            }
        }
        if (e.getSource()==view.submit){
            String number = view.inputSerialNumber.getText();
            String content = view.inputWord.getText();
            ad.setContent(content);
            ad.setSerialNumber(number);
            boolean b = addAdvertisement.addAdvertisement(ad);
            if (b)
                view.hintMess.setText("添加成功");
            else
                view.hintMess.setText("添加失败");
        }
    }

    public void setView(AddAdvertisementView view) {
        this.view=view;
    }
}
