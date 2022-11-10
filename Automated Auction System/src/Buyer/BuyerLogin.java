package Buyer;

import javax.swing.*;
import java.awt.*;

public class BuyerLogin {

    JTextField textFieldUser;
    JTextField textFieldPassWord;
    public BuyerLogin(){

        JFrame frame1 = new JFrame();

        frame1.getContentPane().setBackground(Color.WHITE);
        frame1.setLayout(null);

        JLabel h = new JLabel("Bid Buddy Login ");
        h.setBounds(140,10,300,50);
        h.setFont(new Font("Tohma",Font.PLAIN,30));
        frame1.add(h);

        JLabel username = new JLabel("User Name");
        username.setBounds(40,120,100,30);
        username.setFont(new Font("Tohma",Font.PLAIN,20));
        frame1.add(username);

        textFieldUser = new JTextField();
        textFieldUser.setBounds(150,120,150,30);
        frame1.add(textFieldUser);

        JLabel passWord = new JLabel("Password");
        passWord.setBounds(40,160,100,30);
        passWord.setFont(new Font("Tohma",Font.PLAIN,20));
        frame1.add(passWord);

        textFieldPassWord = new JTextField();
        textFieldPassWord.setBounds(150,160,150,30);
        frame1.add(textFieldPassWord);

        JButton loginButton = new JButton("Buyer Login" );
        loginButton.setBounds(150,210,150,30);
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        frame1.add(loginButton);

        ImageIcon loginImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img3.png"));
        Image i1 = loginImg.getImage().getScaledInstance(350,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(i1);
        JLabel img = new JLabel(imageIcon2);
        img.setBounds(270,40,300,250);
        frame1.add(img);


        JLabel subH = new JLabel(" new Buddy user click");
        subH.setBounds(40,280,200,30);
        subH.setFont( new Font("Tohma",Font.PLAIN,15));
        frame1.add(subH);

        JButton newB = new JButton("Here");
        newB.setBounds(190,285,80,20);
        newB.setFont(new Font("Tohma", Font.PLAIN, 15));
        newB.setForeground(Color.WHITE);
        newB.setBackground(Color.BLUE);
        frame1.add(newB);

        frame1.setSize(580,400);
        frame1.setLocation(400,150);
        frame1.setVisible(true);


    }


    public static void main(String[] args) {
        new BuyerLogin();

    }
}
