package Seller;

import Home.HomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellerHome extends JFrame implements ActionListener {


    JButton createList,updateItems,addItems,removeItems,viewSoldItems,logout;
    SellerHome(){


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon coverImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img10.png"));
        Image i1 = coverImg.getImage().getScaledInstance(480,440,Image.SCALE_DEFAULT);
        ImageIcon coverIcon2 = new ImageIcon(i1);
        JLabel cover = new JLabel(coverIcon2);
        cover.setBounds(50,150,480,440);
        add(cover);

        ImageIcon logoImg = new ImageIcon(ClassLoader.getSystemResource("Photos/logo.png"));
        Image i2 = logoImg.getImage().getScaledInstance(260,190,Image.SCALE_DEFAULT);
        ImageIcon logoIcon2 = new ImageIcon(i2);
        JLabel logo = new JLabel(logoIcon2);
        logo.setBounds(10,0,260,80);
        add(logo);

        JLabel h = new JLabel("Welcome Bidder ");
        h.setBounds(630,0,700,70);
        h.setFont(new Font("Tohma",Font.PLAIN,45));
        h.setForeground(Color.BLACK);
        add(h);

        updateItems = new JButton("Update Product");
        updateItems.setBounds(650,380,150,40);
        updateItems.setFont(new Font("Tahoma",Font.BOLD,12));
        updateItems.addActionListener(this);
        add(updateItems);

        removeItems = new JButton("Remove Product");
        removeItems.setBounds(830,380,150,40);
        removeItems.setFont(new Font("Tahoma",Font.BOLD,12));
        removeItems.addActionListener(this);
        add(removeItems);

        addItems = new JButton("Add Product");
        addItems.setBounds(790,280,150,40);
        addItems.setFont(new Font("Tahoma",Font.BOLD,12));
        addItems.addActionListener(this);
        add(addItems);

        createList = new JButton("Create List");
        createList.setBounds(610,280,150,40);
        createList.setFont(new Font("Tahoma",Font.BOLD,12));
        createList.addActionListener(this);
        add(createList);

        viewSoldItems = new JButton("View Sold Product");
        viewSoldItems.setBounds(700,480,150,40);
        viewSoldItems.setFont(new Font("Tahoma",Font.BOLD,12));
        viewSoldItems.addActionListener(this);
        add(viewSoldItems);

        logout = new JButton("Logout");
        logout.setBounds(890,480,150,40);
        logout.setFont(new Font("Tahoma",Font.BOLD,12));
        logout.addActionListener(this);
        add(logout);




        setSize(1380,740);
        setLocation(0,0);
        setVisible(true);

    }


    public static void main(String[] args) {
        new SellerHome();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if( e.getSource() == logout ){
            setVisible(false);
            new SellerLogin();
        }

    }
}
