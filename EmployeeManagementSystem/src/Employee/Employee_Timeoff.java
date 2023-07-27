//ALON

package Employee;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

class Employee_Timeoff implements ActionListener{

    JFrame f;
    JLabel id1,id2,id6,id7;
    JTextField t1,t2;
    JButton b,b1;
    private String c;

    
    Employee_Timeoff (){
        f = new JFrame("Time off");
        f.setBackground(Color.white);
        f.setLayout(null);

        id7=new JLabel();
        id7.setBounds(0,0,900,700);
        id7.setLayout(null);
        f.add(id7);
        
        id6 = new JLabel("Log Time off");
        id6.setBounds(320,30,500,50);
        id6.setFont(new Font("serif",Font.ITALIC,25));
        id6.setForeground(Color.black);
        id7.add(id6);
        f.add(id7);

 
        id1 = new JLabel("On time");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id7.add(id1);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id7.add(t1);

        id2 = new JLabel("Over Time");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id7.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id7.add(t2);


        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,550,150,40);
        
        id7.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,550,150,40);
        
        id7.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
       String ontime = t1.getText();
        String overtime = t2.getText();
       
        if(e.getSource()== b){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "charish");
            String query = "INSERT INTO timeoff (ontime, overtime) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, ontime);
            preparedStatement.setString(2, overtime);
            

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("data added");
            t1.setText("");
            t2.setText("");
            } else {
                
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
        }else if(e.getSource() == b1){
            f.setVisible(false);
            new details();
        }
    }
}
