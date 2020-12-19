package view;
import control.AddAdvertisement;
import model.Login;

import javax.swing.*;
import java.awt.*;

public class AddAdvertisementView extends JPanel{
    public JTextField inputSerialNumber;
    public JTextArea inputWord;
    public JButton inputPictureFile;
    public JButton submit;
    public JTextField hintMess;
    public Login login;
    HandleAddAdvertisement handleAddAdvertisement;
    AddAdvertisementView(){
        initView();
        registerListener();
    }

    private void registerListener() {
        handleAddAdvertisement= new HandleAddAdvertisement();
        handleAddAdvertisement.setView(this);
        submit.addActionListener(handleAddAdvertisement);
        inputPictureFile.addActionListener(handleAddAdvertisement);

    }

    private void initView() {
        setLayout(new BorderLayout());
        JPanel pNorth=new JPanel();
        JPanel pSouth = new JPanel();
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        inputSerialNumber=new JTextField(20);
        inputWord=new JTextArea();
        inputWord.setLineWrap(true);
        inputWord.setWrapStyleWord(true);
        inputWord.setFont(new Font("宋体",Font.BOLD,20));
        inputPictureFile=new JButton("选择广告图像文件");
        submit=new JButton("添加广告");
        pNorth.add(new JLabel("输入广告序列号"));
        pNorth.add(inputSerialNumber);
        pNorth.add(new JLabel("在文本区输入广告词"));
        pSouth.add(inputPictureFile);
        pSouth.add(submit);
        pSouth.add(hintMess);
        add(pNorth,BorderLayout.NORTH);
        add(pSouth,BorderLayout.SOUTH);
        add(new JScrollPane(inputWord),BorderLayout.CENTER);
    }

    public void setLogin(Login login){
        this.login=login;
    }
    public static void main(String[] args) {
        JFrame first = new JFrame("添加广告");
        first.setContentPane(new AddAdvertisementView());
        Login login = new Login();
        login.setId("王林");
        login.setPassword("123456");
        login.setLoginSuccess(true);
        new AddAdvertisementView().setLogin(login);
        first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        first.setVisible(true);
        first.setSize(1000,200);
        first.setLocation(200,200);
    }
}
