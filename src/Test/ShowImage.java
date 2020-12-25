package Test;

import control.HandleLogin;
import control.QueryOneUserAD;
import model.Advertisement;
import model.LoginResp;
import userView.AdvertisingBoardView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShowImage extends JFrame {
    public ShowImage() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new BorderLayout());

//        String urlString = "D://MyEclipse 6.0//新建文件夹//Exam//bin//images//winter.jpg";
//        String urlString = "C://Users//ASUS//Desktop//图片素材//1.jpg";
        LoginResp loginResp = new LoginResp();
        loginResp.setId("小陈");
        loginResp.setPassword("123456");
        QueryOneUserAD queryoneUserAd = new QueryOneUserAD();
        LoginResp loginResp1 = new HandleLogin().handleLogin(loginResp);
        queryoneUserAd.setLoginResp(loginResp1);
        List<Advertisement> advertisements = queryoneUserAd.queryOneUser(loginResp.getId());
//        JLabel label = new JLabel(new ImageIcon(urlString));
        AdvertisingBoardView view=null;
        Image image =null;
        for (Advertisement advertisement : advertisements) {
             image=advertisement.getImage();

        }
        JLabel label2 = new JLabel(new ImageIcon(image));
//
//        URL url = getClass().getResource("/images/orz2.jpg");
//        JLabel label2 = new JLabel(new ImageIcon(url));
//
//        URL url2 = getClass().getResource("/images/orz.jpg");
//        JLabel label3 = new JLabel(new ImageIcon(url2));

//        panel.add(label, BorderLayout.CENTER);
        panel2.add(label2, BorderLayout.CENTER);
//        panel3.add(label3, BorderLayout.CENTER);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(panel2, BorderLayout.SOUTH);
        this.getContentPane().add(panel3, BorderLayout.EAST);

        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("显示图像");
        this.setVisible(true);
    }

    /**
     * */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ShowImage();
    }

}
