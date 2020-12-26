package userView;

import control.QueryoneUserAd;
import model.Advertisement;
import model.AdvertisingBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HandleQueryOneUserAD implements ActionListener {
    QueryOneUserADView view ;
    QueryoneUserAd query;
    public HandleQueryOneUserAD(){
        query = new QueryoneUserAd();
    }
    public void actionPerformed(ActionEvent e) {
        query.setLoginResp(view.loginResp);
        if(view.loginResp.getLoginSuccess() == false){
            JOptionPane.showMessageDialog
                    (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = view.inputID.getText().trim();
        if(id.length() == 0) return;
        List<Advertisement> ad = query.queryOneUser(id);
        if(ad == null ) return;
        AdvertisingBoard board = new AdvertisingBoard();
        board.setAdvertisement(ad);
        view.pCenter.setAdvertisingBoard(board);
        view.pCenter.next.doClick();
    }
    public void setView(QueryOneUserADView view) {
        this.view = view;
    }
}
