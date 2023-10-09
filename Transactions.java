
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry,exit ;
    String pinnumber;       
            
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));// am edited the original picture to fit in the window file name atm1.jpg
        Image i2 = i1.getImage().getScaledInstance(900,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image); 
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(225,225,350,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(160,327,150,30);//l x same y same  compare with respect to l and r denotes
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(365,327,150,30);//r x 205 y same
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(160,362,150,30);//l x same y 35
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(365,362,150,30);//r x same y 35
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(160,397,150,30); //l x same y top-down 35
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(365,397,150,30);//r x same y 35
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(365,432,150,30);//r x same y 35  perfect compare between l and l , r and r
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); //used to hide the topbar with the help of exit action we can exit the page
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == exit){
             System.exit(0);
         } else if (ae.getSource() == deposit){
              setVisible(false);
              new Deposit(pinnumber).setVisible(true);
         } else if(ae.getSource() == withdrawl){
              setVisible(false);
              new Withdrawl(pinnumber).setVisible(true);
         } else if(ae.getSource() == fastcash){
              setVisible(false);
              new FastCash(pinnumber).setVisible(true);
         } else if(ae.getSource() == pinchange){
             setVisible(false);
             new PinChange(pinnumber).setVisible(true);
         }else if (ae.getSource() == balanceenquiry){
             setVisible(false);
             new BalanceEnquiry(pinnumber).setVisible(true);
         }else if(ae.getSource() == ministatement){
             new MiniStatement(pinnumber).setVisible(true);
         } 
         
    }
   
    public static void main(String args[]) {
        new Transactions("");
    }
}
