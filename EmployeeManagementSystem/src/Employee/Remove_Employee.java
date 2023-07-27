//LANTAJO
//MELO

package Employee;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Remove_Employee implements ActionListener{
    JFrame f;
    JTextField t, t1, t2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8, l9, l10;
    JButton b,b1,b2,b3, b4, b5;

    Remove_Employee(){
        f=new JFrame("Remove Employee");
        f.setBackground(Color.green);   
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,500);
        l5.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/remove.png"));
        l5.setIcon(img);
        f.add(l5);

        
        l1=new JLabel("Employee Id");
        l1.setBounds(50,50,250,30);
        l1.setForeground(Color.white);
        Font f2 = new Font("serif",Font.BOLD,25); 
        l1.setFont(f2);
        l5.add(l1);
        
        l9=new JLabel("Expenses Id");
        l9.setBounds(50,150,250,30);
        l9.setForeground(Color.white);
        l9.setFont(f2);
        l5.add(l9);
        
        l10=new JLabel("Timeoff Id");
        l10.setBounds(50,250,250,30);
        l10.setForeground(Color.white);
        l10.setFont(f2);
        l5.add(l10);

        t=new JTextField();
        t.setBounds(250,50,150,30);
        l5.add(t);
        
        t1=new JTextField();
        t1.setBounds(250,150,150,30);
        l5.add(t1);
        
        t2=new JTextField();
        t2.setBounds(250,250,150,30);
        l5.add(t2);


        b=new JButton("Delete");
        b.setBounds(360,100,100,30);
        b.setBackground(Color.red);
        b.addActionListener(this);
        l5.add(b);
        
        b4=new JButton("Delete");
        b4.setBounds(360,200,100,30);
        b4.setBackground(Color.red);
        b4.addActionListener(this);
        l5.add(b4);
        
        b5=new JButton("Delete");
        b5.setBounds(360,300,100,30);
        b5.setBackground(Color.red);
        b5.addActionListener(this);
        l5.add(b5);

        b3=new JButton("back");
        b3.setBounds(360,400,100,30);   
        b3.addActionListener(this);
        l5.add(b3);


        l2=new JLabel("Name:"); 
        l2.setBounds(50,150,250,30);
        l2.setForeground(Color.white);
        Font f3 = new Font("serif",Font.BOLD,20); 
        l2.setFont(f3);
        l5.add(l2);

        l6=new JLabel();    
        l6.setBounds(200,150,350,30);
        l6.setForeground(Color.white);
        Font F6=new Font("serif",Font.BOLD,20); 
        l6.setFont(F6);
        l5.add(l6);

        l3=new JLabel("Mobile No:");
        l3.setBounds(50,200,250,30);
        l3.setForeground(Color.white);
        Font f4 = new Font("serif",Font.BOLD,20); 
        l3.setFont(f4);
        l5.add(l3);


        l7=new JLabel();
        l7.setBounds(200,200,350,30);
        l7.setForeground(Color.white);
        Font F7=new Font("serif",Font.BOLD,20); 
        l7.setFont(F7);
        l5.add(l7);



        l4=new JLabel("Email Id:");
        l4.setBounds(50,250,250,30);
        l4.setForeground(Color.white);
        Font F5=new Font("serif",Font.BOLD,20); 
        l4.setFont(F5);
        l5.add(l4);

        l8=new JLabel();
        l8.setBounds(200,250,350,30);
        l8.setForeground(Color.white);
        Font f8=new Font("serif",Font.BOLD,20); 
        l8.setFont(f8);
        l5.add(l8);

        b1=new JButton("Remove");
        b1.setBounds(120,300,100,30);
        b1.addActionListener(this);
        l5.add(b1);


        b2=new JButton("Cancel");
        b2.setBounds(300,300,100,30);
        b2.addActionListener(this);
        l5.add(b2);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);

        f.setSize(500,500);
        f.setLocation(500,250);  
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){

        if(e.getSource()== b){
              try{ Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "charish");
              

              int idp = Integer.parseInt(t.getText());

              String sql = "DELETE FROM addemployee where id = "+ idp;
              
              
             
              Statement statement = conn.createStatement();
              
              int rows = statement.executeUpdate(sql);
              
              if (rows > 0){
                 JOptionPane.showMessageDialog(null, "Deleted successful!");
              }
            
          }catch (SQLException ex) {
      
            ex.printStackTrace();
        }
       }else if(e.getSource()== b4){
              try{ Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "charish");
              
              int idB = Integer.parseInt(t1.getText());
              String sql = "DELETE FROM expenses where id = "+ idB;
              
              
             
              Statement statement = conn.createStatement();
              
              int rows = statement.executeUpdate(sql);
              
              if (rows > 0){
                 JOptionPane.showMessageDialog(null, "Deleted successful!");
              }
            
          }catch (SQLException ex) {
              ex.printStackTrace();
          }
        }else if(e.getSource()== b5){
              try{ Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "charish");
              
              int idB = Integer.parseInt(t2.getText());
              String sql = "DELETE FROM timeoff where id = "+ idB;
              
              
             
              Statement statement = conn.createStatement();
              
              int rows = statement.executeUpdate(sql);
              
              if (rows > 0){
                 JOptionPane.showMessageDialog(null, "Deleted successful!");
              }
            
          }catch (SQLException ex) {
      
        }
                
        }else if(e.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }else if(e.getSource()==b3){
            f.setVisible(false);
            details d=new details();
        }
       }
            
    }
