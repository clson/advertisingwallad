package userView;

import model.LoginResp;
import org.apache.commons.lang3.RandomStringUtils;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class AddAdvertisementView extends JPanel {
    public LoginResp loginResp;
    public JTextField inputSerialNumber;
    public JTextArea inputWord;
    public JButton inputPictureFile;
    public JButton submit;
    public JTextField hintMess;
    HandleAddAdvertisement handleAddAdvertisement;
    AddAdvertisementView() {
        initView();
        registerListener() ;
    }
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
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
        submit = new JButton("添加广告");
        //随机生成广告序列号
        //inputSerialNumber.setText(RandomStringUtils.random(5, RandomStringUtils.randomNumeric(5)));
        //inputSerialNumber.setText(UUID.randomUUID().toString().substring(0, 5));
        //inputSerialNumber.setEditable(false);
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
    private void registerListener() {
        handleAddAdvertisement = new HandleAddAdvertisement();
        handleAddAdvertisement.setView(this);
        submit.addActionListener(handleAddAdvertisement);
        inputPictureFile.addActionListener(handleAddAdvertisement);
    }
}
