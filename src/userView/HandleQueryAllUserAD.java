package userView;

import control.QueryAllUserAD;
import model.Advertisement;
import model.AdvertisingBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HandleQueryAllUserAD implements ActionListener {
    QueryAllUserAD queryAll;
    QueryAllUserADView view ;
    public HandleQueryAllUserAD(){
        queryAll = new QueryAllUserAD();
    }
    public void actionPerformed(ActionEvent e) {
        queryAll.setLoginResp(view.loginResp);
        if(view.loginResp.getLoginSuccess() == false){
            JOptionPane.showMessageDialog
                    (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        List<Advertisement> ad = queryAll.queryAllUser();
        if(ad == null ) return;
        AdvertisingBoard board = new AdvertisingBoard();
        board.setAdvertisement(ad);
        view.pCenter.setAdvertisingBoard(board);
        view.pCenter.next.doClick();
    }
    public void setView(QueryAllUserADView view) {
        this.view = view;
    }
}
