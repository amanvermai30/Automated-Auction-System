package Admin;

import Home.MysqlConnectivity;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewSeller extends JFrame implements ActionListener {

    JTable table;
    Choice chSellerID;

    JButton searchB,backB;

    ViewSeller(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon coverImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img9.png"));
        Image i1 = coverImg.getImage().getScaledInstance(480,480,Image.SCALE_DEFAULT);
        ImageIcon coverIcon2 = new ImageIcon(i1);
        JLabel cover = new JLabel(coverIcon2);
        cover.setBounds(30,180,480,480);
        add(cover);

        ImageIcon logoImg = new ImageIcon(ClassLoader.getSystemResource("Photos/logo.png"));
        Image i2 = logoImg.getImage().getScaledInstance(260,190,Image.SCALE_DEFAULT);
        ImageIcon logoIcon2 = new ImageIcon(i2);
        JLabel logo = new JLabel(logoIcon2);
        logo.setBounds(10,0,260,80);
        add(logo);

        JLabel h = new JLabel("Sellers List ");
        h.setBounds(780,0,700,70);
        h.setFont(new Font("Tohma",Font.PLAIN,35));
        h.setForeground(Color.BLACK);
        add(h);

        chSellerID = new Choice();
        chSellerID.setBounds(220,150,150,20);
        add(chSellerID);

        JLabel search = new JLabel("Search by Seller Id");
        search.setBounds(80,150,150,25);
        search.setFont(new Font("Tohma",Font.PLAIN,14));
        add(search);

        searchB = new JButton("search");
        searchB.setBounds(360,20,80,23);
        searchB.addActionListener(this);
        cover.add(searchB);

        backB = new JButton("Back");
        backB.setBounds(360,60,80,23);
        backB.addActionListener(this);
        cover.add(backB);

        table = new JTable();

        try {
            MysqlConnectivity con = new MysqlConnectivity();
            String query = " select * from sellerdetails";
            ResultSet rs = con.s.executeQuery(query);

            while (rs.next()){
                chSellerID.add(rs.getString("sellerID"));
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        try {
            MysqlConnectivity con = new MysqlConnectivity();
            String query = " select * from sellerdetails";
            ResultSet rs = con.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

            while (rs.next()){
                chSellerID.add(rs.getString("sellerID"));
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(510,150,840,530);
        add(jScrollPane);



        setSize(1380,740);
        setLocation(0,0);
        setVisible(true);

    }


    public static void main(String[] args) {
        new ViewSeller();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == backB){
            setVisible(false);
            new AdminHome();

        } else if(e.getSource() == searchB ){

            try {
                MysqlConnectivity con = new MysqlConnectivity();
                String query = "select * from sellerdetails where sellerID =  '"+chSellerID.getSelectedItem()+"' ";
                ResultSet rs = con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }

    }
}
