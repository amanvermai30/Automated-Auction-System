package Admin;

import Home.HomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHome extends JFrame implements ActionListener {

    JButton viewBuyer,viewSeller,viewSelling,logout;
    AdminHome(){

        getContentPane().setBackground(Color.getHSBColor(2.5f,2.9f,0.7f));
        setLayout(null);

        ImageIcon coverImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img6.png"));
        Image i1 = coverImg.getImage().getScaledInstance(1380,740,Image.SCALE_DEFAULT);
        ImageIcon coverIcon2 = new ImageIcon(i1);
        JLabel cover = new JLabel(coverIcon2);
        cover.setBounds(0,0,1380,740);
        add(cover);

        ImageIcon logoImg = new ImageIcon(ClassLoader.getSystemResource("Photos/logo.png"));
        Image i2 = logoImg.getImage().getScaledInstance(260,190,Image.SCALE_DEFAULT);
        ImageIcon logoIcon2 = new ImageIcon(i2);
        JLabel logo = new JLabel(logoIcon2);
        logo.setBounds(10,0,260,80);
        cover.add(logo);

        ImageIcon adminImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img8.png"));
        Image i3 = adminImg.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon adminIcon2 = new ImageIcon(i3);
        JLabel admin = new JLabel(adminIcon2);
        admin.setBounds(680,70,230,200);
        cover.add(admin);



        JLabel h = new JLabel("Welcome Admin ");
        h.setBounds(630,0,700,70);
        h.setFont(new Font("Tohma",Font.PLAIN,45));
        h.setForeground(Color.BLACK);
        cover.add(h);

        viewBuyer = new JButton("View All Buddies");
        viewBuyer.setBounds(650,450,150,40);
        viewBuyer.setFont(new Font("Tahoma",Font.BOLD,12));
        viewBuyer.addActionListener(this);
        cover.add(viewBuyer);

        viewSeller = new JButton("View All Seller");
        viewSeller.setBounds(830,450,150,40);
        viewSeller.setFont(new Font("Tahoma",Font.BOLD,12));
        viewSeller.addActionListener(this);
        cover.add(viewSeller);

        viewSelling = new JButton("Selling Report");
        viewSelling.setBounds(650,350,150,40);
        viewSelling.setFont(new Font("Tahoma",Font.BOLD,12));
        viewSelling.addActionListener(this);
        cover.add(viewSelling);

//        disputeReport = new JButton("Dispute Report");
//        disputeReport.setBounds(650,350,150,40);
//        disputeReport.setFont(new Font("Tahoma",Font.BOLD,12));
//        disputeReport.addActionListener(this);
//        cover.add(disputeReport);

        logout = new JButton("Logout");
        logout.setBounds(830,350,150,40);
        logout.setFont(new Font("Tahoma",Font.BOLD,12));
        logout.addActionListener(this);
        cover.add(logout);


        setSize(1380,740);
        setLocation(0,0);
        setVisible(true);
    }

    public static void main(String[] args) {

        new AdminHome();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if( e.getSource() == logout ){
            setVisible(false);
            new HomePage();
        } else if (e.getSource() == viewBuyer) {
            setVisible(false);
            new ViewBuyer();

        } else if( e.getSource() == viewSeller ){
            setVisible(false);
            new ViewSeller();
        }else if(e.getSource() == viewSelling ){
            setVisible(false);
            new SellingReport();
        }

    }
}
