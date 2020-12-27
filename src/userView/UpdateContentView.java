package userView;

import model.LoginResp;

import javax.swing.*;
import java.awt.*;

public class UpdateContentView extends JPanel {
    public LoginResp loginResp;
    public JTextField inputSerialNumber;
    public JTextArea inputWord;
    public JButton inputPictureFile;
    public JButton submit;
    public JTextField hintMess;
    HandleUpdateContent handleUpdateContent;
    UpdateContentView(){
        initView();
        registerListener() ;
    }

    private void registerListener() {
        handleUpdateContent=new HandleUpdateContent();
        handleUpdateContent.setView(this);
        inputPictureFile.addActionListener(handleUpdateContent);
        submit.addActionListener(handleUpdateContent);
    }

    private void initView() {
        setLayout(new BorderLayout());
        JPanel pNorth = new JPanel();
        JPanel pSouth = new JPanel();
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        inputSerialNumber = new JTextField(20);
        inputWord = new JTextArea();
        inputWord.setLineWrap(true);
        inputWord.setWrapStyleWord(true);
        inputWord.setFont(new Font("宋体",Font.BOLD,20));
        inputPictureFile = new JButton("请选择广告图像文件");
        submit = new JButton("修改广告");
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
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
    }
}
