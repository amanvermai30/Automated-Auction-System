package Home;

import Admin.AdminLogin;
import Buyer.BuyerLogin;
import Seller.SellerLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {


    JButton adminB,sellerB,buyerB;

    public HomePage(){



        getContentPane().setBackground(Color.getHSBColor(2.5f,2.9f,0.7f));
        setLayout(null);

        ImageIcon coverImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img2.png"));
        Image i1 = coverImg.getImage().getScaledInstance(1380,740,Image.SCALE_DEFAULT);
        ImageIcon coverIcon2 = new ImageIcon(i1);
        JLabel cover = new JLabel(coverIcon2);
        cover.setBounds(0,0,1380,740);
        add(cover);

        ImageIcon loginImg = new ImageIcon(ClassLoader.getSystemResource("Photos/logo.png"));
        Image i2 = loginImg.getImage().getScaledInstance(330,240,Image.SCALE_DEFAULT);
        ImageIcon logoIcon2 = new ImageIcon(i2);
        JLabel logo = new JLabel(logoIcon2);
        logo.setBounds(20,0,300,100);
        cover.add(logo);

        JLabel h = new JLabel("Welcome to Your Bid Buddy.com ");
        h.setBounds(430,0,700,70);
        h.setFont(new Font("Tohma",Font.PLAIN,45));
        h.setForeground(Color.BLACK);
        cover.add(h);

//        JLabel subH = new JLabel("Automated Auction System");
//        subH.setBounds(350,50,700,70);
//        subH.setFont(new Font("Tohma",Font.PLAIN,35));
//        subH.setForeground(Color.CYAN);
//        cover.add(subH);

        JLabel subH2 = new JLabel("Buy Before Die");
        subH2.setBounds(950,50,700,70);
        subH2.setFont(new Font("Tohma",Font.PLAIN,25));
        subH2.setForeground(Color.BLACK);
        cover.add(subH2);

        JLabel adminH = new JLabel("Admin");
        adminH.setBounds(150,450,250,70);
        adminH.setFont(new Font("Tohma",Font.PLAIN,30));
        adminH.setForeground(Color.BLACK);
        cover.add(adminH);

        adminB = new JButton("Login Here");
        adminB.setBounds(270,470,110,35);
        adminB.setBackground(new Color(94, 0, 255));
        adminB.setForeground(Color.WHITE);
        adminB.addActionListener(this);
        cover.add(adminB);

        JLabel buyerH = new JLabel("Buyer");
        buyerH.setBounds(150,500,250,70);
        buyerH.setFont(new Font("Tohma",Font.PLAIN,30));
        buyerH.setForeground(Color.BLACK);
        cover.add(buyerH);

        buyerB = new JButton("Login Here");
        buyerB.setBounds(270,520,110,35);
        buyerB.setBackground(new Color(94, 0, 255));
        buyerB.setForeground(Color.WHITE);
        buyerB.addActionListener(this);
        cover.add(buyerB);

        JLabel sellerH = new JLabel("Seller");
        sellerH.setBounds(150,560,250,70);
        sellerH.setFont(new Font("Tohma",Font.PLAIN,30));
        sellerH.setForeground(Color.BLACK);
        cover.add(sellerH);

        sellerB = new JButton("Login Here");
        sellerB.setBounds(270,580,110,35);
        sellerB.setBackground(new Color(94, 0, 255));
        sellerB.setForeground(Color.WHITE);
        sellerB.addActionListener(this);
        cover.add(sellerB);





        setSize(1380,740);
        setLocation(0,0);
        setVisible(true);

        while (true){
            subH2.setVisible(false);
            try {
                Thread.sleep(500);
            }catch (Exception ignored){

            }
            subH2.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception ignored){

            }
        }
    }


    public static void main(String[] args) {
        new HomePage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == adminB ){
            setVisible(false);
            new AdminLogin();
        } else if( e.getSource() == buyerB ){
            setVisible(false);
            new BuyerLogin();
        } else {
            setVisible(false);
            new SellerLogin();
        }

    }
}
