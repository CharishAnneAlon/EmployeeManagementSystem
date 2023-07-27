package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class details  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JButton b1,b3,b4,b5,b6;

    details(){
        f=new JFrame("Employee Detail");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        l1.setIcon(i1);
        f.add(l1);

        l2 = new JLabel("Employee Details");
        l2.setBounds(250,40,500,40);
        l2.setFont(new Font("serif",Font.BOLD,28));
        l2.setForeground(Color.black);
        l1.add(l2);

        b1=new JButton("Add");
        b1.setBounds(240,125,220,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);

        b3=new JButton("Remove");
        b3.setBounds(240,180,220,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);

       
        b5=new JButton("Expenses");
        b5.setBounds(240,230,220,40);
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.addActionListener(this);
        l1.add(b5);
        
        b6=new JButton("Time off");
        b6.setBounds(240,280,220,40);
        b6.setFont(new Font("serif",Font.BOLD,15));
        b6.addActionListener(this);
        l1.add(b6);
        
        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new Add_Employee();
        
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new Remove_Employee();
        }
        if(ae.getSource()==b4){
            f.setVisible(false);
            new Search_Employee();
        }
        if(ae.getSource()==b5){
            f.setVisible(false);
            new Employee_Expenses();
        }
        if(ae.getSource()==b6){
            f.setVisible(false);
            new Employee_Timeoff();
        }
    }


    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}