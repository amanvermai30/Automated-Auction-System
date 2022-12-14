package Seller;

import Home.HomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellerHome extends JFrame implements ActionListener {

    public  static String uniqueUser;
    JButton viewList,updateItems,addItems,removeItems,viewSoldItems,logout;

    SellerHome( String uniqueUser ){
          SellerHome.uniqueUser = uniqueUser;

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

        JLabel h = new JLabel("Welcome "+uniqueUser+" ");
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

        viewList = new JButton("View Product List");
        viewList.setBounds(610,280,150,40);
        viewList.setFont(new Font("Tahoma",Font.BOLD,12));
        viewList.addActionListener(this);
        add(viewList);

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
        new SellerHome(uniqueUser);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if( e.getSource() == logout ){
            setVisible(false);
            new HomePage();
        } else if (e.getSource() == addItems) {
            setVisible(false);
            new AddProduct();

        }else if(e.getSource() == viewList){
            setVisible(false);
            new ViewProduct();
        }else if(e.getSource() == updateItems ){
            setVisible(false);
            new ViewProduct();
        }else if( e.getSource() == removeItems){
            setVisible(false);
            new RemoveProduct();

        }else if(e.getSource() == viewSoldItems){
            setVisible(false);
            new ViewSoldProducts();
        }

    }
}
