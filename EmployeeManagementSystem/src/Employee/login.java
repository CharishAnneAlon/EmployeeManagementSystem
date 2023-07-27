//ALON

package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class login  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    login(){

        JFrame user;
        user = new JFrame("login");
        user.setBackground(Color.blue);
        user.setLayout(null);
        f=new JFrame("login");

        f.setBackground(Color.blue);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        f.add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        f.add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/avatar.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        f.add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);

    }

    @Override
    public void actionPerformed(ActionEvent e){

        String username = t1.getText();
        String password = t2.getText();
        
        if(e.getSource()== b1){
            
            
            try {
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "charish");

          
            String query = "SELECT * FROM login WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);


            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                
                details d = new details();
                d.setVisible(true);
            } else {
       
               
            }


            resultSet.close();
            statement.close();
            conn.close();

        } catch (SQLException ex) {
      
            ex.printStackTrace();
            
        }
        }
    }
    

    public static void main(String[] arg){
        login l=new login();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}