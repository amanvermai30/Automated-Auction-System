package Buyer;

import Home.MysqlConnectivity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

public class NewBuyerDetails extends JFrame implements ActionListener {

    Random ran = new Random();
    int num = ran.nextInt(999999);

    JTextField nameField,emailField,passwordField;
    JLabel buyerIDNumber;
    JButton createB;

    public NewBuyerDetails(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon logoImg = new ImageIcon(ClassLoader.getSystemResource("Photos/logo.png"));
        Image i2 = logoImg.getImage().getScaledInstance(260,190,Image.SCALE_DEFAULT);
        ImageIcon logoIcon2 = new ImageIcon(i2);
        JLabel logo = new JLabel(logoIcon2);
        logo.setBounds(10,0,260,80);
        add(logo);

        ImageIcon loginImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img4.png"));
        Image i1 = loginImg.getImage().getScaledInstance(450,360,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(i1);
        JLabel img = new JLabel(imageIcon2);
        img.setBounds(0,160,450,360);
        add(img);

        JLabel heading = new JLabel("Create Your Buddy Account ");
        heading.setBounds(300,30,500,100);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Username");
        name.setBounds(490,150,150,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(name);

        nameField = new JTextField();
        nameField.setBounds(590,150,150,30);
        add(nameField);

        JLabel email = new JLabel("Email");
        email.setBounds(490,220,150,30);
        email.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(email);

        emailField = new JTextField();
        emailField.setBounds(590,220,150,30);
        add(emailField);

        JLabel password = new JLabel("Password");
        password.setBounds(490,290,150,30);
        password.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(password);

        passwordField = new JTextField();
        passwordField.setBounds(590,290,150,30);
        add(passwordField);

        JLabel buyerID = new JLabel("Buyer ID ");
        buyerID.setBounds(490,360,150,30);
        buyerID.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(buyerID);

        buyerIDNumber = new JLabel(String.valueOf(num));
        buyerIDNumber.setBounds(640,360,150,30);
        buyerIDNumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(buyerIDNumber);


        createB = new JButton(" create account");
        createB.setBounds(570,450,150,40);
        createB.setFont(new Font("Tohma", Font.PLAIN, 15));
        createB.setForeground(Color.WHITE);
        createB.setBackground(Color.BLUE);
        createB.addActionListener(this);
        add(createB);


        setSize(900,650);
        setLocation(230,40);
        setVisible(true);
    }


    public static void main(String[] args) {

        new NewBuyerDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == createB ){

           String name = nameField.getText();
           String email = emailField.getText();
           String password = passwordField.getText();
           String id = buyerIDNumber.getText();

           try {
               MysqlConnectivity con = new MysqlConnectivity();
               String query = "insert into buyerdetails values( '"+name+"', '"+email+"', '"+password+"', '"+id+"') ";
               String query2 = "insert into buyerlogin values( '"+name+"', '"+password+"' ) ";
               con.s.executeUpdate(query);
               con.s.executeUpdate(query2);


           }catch (SQLException ex ){
               ex.printStackTrace();
           }


            JOptionPane.showMessageDialog(null, "Your Buddy Account created");
            setVisible(false);
            new BuyerLogin();
        }
    }
}
