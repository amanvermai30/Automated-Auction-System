package Seller;

import Admin.AdminHome;
import Home.MysqlConnectivity;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class ViewProduct extends JFrame implements ActionListener {

    JTable table;
    Choice chProductID;

    JButton searchB,backB,updateB;

    ViewProduct(){


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon coverImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img12.png"));
        Image i1 = coverImg.getImage().getScaledInstance(480,480,Image.SCALE_DEFAULT);
        ImageIcon coverIcon2 = new ImageIcon(i1);
        JLabel cover = new JLabel(coverIcon2);
        cover.setBounds(0,250,480,480);
        add(cover);

        ImageIcon logoImg = new ImageIcon(ClassLoader.getSystemResource("Photos/logo.png"));
        Image i2 = logoImg.getImage().getScaledInstance(260,190,Image.SCALE_DEFAULT);
        ImageIcon logoIcon2 = new ImageIcon(i2);
        JLabel logo = new JLabel(logoIcon2);
        logo.setBounds(10,0,260,80);
        add(logo);

        JLabel h = new JLabel("All Products ");
        h.setBounds(780,0,700,70);
        h.setFont(new Font("Tohma",Font.PLAIN,35));
        h.setForeground(Color.BLACK);
        add(h);

        chProductID = new Choice();
        chProductID.setBounds(190,110,150,20);
        add(chProductID);

        JLabel search = new JLabel("Search by Buyer Id");
        search.setBounds(60,110,150,25);
        search.setFont(new Font("Tohma",Font.PLAIN,14));
        add(search);

        searchB = new JButton("search");
        searchB.setBounds(360,110,80,23);
        searchB.addActionListener(this);
        add(searchB);

        updateB = new JButton("Update");
        updateB.setBounds(360,180,80,23);
        updateB.addActionListener(this);
        add(updateB);

        backB = new JButton("Back");
        backB.setBounds(360,0,80,23);
        backB.addActionListener(this);
        cover.add(backB);

        table = new JTable();

        try {
            MysqlConnectivity con = new MysqlConnectivity();
            String query = " select * from productlist";
            ResultSet rs = con.s.executeQuery(query);

            while (rs.next()){
                chProductID.add(rs.getString("productID"));
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        try {
            MysqlConnectivity con = new MysqlConnectivity();
            String query = " select * from productlist";
            ResultSet rs = con.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

            while (rs.next()){
                chProductID.add(rs.getString("productID"));
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
        new ViewProduct();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == backB){
            setVisible(false);
            new SellerHome(SellerHome.uniqueUser);

        } else if(e.getSource() == searchB ){

            try {
                MysqlConnectivity con = new MysqlConnectivity();
                String query = "select * from productlist where productID =  '"+chProductID.getSelectedItem()+"' ";
                ResultSet rs = con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }else if( e.getSource() == updateB ){
            setVisible(false);
            new UpdateProduct(chProductID.getSelectedItem());

        }

    }
}
