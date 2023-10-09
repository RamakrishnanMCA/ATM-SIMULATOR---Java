
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
   Deposit(String pinnumber){
         this.pinnumber = pinnumber;
         
        setLayout(null);
   
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));// am edited the original picture to fit in the window file name atm1.jpg
        Image i2 = i1.getImage().getScaledInstance(900,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image); 
       
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,235,400,20);
        image.add(text);
        
        amount =  new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,275,320,25);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(365,397,150,30); // copy paste from previous part location
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(365,432,150,30);//r x same y 35  perfect compare between l and l , r and r
        back.addActionListener(this);
        image.add(back);
      
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
       
   }
    
   public void actionPerformed(ActionEvent ae){
          if(ae.getSource() == deposit){
               String number = amount.getText();
               Date date = new Date();
               if(number.equals("")){
                   JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
               } else {
                   try{
                   Conn conn = new Conn();
                   String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                   conn.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, "Rs "+number+ "Deposited Successfully");
                   setVisible(true);
                   new Transactions(pinnumber).setVisible(true);
                   
                   } catch (Exception e){
                   System.out.println(e);
                   }
               }
               
          } else if(ae.getSource() == back){
           setVisible(false);
             new Transactions(pinnumber).setVisible(true);
          }
       
       
   }
   
    public static void main(String args[]) {
              new Deposit("");
        
    }
}