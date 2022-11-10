package Admin;

import Home.MysqlConnectivity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLogin extends JFrame implements ActionListener {

    JTextField textFieldUser;
    JTextField textFieldPassWord;
    public AdminLogin(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel h = new JLabel("Bid Buddy Login ");
        h.setBounds(140,10,300,50);
        h.setFont(new Font("Tohma",Font.PLAIN,30));
        add(h);

        JLabel username = new JLabel("User Name");
        username.setBounds(40,120,100,30);
        username.setFont(new Font("Tohma",Font.PLAIN,20));
        add(username);

        textFieldUser = new JTextField();
        textFieldUser.setBounds(150,120,150,30);
        add(textFieldUser);

        JLabel passWord = new JLabel("Password");
        passWord.setBounds(40,160,100,30);
        passWord.setFont(new Font("Tohma",Font.PLAIN,20));
        add(passWord);

        textFieldPassWord = new JTextField();
        textFieldPassWord.setBounds(150,160,150,30);
        add(textFieldPassWord);

        JButton loginButton = new JButton("Admin Login" );
        loginButton.setBounds(150,210,150,30);
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);

        ImageIcon loginImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img3.png"));
        Image i1 = loginImg.getImage().getScaledInstance(350,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(i1);
        JLabel img = new JLabel(imageIcon2);
        img.setBounds(270,40,300,250);
        add(img);

        setSize(580,400);
        setLocation(400,150);
        setVisible(true);



    }



    public static void main(String[] args) {
        new AdminLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        try {

            String userName = textFieldUser.getText();
            String password = textFieldPassWord.getText();
            String query = " select * from adminlogin where username = '"+userName+"' and password = '"+password+"' ";
            MysqlConnectivity con = new MysqlConnectivity();

            ResultSet rs = con.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new AdminHome();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username and Password");
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
