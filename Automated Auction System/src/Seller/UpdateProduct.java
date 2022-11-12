package Seller;

import Home.MysqlConnectivity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;

public class UpdateProduct extends JFrame implements ActionListener {

    JTextField productField,categoryField,priceField,quantityField;
    Random ran = new Random();
    int num = ran.nextInt(999999);

    JLabel productIDNumber,ownerField;

    JButton updateB,backB;
    String prodID;
    UpdateProduct( String prodID ){
          this.prodID = prodID;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon coverImg = new ImageIcon(ClassLoader.getSystemResource("Photos/img14.png"));
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

        JLabel h = new JLabel("Update Product");
        h.setBounds(630,0,700,70);
        h.setFont(new Font("Tohma",Font.PLAIN,35));
        h.setForeground(Color.BLACK);
        add(h);

        JLabel productName = new JLabel("Product Name");
        productName.setBounds(530,150,150,30);
        productName.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(productName);

        productField = new JTextField();
        productField.setBounds(690,150,150,30);
        add(productField);

        JLabel category = new JLabel("Category");
        category.setBounds(530,200,150,30);
        category.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(category);

        categoryField = new JTextField();
        categoryField.setBounds(690,200,150,30);
        add(categoryField);


        JLabel price = new JLabel("Price");
        price.setBounds(530,250,150,30);
        price.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(price);

        priceField = new JTextField();
        priceField.setBounds(690,250,150,30);
        add(priceField);

        JLabel quantity = new JLabel("Quantity");
        quantity.setBounds(890,150,150,30);
        quantity.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(quantity);

        quantityField = new JTextField();
        quantityField.setBounds(1050,150,150,30);
        add(quantityField);

        JLabel ownerName = new JLabel("Owner Name");
        ownerName.setBounds(890,200,150,30);
        ownerName.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(ownerName);

        ownerField = new JLabel();
        ownerField.setBounds(1050,200,150,30);
        add(ownerField);

        JLabel productID = new JLabel("Product ID");
        productID.setBounds(890,250,150,30);
        productID.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(productID);


        productIDNumber = new JLabel();
        productIDNumber.setBounds(1050,250,150,30);
        productIDNumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(productIDNumber);

        updateB = new JButton("Update Details");
        updateB.setBounds(680,385,130,35);
        updateB.setFont(new Font("Tohma", Font.PLAIN, 15));
        updateB.setForeground(Color.WHITE);
        updateB.setBackground(Color.BLUE);
        updateB.addActionListener(this);
        add(updateB);

        backB = new JButton("Back");
        backB.setBounds(880,385,130,35);
        backB.setFont(new Font("Tohma", Font.PLAIN, 15));
        backB.setForeground(Color.WHITE);
        backB.setBackground(Color.BLUE);
        backB.addActionListener(this);
        add(backB);

        try {

            MysqlConnectivity con = new MysqlConnectivity();
            String query = "select * from productlist where productID = '"+prodID+"' ";
            ResultSet resultSet = con.s.executeQuery(query);
            while( resultSet.next() ){

                productField.setText(resultSet.getString("productname"));
                categoryField.setText(resultSet.getString("category"));
                priceField.setText(resultSet.getString("price"));
                quantityField.setText(resultSet.getString("quantity"));
                productIDNumber.setText(resultSet.getString("productID"));
                ownerField.setText(resultSet.getString("ownername"));
            }

        }catch (SQLException ex ){
            ex.printStackTrace();
        }



        setSize(1380,740);
        setLocation(0,0);
        setVisible(true);
    }


    public static void main(String[] args) {
        new UpdateProduct("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if( e.getSource() == backB ){
            setVisible(false);
            new ViewProduct();

        } else  if(e.getSource() == updateB ){

            String productName = productField.getText();
            String category = categoryField.getText();
            int price = Integer.parseInt(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            try {
                MysqlConnectivity con = new MysqlConnectivity();
                String query = " update productlist set productname = '"+productName+"', " +
                        "category = '"+category+"'," + " price = '"+price+"', quantity = '"+quantity+"' where productID = '"+prodID+"' ";

                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully ");
                setVisible(false);
                new ViewProduct();

            }catch (SQLException ex ){
                ex.printStackTrace();
            }

        }
    }
}
