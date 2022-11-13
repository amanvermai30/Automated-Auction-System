package Buyer;

import Home.HomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyerHome extends JFrame implements ActionListener {

    JButton purchaseProduct,buyProduct, viewBuyer , logout;
    public  static String uniqueUser;

    BuyerHome( String uniqueBuyerUser ){
        BuyerHome.uniqueUser = uniqueBuyerUser;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon coverImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img16.png"));
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

        ImageIcon buyerImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img17.png"));
        Image i3 = buyerImg.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon buyerIcon2 = new ImageIcon(i3);
        JLabel buyer = new JLabel(buyerIcon2);
        buyer.setBounds(980,70,230,200);
        add(buyer);

        JLabel h = new JLabel("Welcome  "+uniqueBuyerUser+"");
        h.setBounds(630,0,700,70);
        h.setFont(new Font("Tohma",Font.PLAIN,45));
        h.setForeground(Color.BLACK);
        add(h);


        buyProduct = new JButton("Buy Product");
        buyProduct.setBounds(570,280,170,40);
        buyProduct.setFont(new Font("Tahoma",Font.BOLD,12));
        buyProduct.addActionListener(this);
        add(buyProduct);

        purchaseProduct = new JButton("View Purchase Items");
        purchaseProduct.setBounds(790,280,170,40);
        purchaseProduct.setFont(new Font("Tahoma",Font.BOLD,12));
        purchaseProduct.addActionListener(this);
        add(purchaseProduct);

        viewBuyer = new JButton("View Seller");
        viewBuyer.setBounds(650,380,170,40);
        viewBuyer.setFont(new Font("Tahoma",Font.BOLD,12));
        viewBuyer.addActionListener(this);
        add(viewBuyer);

        logout = new JButton("Logout");
        logout.setBounds(870,380,170,40);
        logout.setFont(new Font("Tahoma",Font.BOLD,12));
        logout.addActionListener(this);
        add(logout);


        setSize(1380,740);
        setLocation(0,0);
        setVisible(true);


    }


    public static void main(String[] args) {
        new BuyerHome(uniqueUser);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == buyProduct ){
            setVisible(false);
            new BuyProduct();

        } else if( e.getSource() == viewBuyer ){
            setVisible(false);
            new ViewSeller();

        }else if(e.getSource() == logout ){
            setVisible(false);
            new BuyerLogin();
        }
    }
}
