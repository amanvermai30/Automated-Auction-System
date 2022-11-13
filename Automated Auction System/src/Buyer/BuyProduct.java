package Buyer;

import Home.MysqlConnectivity;
import Seller.SellerHome;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyProduct extends JFrame implements ActionListener {

    JTable table;
    JButton searchB,backB,buyB;
    Choice chProductID;
    BuyProduct(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon coverImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img18.png"));
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

        JLabel h = new JLabel("Buy Products ");
        h.setBounds(780,0,700,70);
        h.setFont(new Font("Tohma",Font.PLAIN,35));
        h.setForeground(Color.BLACK);
        add(h);

        JLabel subH2 = new JLabel("Buy Before Die");
        subH2.setBounds(980,30,700,70);
        subH2.setFont(new Font("Tohma",Font.PLAIN,15));
        subH2.setForeground(Color.BLACK);
        add(subH2);

        chProductID = new Choice();
        chProductID.setBounds(190,110,150,20);
        add(chProductID);

        JLabel search = new JLabel("Search by Product Id");
        search.setBounds(40,110,150,25);
        search.setFont(new Font("Tohma",Font.PLAIN,14));
        add(search);

        searchB = new JButton("search");
        searchB.setBounds(360,110,80,23);
        searchB.addActionListener(this);
        add(searchB);

        buyB = new JButton("Buy Now");
        buyB.setBounds(210,0,90,23);
        buyB.addActionListener(this);
        cover.add(buyB);


        backB = new JButton("Back");
        backB.setBounds(330,0,80,23);
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
        new BuyProduct();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String ownerName = null;
        String productName = null;
        String category = null;
        int price = 0;
        int quantity = 0;
        String productID = null;
        String buyerName = BuyerHome.uniqueUser;

        if(e.getSource() == searchB ){

            try {
                MysqlConnectivity con = new MysqlConnectivity();
                String query = "select * from productlist where productID =  '"+chProductID.getSelectedItem()+"' ";
                ResultSet rs = con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (SQLException ex){
                ex.printStackTrace();
            }




        } else  if(e.getSource() == buyB ){

            try {
                MysqlConnectivity con = new MysqlConnectivity();
                String query = "select * from productlist where productID =  '"+chProductID.getSelectedItem()+"' ";
                ResultSet rs = con.s.executeQuery(query);
                if(rs.next()){
                    ownerName = rs.getString("ownername");
                    category = rs.getString("category");
                    price = rs.getInt("price");
                    quantity = rs.getInt("quantity");
                    productID = rs.getString("productID");
                    productName = rs.getString("productname");

                }

            }catch (SQLException ex){
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, ownerName);


            try {
                MysqlConnectivity con = new MysqlConnectivity();
                String query = "delete from productlist where productID =  '"+chProductID.getSelectedItem()+"' ";
                con.s.executeUpdate(query);

            }catch (SQLException ex){
                ex.printStackTrace();
            }

            try {
                MysqlConnectivity con = new MysqlConnectivity();
                String query = "insert into soldproductlist values( '"+productName+"', '"+category+"'," +
                        " '"+price+"', '"+quantity+"', '"+ownerName+"', '"+productID+"', '"+buyerName+"' ) ";
                con.s.executeUpdate(query);


            }catch (SQLException ex ){
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Thank you for buying "+productName+" Hope you" +
                    "like our service ");
            setVisible(false);
            new BuyerHome(BuyerHome.uniqueUser);



        } else if (e.getSource() == backB) {
            setVisible(false);
            new BuyerHome(BuyerHome.uniqueUser);
        }

    }
}
