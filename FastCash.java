
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date; //we cant use * because we use date in this section when we use * compiler confuse and show error date withrespect to sql or util... so explicitly say date other than *

public class FastCash extends JFrame implements ActionListener{

    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000,back ;
    String pinnumber;       
            
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));// am edited the original picture to fit in the window file name atm1.jpg
        Image i2 = i1.getImage().getScaledInstance(900,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image); 
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(225,225,350,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        rs100 = new JButton("Rs 100");
        rs100.setBounds(160,327,150,30);//l x same y same  compare with respect to l and r denotes
        rs100.addActionListener(this);
        image.add(rs100);
        
        rs500 = new JButton("Rs 500");
        rs500.setBounds(365,327,150,30);//r x 205 y same
        rs500.addActionListener(this);
        image.add(rs500);
        
        rs1000 = new JButton("Rs 1000");
        rs1000.setBounds(160,362,150,30);//l x same y 35
        rs1000.addActionListener(this);
        image.add(rs1000);
        
        rs2000 = new JButton("Rs 2000");
        rs2000.setBounds(365,362,150,30);//r x same y 35
        rs2000.addActionListener(this);
        image.add(rs2000);
        
        rs5000 = new JButton("Rs 5000");
        rs5000.setBounds(160,397,150,30); //l x same y top-down 35
        rs5000.addActionListener(this);
        image.add(rs5000);
        
        rs10000 = new JButton("Rs 10000");
        rs10000.setBounds(365,397,150,30);//r x same y 35
        rs10000.addActionListener(this);
        image.add(rs10000);
        
        back = new JButton("Back");
        back.setBounds(365,432,150,30);//r x same y 35  perfect compare between l and l , r and r
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); //used to hide the topbar with the help of exit action we can exit the page
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == back){
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
         } else {
             String amount = ((JButton)ae.getSource()).getText().substring(3);           
             Conn c = new Conn();
             try{
                 ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                 int balance = 0;
                 while(rs.next()){
                     if(rs.getString("type").equals("Deposit")){
                         balance += Integer.parseInt(rs.getString("amount"));
                     }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                 }
                 
             }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                       JOptionPane.showMessageDialog(null,"Insufficient Balance");
                       return;
                      }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+ amount+ "Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
             }catch (Exception e){
                 System.out.println(e);
             }
         }
         
         
    }
   
    public static void main(String args[]) {
        new FastCash("");
    }
}
